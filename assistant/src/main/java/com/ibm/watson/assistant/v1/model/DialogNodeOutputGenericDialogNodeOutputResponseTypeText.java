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

/** DialogNodeOutputGenericDialogNodeOutputResponseTypeText. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeText
    extends DialogNodeOutputGeneric {

  /** How a response is selected from the list, if more than one response is specified. */
  public interface SelectionPolicy {
    /** sequential. */
    String SEQUENTIAL = "sequential";
    /** random. */
    String RANDOM = "random";
    /** multiline. */
    String MULTILINE = "multiline";
  }

  /** Builder. */
  public static class Builder {
    private String responseType;
    private List<DialogNodeOutputTextValuesElement> values;
    private String selectionPolicy;
    private String delimiter;
    private List<ResponseGenericChannel> channels;

    /**
     * Instantiates a new Builder from an existing
     * DialogNodeOutputGenericDialogNodeOutputResponseTypeText instance.
     *
     * @param dialogNodeOutputGenericDialogNodeOutputResponseTypeText the instance to initialize the
     *     Builder with
     */
    public Builder(
        DialogNodeOutputGeneric dialogNodeOutputGenericDialogNodeOutputResponseTypeText) {
      this.responseType = dialogNodeOutputGenericDialogNodeOutputResponseTypeText.responseType;
      this.values = dialogNodeOutputGenericDialogNodeOutputResponseTypeText.values;
      this.selectionPolicy =
          dialogNodeOutputGenericDialogNodeOutputResponseTypeText.selectionPolicy;
      this.delimiter = dialogNodeOutputGenericDialogNodeOutputResponseTypeText.delimiter;
      this.channels = dialogNodeOutputGenericDialogNodeOutputResponseTypeText.channels;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param responseType the responseType
     * @param values the values
     */
    public Builder(String responseType, List<DialogNodeOutputTextValuesElement> values) {
      this.responseType = responseType;
      this.values = values;
    }

    /**
     * Builds a DialogNodeOutputGenericDialogNodeOutputResponseTypeText.
     *
     * @return the new DialogNodeOutputGenericDialogNodeOutputResponseTypeText instance
     */
    public DialogNodeOutputGenericDialogNodeOutputResponseTypeText build() {
      return new DialogNodeOutputGenericDialogNodeOutputResponseTypeText(this);
    }

    /**
     * Adds a new element to values.
     *
     * @param values the new element to be added
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeText builder
     */
    public Builder addValues(DialogNodeOutputTextValuesElement values) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(values, "values cannot be null");
      if (this.values == null) {
        this.values = new ArrayList<DialogNodeOutputTextValuesElement>();
      }
      this.values.add(values);
      return this;
    }

    /**
     * Adds a new element to channels.
     *
     * @param channels the new element to be added
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeText builder
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
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeText builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the values. Existing values will be replaced.
     *
     * @param values the values
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeText builder
     */
    public Builder values(List<DialogNodeOutputTextValuesElement> values) {
      this.values = values;
      return this;
    }

    /**
     * Set the selectionPolicy.
     *
     * @param selectionPolicy the selectionPolicy
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeText builder
     */
    public Builder selectionPolicy(String selectionPolicy) {
      this.selectionPolicy = selectionPolicy;
      return this;
    }

    /**
     * Set the delimiter.
     *
     * @param delimiter the delimiter
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeText builder
     */
    public Builder delimiter(String delimiter) {
      this.delimiter = delimiter;
      return this;
    }

    /**
     * Set the channels. Existing channels will be replaced.
     *
     * @param channels the channels
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeText builder
     */
    public Builder channels(List<ResponseGenericChannel> channels) {
      this.channels = channels;
      return this;
    }
  }

  protected DialogNodeOutputGenericDialogNodeOutputResponseTypeText() {}

  protected DialogNodeOutputGenericDialogNodeOutputResponseTypeText(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.responseType, "responseType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.values, "values cannot be null");
    responseType = builder.responseType;
    values = builder.values;
    selectionPolicy = builder.selectionPolicy;
    delimiter = builder.delimiter;
    channels = builder.channels;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeOutputGenericDialogNodeOutputResponseTypeText builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}
