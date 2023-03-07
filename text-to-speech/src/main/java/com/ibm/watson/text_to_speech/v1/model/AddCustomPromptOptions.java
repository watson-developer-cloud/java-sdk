/*
 * (C) Copyright IBM Corp. 2023.
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/** The addCustomPrompt options. */
public class AddCustomPromptOptions extends GenericModel {

  protected String customizationId;
  protected String promptId;
  protected PromptMetadata metadata;
  protected InputStream file;

  /** Builder. */
  public static class Builder {
    private String customizationId;
    private String promptId;
    private PromptMetadata metadata;
    private InputStream file;

    /**
     * Instantiates a new Builder from an existing AddCustomPromptOptions instance.
     *
     * @param addCustomPromptOptions the instance to initialize the Builder with
     */
    private Builder(AddCustomPromptOptions addCustomPromptOptions) {
      this.customizationId = addCustomPromptOptions.customizationId;
      this.promptId = addCustomPromptOptions.promptId;
      this.metadata = addCustomPromptOptions.metadata;
      this.file = addCustomPromptOptions.file;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     * @param promptId the promptId
     * @param metadata the metadata
     * @param file the file
     */
    public Builder(
        String customizationId, String promptId, PromptMetadata metadata, InputStream file) {
      this.customizationId = customizationId;
      this.promptId = promptId;
      this.metadata = metadata;
      this.file = file;
    }

    /**
     * Builds a AddCustomPromptOptions.
     *
     * @return the new AddCustomPromptOptions instance
     */
    public AddCustomPromptOptions build() {
      return new AddCustomPromptOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the AddCustomPromptOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the promptId.
     *
     * @param promptId the promptId
     * @return the AddCustomPromptOptions builder
     */
    public Builder promptId(String promptId) {
      this.promptId = promptId;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the AddCustomPromptOptions builder
     */
    public Builder metadata(PromptMetadata metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the AddCustomPromptOptions builder
     */
    public Builder file(InputStream file) {
      this.file = file;
      return this;
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the AddCustomPromptOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder file(File file) throws FileNotFoundException {
      this.file = new FileInputStream(file);
      return this;
    }
  }

  protected AddCustomPromptOptions() {}

  protected AddCustomPromptOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.customizationId, "customizationId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.promptId, "promptId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.metadata, "metadata cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.file, "file cannot be null");
    customizationId = builder.customizationId;
    promptId = builder.promptId;
    metadata = builder.metadata;
    file = builder.file;
  }

  /**
   * New builder.
   *
   * @return a AddCustomPromptOptions builder
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
   * Gets the promptId.
   *
   * <p>The identifier of the prompt that is to be added to the custom model: * Include a maximum of
   * 49 characters in the ID. * Include only alphanumeric characters and `_` (underscores) in the
   * ID. * Do not include XML sensitive characters (double quotes, single quotes, ampersands, angle
   * brackets, and slashes) in the ID. * To add a new prompt, the ID must be unique for the
   * specified custom model. Otherwise, the new information for the prompt overwrites the existing
   * prompt that has that ID.
   *
   * @return the promptId
   */
  public String promptId() {
    return promptId;
  }

  /**
   * Gets the metadata.
   *
   * <p>Information about the prompt that is to be added to a custom model. The following example of
   * a `PromptMetadata` object includes both the required prompt text and an optional speaker model
   * ID:
   *
   * <p>`{ "prompt_text": "Thank you and good-bye!", "speaker_id":
   * "823068b2-ed4e-11ea-b6e0-7b6456aa95cc" }`.
   *
   * @return the metadata
   */
  public PromptMetadata metadata() {
    return metadata;
  }

  /**
   * Gets the file.
   *
   * <p>An audio file that speaks the text of the prompt with intonation and prosody that matches
   * how you would like the prompt to be spoken. * The prompt audio must be in WAV format and must
   * have a minimum sampling rate of 16 kHz. The service accepts audio with higher sampling rates.
   * The service transcodes all audio to 16 kHz before processing it. * The length of the prompt
   * audio is limited to 30 seconds.
   *
   * @return the file
   */
  public InputStream file() {
    return file;
  }
}
