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
package com.ibm.watson.compare_comply.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Identification of a specific type.
 */
public class TypeLabel extends GenericModel {

  private Label label;
  @SerializedName("provenance_ids")
  private List<String> provenanceIds;

  /**
   * Gets the label.
   *
   * A pair of `nature` and `party` objects. The `nature` object identifies the effect of the element on the identified
   * `party`, and the `party` object identifies the affected party.
   *
   * @return the label
   */
  public Label getLabel() {
    return label;
  }

  /**
   * Gets the provenanceIds.
   *
   * One or more hash values that you can send to IBM to provide feedback or receive support.
   *
   * @return the provenanceIds
   */
  public List<String> getProvenanceIds() {
    return provenanceIds;
  }

  /**
   * Sets the label.
   *
   * @param label the new label
   */
  public void setLabel(final Label label) {
    this.label = label;
  }

  /**
   * Sets the provenanceIds.
   *
   * @param provenanceIds the new provenanceIds
   */
  public void setProvenanceIds(final List<String> provenanceIds) {
    this.provenanceIds = provenanceIds;
  }
}
