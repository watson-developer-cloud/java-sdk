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
package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The getCorpus options.
 */
public class GetCorpusOptions extends GenericModel {

  private String customizationId;
  private String corpusName;

  /**
   * Builder.
   */
  public static class Builder {
    private String customizationId;
    private String corpusName;

    private Builder(GetCorpusOptions getCorpusOptions) {
      customizationId = getCorpusOptions.customizationId;
      corpusName = getCorpusOptions.corpusName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

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
     * Builds a GetCorpusOptions.
     *
     * @return the getCorpusOptions
     */
    public GetCorpusOptions build() {
      return new GetCorpusOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the GetCorpusOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the corpusName.
     *
     * @param corpusName the corpusName
     * @return the GetCorpusOptions builder
     */
    public Builder corpusName(String corpusName) {
      this.corpusName = corpusName;
      return this;
    }
  }

  private GetCorpusOptions(Builder builder) {
    Validator.notEmpty(builder.customizationId, "customizationId cannot be empty");
    Validator.notEmpty(builder.corpusName, "corpusName cannot be empty");
    customizationId = builder.customizationId;
    corpusName = builder.corpusName;
  }

  /**
   * New builder.
   *
   * @return a GetCorpusOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * The customization ID (GUID) of the custom language model that is to be used for the request. You must make the
   * request with credentials for the instance of the service that owns the custom model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the corpusName.
   *
   * The name of the corpus for the custom language model.
   *
   * @return the corpusName
   */
  public String corpusName() {
    return corpusName;
  }
}
