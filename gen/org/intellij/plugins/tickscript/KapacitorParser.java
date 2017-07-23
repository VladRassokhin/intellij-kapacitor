// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.tickscript;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.intellij.plugins.tickscript.KapacitorElementTypes.*;
import static org.intellij.plugins.tickscript.psi.KapacitorParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class KapacitorParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == PARAMETER_LIST) {
      r = ParameterList(b, 0);
    }
    else if (t == BOOLEAN_LITERAL) {
      r = boolean_literal(b, 0);
    }
    else if (t == DECLARATION) {
      r = declaration(b, 0);
    }
    else if (t == DURATION_LITERAL) {
      r = duration_literal(b, 0);
    }
    else if (t == EXPRESSION) {
      r = expression(b, 0, -1);
    }
    else if (t == NUMBER_LITERAL) {
      r = number_literal(b, 0);
    }
    else if (t == REFERENCE_LITERAL) {
      r = reference_literal(b, 0);
    }
    else if (t == REGEX_LITERAL) {
      r = regex_literal(b, 0);
    }
    else if (t == STAR_LITERAL) {
      r = star_literal(b, 0);
    }
    else if (t == STRING_LITERAL) {
      r = string_literal(b, 0);
    }
    else if (t == TYPE_DECLARATION) {
      r = type_declaration(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return program(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(BINARY_ADDITION_EXPRESSION, BINARY_AND_EXPRESSION, BINARY_EQUALITY_EXPRESSION, BINARY_MULTIPLY_EXPRESSION,
      BINARY_OR_EXPRESSION, BINARY_RELATIONAL_EXPRESSION, BOOLEAN_LITERAL, CHAIN_AT_EXPRESSION,
      CHAIN_DOT_EXPRESSION, CHAIN_PIPE_EXPRESSION, DURATION_LITERAL, EXPRESSION,
      IDENTIFIER, LAMBDA_EXPRESSION, LITERAL, METHOD_CALL_EXPRESSION,
      NUMBER_LITERAL, PARENTHESIZED_EXPRESSION, REFERENCE_LITERAL, REGEX_LITERAL,
      STAR_LITERAL, STRING_LIST, STRING_LITERAL, UNARY_EXPRESSION),
  };

  /* ********************************************************** */
  // '(' (expression? (',' expression )* )?')'
  public static boolean ParameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList")) return false;
    if (!nextTokenIs(b, L_PAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER_LIST, null);
    r = consumeToken(b, L_PAREN);
    p = r; // pin = 1
    r = r && report_error_(b, ParameterList_1(b, l + 1));
    r = p && consumeToken(b, R_PAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (expression? (',' expression )* )?
  private static boolean ParameterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1")) return false;
    ParameterList_1_0(b, l + 1);
    return true;
  }

  // expression? (',' expression )*
  private static boolean ParameterList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = ParameterList_1_0_0(b, l + 1);
    p = r; // pin = 1
    r = r && ParameterList_1_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // expression?
  private static boolean ParameterList_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0_0")) return false;
    expression(b, l + 1, -1);
    return true;
  }

  // (',' expression )*
  private static boolean ParameterList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ParameterList_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ParameterList_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' expression
  private static boolean ParameterList_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && expression(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // (string_literal | identifier | star_literal) (','|&']')
  static boolean StringListItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringListItem")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = StringListItem_0(b, l + 1);
    p = r; // pin = 1
    r = r && StringListItem_1(b, l + 1);
    exit_section_(b, l, m, r, p, not_bracket_or_next_value_parser_);
    return r || p;
  }

  // string_literal | identifier | star_literal
  private static boolean StringListItem_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringListItem_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_literal(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    if (!r) r = star_literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','|&']'
  private static boolean StringListItem_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringListItem_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    if (!r) r = StringListItem_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &']'
  private static boolean StringListItem_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringListItem_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, R_BRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OP_Plus | OP_Minus
  static boolean addOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addOp")) return false;
    if (!nextTokenIs(b, "<operator>", OP_MINUS, OP_PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<operator>");
    r = consumeToken(b, OP_PLUS);
    if (!r) r = consumeToken(b, OP_MINUS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OP_And
  static boolean andOp(PsiBuilder b, int l) {
    return consumeToken(b, OP_AND);
  }

  /* ********************************************************** */
  // TRUE | FALSE
  public static boolean boolean_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_literal")) return false;
    if (!nextTokenIs(b, "<boolean literal>", FALSE, TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_LITERAL, "<boolean literal>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "var" identifier "=" expression
  public static boolean declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration")) return false;
    if (!nextTokenIs(b, KW_VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_VAR);
    r = r && identifier(b, l + 1);
    r = r && consumeToken(b, ASGN);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // DURATION
  public static boolean duration_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "duration_literal")) return false;
    if (!nextTokenIs(b, DURATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DURATION);
    exit_section_(b, m, DURATION_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // OP_Equal | OP_NotEqual | OP_RegexEqual | OP_RegexNotEqual
  static boolean equalityOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<operator>");
    r = consumeToken(b, OP_EQUAL);
    if (!r) r = consumeToken(b, OP_NOTEQUAL);
    if (!r) r = consumeToken(b, OP_REGEXEQUAL);
    if (!r) r = consumeToken(b, OP_REGEXNOTEQUAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OP_Mult | OP_Div | OP_Mod
  static boolean mulOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mulOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<operator>");
    r = consumeToken(b, OP_MULT);
    if (!r) r = consumeToken(b, OP_DIV);
    if (!r) r = consumeToken(b, OP_MOD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(']'|(string_literal | identifier | star_literal))
  static boolean not_bracket_or_next_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_bracket_or_next_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !not_bracket_or_next_value_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ']'|(string_literal | identifier | star_literal)
  private static boolean not_bracket_or_next_value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_bracket_or_next_value_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, R_BRACKET);
    if (!r) r = not_bracket_or_next_value_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // string_literal | identifier | star_literal
  private static boolean not_bracket_or_next_value_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_bracket_or_next_value_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_literal(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    if (!r) r = star_literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NUMBER
  public static boolean number_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal")) return false;
    if (!nextTokenIs(b, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    exit_section_(b, m, NUMBER_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // OP_Or
  static boolean orOp(PsiBuilder b, int l) {
    return consumeToken(b, OP_OR);
  }

  /* ********************************************************** */
  // statement*
  static boolean program(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program")) return false;
    int c = current_position_(b);
    while (true) {
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "program", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // REFERENCE_STRING
  public static boolean reference_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_literal")) return false;
    if (!nextTokenIs(b, REFERENCE_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REFERENCE_STRING);
    exit_section_(b, m, REFERENCE_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // REGEX_STRING
  public static boolean regex_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "regex_literal")) return false;
    if (!nextTokenIs(b, REGEX_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REGEX_STRING);
    exit_section_(b, m, REGEX_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // OP_Less | OP_Greater | OP_LessEqual | OP_GreaterEqual
  static boolean relationalOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationalOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<operator>");
    r = consumeToken(b, OP_LESS);
    if (!r) r = consumeToken(b, OP_GREATER);
    if (!r) r = consumeToken(b, OP_LESSEQUAL);
    if (!r) r = consumeToken(b, OP_GREATEREQUAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "*"
  public static boolean star_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "star_literal")) return false;
    if (!nextTokenIs(b, OP_MULT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_MULT);
    exit_section_(b, m, STAR_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // type_declaration | declaration | expression
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_declaration(b, l + 1);
    if (!r) r = declaration(b, l + 1);
    if (!r) r = expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SINGLE_QUOTED_STRING | TRIPLE_QUOTED_STRING
  public static boolean string_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal")) return false;
    if (!nextTokenIs(b, "<string literal>", SINGLE_QUOTED_STRING, TRIPLE_QUOTED_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_LITERAL, "<string literal>");
    r = consumeToken(b, SINGLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, TRIPLE_QUOTED_STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "var" identifier identifier
  public static boolean type_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_declaration")) return false;
    if (!nextTokenIs(b, KW_VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_VAR);
    r = r && identifier(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, TYPE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // addOp | OP_Not
  static boolean unaryOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<operator>");
    r = addOp(b, l + 1);
    if (!r) r = consumeToken(b, OP_NOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression root: expression
  // Operator priority table:
  // 0: PREFIX(ParenthesizedExpression)
  // 1: PREFIX(LambdaExpression)
  // 2: BINARY(BinaryOrExpression)
  // 3: BINARY(BinaryAndExpression)
  // 4: BINARY(BinaryEqualityExpression)
  // 5: BINARY(BinaryRelationalExpression)
  // 6: BINARY(BinaryAdditionExpression)
  // 7: BINARY(BinaryMultiplyExpression)
  // 8: BINARY(ChainPipeExpression)
  // 9: BINARY(ChainDotExpression)
  // 10: BINARY(ChainAtExpression)
  // 11: POSTFIX(MethodCallExpression)
  // 12: ATOM(identifier)
  // 13: PREFIX(UnaryExpression)
  // 14: ATOM(literal)
  // 15: ATOM(StringList)
  public static boolean expression(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expression")) return false;
    addVariant(b, "<expression>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expression>");
    r = ParenthesizedExpression(b, l + 1);
    if (!r) r = LambdaExpression(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    if (!r) r = UnaryExpression(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = StringList(b, l + 1);
    p = r;
    r = r && expression_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean expression_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expression_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 2 && orOp(b, l + 1)) {
        r = expression(b, l, 2);
        exit_section_(b, l, m, BINARY_OR_EXPRESSION, r, true, null);
      }
      else if (g < 3 && andOp(b, l + 1)) {
        r = expression(b, l, 3);
        exit_section_(b, l, m, BINARY_AND_EXPRESSION, r, true, null);
      }
      else if (g < 4 && equalityOp(b, l + 1)) {
        r = expression(b, l, 4);
        exit_section_(b, l, m, BINARY_EQUALITY_EXPRESSION, r, true, null);
      }
      else if (g < 5 && relationalOp(b, l + 1)) {
        r = expression(b, l, 5);
        exit_section_(b, l, m, BINARY_RELATIONAL_EXPRESSION, r, true, null);
      }
      else if (g < 6 && addOp(b, l + 1)) {
        r = expression(b, l, 6);
        exit_section_(b, l, m, BINARY_ADDITION_EXPRESSION, r, true, null);
      }
      else if (g < 7 && mulOp(b, l + 1)) {
        r = expression(b, l, 7);
        exit_section_(b, l, m, BINARY_MULTIPLY_EXPRESSION, r, true, null);
      }
      else if (g < 8 && consumeTokenSmart(b, PIPE)) {
        r = expression(b, l, 8);
        exit_section_(b, l, m, CHAIN_PIPE_EXPRESSION, r, true, null);
      }
      else if (g < 9 && consumeTokenSmart(b, DOT)) {
        r = expression(b, l, 9);
        exit_section_(b, l, m, CHAIN_DOT_EXPRESSION, r, true, null);
      }
      else if (g < 10 && consumeTokenSmart(b, AT)) {
        r = expression(b, l, 10);
        exit_section_(b, l, m, CHAIN_AT_EXPRESSION, r, true, null);
      }
      else if (g < 11 && ParameterList(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, METHOD_CALL_EXPRESSION, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  public static boolean ParenthesizedExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParenthesizedExpression")) return false;
    if (!nextTokenIsSmart(b, L_PAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = ParenthesizedExpression_0(b, l + 1);
    p = r;
    r = p && expression(b, l, 0);
    r = p && report_error_(b, ParenthesizedExpression_1(b, l + 1)) && r;
    exit_section_(b, l, m, PARENTHESIZED_EXPRESSION, r, p, null);
    return r || p;
  }

  // '(' <<push 0>>
  private static boolean ParenthesizedExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParenthesizedExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, L_PAREN);
    r = r && push(b, l + 1, 0);
    exit_section_(b, m, null, r);
    return r;
  }

  // ')' <<pop>>
  private static boolean ParenthesizedExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParenthesizedExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, R_PAREN);
    r = r && pop(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  public static boolean LambdaExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaExpression")) return false;
    if (!nextTokenIsSmart(b, KW_LAMBDA)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, KW_LAMBDA);
    p = r;
    r = p && expression(b, l, 1);
    exit_section_(b, l, m, LAMBDA_EXPRESSION, r, p, null);
    return r || p;
  }

  // ID
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIsSmart(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER, "<Identifier>");
    r = consumeTokenSmart(b, ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  public static boolean UnaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryExpression")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = unaryOp(b, l + 1);
    p = r;
    r = p && expression(b, l, 13);
    exit_section_(b, l, m, UNARY_EXPRESSION, r, p, null);
    return r || p;
  }

  // number_literal | string_literal | boolean_literal | duration_literal | regex_literal | star_literal | reference_literal
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, LITERAL, "<literal>");
    r = number_literal(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    if (!r) r = boolean_literal(b, l + 1);
    if (!r) r = duration_literal(b, l + 1);
    if (!r) r = regex_literal(b, l + 1);
    if (!r) r = star_literal(b, l + 1);
    if (!r) r = reference_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '[' StringListItem* ']'
  public static boolean StringList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringList")) return false;
    if (!nextTokenIsSmart(b, L_BRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STRING_LIST, null);
    r = consumeTokenSmart(b, L_BRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, StringList_1(b, l + 1));
    r = p && consumeToken(b, R_BRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // StringListItem*
  private static boolean StringList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!StringListItem(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StringList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  final static Parser not_bracket_or_next_value_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return not_bracket_or_next_value(b, l + 1);
    }
  };
}
