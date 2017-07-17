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
package org.intellij.plugins.kapacitor;

import com.intellij.lexer.Lexer;

public class KapacitorLexerTest extends BaseLexerTestCase {

  @Override
  protected Lexer createLexer() {
    return new KapacitorLexer();
  }

  @Override
  protected String getDirPath() {
    return "test-data/lexer";
  }

  public void testKeywords() throws Exception {
    doTest("AND", "AND ('AND')");
    doTest("OR", "OR ('OR')");
    doTest("TRUE", "TRUE ('TRUE')");
    doTest("FALSE", "FALSE ('FALSE')");
    doTest("var", "var ('var')");
    doTest("lambda:", "lambda: ('lambda:')");
    doTest("lambda ", "ID ('lambda')\nWHITE_SPACE (' ')");
  }

  public void testNumbers() throws Exception {
    doTest("42", "NUMBER ('42')");
    doTest("42.21", "NUMBER ('42.21')");
    doTest(".421", "NUMBER ('.421')");
    doTest("0.421", "NUMBER ('0.421')");
  }

  public void testDurations() throws Exception {
    doTest("42s", "DURATION ('42s')");
    doTest("1u", "DURATION ('1u')");
    doTest("1µ", "DURATION ('1µ')");
    doTest("1ms", "DURATION ('1ms')");
    doTest("1h", "DURATION ('1h')");
    doTest("1d", "DURATION ('1d')");
    doTest("1w", "DURATION ('1w')");
  }

  public void testVariables() throws Exception {
    doTest("variable", "ID ('variable')");
    doTest("myVar01", "ID ('myVar01')");
  }

  public void testReferences() throws Exception {
    doTest("\"\"", "REFERENCE_STRING ('\"\"')");
    doTest("\"ref with spaces\"", "REFERENCE_STRING ('\"ref with spaces\"')");
    doTest("\"ref\\\"\"", "REFERENCE_STRING ('\"ref\\\"\"')");
  }

  public void testStrings() throws Exception {
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

  public void testMultilineStrings() throws Exception {
    doTest("'s\nt\nr'", "SINGLE_QUOTED_STRING (''s\\nt\\nr'')");
    doTest("'s\\nt\\nr'", "SINGLE_QUOTED_STRING (''s\\nt\\nr'')");

    doTest("'''s\nt\nr'''", "TRIPLE_QUOTED_STRING (''''s\\nt\\nr'''')");
    doTest("'''s\\nt\\nr'''", "TRIPLE_QUOTED_STRING (''''s\\nt\\nr'''')");
  }

  public void testRegex() throws Exception {
    doTest("/.*/", "REGEX_STRING ('/.*/')");
    doTest("/^abc$/", "REGEX_STRING ('/^abc$/')");
    doTest("/^((.*)[a-z]+\\S{0,2})|cat\\/\\/$/", "REGEX_STRING ('/^((.*)[a-z]+\\S{0,2})|cat\\/\\/$/')");
  }

  public void testSpace() throws Exception {
    doTest(" ", "WHITE_SPACE (' ')");
    doTest(" \t\n", "WHITE_SPACE (' \t\\n')");
  }

  public void testCombinations() throws Exception {
    doTest("var x = avg()",
        "var ('var')\n" +
            "WHITE_SPACE (' ')\n" +
            "ID ('x')\n" +
            "WHITE_SPACE (' ')\n" +
            "= ('=')\n" +
            "WHITE_SPACE (' ')\n" +
            "ID ('avg')\n" +
            "( ('(')\n" +
            ") (')')");
    doTest("var x = avg()|parallel(4)x.groupby('cpu')|window().period(10s)",
        "var ('var')\n" +
            "WHITE_SPACE (' ')\n" +
            "ID ('x')\n" +
            "WHITE_SPACE (' ')\n" +
            "= ('=')\n" +
            "WHITE_SPACE (' ')\n" +
            "ID ('avg')\n" +
            "( ('(')\n" +
            ") (')')\n" +
            "| ('|')\n" +
            "ID ('parallel')\n" +
            "( ('(')\n" +
            "NUMBER ('4')\n" +
            ") (')')\n" +
            "ID ('x')\n" +
            ". ('.')\n" +
            "ID ('groupby')\n" +
            "( ('(')\n" +
            "SINGLE_QUOTED_STRING (''cpu'')\n" +
            ") (')')\n" +
            "| ('|')\n" +
            "ID ('window')\n" +
            "( ('(')\n" +
            ") (')')\n" +
            ". ('.')\n" +
            "ID ('period')\n" +
            "( ('(')\n" +
            "DURATION ('10s')\n" +
            ") (')')");
  }

  public void testComments() throws Exception {
    doTest("// Comment all of this is ignored", "line_comment ('// Comment all of this is ignored')");
    doTest("var x = 1\n// Comment",
        "var ('var')\n" +
            "WHITE_SPACE (' ')\n" +
            "ID ('x')\n" +
            "WHITE_SPACE (' ')\n" +
            "= ('=')\n" +
            "WHITE_SPACE (' ')\n" +
            "NUMBER ('1')\n" +
            "WHITE_SPACE ('\\n')\n" +
            "line_comment ('// Comment')");
    doTest("var x = 1\n// Comment\nx.groupby('cpu')",
        "var ('var')\n" +
        "WHITE_SPACE (' ')\n" +
        "ID ('x')\n" +
        "WHITE_SPACE (' ')\n" +
        "= ('=')\n" +
        "WHITE_SPACE (' ')\n" +
        "NUMBER ('1')\n" +
        "WHITE_SPACE ('\\n')\n" +
        "line_comment ('// Comment')\n" +
        "WHITE_SPACE ('\\n')\n" +
        "ID ('x')\n" +
        ". ('.')\n" +
        "ID ('groupby')\n" +
        "( ('(')\n" +
        "SINGLE_QUOTED_STRING (''cpu'')\n" +
        ") (')')");
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