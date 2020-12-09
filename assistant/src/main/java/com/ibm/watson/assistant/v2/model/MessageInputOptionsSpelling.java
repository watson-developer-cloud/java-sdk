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
package com.ibm.watson.assistant.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Spelling correction options for the message. Any options specified on an individual message
 * override the settings configured for the skill.
 */
public class MessageInputOptionsSpelling extends GenericModel {

  protected Boolean suggestions;

  @SerializedName("auto_correct")
  protected Boolean autoCorrect;

  /** Builder. */
  public static class Builder {
    private Boolean suggestions;
    private Boolean autoCorrect;

    private Builder(MessageInputOptionsSpelling messageInputOptionsSpelling) {
      this.suggestions = messageInputOptionsSpelling.suggestions;
      this.autoCorrect = messageInputOptionsSpelling.autoCorrect;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a MessageInputOptionsSpelling.
     *
     * @return the new MessageInputOptionsSpelling instance
     */
    public MessageInputOptionsSpelling build() {
      return new MessageInputOptionsSpelling(this);
    }

    /**
     * Set the suggestions.
     *
     * @param suggestions the suggestions
     * @return the MessageInputOptionsSpelling builder
     */
    public Builder suggestions(Boolean suggestions) {
      this.suggestions = suggestions;
      return this;
    }

    /**
     * Set the autoCorrect.
     *
     * @param autoCorrect the autoCorrect
     * @return the MessageInputOptionsSpelling builder
     */
    public Builder autoCorrect(Boolean autoCorrect) {
      this.autoCorrect = autoCorrect;
      return this;
    }
  }

  protected MessageInputOptionsSpelling(Builder builder) {
    suggestions = builder.suggestions;
    autoCorrect = builder.autoCorrect;
  }

  /**
   * New builder.
   *
   * @return a MessageInputOptionsSpelling builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the suggestions.
   *
   * <p>Whether to use spelling correction when processing the input. If spelling correction is used
   * and **auto_correct** is `true`, any spelling corrections are automatically applied to the user
   * input. If **auto_correct** is `false`, any suggested corrections are returned in the
   * **output.spelling** property.
   *
   * <p>This property overrides the value of the **spelling_suggestions** property in the workspace
   * settings for the skill.
   *
   * @return the suggestions
   */
  public Boolean suggestions() {
    return suggestions;
  }

  /**
   * Gets the autoCorrect.
   *
   * <p>Whether to use autocorrection when processing the input. If this property is `true`, any
   * corrections are automatically applied to the user input, and the original text is returned in
   * the **output.spelling** property of the message response. This property overrides the value of
   * the **spelling_auto_correct** property in the workspace settings for the skill.
   *
   * @return the autoCorrect
   */
  public Boolean autoCorrect() {
    return autoCorrect;
  }
}
