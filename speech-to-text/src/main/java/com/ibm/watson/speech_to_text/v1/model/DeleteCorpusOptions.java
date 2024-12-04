/*
 * (C) Copyright IBM Corp. 2018, 2024.
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

/** The deleteCorpus options. */
public class DeleteCorpusOptions extends GenericModel {

  protected String customizationId;
  protected String corpusName;

  /** Builder. */
  public static class Builder {
    private String customizationId;
    private String corpusName;

    /**
     * Instantiates a new Builder from an existing DeleteCorpusOptions instance.
     *
     * @param deleteCorpusOptions the instance to initialize the Builder with
     */
    private Builder(DeleteCorpusOptions deleteCorpusOptions) {
      this.customizationId = deleteCorpusOptions.customizationId;
      this.corpusName = deleteCorpusOptions.corpusName;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     * @param corpusName the corpusName
     */
    public Builder(String customizationId, String corpusName) {
      this.customizationId = customizationId;
      this.corpusName = corpusName;
    }

    /**
     * Builds a DeleteCorpusOptions.
     *
     * @return the new DeleteCorpusOptions instance
     */
    public DeleteCorpusOptions build() {
      return new DeleteCorpusOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the DeleteCorpusOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the corpusName.
     *
     * @param corpusName the corpusName
     * @return the DeleteCorpusOptions builder
     */
    public Builder corpusName(String corpusName) {
      this.corpusName = corpusName;
      return this;
    }
  }

  protected DeleteCorpusOptions() {}

  protected DeleteCorpusOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.customizationId, "customizationId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.corpusName, "corpusName cannot be empty");
    customizationId = builder.customizationId;
    corpusName = builder.corpusName;
  }

  /**
   * New builder.
   *
   * @return a DeleteCorpusOptions builder
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
   * Gets the corpusName.
   *
   * <p>The name of the corpus for the custom language model.
   *
   * @return the corpusName
   */
  public String corpusName() {
    return corpusName;
  }
}
