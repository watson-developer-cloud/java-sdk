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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A pair of `nature` and `party` objects. The `nature` object identifies the effect of the element on the identified
 * `party`, and the `party` object identifies the affected party.
 */
public class Label extends GenericModel {

  protected String nature;
  protected String party;

  /**
   * Builder.
   */
  public static class Builder {
    private String nature;
    private String party;

    private Builder(Label label) {
      this.nature = label.nature;
      this.party = label.party;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param nature the nature
     * @param party the party
     */
    public Builder(String nature, String party) {
      this.nature = nature;
      this.party = party;
    }

    /**
     * Builds a Label.
     *
     * @return the label
     */
    public Label build() {
      return new Label(this);
    }

    /**
     * Set the nature.
     *
     * @param nature the nature
     * @return the Label builder
     */
    public Builder nature(String nature) {
      this.nature = nature;
      return this;
    }

    /**
     * Set the party.
     *
     * @param party the party
     * @return the Label builder
     */
    public Builder party(String party) {
      this.party = party;
      return this;
    }
  }

  protected Label(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.nature,
        "nature cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.party,
        "party cannot be null");
    nature = builder.nature;
    party = builder.party;
  }

  /**
   * New builder.
   *
   * @return a Label builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the nature.
   *
   * The identified `nature` of the element.
   *
   * @return the nature
   */
  public String nature() {
    return nature;
  }

  /**
   * Gets the party.
   *
   * The identified `party` of the element.
   *
   * @return the party
   */
  public String party() {
    return party;
  }
}
