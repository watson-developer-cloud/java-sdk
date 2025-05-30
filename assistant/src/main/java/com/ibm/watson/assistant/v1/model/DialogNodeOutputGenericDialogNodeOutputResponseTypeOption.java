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

package com.ibm.watson.assistant.v1.model;

import java.util.ArrayList;
import java.util.List;

/** DialogNodeOutputGenericDialogNodeOutputResponseTypeOption. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeOption
    extends DialogNodeOutputGeneric {

  /** The preferred type of control to display, if supported by the channel. */
  public interface Preference {
    /** dropdown. */
    String DROPDOWN = "dropdown";
    /** button. */
    String BUTTON = "button";
  }

  /** Builder. */
  public static class Builder {
    private String responseType;
    private String title;
    private String description;
    private String preference;
    private List<DialogNodeOutputOptionsElement> options;
    private List<ResponseGenericChannel> channels;

    /**
     * Instantiates a new Builder from an existing
     * DialogNodeOutputGenericDialogNodeOutputResponseTypeOption instance.
     *
     * @param dialogNodeOutputGenericDialogNodeOutputResponseTypeOption the instance to initialize
     *     the Builder with
     */
    public Builder(
        DialogNodeOutputGeneric dialogNodeOutputGenericDialogNodeOutputResponseTypeOption) {
      this.responseType = dialogNodeOutputGenericDialogNodeOutputResponseTypeOption.responseType;
      this.title = dialogNodeOutputGenericDialogNodeOutputResponseTypeOption.title;
      this.description = dialogNodeOutputGenericDialogNodeOutputResponseTypeOption.description;
      this.preference = dialogNodeOutputGenericDialogNodeOutputResponseTypeOption.preference;
      this.options = dialogNodeOutputGenericDialogNodeOutputResponseTypeOption.options;
      this.channels = dialogNodeOutputGenericDialogNodeOutputResponseTypeOption.channels;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param responseType the responseType
     * @param title the title
     * @param options the options
     */
    public Builder(
        String responseType, String title, List<DialogNodeOutputOptionsElement> options) {
      this.responseType = responseType;
      this.title = title;
      this.options = options;
    }

    /**
     * Builds a DialogNodeOutputGenericDialogNodeOutputResponseTypeOption.
     *
     * @return the new DialogNodeOutputGenericDialogNodeOutputResponseTypeOption instance
     */
    public DialogNodeOutputGenericDialogNodeOutputResponseTypeOption build() {
      return new DialogNodeOutputGenericDialogNodeOutputResponseTypeOption(this);
    }

    /**
     * Adds a new element to options.
     *
     * @param options the new element to be added
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeOption builder
     */
    public Builder addOptions(DialogNodeOutputOptionsElement options) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(options, "options cannot be null");
      if (this.options == null) {
        this.options = new ArrayList<DialogNodeOutputOptionsElement>();
      }
      this.options.add(options);
      return this;
    }

    /**
     * Adds a new element to channels.
     *
     * @param channels the new element to be added
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeOption builder
     */
    public Builder addChannels(ResponseGenericChannel channels) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(channels, "channels cannot be null");
      if (this.channels == null) {
        this.channels = new ArrayList<ResponseGenericChannel>();
      }
      this.channels.add(channels);
      return this;
    }

    /**
     * Set the responseType.
     *
     * @param responseType the responseType
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeOption builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeOption builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeOption builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the preference.
     *
     * @param preference the preference
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeOption builder
     */
    public Builder preference(String preference) {
      this.preference = preference;
      return this;
    }

    /**
     * Set the options. Existing options will be replaced.
     *
     * @param options the options
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeOption builder
     */
    public Builder options(List<DialogNodeOutputOptionsElement> options) {
      this.options = options;
      return this;
    }

    /**
     * Set the channels. Existing channels will be replaced.
     *
     * @param channels the channels
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeOption builder
     */
    public Builder channels(List<ResponseGenericChannel> channels) {
      this.channels = channels;
      return this;
    }
  }

  protected DialogNodeOutputGenericDialogNodeOutputResponseTypeOption() {}

  protected DialogNodeOutputGenericDialogNodeOutputResponseTypeOption(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.responseType, "responseType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.title, "title cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.options, "options cannot be null");
    responseType = builder.responseType;
    title = builder.title;
    description = builder.description;
    preference = builder.preference;
    options = builder.options;
    channels = builder.channels;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeOutputGenericDialogNodeOutputResponseTypeOption builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}
