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

import com.intellij.application.options.colors.InspectionColorSettingsPage
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.psi.codeStyle.DisplayPriority
import com.intellij.psi.codeStyle.DisplayPrioritySortable
import javax.swing.Icon

class KapacitorColorsPage : ColorSettingsPage, InspectionColorSettingsPage, DisplayPrioritySortable {

  companion object {
    private val descriptors: Array<out AttributesDescriptor> = arrayOf(
        AttributesDescriptor("Braces and Operators//Brackets", KapacitorSyntaxHighlighterFactory.Kapacitor_BRACKETS),
        AttributesDescriptor("Braces and Operators//Braces", KapacitorSyntaxHighlighterFactory.Kapacitor_PARENTHESES),
        AttributesDescriptor("Braces and Operators//Comma", KapacitorSyntaxHighlighterFactory.Kapacitor_COMMA),
        AttributesDescriptor("Braces and Operators//Operation sign", KapacitorSyntaxHighlighterFactory.Kapacitor_OPERATION_SIGN),

        AttributesDescriptor("Number", KapacitorSyntaxHighlighterFactory.Kapacitor_NUMBER),
        AttributesDescriptor("Keyword", KapacitorSyntaxHighlighterFactory.Kapacitor_KEYWORD),
        AttributesDescriptor("Identifier", KapacitorSyntaxHighlighterFactory.Kapacitor_IDENTIFIER),

        AttributesDescriptor("Comments", KapacitorSyntaxHighlighterFactory.Kapacitor_LINE_COMMENT),

        AttributesDescriptor("String//String text", KapacitorSyntaxHighlighterFactory.Kapacitor_STRING),
        AttributesDescriptor("String//Valid escape sequence", KapacitorSyntaxHighlighterFactory.Kapacitor_VALID_ESCAPE),
        AttributesDescriptor("String//Invalid escape sequence", KapacitorSyntaxHighlighterFactory.Kapacitor_INVALID_ESCAPE)
    )
    private val additional: Map<String, TextAttributesKey> = mapOf(
    )
  }

  override fun getIcon(): Icon? {
    return Icons.FileTypes.Kapacitor
  }

  override fun getHighlighter(): SyntaxHighlighter {
    return SyntaxHighlighterFactory.getSyntaxHighlighter(KapacitorLanguage, null, null)
  }

  override fun getDemoText(): String {
    return """/*
  Here's simple Kapacitor code to show you syntax highlighter.
  Suggestions are welcome at https://github.com/VladRassokhin/intellij-hcl/issues
*/
<pk>name</pk> = value
// Simple single line comment
<bt1>block</bt1> <bt2>with</bt2> <btO>five</btO> <btO>types</btO> <btO>and</btO> <bn>'name'</bn> {
  <pk>array</pk> = [ 'a', 100, "b", 10.5e-42, true, false ]
  <pk>empty_array</pk> = []
  <pk>empty_object</pk> = {}
  # Yet another comment style
  <pk>strings</pk> = {
    <pk>"something"</pk> = "\"Quoted Yep!\""
    <pk>bad</pk> = "Invalid escaping:\c"
    <pk>'good'</pk> = "Valid escaping:\"\n\"\"
  }
}
<bon>block_with_only_one_name</bon> {
}
"""
  }

  override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? {
    return additional
  }

  override fun getAttributeDescriptors(): Array<out AttributesDescriptor> {
    return descriptors
  }

  override fun getColorDescriptors(): Array<out ColorDescriptor> {
    return ColorDescriptor.EMPTY_ARRAY
  }

  override fun getDisplayName(): String {
    return KapacitorLanguage.displayName
  }

  override fun getPriority(): DisplayPriority? {
    return DisplayPriority.LANGUAGE_SETTINGS
  }
}