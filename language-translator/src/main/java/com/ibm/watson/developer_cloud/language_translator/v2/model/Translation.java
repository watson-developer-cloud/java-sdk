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
 * Translation.
 */
public class Translation extends GenericModel {

  private String translation;

  /**
   * Gets the translation.
   *
   * Translation output in UTF-8.
   *
   * @return the translation
   */
  public String getTranslation() {
    return translation;
  }

  /**
   * Sets the translation.
   *
   * @param translation the new translation
   */
  public void setTranslation(final String translation) {
    this.translation = translation;
  }
}
