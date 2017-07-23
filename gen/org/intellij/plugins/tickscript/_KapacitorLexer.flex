package org.intellij.plugins.tickscript;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.intellij.plugins.tickscript.KapacitorElementTypes.*;

%%

%{
  public _KapacitorLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _KapacitorLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

LINE_COMMENT=("//".*)|(#.*)
ID=[a-zA-Z_][0-9a-zA-Z_]*
NUMBER=-?([0-9]+(\.[0-9]+)?)|(\.[0-9]+)
DURATION=[1-9][0-9]*([uµsmhdw]|ms)
SINGLE_QUOTED_STRING='([^\\']|\\.)*'
TRIPLE_QUOTED_STRING='''([^']+'{0,2})*'''
REGEX_STRING="/"([^\\\r\n]|\\[^\r\n])*"/"
REFERENCE_STRING=\"([^\\\"\r\n]|\\[^\r\n])*\"

%%
<YYINITIAL> {
  {WHITE_SPACE}               { return WHITE_SPACE; }

  "("                         { return L_PAREN; }
  ")"                         { return R_PAREN; }
  "["                         { return L_BRACKET; }
  "]"                         { return R_BRACKET; }
  "="                         { return ASGN; }
  "|"                         { return PIPE; }
  "@"                         { return AT; }
  ","                         { return COMMA; }
  "."                         { return DOT; }
  "!"                         { return OP_NOT; }
  "+"                         { return OP_PLUS; }
  "-"                         { return OP_MINUS; }
  "*"                         { return OP_MULT; }
  "/"                         { return OP_DIV; }
  "%"                         { return OP_MOD; }
  "=="                        { return OP_EQUAL; }
  "!="                        { return OP_NOTEQUAL; }
  "<"                         { return OP_LESS; }
  ">"                         { return OP_GREATER; }
  "<="                        { return OP_LESSEQUAL; }
  ">="                        { return OP_GREATEREQUAL; }
  "=~"                        { return OP_REGEXEQUAL; }
  "!~"                        { return OP_REGEXNOTEQUAL; }
  "AND"                       { return OP_AND; }
  "OR"                        { return OP_OR; }
  "var"                       { return KW_VAR; }
  "lambda:"                   { return KW_LAMBDA; }
  "TRUE"                      { return TRUE; }
  "FALSE"                     { return FALSE; }

  {LINE_COMMENT}              { return LINE_COMMENT; }
  {ID}                        { return ID; }
  {NUMBER}                    { return NUMBER; }
  {DURATION}                  { return DURATION; }
  {SINGLE_QUOTED_STRING}      { return SINGLE_QUOTED_STRING; }
  {TRIPLE_QUOTED_STRING}      { return TRIPLE_QUOTED_STRING; }
  {REGEX_STRING}              { return REGEX_STRING; }
  {REFERENCE_STRING}          { return REFERENCE_STRING; }

}

[^] { return BAD_CHARACTER; }
