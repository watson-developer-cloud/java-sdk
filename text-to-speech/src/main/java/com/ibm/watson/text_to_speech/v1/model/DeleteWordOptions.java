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

package com.ibm.watson.text_to_speech.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The deleteWord options. */
public class DeleteWordOptions extends GenericModel {

  protected String customizationId;
  protected String word;

  /** Builder. */
  public static class Builder {
    private String customizationId;
    private String word;

    /**
     * Instantiates a new Builder from an existing DeleteWordOptions instance.
     *
     * @param deleteWordOptions the instance to initialize the Builder with
     */
    private Builder(DeleteWordOptions deleteWordOptions) {
      this.customizationId = deleteWordOptions.customizationId;
      this.word = deleteWordOptions.word;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     * @param word the word
     */
    public Builder(String customizationId, String word) {
      this.customizationId = customizationId;
      this.word = word;
    }

    /**
     * Builds a DeleteWordOptions.
     *
     * @return the new DeleteWordOptions instance
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
     * Set the word.
     *
     * @param word the word
     * @return the DeleteWordOptions builder
     */
    public Builder word(String word) {
      this.word = word;
      return this;
    }
  }

  protected DeleteWordOptions() {}

  protected DeleteWordOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.customizationId, "customizationId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.word, "word cannot be empty");
    customizationId = builder.customizationId;
    word = builder.word;
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
   * <p>The customization ID (GUID) of the custom model. You must make the request with credentials
   * for the instance of the service that owns the custom model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the word.
   *
   * <p>The word that is to be deleted from the custom model.
   *
   * @return the word
   */
  public String word() {
    return word;
  }
}
