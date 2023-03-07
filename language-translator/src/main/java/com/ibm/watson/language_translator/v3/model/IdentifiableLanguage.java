/*
 * (C) Copyright IBM Corp. 2023.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** IdentifiableLanguage. */
public class IdentifiableLanguage extends GenericModel {

  protected String language;
  protected String name;

  protected IdentifiableLanguage() {}

  /**
   * Gets the language.
   *
   * <p>The language code for an identifiable language.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the name.
   *
   * <p>The name of the identifiable language.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }
}
