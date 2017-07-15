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

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory
import com.intellij.openapi.fileTypes.LanguageFileType

object KapacitorFileType : LanguageFileType(KapacitorLanguage) {
  val DEFAULT_EXTENSION: String = "tick"

  override fun getIcon() = Icons.FileTypes.Kapacitor

  override fun getDefaultExtension() = DEFAULT_EXTENSION

  override fun getDescription() = "Kapacitor TICKscript" // TODO: Better one

  override fun getName() = "Kapacitor"

}

class KapacitorFileTypeFactory : FileTypeFactory() {
  override fun createFileTypes(consumer: FileTypeConsumer) {
    consumer.consume(KapacitorFileType, KapacitorFileType.DEFAULT_EXTENSION)
  }
}
