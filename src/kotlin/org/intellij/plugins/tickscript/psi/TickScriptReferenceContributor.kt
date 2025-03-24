/*
 * Copyright 2000-2025 JetBrains s.r.o.
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
package org.intellij.plugins.tickscript.psi

import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.patterns.PlatformPatterns.psiFile
import com.intellij.patterns.PsiFilePattern
import com.intellij.patterns.StandardPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import org.intellij.plugins.tickscript.TickScriptLanguage
import java.util.*

class TickScriptReferenceContributor : PsiReferenceContributor() {

  override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
    registrar.registerReferenceProvider(
        psiElement(TickScriptIdentifier::class.java)
            .inFile(TickScriptConfigFile)
            .withParent(StandardPatterns.or(
                psiElement(TickScriptBinaryExpression::class.java),
                psiElement(TickScriptParameterList::class.java),
                psiElement(TickScriptDeclaration::class.java)
            ))
        , ParameterReferenceProvider)
    registrar.registerReferenceProvider(
        psiElement(TickScriptIdentifier::class.java)
            .inFile(TickScriptConfigFile)
            .withParent(psiElement(TickScriptChainExpression::class.java))
            .isFirstAcceptedChild(psiElement())
        , ParameterReferenceProvider)
  }
}

private val TickScriptConfigFile: PsiFilePattern.Capture<TickScriptFile> =
  psiFile(TickScriptFile::class.java)
    .withLanguage(TickScriptLanguage)

object ParameterReferenceProvider : PsiReferenceProvider() {
  override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
    if (element !is TickScriptIdentifier) return PsiReference.EMPTY_ARRAY
    val parent = element.parent
    if (parent is TickScriptChainExpression) {
      if (parent.lOperand === element) return arrayOf(ParameterReferenceLazyReference(element))
    } else if (parent is TickScriptDeclaration) {
      return arrayOf(ParameterReferenceLazyReference(element))
    } else if (parent is TickScriptParameterList) return arrayOf(ParameterReferenceLazyReference(element))
    else if (parent is TickScriptBinaryExpression) return arrayOf(ParameterReferenceLazyReference(element))
    return PsiReference.EMPTY_ARRAY
  }

}

class ParameterReferenceLazyReference(element: TickScriptIdentifier) : PsiReferenceBase.Poly<TickScriptIdentifier>(element) {
  override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
    val file = element.containingFile ?: return emptyArray()
    val values = ArrayList<TickScriptIdentifier>()
    val types = ArrayList<TickScriptIdentifier>()
    file.acceptChildren(object : TickScriptElementVisitor() {
      override fun visitDeclaration(o: TickScriptDeclaration) {
        if (o.variable.name == element.name) values.add(o.variable)
      }

      override fun visitTypeDeclaration(o: TickScriptTypeDeclaration) {
        if (o.variable.name == element.name) types.add(o.variable)
      }
    })
    values.remove(element)
    types.remove(element)
    if (types.isNotEmpty()) {
      return types.map { PsiElementResolveResult(it) }.toTypedArray()
    }
    return values.map { PsiElementResolveResult(it) }.toTypedArray()
  }


  override fun getVariants(): Array<Any> {
    val file = element.containingFile ?: return emptyArray()
    val found = ArrayList<TickScriptIdentifier>()
    file.acceptChildren(object : TickScriptElementVisitor() {
      override fun visitDeclaration(o: TickScriptDeclaration) {
        found.add(o.variable)
      }

      override fun visitTypeDeclaration(o: TickScriptTypeDeclaration) {
        found.add(o.variable)
      }
    })
    return found.toTypedArray()
  }
}