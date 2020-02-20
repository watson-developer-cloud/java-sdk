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
package com.ibm.watson.discovery.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An expansion definition. Each object respresents one set of expandable strings. For example, you could have
 * expansions for the word `hot` in one object, and expansions for the word `cold` in another.
 */
public class Expansion extends GenericModel {

  @SerializedName("input_terms")
  protected List<String> inputTerms;
  @SerializedName("expanded_terms")
  protected List<String> expandedTerms;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> inputTerms;
    private List<String> expandedTerms;

    private Builder(Expansion expansion) {
      this.inputTerms = expansion.inputTerms;
      this.expandedTerms = expansion.expandedTerms;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param expandedTerms the expandedTerms
     */
    public Builder(List<String> expandedTerms) {
      this.expandedTerms = expandedTerms;
    }

    /**
     * Builds a Expansion.
     *
     * @return the expansion
     */
    public Expansion build() {
      return new Expansion(this);
    }

    /**
     * Adds an inputTerms to inputTerms.
     *
     * @param inputTerms the new inputTerms
     * @return the Expansion builder
     */
    public Builder addInputTerms(String inputTerms) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(inputTerms,
          "inputTerms cannot be null");
      if (this.inputTerms == null) {
        this.inputTerms = new ArrayList<String>();
      }
      this.inputTerms.add(inputTerms);
      return this;
    }

    /**
     * Adds an expandedTerms to expandedTerms.
     *
     * @param expandedTerms the new expandedTerms
     * @return the Expansion builder
     */
    public Builder addExpandedTerms(String expandedTerms) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(expandedTerms,
          "expandedTerms cannot be null");
      if (this.expandedTerms == null) {
        this.expandedTerms = new ArrayList<String>();
      }
      this.expandedTerms.add(expandedTerms);
      return this;
    }

    /**
     * Set the inputTerms.
     * Existing inputTerms will be replaced.
     *
     * @param inputTerms the inputTerms
     * @return the Expansion builder
     */
    public Builder inputTerms(List<String> inputTerms) {
      this.inputTerms = inputTerms;
      return this;
    }

    /**
     * Set the expandedTerms.
     * Existing expandedTerms will be replaced.
     *
     * @param expandedTerms the expandedTerms
     * @return the Expansion builder
     */
    public Builder expandedTerms(List<String> expandedTerms) {
      this.expandedTerms = expandedTerms;
      return this;
    }
  }

  protected Expansion(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.expandedTerms,
        "expandedTerms cannot be null");
    inputTerms = builder.inputTerms;
    expandedTerms = builder.expandedTerms;
  }

  /**
   * New builder.
   *
   * @return a Expansion builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the inputTerms.
   *
   * A list of terms that will be expanded for this expansion. If specified, only the items in this list are expanded.
   *
   * @return the inputTerms
   */
  public List<String> inputTerms() {
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
  public List<String> expandedTerms() {
    return expandedTerms;
  }
}
