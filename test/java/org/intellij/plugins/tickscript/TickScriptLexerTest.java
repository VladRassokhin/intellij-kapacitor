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
package org.intellij.plugins.tickscript;

import com.intellij.lexer.Lexer;
import org.jetbrains.annotations.NotNull;

public class TickScriptLexerTest extends BaseLexerTestCase {

  @Override
  protected @NotNull Lexer createLexer() {
    return new TickScriptLexer();
  }

  @Override
  protected @NotNull String getDirPath() {
    return "test-data/lexer";
  }

  public void testKeywords() {
    doTest("AND", "AND ('AND')");
    doTest("OR", "OR ('OR')");
    doTest("TRUE", "TRUE ('TRUE')");
    doTest("FALSE", "FALSE ('FALSE')");
    doTest("var", "var ('var')");
    doTest("lambda:", "lambda: ('lambda:')");
    doTest("lambda ", "ID ('lambda')\nWHITE_SPACE (' ')");
  }

  public void testNumbers() {
    doTest("42", "NUMBER ('42')");
    doTest("42.21", "NUMBER ('42.21')");
    doTest(".421", "NUMBER ('.421')");
    doTest("0.421", "NUMBER ('0.421')");
  }

  public void testDurations() {
    doTest("42s", "DURATION ('42s')");
    doTest("1u", "DURATION ('1u')");
    doTest("1µ", "DURATION ('1µ')");
    doTest("1ms", "DURATION ('1ms')");
    doTest("1h", "DURATION ('1h')");
    doTest("1d", "DURATION ('1d')");
    doTest("1w", "DURATION ('1w')");
  }

  public void testVariables() {
    doTest("variable", "ID ('variable')");
    doTest("myVar01", "ID ('myVar01')");
  }

  public void testReferences() {
    doTest("\"\"", "REFERENCE_STRING ('\"\"')");
    doTest("\"ref with spaces\"", "REFERENCE_STRING ('\"ref with spaces\"')");
    doTest("\"ref\\\"\"", "REFERENCE_STRING ('\"ref\\\"\"')");
  }

  public void testStrings() {
    doTest("''", "SINGLE_QUOTED_STRING ('''')");
    doTest("''''''", "TRIPLE_QUOTED_STRING ('''''''')");
    doTest("'str'", "SINGLE_QUOTED_STRING (''str'')");
    doTest("'str\\''", "SINGLE_QUOTED_STRING (''str\\''')");
    doTest("'''str'''", "TRIPLE_QUOTED_STRING (''''str'''')");
    doTest("'''s'tr'''", "TRIPLE_QUOTED_STRING (''''s'tr'''')");
    doTest("'''s\\'tr'''", "TRIPLE_QUOTED_STRING (''''s\\'tr'''')");

    doTest("'a''b'", "SINGLE_QUOTED_STRING (''a'')\nSINGLE_QUOTED_STRING (''b'')");
    doTest("'a'\n'b'", "SINGLE_QUOTED_STRING (''a'')\nWHITE_SPACE ('\\n')\nSINGLE_QUOTED_STRING (''b'')");

    doTest("'''x'''\n'''y'''","TRIPLE_QUOTED_STRING (''''x'''')\nWHITE_SPACE ('\\n')\nTRIPLE_QUOTED_STRING (''''y'''')");
  }

  public void testMultilineStrings() {
    doTest("'s\nt\nr'", "SINGLE_QUOTED_STRING (''s\\nt\\nr'')");
    doTest("'s\\nt\\nr'", "SINGLE_QUOTED_STRING (''s\\nt\\nr'')");

    doTest("'''s\nt\nr'''", "TRIPLE_QUOTED_STRING (''''s\\nt\\nr'''')");
    doTest("'''s\\nt\\nr'''", "TRIPLE_QUOTED_STRING (''''s\\nt\\nr'''')");
  }

  public void testRegex() {
    doTest("/.*/", "REGEX_STRING ('/.*/')");
    doTest("/^abc$/", "REGEX_STRING ('/^abc$/')");
    doTest("/^((.*)[a-z]+\\S{0,2})|cat\\/\\/$/", "REGEX_STRING ('/^((.*)[a-z]+\\S{0,2})|cat\\/\\/$/')");
  }

  public void testSpace() {
    doTest(" ", "WHITE_SPACE (' ')");
    doTest(" \t\n", "WHITE_SPACE (' \t\\n')");
  }

  public void testCombinations() {
    doTest("var x = avg()",
        """
            var ('var')
            WHITE_SPACE (' ')
            ID ('x')
            WHITE_SPACE (' ')
            = ('=')
            WHITE_SPACE (' ')
            ID ('avg')
            ( ('(')
            ) (')')""");
    doTest("var x = avg()|parallel(4)x.groupby('cpu')|window().period(10s)",
        """
            var ('var')
            WHITE_SPACE (' ')
            ID ('x')
            WHITE_SPACE (' ')
            = ('=')
            WHITE_SPACE (' ')
            ID ('avg')
            ( ('(')
            ) (')')
            | ('|')
            ID ('parallel')
            ( ('(')
            NUMBER ('4')
            ) (')')
            ID ('x')
            . ('.')
            ID ('groupby')
            ( ('(')
            SINGLE_QUOTED_STRING (''cpu'')
            ) (')')
            | ('|')
            ID ('window')
            ( ('(')
            ) (')')
            . ('.')
            ID ('period')
            ( ('(')
            DURATION ('10s')
            ) (')')""");
  }

  public void testComments() {
    doTest("// Comment all of this is ignored", "line_comment ('// Comment all of this is ignored')");
    doTest("var x = 1\n// Comment",
        """
            var ('var')
            WHITE_SPACE (' ')
            ID ('x')
            WHITE_SPACE (' ')
            = ('=')
            WHITE_SPACE (' ')
            NUMBER ('1')
            WHITE_SPACE ('\\n')
            line_comment ('// Comment')""");
    doTest("var x = 1\n// Comment\nx.groupby('cpu')",
        """
            var ('var')
            WHITE_SPACE (' ')
            ID ('x')
            WHITE_SPACE (' ')
            = ('=')
            WHITE_SPACE (' ')
            NUMBER ('1')
            WHITE_SPACE ('\\n')
            line_comment ('// Comment')
            WHITE_SPACE ('\\n')
            ID ('x')
            . ('.')
            ID ('groupby')
            ( ('(')
            SINGLE_QUOTED_STRING (''cpu'')
            ) (')')""");
  }

  /*
"!",
"a + b",
"a - b",
"a * b",
"a / b",
"a = b",
"a == b",
"a != b",
"a > b",
"a >= b",
"a < b",
"a <= b",
"a =~ b",
"a !~ b",
"(",
")",
"[",
"]",
".",
"|",
"@",
   */
}