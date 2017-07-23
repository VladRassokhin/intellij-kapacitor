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

import com.intellij.lang.ParserDefinition;
import com.intellij.testFramework.ParsingTestCase;
import com.intellij.testFramework.TestDataPath;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

@TestDataPath("$CONTENT_ROOT/test-data/psi/")
public class KapacitorParserTest extends ParsingTestCase {
  private KapacitorParserTest(@NonNls @NotNull String dataPath, @NotNull String fileExt, final boolean lowercaseFirstLetter, @NotNull ParserDefinition... definitions) {
    super(dataPath, fileExt, lowercaseFirstLetter, definitions);
  }

  public KapacitorParserTest() {
    this("psi", "tick", false, new KapacitorParserDefinition());
  }

  @Override
  protected String getTestDataPath() {
    return "test-data/";
  }

  @Override
  protected boolean skipSpaces() {
    return true;
  }

  private void doTest() {
    doTest(true);
  }


  //region TestParseStrings
  public void testStringSingleQuote() throws Exception {
    doCodeTest("f('asdf')");
  }

  public void testStringTripleQuote() throws Exception {
    doCodeTest("f('''asdf''')");
  }

  public void testStringSingleQuoteEscape() throws Exception {
    doCodeTest("f('a\\'sdf')");
  }

  public void testStringTripleQuoteEscape() throws Exception {
    doCodeTest("f('''\\'asdf''')");
  }
  //endregion


  public void testTypeDeclarations() throws Exception {
    doCodeTest("var x int\nvar x float");
  }

  public void testSimpleValueDeclarations() throws Exception {
    doTest();
  }

  public void testValueDeclarations() throws Exception {
    doTest();
  }

  public void testSimpleFunction() throws Exception {
    doCodeTest("string(5m)");
  }

  public void testFunctionInvocation() throws Exception {
    doCodeTest("f('first ' + string(5m) + 'third')");
  }

  public void testSimpleStream() throws Exception {
    doCodeTest("var t = 42\n" +
        "stream.where(lambda: \"value\" > t)");
  }

  public void testLeftAssociativeOps0() throws Exception {
    doCodeTest("var x = (1 + 2 - 3 * 4 / 5)");
  }

  public void testLeftAssociativeOps1() throws Exception {
    doCodeTest("global(lambda:\n" +
        "\t// Test Left-Associative operators\n" +
        "\t// should parse as ((1+2)-(3*4)/5)\n" +
        "\t(1 + 2 - 3 * 4 / 5)\n" +
        ")");
  }

  public void testLeftAssociativeOps2() throws Exception {
    doCodeTest("global(lambda:\n" +
        "// If this\n" +
        "// is less than that\n" +
        "(1 + 2 - 3 * 4 / 5) \n" +
        "< (sin(6))\n" +
        "AND \n" +
        "// more comments.\n" +
        "(TRUE OR FALSE))");
  }

  public void testStream() throws Exception {
    doCodeTest("var x = stream\n" +
        "  |window()\n" +
        "  .period(5m)\n" +
        "  .every(60s)\n" +
        "  |map(influxql.agg.mean('value'))");
  }

  public void testStreamDynFunc() throws Exception {
    doCodeTest("var x = stream\n" +
        "\t\t@dynamicFunc()\n" +
        "\t\t\t.property(5m)");
  }

  public void testPipes() throws Exception {
    doCodeTest(
        "stream\n" +
            "  |a().b()\n" +
            "  |c().d()\n" +
            "  |e().f('mydb')");
  }

  public void testComplexExample() throws Exception {
    doTest();
  }

}
