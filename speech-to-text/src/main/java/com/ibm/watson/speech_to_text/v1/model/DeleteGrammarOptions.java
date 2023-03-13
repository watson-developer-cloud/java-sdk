/*
 * (C) Copyright IBM Corp. 2019, 2023.
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
package com.ibm.watson.speech_to_text.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The deleteGrammar options. */
public class DeleteGrammarOptions extends GenericModel {

  protected String customizationId;
  protected String grammarName;

  /** Builder. */
  public static class Builder {
    private String customizationId;
    private String grammarName;

    /**
     * Instantiates a new Builder from an existing DeleteGrammarOptions instance.
     *
     * @param deleteGrammarOptions the instance to initialize the Builder with
     */
    private Builder(DeleteGrammarOptions deleteGrammarOptions) {
      this.customizationId = deleteGrammarOptions.customizationId;
      this.grammarName = deleteGrammarOptions.grammarName;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     * @param grammarName the grammarName
     */
    public Builder(String customizationId, String grammarName) {
      this.customizationId = customizationId;
      this.grammarName = grammarName;
    }

    /**
     * Builds a DeleteGrammarOptions.
     *
     * @return the new DeleteGrammarOptions instance
     */
    public DeleteGrammarOptions build() {
      return new DeleteGrammarOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the DeleteGrammarOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the grammarName.
     *
     * @param grammarName the grammarName
     * @return the DeleteGrammarOptions builder
     */
    public Builder grammarName(String grammarName) {
      this.grammarName = grammarName;
      return this;
    }
  }

  protected DeleteGrammarOptions() {}

  protected DeleteGrammarOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.customizationId, "customizationId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.grammarName, "grammarName cannot be empty");
    customizationId = builder.customizationId;
    grammarName = builder.grammarName;
  }

  /**
   * New builder.
   *
   * @return a DeleteGrammarOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * <p>The customization ID (GUID) of the custom language model that is to be used for the request.
   * You must make the request with credentials for the instance of the service that owns the custom
   * model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the grammarName.
   *
   * <p>The name of the grammar for the custom language model.
   *
   * @return the grammarName
   */
  public String grammarName() {
    return grammarName;
  }
}
