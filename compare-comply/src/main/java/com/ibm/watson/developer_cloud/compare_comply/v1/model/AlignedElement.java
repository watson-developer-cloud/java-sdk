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
package com.ibm.watson.developer_cloud.compare_comply.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * AlignedElement.
 */
public class AlignedElement extends GenericModel {

  @SerializedName("element_pair")
  private List<ElementPair> elementPair;
  @SerializedName("identical_text")
  private Boolean identicalText;
  @SerializedName("significant_elements")
  private Boolean significantElements;
  @SerializedName("provenance_ids")
  private List<String> provenanceIds;

  /**
   * Gets the elementPair.
   *
   * Identifies two elements that semantically align between the compared documents.
   *
   * @return the elementPair
   */
  public List<ElementPair> getElementPair() {
    return elementPair;
  }

  /**
   * Gets the identicalText.
   *
   * Specifies whether the text is identical.
   *
   * @return the identicalText
   */
  public Boolean isIdenticalText() {
    return identicalText;
  }

  /**
   * Gets the significantElements.
   *
   * Indicates that the elements aligned are contractual clauses of significance.
   *
   * @return the significantElements
   */
  public Boolean isSignificantElements() {
    return significantElements;
  }

  /**
   * Gets the provenanceIds.
   *
   * One or more hashed values that you can send to IBM to provide feedback or receive support.
   *
   * @return the provenanceIds
   */
  public List<String> getProvenanceIds() {
    return provenanceIds;
  }
}
