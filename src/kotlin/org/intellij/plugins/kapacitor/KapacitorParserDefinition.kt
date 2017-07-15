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
import org.intellij.plugins.kapacitor.KapacitorElementTypes.*
import org.intellij.plugins.kapacitor.psi.impl.KapacitorFileImpl

open class KapacitorParserDefinition : ParserDefinition {

  override fun createLexer(project: Project): Lexer {
    return KapacitorLexer()
  }

  override fun createParser(project: Project): PsiParser {
    return KapacitorParser()
  }

  override fun getFileNodeType(): IFileElementType {
    return FILE
  }

  override fun getWhitespaceTokens(): TokenSet {
    return WHITE_SPACES
  }

  override fun getCommentTokens(): TokenSet {
    return COMMENTARIES
  }

  override fun getStringLiteralElements(): TokenSet {
    return STRING_LITERALS
  }

  override fun createElement(node: ASTNode): PsiElement {
    val type = node.elementType
    if (type is KapacitorElementType) {
      return Factory.createElement(node)
    }
    if (type is KapacitorTokenType) {
      return Factory.createElement(node)
    }
    return ASTWrapperPsiElement(node)
  }

  override fun createFile(fileViewProvider: FileViewProvider): PsiFile {
    return KapacitorFileImpl(fileViewProvider, KapacitorLanguage)
  }

  override fun spaceExistanceTypeBetweenTokens(left: ASTNode, right: ASTNode) = ParserDefinition.SpaceRequirements.MAY

  companion object {
    val WHITE_SPACES: TokenSet = TokenSet.create(TokenType.WHITE_SPACE)
    val STRING_LITERALS: TokenSet = TokenSet.create(STRING_LITERAL, REGEX_LITERAL, REFERENCE_LITERAL)
    val IDENTIFYING_LITERALS: TokenSet = TokenSet.orSet(STRING_LITERALS, TokenSet.create(ID))

    val FILE: IFileElementType = IFileElementType(KapacitorLanguage)

    val PARENTHESES: TokenSet = TokenSet.create(L_PAREN, R_PAREN)
    val BRACKETS: TokenSet = TokenSet.create(L_BRACKET, R_BRACKET)

    val CONTAINERS: TokenSet = TokenSet.create(STRING_LIST)

    val BOOLEANS: TokenSet = TokenSet.create(TRUE, FALSE)
    val KEYWORDS: TokenSet = TokenSet.create(TRUE, FALSE, KW_LAMBDA, KW_VAR)

    val LITERALS: TokenSet = TokenSet.orSet(STRING_LITERALS, BOOLEANS, TokenSet.create(NUMBER_LITERAL, DURATION_LITERAL, STAR_LITERAL))
    val VALUES: TokenSet = TokenSet.orSet(/*CONTAINERS,*/ LITERALS)
    val COMMENTARIES: TokenSet = TokenSet.create(/*BLOCK_COMMENT, */LINE_COMMENT)
    val PIPES: TokenSet = TokenSet.create(DOT, AT, PIPE)
  }
}
