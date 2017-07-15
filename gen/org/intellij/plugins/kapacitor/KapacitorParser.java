// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.kapacitor;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.intellij.plugins.kapacitor.KapacitorElementTypes.*;
import static org.intellij.plugins.kapacitor.psi.KapacitorParserUtil.*;
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
    if (t == PRIMARY_FUNC) {
      r = PrimaryFunc(b, 0);
    }
    else if (t == STRING_LIST) {
      r = StringList(b, 0);
    }
    else if (t == BOOLEAN_LITERAL) {
      r = boolean_literal(b, 0);
    }
    else if (t == CHAIN) {
      r = chain(b, 0);
    }
    else if (t == DECLARATION) {
      r = declaration(b, 0);
    }
    else if (t == DURATION_LITERAL) {
      r = duration_literal(b, 0);
    }
    else if (t == EXPRESSION) {
      r = expression(b, 0);
    }
    else if (t == FUNCTION) {
      r = function(b, 0);
    }
    else if (t == IDENTIFIER) {
      r = identifier(b, 0);
    }
    else if (t == LAMBDA) {
      r = lambda(b, 0);
    }
    else if (t == LITERAL) {
      r = literal(b, 0);
    }
    else if (t == NUMBER_LITERAL) {
      r = number_literal(b, 0);
    }
    else if (t == OPERATOR_LITERAL) {
      r = operator_literal(b, 0);
    }
    else if (t == PRIMARY_EXPR) {
      r = primary_expr(b, 0);
    }
    else if (t == PRIMARY_UNARY_EXPR) {
      r = primary_unary_expr(b, 0);
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
    else if (t == STATEMENT) {
      r = statement(b, 0);
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
    create_token_set_(EXPRESSION, FUNCTION, LAMBDA, PRIMARY_EXPR),
    create_token_set_(BOOLEAN_LITERAL, DURATION_LITERAL, LITERAL, NUMBER_LITERAL,
      OPERATOR_LITERAL, REFERENCE_LITERAL, REGEX_LITERAL, STAR_LITERAL,
      STRING_LITERAL),
  };

  /* ********************************************************** */
  // identifier "(" PrimaryParameter* ")"
  public static boolean PrimaryFunc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryFunc")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, L_PAREN);
    r = r && PrimaryFunc_2(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, PRIMARY_FUNC, r);
    return r;
  }

  // PrimaryParameter*
  private static boolean PrimaryFunc_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryFunc_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!PrimaryParameter(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PrimaryFunc_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // (primary_expr) (','|&')')
  static boolean PrimaryParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryParameter")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = PrimaryParameter_0(b, l + 1);
    p = r; // pin = 1
    r = r && PrimaryParameter_1(b, l + 1);
    exit_section_(b, l, m, r, p, not_paren_or_next_primary_parameter_parser_);
    return r || p;
  }

  // (primary_expr)
  private static boolean PrimaryParameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryParameter_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primary_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','|&')'
  private static boolean PrimaryParameter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryParameter_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    if (!r) r = PrimaryParameter_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &')'
  private static boolean PrimaryParameter_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryParameter_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, R_PAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '[' StringListItem* ']'
  public static boolean StringList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringList")) return false;
    if (!nextTokenIs(b, L_BRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STRING_LIST, null);
    r = consumeToken(b, L_BRACKET);
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
  // ("@"|"|"|".") function chain* | ("." identifier chain*)
  public static boolean chain(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chain")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CHAIN, "<chain>");
    r = chain_0(b, l + 1);
    if (!r) r = chain_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("@"|"|"|".") function chain*
  private static boolean chain_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chain_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = chain_0_0(b, l + 1);
    r = r && function(b, l + 1);
    r = r && chain_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "@"|"|"|"."
  private static boolean chain_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chain_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, PIPE);
    if (!r) r = consumeToken(b, DOT);
    exit_section_(b, m, null, r);
    return r;
  }

  // chain*
  private static boolean chain_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chain_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!chain(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "chain_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // "." identifier chain*
  private static boolean chain_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chain_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && identifier(b, l + 1);
    r = r && chain_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // chain*
  private static boolean chain_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chain_1_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!chain(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "chain_1_2", c)) break;
      c = current_position_(b);
    }
    return true;
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
    r = r && expression(b, l + 1);
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
  // function_expr | function chain* | identifier_expr | identifier chain* |  primary_expr | lambda | StringList | primary
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPRESSION, "<expression>");
    r = function_expr(b, l + 1);
    if (!r) r = expression_1(b, l + 1);
    if (!r) r = identifier_expr(b, l + 1);
    if (!r) r = expression_3(b, l + 1);
    if (!r) r = primary_expr(b, l + 1);
    if (!r) r = lambda(b, l + 1);
    if (!r) r = StringList(b, l + 1);
    if (!r) r = primary(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // function chain*
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function(b, l + 1);
    r = r && expression_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // chain*
  private static boolean expression_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!chain(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression_1_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // identifier chain*
  private static boolean expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && expression_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // chain*
  private static boolean expression_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_3_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!chain(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression_3_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // identifier "(" parameter* ")"
  public static boolean function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, L_PAREN);
    r = r && function_2(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, FUNCTION, r);
    return r;
  }

  // parameter*
  private static boolean function_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!parameter(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // function operator_literal primary
  static boolean function_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_expr")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function(b, l + 1);
    r = r && operator_literal(b, l + 1);
    r = r && primary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // identifier operator_literal primary
  static boolean identifier_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_expr")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && operator_literal(b, l + 1);
    r = r && primary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "lambda:" primary_expr
  public static boolean lambda(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda")) return false;
    if (!nextTokenIs(b, KW_LAMBDA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_LAMBDA);
    r = r && primary_expr(b, l + 1);
    exit_section_(b, m, LAMBDA, r);
    return r;
  }

  /* ********************************************************** */
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
  // !(')'|(expression))
  static boolean not_paren_or_next_parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_paren_or_next_parameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !not_paren_or_next_parameter_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ')'|(expression)
  private static boolean not_paren_or_next_parameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_paren_or_next_parameter_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, R_PAREN);
    if (!r) r = not_paren_or_next_parameter_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (expression)
  private static boolean not_paren_or_next_parameter_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_paren_or_next_parameter_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(')'|(primary_expr))
  static boolean not_paren_or_next_primary_parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_paren_or_next_primary_parameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !not_paren_or_next_primary_parameter_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ')'|(primary_expr)
  private static boolean not_paren_or_next_primary_parameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_paren_or_next_primary_parameter_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, R_PAREN);
    if (!r) r = not_paren_or_next_primary_parameter_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (primary_expr)
  private static boolean not_paren_or_next_primary_parameter_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_paren_or_next_primary_parameter_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primary_expr(b, l + 1);
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
  // "+" | "-" | "*" | "/" | "==" | "!=" |
  //                  "<" | "<=" | ">" | ">=" | "=~" | "!~" |
  //                  "AND" | "OR"
  public static boolean operator_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operator_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERATOR_LITERAL, "<operator literal>");
    r = consumeToken(b, OP_PLUS);
    if (!r) r = consumeToken(b, OP_MINUS);
    if (!r) r = consumeToken(b, OP_MULT);
    if (!r) r = consumeToken(b, OP_DIV);
    if (!r) r = consumeToken(b, OP_EQUAL);
    if (!r) r = consumeToken(b, OP_NOTEQUAL);
    if (!r) r = consumeToken(b, OP_LESS);
    if (!r) r = consumeToken(b, OP_LESSEQUAL);
    if (!r) r = consumeToken(b, OP_GREATER);
    if (!r) r = consumeToken(b, OP_GREATEREQUAL);
    if (!r) r = consumeToken(b, OP_REGEXEQUAL);
    if (!r) r = consumeToken(b, OP_REGEXNOTEQUAL);
    if (!r) r = consumeToken(b, OP_AND);
    if (!r) r = consumeToken(b, OP_OR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (expression) (','|&')')
  static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = parameter_0(b, l + 1);
    p = r; // pin = 1
    r = r && parameter_1(b, l + 1);
    exit_section_(b, l, m, r, p, not_paren_or_next_parameter_parser_);
    return r || p;
  }

  // (expression)
  private static boolean parameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','|&')'
  private static boolean parameter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    if (!r) r = parameter_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &')'
  private static boolean parameter_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, R_PAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "(" primary_expr ")" | literal | PrimaryFunc | identifier | primary_unary_expr
  static boolean primary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primary_0(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = PrimaryFunc(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    if (!r) r = primary_unary_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "(" primary_expr ")"
  private static boolean primary_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PAREN);
    r = r && primary_expr(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // primary (operator_literal primary)*
  public static boolean primary_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, PRIMARY_EXPR, "<primary expr>");
    r = primary(b, l + 1);
    r = r && primary_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (operator_literal primary)*
  private static boolean primary_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expr_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!primary_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primary_expr_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // operator_literal primary
  private static boolean primary_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = operator_literal(b, l + 1);
    r = r && primary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "-" primary | "!" primary
  public static boolean primary_unary_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_unary_expr")) return false;
    if (!nextTokenIs(b, "<primary unary expr>", OP_NOT, OP_MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_UNARY_EXPR, "<primary unary expr>");
    r = primary_unary_expr_0(b, l + 1);
    if (!r) r = primary_unary_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "-" primary
  private static boolean primary_unary_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_unary_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_MINUS);
    r = r && primary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "!" primary
  private static boolean primary_unary_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_unary_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_NOT);
    r = r && primary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = type_declaration(b, l + 1);
    if (!r) r = declaration(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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

  final static Parser not_bracket_or_next_value_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return not_bracket_or_next_value(b, l + 1);
    }
  };
  final static Parser not_paren_or_next_parameter_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return not_paren_or_next_parameter(b, l + 1);
    }
  };
  final static Parser not_paren_or_next_primary_parameter_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return not_paren_or_next_primary_parameter(b, l + 1);
    }
  };
}
