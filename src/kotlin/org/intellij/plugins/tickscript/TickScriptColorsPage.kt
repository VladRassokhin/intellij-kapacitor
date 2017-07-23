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
package org.intellij.plugins.tickscript

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

class TickScriptColorsPage : ColorSettingsPage, InspectionColorSettingsPage, DisplayPrioritySortable {

  companion object {
    private val descriptors: Array<out AttributesDescriptor> = arrayOf(
        AttributesDescriptor("Braces and Operators//Brackets", TickScriptSyntaxHighlighterFactory.TickScript_BRACKETS),
        AttributesDescriptor("Braces and Operators//Braces", TickScriptSyntaxHighlighterFactory.TickScript_PARENTHESES),
        AttributesDescriptor("Braces and Operators//Comma", TickScriptSyntaxHighlighterFactory.TickScript_COMMA),
        AttributesDescriptor("Braces and Operators//Chains", TickScriptSyntaxHighlighterFactory.TickScript_CHAINS),
        AttributesDescriptor("Braces and Operators//Operation sign", TickScriptSyntaxHighlighterFactory.TickScript_OPERATION_SIGN),

        AttributesDescriptor("Number", TickScriptSyntaxHighlighterFactory.TickScript_NUMBER),
        AttributesDescriptor("Keyword", TickScriptSyntaxHighlighterFactory.TickScript_KEYWORD),
        AttributesDescriptor("Identifier", TickScriptSyntaxHighlighterFactory.TickScript_IDENTIFIER),

        AttributesDescriptor("Comments", TickScriptSyntaxHighlighterFactory.TickScript_LINE_COMMENT),

        AttributesDescriptor("String//References", TickScriptSyntaxHighlighterFactory.TickScript_REFERENCE),
        AttributesDescriptor("String//String text", TickScriptSyntaxHighlighterFactory.TickScript_STRING),
        AttributesDescriptor("String//Valid escape sequence", TickScriptSyntaxHighlighterFactory.TickScript_VALID_ESCAPE),
        AttributesDescriptor("String//Invalid escape sequence", TickScriptSyntaxHighlighterFactory.TickScript_INVALID_ESCAPE)
    )
    private val additional: Map<String, TextAttributesKey> = mapOf(
    )
  }

  override fun getIcon(): Icon? {
    return Icons.FileTypes.TickScript
  }

  override fun getHighlighter(): SyntaxHighlighter {
    return SyntaxHighlighterFactory.getSyntaxHighlighter(TickScriptLanguage, null, null)
  }

  override fun getDemoText(): String {
    return """
// Parameters
var info = '{info_level}'
var warn = '{warn_level}'
var crit = '{crit_level}'
var infoSig = 2.5
var warnSig = 3
var critSig = 3.5
var period = 10s
var every = 10s

// Dataframe
var data = batch
  |query('''{InfluxQL_Query}''')
    .period(period)
    .every(every)
    .groupBy('host')

// Thresholds
var alert = data
  |eval(lambda: sigma("stat"))
    .as('sigma')
    .keep()
  |alert()
    .id('{{ index .Tags "host"}}/{alert_metric}')
    .message('{{ .ID }}:{{ index .Fields "stat" }}')
    .info(lambda: "stat" > info OR "sigma" > infoSig)
    .warn(lambda: "stat" > warn OR "sigma" > warnSig)
    .crit(lambda: "stat" > crit OR "sigma" > critSig)

// Alert
alert
  .log('/tmp/{alert_name}_log.txt').simple_regex(/.*/)
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
    return TickScriptLanguage.displayName
  }

  override fun getPriority(): DisplayPriority? {
    return DisplayPriority.LANGUAGE_SETTINGS
  }
}