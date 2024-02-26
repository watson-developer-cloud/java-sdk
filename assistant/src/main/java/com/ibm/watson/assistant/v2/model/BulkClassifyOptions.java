/*
 * (C) Copyright IBM Corp. 2020, 2024.
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
package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** The bulkClassify options. */
public class BulkClassifyOptions extends GenericModel {

  protected String skillId;
  protected List<BulkClassifyUtterance> input;

  /** Builder. */
  public static class Builder {
    private String skillId;
    private List<BulkClassifyUtterance> input;

    /**
     * Instantiates a new Builder from an existing BulkClassifyOptions instance.
     *
     * @param bulkClassifyOptions the instance to initialize the Builder with
     */
    private Builder(BulkClassifyOptions bulkClassifyOptions) {
      this.skillId = bulkClassifyOptions.skillId;
      this.input = bulkClassifyOptions.input;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param skillId the skillId
     * @param input the input
     */
    public Builder(String skillId, List<BulkClassifyUtterance> input) {
      this.skillId = skillId;
      this.input = input;
    }

    /**
     * Builds a BulkClassifyOptions.
     *
     * @return the new BulkClassifyOptions instance
     */
    public BulkClassifyOptions build() {
      return new BulkClassifyOptions(this);
    }

    /**
     * Adds a new element to input.
     *
     * @param input the new element to be added
     * @return the BulkClassifyOptions builder
     */
    public Builder addInput(BulkClassifyUtterance input) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(input, "input cannot be null");
      if (this.input == null) {
        this.input = new ArrayList<BulkClassifyUtterance>();
      }
      this.input.add(input);
      return this;
    }

    /**
     * Set the skillId.
     *
     * @param skillId the skillId
     * @return the BulkClassifyOptions builder
     */
    public Builder skillId(String skillId) {
      this.skillId = skillId;
      return this;
    }

    /**
     * Set the input. Existing input will be replaced.
     *
     * @param input the input
     * @return the BulkClassifyOptions builder
     */
    public Builder input(List<BulkClassifyUtterance> input) {
      this.input = input;
      return this;
    }
  }

  protected BulkClassifyOptions() {}

  protected BulkClassifyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.skillId, "skillId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.input, "input cannot be null");
    skillId = builder.skillId;
    input = builder.input;
  }

  /**
   * New builder.
   *
   * @return a BulkClassifyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the skillId.
   *
   * <p>Unique identifier of the skill. To find the skill ID in the watsonx Assistant user
   * interface, open the skill settings and click **API Details**.
   *
   * @return the skillId
   */
  public String skillId() {
    return skillId;
  }

  /**
   * Gets the input.
   *
   * <p>An array of input utterances to classify.
   *
   * @return the input
   */
  public List<BulkClassifyUtterance> input() {
    return input;
  }
}
