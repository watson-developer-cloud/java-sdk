/*
 * (C) Copyright IBM Corp. 2020, 2021.
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

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/** RuntimeResponseGenericRuntimeResponseTypeSuggestion. */
public class RuntimeResponseGenericRuntimeResponseTypeSuggestion extends RuntimeResponseGeneric {

  @SerializedName("response_type")
  private String responseType;

  private String title;
  private List<DialogSuggestion> suggestions;
  private List<ResponseGenericChannel> channels;

  /** Builder. */
  public static class Builder {
    private String responseType;
    private String title;
    private List<DialogSuggestion> suggestions;
    private List<ResponseGenericChannel> channels;

    public Builder(
        RuntimeResponseGenericRuntimeResponseTypeSuggestion
            runtimeResponseGenericRuntimeResponseTypeSuggestion) {
      this.responseType = runtimeResponseGenericRuntimeResponseTypeSuggestion.responseType;
      this.title = runtimeResponseGenericRuntimeResponseTypeSuggestion.title;
      this.suggestions = runtimeResponseGenericRuntimeResponseTypeSuggestion.suggestions;
      this.channels = runtimeResponseGenericRuntimeResponseTypeSuggestion.channels;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param responseType the responseType
     * @param title the title
     * @param suggestions the suggestions
     */
    public Builder(String responseType, String title, List<DialogSuggestion> suggestions) {
      this.responseType = responseType;
      this.title = title;
      this.suggestions = suggestions;
    }

    /**
     * Builds a RuntimeResponseGenericRuntimeResponseTypeSuggestion.
     *
     * @return the new RuntimeResponseGenericRuntimeResponseTypeSuggestion instance
     */
    public RuntimeResponseGenericRuntimeResponseTypeSuggestion build() {
      return new RuntimeResponseGenericRuntimeResponseTypeSuggestion(this);
    }

    /**
     * Adds an suggestions to suggestions.
     *
     * @param suggestions the new suggestions
     * @return the RuntimeResponseGenericRuntimeResponseTypeSuggestion builder
     */
    public Builder addSuggestions(DialogSuggestion suggestions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(suggestions, "suggestions cannot be null");
      if (this.suggestions == null) {
        this.suggestions = new ArrayList<DialogSuggestion>();
      }
      this.suggestions.add(suggestions);
      return this;
    }

    /**
     * Adds an channels to channels.
     *
     * @param channels the new channels
     * @return the RuntimeResponseGenericRuntimeResponseTypeSuggestion builder
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
     * @return the RuntimeResponseGenericRuntimeResponseTypeSuggestion builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the RuntimeResponseGenericRuntimeResponseTypeSuggestion builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the suggestions. Existing suggestions will be replaced.
     *
     * @param suggestions the suggestions
     * @return the RuntimeResponseGenericRuntimeResponseTypeSuggestion builder
     */
    public Builder suggestions(List<DialogSuggestion> suggestions) {
      this.suggestions = suggestions;
      return this;
    }

    /**
     * Set the channels. Existing channels will be replaced.
     *
     * @param channels the channels
     * @return the RuntimeResponseGenericRuntimeResponseTypeSuggestion builder
     */
    public Builder channels(List<ResponseGenericChannel> channels) {
      this.channels = channels;
      return this;
    }
  }

  protected RuntimeResponseGenericRuntimeResponseTypeSuggestion(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.responseType, "responseType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.title, "title cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.suggestions, "suggestions cannot be null");
    responseType = builder.responseType;
    title = builder.title;
    suggestions = builder.suggestions;
    channels = builder.channels;
  }

  /**
   * New builder.
   *
   * @return a RuntimeResponseGenericRuntimeResponseTypeSuggestion builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the responseType.
   *
   * <p>The type of response returned by the dialog node. The specified response type must be
   * supported by the client application or channel.
   *
   * @return the responseType
   */
  public String responseType() {
    return responseType;
  }

  /**
   * Gets the channels.
   *
   * <p>An array of objects specifying channels for which the response is intended. If **channels**
   * is present, the response is intended for a built-in integration and should not be handled by an
   * API client.
   *
   * @return the channels
   */
  public List<ResponseGenericChannel> channels() {
    return channels;
  }

  /**
   * Gets the title.
   *
   * <p>The title or introductory text to show before the response.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the suggestions.
   *
   * <p>An array of objects describing the possible matching dialog nodes from which the user can
   * choose.
   *
   * @return the suggestions
   */
  public List<DialogSuggestion> suggestions() {
    return suggestions;
  }
}
