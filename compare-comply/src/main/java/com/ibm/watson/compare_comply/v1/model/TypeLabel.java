/*
 * (C) Copyright IBM Corp. 2018, 2020.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** Identification of a specific type. */
public class TypeLabel extends GenericModel {

  /** The type of modification of the feedback entry in the updated labels response. */
  public interface Modification {
    /** added. */
    String ADDED = "added";
    /** unchanged. */
    String UNCHANGED = "unchanged";
    /** removed. */
    String REMOVED = "removed";
  }

  protected Label label;

  @SerializedName("provenance_ids")
  protected List<String> provenanceIds;

  protected String modification;

  /** Builder. */
  public static class Builder {
    private Label label;
    private List<String> provenanceIds;
    private String modification;

    private Builder(TypeLabel typeLabel) {
      this.label = typeLabel.label;
      this.provenanceIds = typeLabel.provenanceIds;
      this.modification = typeLabel.modification;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a TypeLabel.
     *
     * @return the new TypeLabel instance
     */
    public TypeLabel build() {
      return new TypeLabel(this);
    }

    /**
     * Adds an provenanceIds to provenanceIds.
     *
     * @param provenanceIds the new provenanceIds
     * @return the TypeLabel builder
     */
    public Builder addProvenanceIds(String provenanceIds) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(provenanceIds, "provenanceIds cannot be null");
      if (this.provenanceIds == null) {
        this.provenanceIds = new ArrayList<String>();
      }
      this.provenanceIds.add(provenanceIds);
      return this;
    }

    /**
     * Set the label.
     *
     * @param label the label
     * @return the TypeLabel builder
     */
    public Builder label(Label label) {
      this.label = label;
      return this;
    }

    /**
     * Set the provenanceIds. Existing provenanceIds will be replaced.
     *
     * @param provenanceIds the provenanceIds
     * @return the TypeLabel builder
     */
    public Builder provenanceIds(List<String> provenanceIds) {
      this.provenanceIds = provenanceIds;
      return this;
    }

    /**
     * Set the modification.
     *
     * @param modification the modification
     * @return the TypeLabel builder
     */
    public Builder modification(String modification) {
      this.modification = modification;
      return this;
    }
  }

  protected TypeLabel(Builder builder) {
    label = builder.label;
    provenanceIds = builder.provenanceIds;
    modification = builder.modification;
  }

  /**
   * New builder.
   *
   * @return a TypeLabel builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the label.
   *
   * <p>A pair of `nature` and `party` objects. The `nature` object identifies the effect of the
   * element on the identified `party`, and the `party` object identifies the affected party.
   *
   * @return the label
   */
  public Label label() {
    return label;
  }

  /**
   * Gets the provenanceIds.
   *
   * <p>Hashed values that you can send to IBM to provide feedback or receive support.
   *
   * @return the provenanceIds
   */
  public List<String> provenanceIds() {
    return provenanceIds;
  }

  /**
   * Gets the modification.
   *
   * <p>The type of modification of the feedback entry in the updated labels response.
   *
   * @return the modification
   */
  public String modification() {
    return modification;
  }
}
