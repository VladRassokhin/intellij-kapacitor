// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.kapacitor;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.plugins.kapacitor.psi.impl.*;

public interface KapacitorElementTypes {

  IElementType BINARY_ADDITION_EXPRESSION = new KapacitorElementType("BINARY_ADDITION_EXPRESSION");
  IElementType BINARY_AND_EXPRESSION = new KapacitorElementType("BINARY_AND_EXPRESSION");
  IElementType BINARY_EQUALITY_EXPRESSION = new KapacitorElementType("BINARY_EQUALITY_EXPRESSION");
  IElementType BINARY_MULTIPLY_EXPRESSION = new KapacitorElementType("BINARY_MULTIPLY_EXPRESSION");
  IElementType BINARY_OR_EXPRESSION = new KapacitorElementType("BINARY_OR_EXPRESSION");
  IElementType BINARY_RELATIONAL_EXPRESSION = new KapacitorElementType("BINARY_RELATIONAL_EXPRESSION");
  IElementType BOOLEAN_LITERAL = new KapacitorElementType("BOOLEAN_LITERAL");
  IElementType CHAIN_AT_EXPRESSION = new KapacitorElementType("CHAIN_AT_EXPRESSION");
  IElementType CHAIN_DOT_EXPRESSION = new KapacitorElementType("CHAIN_DOT_EXPRESSION");
  IElementType CHAIN_PIPE_EXPRESSION = new KapacitorElementType("CHAIN_PIPE_EXPRESSION");
  IElementType DECLARATION = new KapacitorElementType("DECLARATION");
  IElementType DURATION_LITERAL = new KapacitorElementType("DURATION_LITERAL");
  IElementType EXPRESSION = new KapacitorElementType("EXPRESSION");
  IElementType IDENTIFIER = new KapacitorElementType("IDENTIFIER");
  IElementType LAMBDA_EXPRESSION = new KapacitorElementType("LAMBDA_EXPRESSION");
  IElementType LITERAL = new KapacitorElementType("LITERAL");
  IElementType METHOD_CALL_EXPRESSION = new KapacitorElementType("METHOD_CALL_EXPRESSION");
  IElementType NUMBER_LITERAL = new KapacitorElementType("NUMBER_LITERAL");
  IElementType PARAMETER_LIST = new KapacitorElementType("PARAMETER_LIST");
  IElementType PARENTHESIZED_EXPRESSION = new KapacitorElementType("PARENTHESIZED_EXPRESSION");
  IElementType REFERENCE_LITERAL = new KapacitorElementType("REFERENCE_LITERAL");
  IElementType REGEX_LITERAL = new KapacitorElementType("REGEX_LITERAL");
  IElementType STAR_LITERAL = new KapacitorElementType("STAR_LITERAL");
  IElementType STRING_LIST = new KapacitorElementType("STRING_LIST");
  IElementType STRING_LITERAL = new KapacitorElementType("STRING_LITERAL");
  IElementType TYPE_DECLARATION = new KapacitorElementType("TYPE_DECLARATION");
  IElementType UNARY_EXPRESSION = new KapacitorElementType("UNARY_EXPRESSION");

  IElementType ASGN = new KapacitorTokenType("=");
  IElementType AT = new KapacitorTokenType("@");
  IElementType COMMA = new KapacitorTokenType(",");
  IElementType DOT = new KapacitorTokenType(".");
  IElementType DURATION = new KapacitorTokenType("DURATION");
  IElementType FALSE = new KapacitorTokenType("FALSE");
  IElementType ID = new KapacitorTokenType("ID");
  IElementType KW_LAMBDA = new KapacitorTokenType("lambda:");
  IElementType KW_VAR = new KapacitorTokenType("var");
  IElementType LINE_COMMENT = new KapacitorTokenType("line_comment");
  IElementType L_BRACKET = new KapacitorTokenType("[");
  IElementType L_PAREN = new KapacitorTokenType("(");
  IElementType NUMBER = new KapacitorTokenType("NUMBER");
  IElementType OP_AND = new KapacitorTokenType("AND");
  IElementType OP_DIV = new KapacitorTokenType("/");
  IElementType OP_EQUAL = new KapacitorTokenType("==");
  IElementType OP_GREATER = new KapacitorTokenType(">");
  IElementType OP_GREATEREQUAL = new KapacitorTokenType(">=");
  IElementType OP_LESS = new KapacitorTokenType("<");
  IElementType OP_LESSEQUAL = new KapacitorTokenType("<=");
  IElementType OP_MINUS = new KapacitorTokenType("-");
  IElementType OP_MOD = new KapacitorTokenType("%");
  IElementType OP_MULT = new KapacitorTokenType("*");
  IElementType OP_NOT = new KapacitorTokenType("!");
  IElementType OP_NOTEQUAL = new KapacitorTokenType("!=");
  IElementType OP_OR = new KapacitorTokenType("OR");
  IElementType OP_PLUS = new KapacitorTokenType("+");
  IElementType OP_REGEXEQUAL = new KapacitorTokenType("=~");
  IElementType OP_REGEXNOTEQUAL = new KapacitorTokenType("!~");
  IElementType PIPE = new KapacitorTokenType("|");
  IElementType REFERENCE_STRING = new KapacitorTokenType("REFERENCE_STRING");
  IElementType REGEX_STRING = new KapacitorTokenType("REGEX_STRING");
  IElementType R_BRACKET = new KapacitorTokenType("]");
  IElementType R_PAREN = new KapacitorTokenType(")");
  IElementType SINGLE_QUOTED_STRING = new KapacitorTokenType("SINGLE_QUOTED_STRING");
  IElementType TRIPLE_QUOTED_STRING = new KapacitorTokenType("TRIPLE_QUOTED_STRING");
  IElementType TRUE = new KapacitorTokenType("TRUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == BINARY_ADDITION_EXPRESSION) {
        return new KapacitorBinaryAdditionExpressionImpl(node);
      }
      else if (type == BINARY_AND_EXPRESSION) {
        return new KapacitorBinaryAndExpressionImpl(node);
      }
      else if (type == BINARY_EQUALITY_EXPRESSION) {
        return new KapacitorBinaryEqualityExpressionImpl(node);
      }
      else if (type == BINARY_MULTIPLY_EXPRESSION) {
        return new KapacitorBinaryMultiplyExpressionImpl(node);
      }
      else if (type == BINARY_OR_EXPRESSION) {
        return new KapacitorBinaryOrExpressionImpl(node);
      }
      else if (type == BINARY_RELATIONAL_EXPRESSION) {
        return new KapacitorBinaryRelationalExpressionImpl(node);
      }
      else if (type == BOOLEAN_LITERAL) {
        return new KapacitorBooleanLiteralImpl(node);
      }
      else if (type == CHAIN_AT_EXPRESSION) {
        return new KapacitorChainAtExpressionImpl(node);
      }
      else if (type == CHAIN_DOT_EXPRESSION) {
        return new KapacitorChainDotExpressionImpl(node);
      }
      else if (type == CHAIN_PIPE_EXPRESSION) {
        return new KapacitorChainPipeExpressionImpl(node);
      }
      else if (type == DECLARATION) {
        return new KapacitorDeclarationImpl(node);
      }
      else if (type == DURATION_LITERAL) {
        return new KapacitorDurationLiteralImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new KapacitorIdentifierImpl(node);
      }
      else if (type == LAMBDA_EXPRESSION) {
        return new KapacitorLambdaExpressionImpl(node);
      }
      else if (type == METHOD_CALL_EXPRESSION) {
        return new KapacitorMethodCallExpressionImpl(node);
      }
      else if (type == NUMBER_LITERAL) {
        return new KapacitorNumberLiteralImpl(node);
      }
      else if (type == PARAMETER_LIST) {
        return new KapacitorParameterListImpl(node);
      }
      else if (type == PARENTHESIZED_EXPRESSION) {
        return new KapacitorParenthesizedExpressionImpl(node);
      }
      else if (type == REFERENCE_LITERAL) {
        return new KapacitorReferenceLiteralImpl(node);
      }
      else if (type == REGEX_LITERAL) {
        return new KapacitorRegexLiteralImpl(node);
      }
      else if (type == STAR_LITERAL) {
        return new KapacitorStarLiteralImpl(node);
      }
      else if (type == STRING_LIST) {
        return new KapacitorStringListImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new KapacitorStringLiteralImpl(node);
      }
      else if (type == TYPE_DECLARATION) {
        return new KapacitorTypeDeclarationImpl(node);
      }
      else if (type == UNARY_EXPRESSION) {
        return new KapacitorUnaryExpressionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
