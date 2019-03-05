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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An expansion definition. Each object respresents one set of expandable strings. For example, you could have
 * expansions for the word `hot` in one object, and expansions for the word `cold` in another.
 */
public class Expansion extends GenericModel {

  @SerializedName("input_terms")
  private List<String> inputTerms;
  @SerializedName("expanded_terms")
  private List<String> expandedTerms;

  /**
   * Gets the inputTerms.
   *
   * A list of terms that will be expanded for this expansion. If specified, only the items in this list are expanded.
   *
   * @return the inputTerms
   */
  public List<String> getInputTerms() {
    return inputTerms;
  }

  /**
   * Gets the expandedTerms.
   *
   * A list of terms that this expansion will be expanded to. If specified without **input_terms**, it also functions as
   * the input term list.
   *
   * @return the expandedTerms
   */
  public List<String> getExpandedTerms() {
    return expandedTerms;
  }

  /**
   * Sets the inputTerms.
   *
   * @param inputTerms the new inputTerms
   */
  public void setInputTerms(final List<String> inputTerms) {
    this.inputTerms = inputTerms;
  }

  /**
   * Sets the expandedTerms.
   *
   * @param expandedTerms the new expandedTerms
   */
  public void setExpandedTerms(final List<String> expandedTerms) {
    this.expandedTerms = expandedTerms;
  }
}
