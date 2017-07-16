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

import com.intellij.psi.PsiElement
import com.intellij.usages.impl.rules.UsageType
import com.intellij.usages.impl.rules.UsageTypeProvider
import org.intellij.plugins.kapacitor.psi.*

class KapacitorUsageTypeProvider : UsageTypeProvider {
  override fun getUsageType(element: PsiElement?): UsageType? {
    if (element == null) return null
    if (element !is KapacitorExpression) return null
    if (element is KapacitorIdentifier) {
      val parent = (element as PsiElement).parent
      if (parent is KapacitorDeclaration) {
        return if (parent.variable === element) UsageType.WRITE else UsageType.READ
      }
      if (parent is KapacitorTypeDeclaration) {
        if (parent.variable === element) {
          return UsageType.CLASS_LOCAL_VAR_DECLARATION
        }
      } else if (parent is KapacitorParameterList) {
        return UsageType.READ
      } else if (parent is KapacitorChainExpression) {
        if (parent.lOperand === element) {
          return UsageType.READ
        }
      } else if (parent is KapacitorBinaryExpression) {
        return UsageType.READ
      }
    }
    return null
  }
}