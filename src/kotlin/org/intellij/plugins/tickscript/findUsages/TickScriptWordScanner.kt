/*
 * Copyright 2000-2025 JetBrains s.r.o.
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
package org.intellij.plugins.tickscript.findUsages

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.psi.tree.TokenSet
import org.intellij.plugins.tickscript.TickScriptElementTypes
import org.intellij.plugins.tickscript.TickScriptLexer
import org.intellij.plugins.tickscript.TokenSets

class TickScriptWordScanner(lexer: TickScriptLexer) : DefaultWordsScanner(lexer, TokenSet.create(TickScriptElementTypes.IDENTIFIER), TokenSets.COMMENTARIES, TokenSets.STRING_LITERALS) {
  init {
    setMayHaveFileRefsInLiterals(true)
  }
}