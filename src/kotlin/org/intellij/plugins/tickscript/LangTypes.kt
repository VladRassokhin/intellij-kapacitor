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
package org.intellij.plugins.tickscript

import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import org.intellij.plugins.tickscript.KapacitorElementTypes.*

open class KapacitorElementType(debugName: String) : IElementType(debugName, KapacitorLanguage)
open class KapacitorTokenType(debugName: String) : IElementType(debugName, KapacitorLanguage)

object KapacitorTokenTypes {
  val BINARY_OPERATORS: TokenSet = TokenSet.create(
      OP_PLUS, OP_MINUS, OP_MULT, OP_DIV, OP_MOD,
      OP_EQUAL, OP_NOTEQUAL,
      OP_REGEXEQUAL, OP_REGEXNOTEQUAL,
      OP_LESS, OP_GREATER, OP_LESSEQUAL, OP_GREATEREQUAL,
      OP_AND, OP_OR
  )

  val UNARY_OPERATORS: TokenSet = TokenSet.create(
      /*OP_PLUS, */OP_MINUS, OP_NOT
  )

  val ALL_OPERATORS = TokenSet.orSet(UNARY_OPERATORS, BINARY_OPERATORS, TokenSet.create(KapacitorElementTypes.ASGN))
}