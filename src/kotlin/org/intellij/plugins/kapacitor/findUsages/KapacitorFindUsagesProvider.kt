/*
 * Copyright 2000-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.intellij.plugins.kapacitor.findUsages

import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.intellij.plugins.kapacitor.KapacitorLexer
import org.intellij.plugins.kapacitor.psi.*

class KapacitorFindUsagesProvider : FindUsagesProvider {
  override fun getHelpId(psiElement: PsiElement): String? = null

  override fun getWordsScanner(): WordsScanner? {
    return KapacitorWordScanner(KapacitorLexer())
  }

  override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
    if (psiElement !is PsiNamedElement || psiElement !is KapacitorExpression) {
      return false
    }
    if (psiElement is KapacitorIdentifier) {
      if (KapacitorPsiUtil.isVariableDeclaration(psiElement)) return true
      val parent = (psiElement as PsiElement).parent
      if (parent is KapacitorDeclaration) {
        return psiElement === parent.value
      }
      if (parent is KapacitorParameterList) {
        return true
      }
    }
    return true
  }

  override fun getType(element: PsiElement): String {
//    if (element is KapacitorDeclaration) {
//      return "Declaration"
//    }
//    if (element is KapacitorTypeDeclaration) {
//      return "Type Declaration"
//    }
    if (element is KapacitorIdentifier /*|| element is KapacitorStringLiteral || element is KapacitorReferenceLiteral*/) {
      if (KapacitorPsiUtil.isVariableDeclaration(element)) {
        return "Variable"
      }
      if (element.parent is KapacitorParameterList) return "Method Parameter"
    }
    if (element is PsiNamedElement) {
      return "<Untyped PsiNamedElement${element.javaClass.name}>"
    }
    return "<Untyped non-PsiNamedElement ${element.node.elementType}>"
  }

  override fun getDescriptiveName(element: PsiElement): String {
    val name = (element as? PsiNamedElement)?.name
    return name ?: "<Not An PsiNamedElement ${element.node.elementType}>"
  }

  override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
    return getDescriptiveName(element)
  }
}
