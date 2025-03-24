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
package org.intellij.plugins.tickscript

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.StringEscapesTokenTypes
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet


open class TickScriptSyntaxHighlighterFactory : SyntaxHighlighterFactory() {

  open class MySyntaxHighlighter(private val lexer: TickScriptLexer) : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<out TextAttributesKey> {
      return pack(ourAttributes[tokenType])
    }

    override fun getHighlightingLexer(): Lexer {
      return lexer
//      val layeredLexer = LayeredLexer(lexer)

      // TODO: Use custom StringLiteralLexer?
//      layeredLexer.registerSelfStoppingLayer(StringLiteralLexer('\"', TickScriptElementTypes.TRIPLE_QUOTED_STRING, false, "/vaUX", true, false), arrayOf(TickScriptElementTypes.DOUBLE_QUOTED_STRING), IElementType.EMPTY_ARRAY)
//      layeredLexer.registerSelfStoppingLayer(StringLiteralLexer('\'', TickScriptElementTypes.SINGLE_QUOTED_STRING, false, "/vaUX", true, false), arrayOf(TickScriptElementTypes.SINGLE_QUOTED_STRING), IElementType.EMPTY_ARRAY)
//      return layeredLexer
    }

  }

  override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter {
    return MySyntaxHighlighter(TickScriptLexer())
  }
}

object Attributes {
  val TickScript_BRACKETS: TextAttributesKey = TextAttributesKey.createTextAttributesKey("TickScript.BRACKETS", BRACKETS)
  val TickScript_PARENTHESES: TextAttributesKey = TextAttributesKey.createTextAttributesKey("TickScript.PARENTHESES", PARENTHESES)
  val TickScript_COMMA: TextAttributesKey = TextAttributesKey.createTextAttributesKey("TickScript.COMMA", COMMA)
  val TickScript_CHAINS: TextAttributesKey = TextAttributesKey.createTextAttributesKey("TickScript.CHAINS", DOT)
  val TickScript_OPERATION_SIGN: TextAttributesKey = TextAttributesKey.createTextAttributesKey("TickScript.OPERATION_SIGN", OPERATION_SIGN)
  val TickScript_NUMBER: TextAttributesKey = TextAttributesKey.createTextAttributesKey("TickScript.NUMBER", NUMBER)
  val TickScript_STRING: TextAttributesKey = TextAttributesKey.createTextAttributesKey("TickScript.STRING", STRING)
  val TickScript_REFERENCE: TextAttributesKey = TextAttributesKey.createTextAttributesKey("TickScript.REFERENCE", TEMPLATE_LANGUAGE_COLOR)
  val TickScript_KEYWORD: TextAttributesKey = TextAttributesKey.createTextAttributesKey("TickScript.KEYWORD", KEYWORD)
  val TickScript_LINE_COMMENT: TextAttributesKey = TextAttributesKey.createTextAttributesKey("TickScript.LINE_COMMENT", LINE_COMMENT)

  // Artificial element type
  val TickScript_IDENTIFIER: TextAttributesKey = TextAttributesKey.createTextAttributesKey("TickScript.IDENTIFIER", IDENTIFIER)

  // String escapes
  val TickScript_VALID_ESCAPE: TextAttributesKey = TextAttributesKey.createTextAttributesKey("TickScript.VALID_ESCAPE", VALID_STRING_ESCAPE)
  val TickScript_INVALID_ESCAPE: TextAttributesKey =
    TextAttributesKey.createTextAttributesKey("TickScript.INVALID_ESCAPE", INVALID_STRING_ESCAPE)

}

private fun fillMap(map: MutableMap<IElementType, TextAttributesKey>, value: TextAttributesKey, vararg types: IElementType) {
  for (type in types) {
    map[type] = value
  }
}

private fun fillMap(map: MutableMap<IElementType, TextAttributesKey>, keys: TokenSet, value: TextAttributesKey) {
  fillMap(map, value, *keys.types)
}

val ourAttributes: MutableMap<IElementType, TextAttributesKey> = HashMap<IElementType, TextAttributesKey>().apply {
  fillMap(this, Attributes.TickScript_LINE_COMMENT, TickScriptElementTypes.LINE_COMMENT)

  fillMap(this, TokenSets.PARENTHESES, Attributes.TickScript_PARENTHESES)
  fillMap(this, TokenSets.BRACKETS, Attributes.TickScript_BRACKETS)

  fillMap(this, TokenSets.KEYWORDS, Attributes.TickScript_KEYWORD)

  fillMap(this, Attributes.TickScript_COMMA, TickScriptElementTypes.COMMA)
  fillMap(this, TokenSets.PIPES, Attributes.TickScript_CHAINS)
  fillMap(this, TickScriptTokenTypes.ALL_OPERATORS, Attributes.TickScript_OPERATION_SIGN)

  fillMap(this, Attributes.TickScript_NUMBER, TickScriptElementTypes.NUMBER, TickScriptElementTypes.DURATION)

  fillMap(this, Attributes.TickScript_STRING, TickScriptElementTypes.SINGLE_QUOTED_STRING)
  fillMap(this, Attributes.TickScript_STRING, TickScriptElementTypes.TRIPLE_QUOTED_STRING)
  fillMap(this, Attributes.TickScript_STRING, TickScriptElementTypes.REGEX_LITERAL)

  fillMap(this, Attributes.TickScript_REFERENCE, TickScriptElementTypes.REFERENCE_STRING)

  fillMap(this, Attributes.TickScript_IDENTIFIER, TickScriptElementTypes.ID)

  fillMap(this, HighlighterColors.BAD_CHARACTER, TokenType.BAD_CHARACTER)

  fillMap(this, Attributes.TickScript_VALID_ESCAPE, StringEscapesTokenTypes.VALID_STRING_ESCAPE_TOKEN)
  fillMap(
    this,
    Attributes.TickScript_INVALID_ESCAPE,
    StringEscapesTokenTypes.INVALID_CHARACTER_ESCAPE_TOKEN,
    StringEscapesTokenTypes.INVALID_UNICODE_ESCAPE_TOKEN
  )
}
