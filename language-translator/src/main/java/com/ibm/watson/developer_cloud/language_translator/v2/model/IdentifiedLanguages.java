/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.language_translator.v2.model;

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * IdentifiedLanguages.
 */
public class IdentifiedLanguages extends GenericModel {

  private List<IdentifiedLanguage> languages;

  /**
   * Gets the languages.
   *
   * A ranking of identified languages with confidence scores.
   *
   * @return the languages
   */
  public List<IdentifiedLanguage> getLanguages() {
    return languages;
  }

  /**
   * Sets the languages.
   *
   * @param languages the new languages
   */
  public void setLanguages(final List<IdentifiedLanguage> languages) {
    this.languages = languages;
  }
}
