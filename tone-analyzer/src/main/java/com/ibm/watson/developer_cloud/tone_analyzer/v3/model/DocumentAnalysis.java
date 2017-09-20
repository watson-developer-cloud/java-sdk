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
package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * DocumentAnalysis.
 */
public class DocumentAnalysis extends GenericModel {

  @SerializedName("tone_categories")
  private List<ToneCategory> toneCategories;

  /**
   * Gets the toneCategories.
   *
   * An array of `ToneCategory` objects that provides the results of the tone analysis for the full document of the
   * input content. The service returns results only for the tones specified with the `tones` parameter of the request.
   *
   * @return the toneCategories
   */
  public List<ToneCategory> getToneCategories() {
    return toneCategories;
  }

  /**
   * Sets the toneCategories.
   *
   * @param toneCategories the new toneCategories
   */
  public void setToneCategories(final List<ToneCategory> toneCategories) {
    this.toneCategories = toneCategories;
  }
}
