/*
 * (C) Copyright IBM Corp. 2021, 2022.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about the prompt that is to be added to a custom model. The following example of a
 * `PromptMetadata` object includes both the required prompt text and an optional speaker model ID:
 *
 * <p>`{ "prompt_text": "Thank you and good-bye!", "speaker_id":
 * "823068b2-ed4e-11ea-b6e0-7b6456aa95cc" }`.
 */
public class PromptMetadata extends GenericModel {

  @SerializedName("prompt_text")
  protected String promptText;

  @SerializedName("speaker_id")
  protected String speakerId;

  /** Builder. */
  public static class Builder {
    private String promptText;
    private String speakerId;

    private Builder(PromptMetadata promptMetadata) {
      this.promptText = promptMetadata.promptText;
      this.speakerId = promptMetadata.speakerId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param promptText the promptText
     */
    public Builder(String promptText) {
      this.promptText = promptText;
    }

    /**
     * Builds a PromptMetadata.
     *
     * @return the new PromptMetadata instance
     */
    public PromptMetadata build() {
      return new PromptMetadata(this);
    }

    /**
     * Set the promptText.
     *
     * @param promptText the promptText
     * @return the PromptMetadata builder
     */
    public Builder promptText(String promptText) {
      this.promptText = promptText;
      return this;
    }

    /**
     * Set the speakerId.
     *
     * @param speakerId the speakerId
     * @return the PromptMetadata builder
     */
    public Builder speakerId(String speakerId) {
      this.speakerId = speakerId;
      return this;
    }
  }

  protected PromptMetadata() {}

  protected PromptMetadata(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.promptText, "promptText cannot be null");
    promptText = builder.promptText;
    speakerId = builder.speakerId;
  }

  /**
   * New builder.
   *
   * @return a PromptMetadata builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the promptText.
   *
   * <p>The required written text of the spoken prompt. The length of a prompt's text is limited to
   * a few sentences. Speaking one or two sentences of text is the recommended limit. A prompt
   * cannot contain more than 1000 characters of text. Escape any XML control characters (double
   * quotes, single quotes, ampersands, angle brackets, and slashes) that appear in the text of the
   * prompt.
   *
   * @return the promptText
   */
  public String promptText() {
    return promptText;
  }

  /**
   * Gets the speakerId.
   *
   * <p>The optional speaker ID (GUID) of a previously defined speaker model that is to be
   * associated with the prompt.
   *
   * @return the speakerId
   */
  public String speakerId() {
    return speakerId;
  }
}
