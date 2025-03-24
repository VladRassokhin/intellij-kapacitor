// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.tickscript;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.plugins.tickscript.psi.impl.*;

public interface TickScriptElementTypes {

  IElementType BINARY_ADDITION_EXPRESSION = new TickScriptElementType("BINARY_ADDITION_EXPRESSION");
  IElementType BINARY_AND_EXPRESSION = new TickScriptElementType("BINARY_AND_EXPRESSION");
  IElementType BINARY_EQUALITY_EXPRESSION = new TickScriptElementType("BINARY_EQUALITY_EXPRESSION");
  IElementType BINARY_MULTIPLY_EXPRESSION = new TickScriptElementType("BINARY_MULTIPLY_EXPRESSION");
  IElementType BINARY_OR_EXPRESSION = new TickScriptElementType("BINARY_OR_EXPRESSION");
  IElementType BINARY_RELATIONAL_EXPRESSION = new TickScriptElementType("BINARY_RELATIONAL_EXPRESSION");
  IElementType BOOLEAN_LITERAL = new TickScriptElementType("BOOLEAN_LITERAL");
  IElementType CHAIN_AT_EXPRESSION = new TickScriptElementType("CHAIN_AT_EXPRESSION");
  IElementType CHAIN_DOT_EXPRESSION = new TickScriptElementType("CHAIN_DOT_EXPRESSION");
  IElementType CHAIN_PIPE_EXPRESSION = new TickScriptElementType("CHAIN_PIPE_EXPRESSION");
  IElementType DECLARATION = new TickScriptElementType("DECLARATION");
  IElementType DURATION_LITERAL = new TickScriptElementType("DURATION_LITERAL");
  IElementType EXPRESSION = new TickScriptElementType("EXPRESSION");
  IElementType IDENTIFIER = new TickScriptElementType("IDENTIFIER");
  IElementType LAMBDA_EXPRESSION = new TickScriptElementType("LAMBDA_EXPRESSION");
  IElementType LITERAL = new TickScriptElementType("LITERAL");
  IElementType METHOD_CALL_EXPRESSION = new TickScriptElementType("METHOD_CALL_EXPRESSION");
  IElementType NUMBER_LITERAL = new TickScriptElementType("NUMBER_LITERAL");
  IElementType PARAMETER_LIST = new TickScriptElementType("PARAMETER_LIST");
  IElementType PARENTHESIZED_EXPRESSION = new TickScriptElementType("PARENTHESIZED_EXPRESSION");
  IElementType REFERENCE_LITERAL = new TickScriptElementType("REFERENCE_LITERAL");
  IElementType REGEX_LITERAL = new TickScriptElementType("REGEX_LITERAL");
  IElementType STAR_LITERAL = new TickScriptElementType("STAR_LITERAL");
  IElementType STRING_LIST = new TickScriptElementType("STRING_LIST");
  IElementType STRING_LITERAL = new TickScriptElementType("STRING_LITERAL");
  IElementType TYPE_DECLARATION = new TickScriptElementType("TYPE_DECLARATION");
  IElementType UNARY_EXPRESSION = new TickScriptElementType("UNARY_EXPRESSION");

  IElementType ASGN = new TickScriptTokenType("=");
  IElementType AT = new TickScriptTokenType("@");
  IElementType COMMA = new TickScriptTokenType(",");
  IElementType DOT = new TickScriptTokenType(".");
  IElementType DURATION = new TickScriptTokenType("DURATION");
  IElementType FALSE = new TickScriptTokenType("FALSE");
  IElementType ID = new TickScriptTokenType("ID");
  IElementType KW_LAMBDA = new TickScriptTokenType("lambda:");
  IElementType KW_VAR = new TickScriptTokenType("var");
  IElementType LINE_COMMENT = new TickScriptTokenType("line_comment");
  IElementType L_BRACKET = new TickScriptTokenType("[");
  IElementType L_PAREN = new TickScriptTokenType("(");
  IElementType NUMBER = new TickScriptTokenType("NUMBER");
  IElementType OP_AND = new TickScriptTokenType("AND");
  IElementType OP_DIV = new TickScriptTokenType("/");
  IElementType OP_EQUAL = new TickScriptTokenType("==");
  IElementType OP_GREATER = new TickScriptTokenType(">");
  IElementType OP_GREATEREQUAL = new TickScriptTokenType(">=");
  IElementType OP_LESS = new TickScriptTokenType("<");
  IElementType OP_LESSEQUAL = new TickScriptTokenType("<=");
  IElementType OP_MINUS = new TickScriptTokenType("-");
  IElementType OP_MOD = new TickScriptTokenType("%");
  IElementType OP_MULT = new TickScriptTokenType("*");
  IElementType OP_NOT = new TickScriptTokenType("!");
  IElementType OP_NOTEQUAL = new TickScriptTokenType("!=");
  IElementType OP_OR = new TickScriptTokenType("OR");
  IElementType OP_PLUS = new TickScriptTokenType("+");
  IElementType OP_REGEXEQUAL = new TickScriptTokenType("=~");
  IElementType OP_REGEXNOTEQUAL = new TickScriptTokenType("!~");
  IElementType PIPE = new TickScriptTokenType("|");
  IElementType REFERENCE_STRING = new TickScriptTokenType("REFERENCE_STRING");
  IElementType REGEX_STRING = new TickScriptTokenType("REGEX_STRING");
  IElementType R_BRACKET = new TickScriptTokenType("]");
  IElementType R_PAREN = new TickScriptTokenType(")");
  IElementType SINGLE_QUOTED_STRING = new TickScriptTokenType("SINGLE_QUOTED_STRING");
  IElementType TRIPLE_QUOTED_STRING = new TickScriptTokenType("TRIPLE_QUOTED_STRING");
  IElementType TRUE = new TickScriptTokenType("TRUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BINARY_ADDITION_EXPRESSION) {
        return new TickScriptBinaryAdditionExpressionImpl(node);
      }
      else if (type == BINARY_AND_EXPRESSION) {
        return new TickScriptBinaryAndExpressionImpl(node);
      }
      else if (type == BINARY_EQUALITY_EXPRESSION) {
        return new TickScriptBinaryEqualityExpressionImpl(node);
      }
      else if (type == BINARY_MULTIPLY_EXPRESSION) {
        return new TickScriptBinaryMultiplyExpressionImpl(node);
      }
      else if (type == BINARY_OR_EXPRESSION) {
        return new TickScriptBinaryOrExpressionImpl(node);
      }
      else if (type == BINARY_RELATIONAL_EXPRESSION) {
        return new TickScriptBinaryRelationalExpressionImpl(node);
      }
      else if (type == BOOLEAN_LITERAL) {
        return new TickScriptBooleanLiteralImpl(node);
      }
      else if (type == CHAIN_AT_EXPRESSION) {
        return new TickScriptChainAtExpressionImpl(node);
      }
      else if (type == CHAIN_DOT_EXPRESSION) {
        return new TickScriptChainDotExpressionImpl(node);
      }
      else if (type == CHAIN_PIPE_EXPRESSION) {
        return new TickScriptChainPipeExpressionImpl(node);
      }
      else if (type == DECLARATION) {
        return new TickScriptDeclarationImpl(node);
      }
      else if (type == DURATION_LITERAL) {
        return new TickScriptDurationLiteralImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new TickScriptIdentifierImpl(node);
      }
      else if (type == LAMBDA_EXPRESSION) {
        return new TickScriptLambdaExpressionImpl(node);
      }
      else if (type == METHOD_CALL_EXPRESSION) {
        return new TickScriptMethodCallExpressionImpl(node);
      }
      else if (type == NUMBER_LITERAL) {
        return new TickScriptNumberLiteralImpl(node);
      }
      else if (type == PARAMETER_LIST) {
        return new TickScriptParameterListImpl(node);
      }
      else if (type == PARENTHESIZED_EXPRESSION) {
        return new TickScriptParenthesizedExpressionImpl(node);
      }
      else if (type == REFERENCE_LITERAL) {
        return new TickScriptReferenceLiteralImpl(node);
      }
      else if (type == REGEX_LITERAL) {
        return new TickScriptRegexLiteralImpl(node);
      }
      else if (type == STAR_LITERAL) {
        return new TickScriptStarLiteralImpl(node);
      }
      else if (type == STRING_LIST) {
        return new TickScriptStringListImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new TickScriptStringLiteralImpl(node);
      }
      else if (type == TYPE_DECLARATION) {
        return new TickScriptTypeDeclarationImpl(node);
      }
      else if (type == UNARY_EXPRESSION) {
        return new TickScriptUnaryExpressionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
