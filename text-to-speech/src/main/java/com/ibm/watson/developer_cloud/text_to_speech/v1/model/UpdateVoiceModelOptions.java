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
package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The updateVoiceModel options.
 */
public class UpdateVoiceModelOptions extends GenericModel {

  private String customizationId;
  private String name;
  private String description;
  private List<Word> words;

  /**
   * Builder.
   */
  public static class Builder {
    private String customizationId;
    private String name;
    private String description;
    private List<Word> words;

    private Builder(UpdateVoiceModelOptions updateVoiceModelOptions) {
      customizationId = updateVoiceModelOptions.customizationId;
      name = updateVoiceModelOptions.name;
      description = updateVoiceModelOptions.description;
      words = updateVoiceModelOptions.words;
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
     */
    public Builder(String customizationId) {
      this.customizationId = customizationId;
    }

    /**
     * Builds a UpdateVoiceModelOptions.
     *
     * @return the updateVoiceModelOptions
     */
    public UpdateVoiceModelOptions build() {
      return new UpdateVoiceModelOptions(this);
    }

    /**
     * Adds an word to words.
     *
     * @param word the new word
     * @return the UpdateVoiceModelOptions builder
     */
    public Builder addWord(Word word) {
      Validator.notNull(word, "word cannot be null");
      if (this.words == null) {
        this.words = new ArrayList<Word>();
      }
      this.words.add(word);
      return this;
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the UpdateVoiceModelOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateVoiceModelOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateVoiceModelOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the words.
     * Existing words will be replaced.
     *
     * @param words the words
     * @return the UpdateVoiceModelOptions builder
     */
    public Builder words(List<Word> words) {
      this.words = words;
      return this;
    }
  }

  private UpdateVoiceModelOptions(Builder builder) {
    Validator.notEmpty(builder.customizationId, "customizationId cannot be empty");
    customizationId = builder.customizationId;
    name = builder.name;
    description = builder.description;
    words = builder.words;
  }

  /**
   * New builder.
   *
   * @return a UpdateVoiceModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * The GUID of the custom voice model that is to be updated. You must make the request with service credentials
   * created for the instance of the service that owns the custom model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the name.
   *
   * A new name for the custom voice model.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * A new description for the custom voice model.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the words.
   *
   * An array of words and their translations that are to be added or updated for the custom voice model. Pass an empty
   * array to make no additions or updates.
   *
   * @return the words
   */
  public List<Word> words() {
    return words;
  }
}
