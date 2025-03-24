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

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.intellij.plugins.tickscript.TickScriptElementTypes.*
import org.intellij.plugins.tickscript.psi.impl.TickScriptFileImpl

open class TickScriptParserDefinition : ParserDefinition {

  override fun createLexer(project: Project): Lexer {
    return TickScriptLexer()
  }

  override fun createParser(project: Project): PsiParser {
    return TickScriptParser()
  }

  override fun getFileNodeType(): IFileElementType {
    return TokenSets.FILE
  }

  override fun getWhitespaceTokens(): TokenSet {
    return TokenSets.WHITE_SPACES
  }

  override fun getCommentTokens(): TokenSet {
    return TokenSets.COMMENTARIES
  }

  override fun getStringLiteralElements(): TokenSet {
    return TokenSets.STRING_LITERALS
  }

  override fun createElement(node: ASTNode): PsiElement {
    val type = node.elementType
    if (type is TickScriptElementType) {
      return Factory.createElement(node)
    }
    if (type is TickScriptTokenType) {
      return Factory.createElement(node)
    }
    return ASTWrapperPsiElement(node)
  }

  override fun createFile(fileViewProvider: FileViewProvider): PsiFile {
    return TickScriptFileImpl(fileViewProvider, TickScriptLanguage)
  }
}


object TokenSets {
  @JvmStatic
  val WHITE_SPACES: TokenSet = TokenSet.create(TokenType.WHITE_SPACE)

  @JvmStatic
  val STRING_LITERALS: TokenSet = TokenSet.create(STRING_LITERAL, REGEX_LITERAL, REFERENCE_LITERAL)

  @JvmStatic
  val IDENTIFYING_LITERALS: TokenSet = TokenSet.orSet(STRING_LITERALS, TokenSet.create(ID))

  @JvmStatic
  val FILE: IFileElementType = IFileElementType(TickScriptLanguage)


  @JvmStatic
  val PARENTHESES: TokenSet = TokenSet.create(L_PAREN, R_PAREN)

  @JvmStatic
  val BRACKETS: TokenSet = TokenSet.create(L_BRACKET, R_BRACKET)

  @JvmStatic
  val CONTAINERS: TokenSet = TokenSet.create(STRING_LIST)

  @JvmStatic
  val BOOLEANS: TokenSet = TokenSet.create(TRUE, FALSE)

  @JvmStatic
  val KEYWORDS: TokenSet = TokenSet.create(TRUE, FALSE, KW_LAMBDA, KW_VAR)

  @JvmStatic
  val LITERALS: TokenSet = TokenSet.orSet(STRING_LITERALS, BOOLEANS, TokenSet.create(NUMBER_LITERAL, DURATION_LITERAL, STAR_LITERAL))

  @JvmStatic
  val VALUES: TokenSet = TokenSet.orSet(/*CONTAINERS,*/ LITERALS)

  @JvmStatic
  val COMMENTARIES: TokenSet = TokenSet.create(/*BLOCK_COMMENT, */LINE_COMMENT)

  @JvmStatic
  val PIPES: TokenSet = TokenSet.create(DOT, AT, PIPE)
}