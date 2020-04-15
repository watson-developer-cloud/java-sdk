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
package com.ibm.watson.speech_to_text.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The deleteWord options. */
public class DeleteWordOptions extends GenericModel {

  protected String customizationId;
  protected String wordName;

  /** Builder. */
  public static class Builder {
    private String customizationId;
    private String wordName;

    private Builder(DeleteWordOptions deleteWordOptions) {
      this.customizationId = deleteWordOptions.customizationId;
      this.wordName = deleteWordOptions.wordName;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     * @param wordName the wordName
     */
    public Builder(String customizationId, String wordName) {
      this.customizationId = customizationId;
      this.wordName = wordName;
    }

    /**
     * Builds a DeleteWordOptions.
     *
     * @return the deleteWordOptions
     */
    public DeleteWordOptions build() {
      return new DeleteWordOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the DeleteWordOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the wordName.
     *
     * @param wordName the wordName
     * @return the DeleteWordOptions builder
     */
    public Builder wordName(String wordName) {
      this.wordName = wordName;
      return this;
    }
  }

  protected DeleteWordOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.customizationId, "customizationId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.wordName, "wordName cannot be empty");
    customizationId = builder.customizationId;
    wordName = builder.wordName;
  }

  /**
   * New builder.
   *
   * @return a DeleteWordOptions builder
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
   * Gets the wordName.
   *
   * <p>The custom word that is to be deleted from the custom language model. URL-encode the word if
   * it includes non-ASCII characters. For more information, see [Character
   * encoding](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-corporaWords#charEncoding).
   *
   * @return the wordName
   */
  public String wordName() {
    return wordName;
  }
}
