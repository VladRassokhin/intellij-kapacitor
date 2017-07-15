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
package org.intellij.plugins.kapacitor

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
import java.util.*


open class KapacitorSyntaxHighlighterFactory : SyntaxHighlighterFactory() {

  companion object {
    val Kapacitor_BRACKETS: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kapacitor.BRACKETS", BRACKETS)
    val Kapacitor_PARENTHESES: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kapacitor.PARENTHESES", PARENTHESES)
    val Kapacitor_COMMA: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kapacitor.COMMA", COMMA)
    val Kapacitor_CHAINS: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kapacitor.CHAINS", DOT)
    val Kapacitor_OPERATION_SIGN: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kapacitor.OPERATION_SIGN", OPERATION_SIGN)
    val Kapacitor_NUMBER: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kapacitor.NUMBER", NUMBER)
    val Kapacitor_STRING: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kapacitor.STRING", STRING)
    val Kapacitor_REFERENCE: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kapacitor.REFERENCE", TEMPLATE_LANGUAGE_COLOR)
    val Kapacitor_KEYWORD: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kapacitor.KEYWORD", KEYWORD)
    val Kapacitor_LINE_COMMENT: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kapacitor.LINE_COMMENT", LINE_COMMENT)

    // Artificial element type
    val Kapacitor_IDENTIFIER: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kapacitor.IDENTIFIER", IDENTIFIER)

    // String escapes
    val Kapacitor_VALID_ESCAPE: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kapacitor.VALID_ESCAPE", VALID_STRING_ESCAPE)
    val Kapacitor_INVALID_ESCAPE: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kapacitor.INVALID_ESCAPE", INVALID_STRING_ESCAPE)
  }


  open class MySyntaxHighlighter(val lexer: KapacitorLexer) : SyntaxHighlighterBase() {
    val ourAttributes: Map<IElementType, TextAttributesKey> = HashMap()


    init {
      SyntaxHighlighterBase.fillMap(ourAttributes, Kapacitor_LINE_COMMENT, KapacitorElementTypes.LINE_COMMENT)

      SyntaxHighlighterBase.fillMap(ourAttributes, KapacitorParserDefinition.PARENTHESES, Kapacitor_PARENTHESES)
      SyntaxHighlighterBase.fillMap(ourAttributes, KapacitorParserDefinition.BRACKETS, Kapacitor_BRACKETS)

      SyntaxHighlighterBase.fillMap(ourAttributes, KapacitorParserDefinition.KEYWORDS, Kapacitor_KEYWORD)

      SyntaxHighlighterBase.fillMap(ourAttributes, Kapacitor_COMMA, KapacitorElementTypes.COMMA)
      SyntaxHighlighterBase.fillMap(ourAttributes, KapacitorParserDefinition.PIPES, Kapacitor_CHAINS)
      SyntaxHighlighterBase.fillMap(ourAttributes, KapacitorTokenTypes.ALL_OPERATORS, Kapacitor_OPERATION_SIGN)

      SyntaxHighlighterBase.fillMap(ourAttributes, Kapacitor_NUMBER, KapacitorElementTypes.NUMBER, KapacitorElementTypes.DURATION)

      SyntaxHighlighterBase.fillMap(ourAttributes, Kapacitor_STRING, KapacitorElementTypes.SINGLE_QUOTED_STRING)
      SyntaxHighlighterBase.fillMap(ourAttributes, Kapacitor_STRING, KapacitorElementTypes.TRIPLE_QUOTED_STRING)
      SyntaxHighlighterBase.fillMap(ourAttributes, Kapacitor_STRING, KapacitorElementTypes.REGEX_LITERAL)

      SyntaxHighlighterBase.fillMap(ourAttributes, Kapacitor_REFERENCE, KapacitorElementTypes.REFERENCE_STRING)

      SyntaxHighlighterBase.fillMap(ourAttributes, Kapacitor_IDENTIFIER, KapacitorElementTypes.ID)

      SyntaxHighlighterBase.fillMap(ourAttributes, HighlighterColors.BAD_CHARACTER, TokenType.BAD_CHARACTER)

      SyntaxHighlighterBase.fillMap(ourAttributes, Kapacitor_VALID_ESCAPE, StringEscapesTokenTypes.VALID_STRING_ESCAPE_TOKEN)
      SyntaxHighlighterBase.fillMap(ourAttributes, Kapacitor_INVALID_ESCAPE, StringEscapesTokenTypes.INVALID_CHARACTER_ESCAPE_TOKEN, StringEscapesTokenTypes.INVALID_UNICODE_ESCAPE_TOKEN)
    }


    override fun getTokenHighlights(tokenType: IElementType?): Array<out TextAttributesKey> {
      return SyntaxHighlighterBase.pack(ourAttributes[tokenType])
    }

    override fun getHighlightingLexer(): Lexer {
      return lexer
//      val layeredLexer = LayeredLexer(lexer)

      // TODO: Use custom StringLiteralLexer?
//      layeredLexer.registerSelfStoppingLayer(StringLiteralLexer('\"', KapacitorElementTypes.TRIPLE_QUOTED_STRING, false, "/vaUX", true, false), arrayOf(KapacitorElementTypes.DOUBLE_QUOTED_STRING), IElementType.EMPTY_ARRAY)
//      layeredLexer.registerSelfStoppingLayer(StringLiteralLexer('\'', KapacitorElementTypes.SINGLE_QUOTED_STRING, false, "/vaUX", true, false), arrayOf(KapacitorElementTypes.SINGLE_QUOTED_STRING), IElementType.EMPTY_ARRAY)
//      return layeredLexer
    }

  }

  override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter {
    return MySyntaxHighlighter(KapacitorLexer())
  }
}
