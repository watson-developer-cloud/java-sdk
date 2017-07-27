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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * IdentifiableLanguage.
 */
public class IdentifiableLanguage extends GenericModel {

  private String language;
  private String name;

  /**
   * Gets the language.
   *
   * The code for an identifiable language.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the name.
   *
   * The name of the identifiable language.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the language.
   *
   * @param language the new language
   */
  public void setLanguage(final String language) {
    this.language = language;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }
}
