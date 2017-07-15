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

import com.intellij.openapi.util.TextRange
import com.intellij.psi.InjectedLanguagePlaces
import com.intellij.psi.LanguageInjector
import com.intellij.psi.PsiLanguageInjectionHost
import org.intellij.lang.regexp.RegExpLanguage
import org.intellij.plugins.kapacitor.psi.impl.KapacitorRegexLiteralMixin

class RegexInjector : LanguageInjector {
  override fun getLanguagesToInject(host: PsiLanguageInjectionHost, places: InjectedLanguagePlaces) {
    return Companion.getLanguagesToInject(host, places)
  }

  companion object {
    fun getLanguagesToInject(host: PsiLanguageInjectionHost, places: InjectedLanguagePlaces) {
      if (host is KapacitorRegexLiteralMixin) return getStringLiteralInjections(host, places)
      return
    }

    fun getStringLiteralInjections(host: KapacitorRegexLiteralMixin, places: InjectedLanguagePlaces) {
      places.addPlace(RegExpLanguage.INSTANCE, TextRange.from(1, host.textLength - 2), null, null)
    }
  }
}