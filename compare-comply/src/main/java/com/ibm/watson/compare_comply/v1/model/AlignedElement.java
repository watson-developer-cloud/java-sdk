/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.compare_comply.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * AlignedElement.
 */
public class AlignedElement extends GenericModel {

  @SerializedName("element_pair")
  protected List<ElementPair> elementPair;
  @SerializedName("identical_text")
  protected Boolean identicalText;
  @SerializedName("provenance_ids")
  protected List<String> provenanceIds;
  @SerializedName("significant_elements")
  protected Boolean significantElements;

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
   * Specifies whether the aligned element is identical. Elements are considered identical despite minor differences
   * such as leading punctuation, end-of-sentence punctuation, whitespace, the presence or absence of definite or
   * indefinite articles, and others.
   *
   * @return the identicalText
   */
  public Boolean isIdenticalText() {
    return identicalText;
  }

  /**
   * Gets the provenanceIds.
   *
   * Hashed values that you can send to IBM to provide feedback or receive support.
   *
   * @return the provenanceIds
   */
  public List<String> getProvenanceIds() {
    return provenanceIds;
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
}
