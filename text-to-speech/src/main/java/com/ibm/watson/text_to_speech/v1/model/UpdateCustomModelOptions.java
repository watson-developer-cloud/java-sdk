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
package com.ibm.watson.text_to_speech.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** The updateCustomModel options. */
public class UpdateCustomModelOptions extends GenericModel {

  protected String customizationId;
  protected String name;
  protected String description;
  protected List<Word> words;

  /** Builder. */
  public static class Builder {
    private String customizationId;
    private String name;
    private String description;
    private List<Word> words;

    /**
     * Instantiates a new Builder from an existing UpdateCustomModelOptions instance.
     *
     * @param updateCustomModelOptions the instance to initialize the Builder with
     */
    private Builder(UpdateCustomModelOptions updateCustomModelOptions) {
      this.customizationId = updateCustomModelOptions.customizationId;
      this.name = updateCustomModelOptions.name;
      this.description = updateCustomModelOptions.description;
      this.words = updateCustomModelOptions.words;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     */
    public Builder(String customizationId) {
      this.customizationId = customizationId;
    }

    /**
     * Builds a UpdateCustomModelOptions.
     *
     * @return the new UpdateCustomModelOptions instance
     */
    public UpdateCustomModelOptions build() {
      return new UpdateCustomModelOptions(this);
    }

    /**
     * Adds a new element to words.
     *
     * @param word the new element to be added
     * @return the UpdateCustomModelOptions builder
     */
    public Builder addWord(Word word) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(word, "word cannot be null");
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
     * @return the UpdateCustomModelOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateCustomModelOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateCustomModelOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the words. Existing words will be replaced.
     *
     * @param words the words
     * @return the UpdateCustomModelOptions builder
     */
    public Builder words(List<Word> words) {
      this.words = words;
      return this;
    }
  }

  protected UpdateCustomModelOptions() {}

  protected UpdateCustomModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.customizationId, "customizationId cannot be empty");
    customizationId = builder.customizationId;
    name = builder.name;
    description = builder.description;
    words = builder.words;
  }

  /**
   * New builder.
   *
   * @return a UpdateCustomModelOptions builder
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
   * Gets the name.
   *
   * <p>A new name for the custom model.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>A new description for the custom model.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the words.
   *
   * <p>An array of `Word` objects that provides the words and their translations that are to be
   * added or updated for the custom model. Pass an empty array to make no additions or updates.
   *
   * @return the words
   */
  public List<Word> words() {
    return words;
  }
}
