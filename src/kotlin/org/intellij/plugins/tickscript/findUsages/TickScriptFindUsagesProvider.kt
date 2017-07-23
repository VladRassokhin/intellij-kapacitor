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
package org.intellij.plugins.tickscript.findUsages

import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.intellij.plugins.tickscript.TickScriptLexer
import org.intellij.plugins.tickscript.psi.*

class TickScriptFindUsagesProvider : FindUsagesProvider {
  override fun getHelpId(psiElement: PsiElement): String? = null

  override fun getWordsScanner(): WordsScanner? {
    return TickScriptWordScanner(TickScriptLexer())
  }

  override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
    if (psiElement !is PsiNamedElement || psiElement !is TickScriptExpression) {
      return false
    }
    if (psiElement is TickScriptIdentifier) {
      if (TickScriptPsiUtil.isVariableDeclaration(psiElement)) return true
      val parent = (psiElement as PsiElement).parent
      return when (parent) {
        is TickScriptDeclaration -> true
        is TickScriptParameterList -> true
        is TickScriptBinaryExpression -> true
        is TickScriptChainExpression -> parent.lOperand === psiElement
        else -> false
      }
    }
    return false
  }

  override fun getType(element: PsiElement): String {
    if (element is TickScriptIdentifier) {
      if (TickScriptPsiUtil.isVariableDeclaration(element)) {
        return "Variable"
      }
      val parent = (element as PsiElement).parent
      when (parent) {
        is TickScriptDeclaration -> return "Variable value"
        is TickScriptParameterList -> return "Parameter"
        is TickScriptBinaryExpression -> return "Operand"
        is TickScriptChainExpression -> if (parent.lOperand === element) return "Chain Source"
      }
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
