/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.tone_analyzer.v3.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ToneCategory.
 */
public class ToneCategory extends GenericModel {

  private List<ToneScore> tones;
  @SerializedName("category_id")
  private String categoryId;
  @SerializedName("category_name")
  private String categoryName;

  /**
   * Gets the tones.
   *
   * An array of `ToneScore` objects that provides the results for the tones of the category.
   *
   * @return the tones
   */
  public List<ToneScore> getTones() {
    return tones;
  }

  /**
   * Gets the categoryId.
   *
   * The unique, non-localized identifier of the category for the results. The service can return results for the
   * following category IDs: `emotion_tone`, `language_tone`, and `social_tone`.
   *
   * @return the categoryId
   */
  public String getCategoryId() {
    return categoryId;
  }

  /**
   * Gets the categoryName.
   *
   * The user-visible, localized name of the category.
   *
   * @return the categoryName
   */
  public String getCategoryName() {
    return categoryName;
  }
}
