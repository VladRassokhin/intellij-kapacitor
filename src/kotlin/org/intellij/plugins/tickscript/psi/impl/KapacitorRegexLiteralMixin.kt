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
package org.intellij.plugins.tickscript.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiLanguageInjectionHost
import com.intellij.psi.impl.source.tree.LeafElement
import org.intellij.plugins.tickscript.psi.KapacitorRegexLiteral

abstract class KapacitorRegexLiteralMixin(node: ASTNode) : KapacitorLiteralImpl(node), KapacitorRegexLiteral, PsiLanguageInjectionHost {
  override fun isValidHost() = true

  override fun updateText(text: String): PsiLanguageInjectionHost {
    val valueNode = node.firstChildNode
    assert(valueNode is LeafElement)
    (valueNode as LeafElement).replaceWithText(text)
    return this
  }

  override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost> {
    return object : LiteralTextEscaper<KapacitorRegexLiteralMixin>(this) {
      override fun isOneLine(): Boolean {
        return true
      }

      override fun decode(rangeInsideHost: TextRange, outChars: StringBuilder): Boolean {
        outChars.append(rangeInsideHost.subSequence(myHost.text))
        return true
      }

      override fun getOffsetInHost(offsetInDecoded: Int, rangeInsideHost: TextRange): Int {
        val offset = offsetInDecoded + rangeInsideHost.startOffset
        if (offset < rangeInsideHost.startOffset) {
          return -1
        }
        if (offset > rangeInsideHost.endOffset) {
          return -1
        }
        return offset
      }

      override fun getRelevantTextRange(): TextRange {
        if (myHost.textLength == 0) return TextRange.EMPTY_RANGE
        return TextRange.create(1, myHost.textLength - 1)
      }

    }
  }
}