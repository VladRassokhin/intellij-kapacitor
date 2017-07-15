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
package org.intellij.plugins.kapacitor.psi

import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiFilePattern
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import org.intellij.plugins.kapacitor.KapacitorLanguage
import java.util.*

class KapacitorReferenceContributor : PsiReferenceContributor() {
  companion object {
    val KapacitorConfigFile: PsiFilePattern.Capture<KapacitorFile> =
        PlatformPatterns.psiFile(KapacitorFile::class.java)
            .withLanguage(KapacitorLanguage)
  }

  override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {

    registrar.registerReferenceProvider(
        PlatformPatterns.psiElement(KapacitorIdentifier::class.java)
            .inFile(KapacitorConfigFile)
            .withParent(PlatformPatterns.psiElement(KapacitorParameterList::class.java))
        , ParameterReferenceProvider)
  }
}

object ParameterReferenceProvider : PsiReferenceProvider() {
  override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
    if (element !is KapacitorIdentifier) return PsiReference.EMPTY_ARRAY
    if (element.parent !is KapacitorParameterList) return PsiReference.EMPTY_ARRAY
    return arrayOf(ParameterReferenceLazyReference(element))
  }

}

class ParameterReferenceLazyReference(element: KapacitorIdentifier) : PsiReferenceBase.Poly<KapacitorIdentifier>(element) {
  override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
    val file = element.containingFile ?: return emptyArray()
    val found = ArrayList<KapacitorIdentifier>()
    file.acceptChildren(object : KapacitorElementVisitor() {
      override fun visitDeclaration(o: KapacitorDeclaration) {
        if (o.variable.name == element.name) found.add(o.variable)
      }
    })
    return found.map { PsiElementResolveResult(it) }.toTypedArray()
  }


  override fun getVariants(): Array<Any> {
    val file = element.containingFile ?: return emptyArray()
    val found = ArrayList<KapacitorIdentifier>()
    file.acceptChildren(object : KapacitorElementVisitor() {
      override fun visitDeclaration(o: KapacitorDeclaration) {
        found.add(o.variable)
      }
    })
    return found.toTypedArray()
  }
}