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

import com.intellij.psi.PsiElement
import com.intellij.usages.impl.rules.UsageType
import com.intellij.usages.impl.rules.UsageTypeProvider
import org.intellij.plugins.tickscript.psi.*

class TickScriptUsageTypeProvider : UsageTypeProvider {
  override fun getUsageType(element: PsiElement?): UsageType? {
    if (element == null) return null
    if (element !is TickScriptExpression) return null
    if (element is TickScriptIdentifier) {
      val parent = (element as PsiElement).parent
      if (parent is TickScriptDeclaration) {
        return if (parent.variable === element) UsageType.WRITE else UsageType.READ
      }
      if (parent is TickScriptTypeDeclaration) {
        if (parent.variable === element) {
          return UsageType.CLASS_LOCAL_VAR_DECLARATION
        }
      } else if (parent is TickScriptParameterList) {
        return UsageType.READ
      } else if (parent is TickScriptChainExpression) {
        if (parent.lOperand === element) {
          return UsageType.READ
        }
      } else if (parent is TickScriptBinaryExpression) {
        return UsageType.READ
      }
    }
    return null
  }
}