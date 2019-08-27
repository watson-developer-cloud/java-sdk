/*
 * (C) Copyright IBM Corp. 2019.
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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * RuntimeResponseGeneric.
 */
public class RuntimeResponseGeneric extends GenericModel {

  /**
   * The type of response returned by the dialog node. The specified response type must be supported by the client
   * application or channel.
   *
   * **Note:** The **suggestion** response type is part of the disambiguation feature, which is only available for
   * Premium users.
   */
  public interface ResponseType {
    /** text. */
    String TEXT = "text";
    /** pause. */
    String PAUSE = "pause";
    /** image. */
    String IMAGE = "image";
    /** option. */
    String OPTION = "option";
    /** connect_to_agent. */
    String CONNECT_TO_AGENT = "connect_to_agent";
    /** suggestion. */
    String SUGGESTION = "suggestion";
    /** search. */
    String SEARCH = "search";
  }

  /**
   * The preferred type of control to display.
   */
  public interface Preference {
    /** dropdown. */
    String DROPDOWN = "dropdown";
    /** button. */
    String BUTTON = "button";
  }

  @SerializedName("response_type")
  private String responseType;
  private String text;
  private Long time;
  private Boolean typing;
  private String source;
  private String title;
  private String description;
  private String preference;
  private List<DialogNodeOutputOptionsElement> options;
  @SerializedName("message_to_human_agent")
  private String messageToHumanAgent;
  private String topic;
  private List<DialogSuggestion> suggestions;
  private String header;
  private List<SearchResult> results;

  /**
   * Builder.
   */
  public static class Builder {
    private String responseType;
    private String text;
    private Long time;
    private Boolean typing;
    private String source;
    private String title;
    private String description;
    private String preference;
    private List<DialogNodeOutputOptionsElement> options;
    private String messageToHumanAgent;
    private String topic;
    private List<DialogSuggestion> suggestions;
    private String header;
    private List<SearchResult> results;

    private Builder(RuntimeResponseGeneric runtimeResponseGeneric) {
      this.responseType = runtimeResponseGeneric.responseType;
      this.text = runtimeResponseGeneric.text;
      this.time = runtimeResponseGeneric.time;
      this.typing = runtimeResponseGeneric.typing;
      this.source = runtimeResponseGeneric.source;
      this.title = runtimeResponseGeneric.title;
      this.description = runtimeResponseGeneric.description;
      this.preference = runtimeResponseGeneric.preference;
      this.options = runtimeResponseGeneric.options;
      this.messageToHumanAgent = runtimeResponseGeneric.messageToHumanAgent;
      this.topic = runtimeResponseGeneric.topic;
      this.suggestions = runtimeResponseGeneric.suggestions;
      this.header = runtimeResponseGeneric.header;
      this.results = runtimeResponseGeneric.results;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param responseType the responseType
     */
    public Builder(String responseType) {
      this.responseType = responseType;
    }

    /**
     * Builds a RuntimeResponseGeneric.
     *
     * @return the runtimeResponseGeneric
     */
    public RuntimeResponseGeneric build() {
      return new RuntimeResponseGeneric(this);
    }

    /**
     * Adds an options to options.
     *
     * @param options the new options
     * @return the RuntimeResponseGeneric builder
     */
    public Builder addOptions(DialogNodeOutputOptionsElement options) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(options,
          "options cannot be null");
      if (this.options == null) {
        this.options = new ArrayList<DialogNodeOutputOptionsElement>();
      }
      this.options.add(options);
      return this;
    }

    /**
     * Adds an suggestions to suggestions.
     *
     * @param suggestions the new suggestions
     * @return the RuntimeResponseGeneric builder
     */
    public Builder addSuggestions(DialogSuggestion suggestions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(suggestions,
          "suggestions cannot be null");
      if (this.suggestions == null) {
        this.suggestions = new ArrayList<DialogSuggestion>();
      }
      this.suggestions.add(suggestions);
      return this;
    }

    /**
     * Adds an results to results.
     *
     * @param results the new results
     * @return the RuntimeResponseGeneric builder
     */
    public Builder addResults(SearchResult results) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(results,
          "results cannot be null");
      if (this.results == null) {
        this.results = new ArrayList<SearchResult>();
      }
      this.results.add(results);
      return this;
    }

    /**
     * Set the responseType.
     *
     * @param responseType the responseType
     * @return the RuntimeResponseGeneric builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the RuntimeResponseGeneric builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the time.
     *
     * @param time the time
     * @return the RuntimeResponseGeneric builder
     */
    public Builder time(long time) {
      this.time = time;
      return this;
    }

    /**
     * Set the typing.
     *
     * @param typing the typing
     * @return the RuntimeResponseGeneric builder
     */
    public Builder typing(Boolean typing) {
      this.typing = typing;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the RuntimeResponseGeneric builder
     */
    public Builder source(String source) {
      this.source = source;
      return this;
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the RuntimeResponseGeneric builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the RuntimeResponseGeneric builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the preference.
     *
     * @param preference the preference
     * @return the RuntimeResponseGeneric builder
     */
    public Builder preference(String preference) {
      this.preference = preference;
      return this;
    }

    /**
     * Set the options.
     * Existing options will be replaced.
     *
     * @param options the options
     * @return the RuntimeResponseGeneric builder
     */
    public Builder options(List<DialogNodeOutputOptionsElement> options) {
      this.options = options;
      return this;
    }

    /**
     * Set the messageToHumanAgent.
     *
     * @param messageToHumanAgent the messageToHumanAgent
     * @return the RuntimeResponseGeneric builder
     */
    public Builder messageToHumanAgent(String messageToHumanAgent) {
      this.messageToHumanAgent = messageToHumanAgent;
      return this;
    }

    /**
     * Set the topic.
     *
     * @param topic the topic
     * @return the RuntimeResponseGeneric builder
     */
    public Builder topic(String topic) {
      this.topic = topic;
      return this;
    }

    /**
     * Set the suggestions.
     * Existing suggestions will be replaced.
     *
     * @param suggestions the suggestions
     * @return the RuntimeResponseGeneric builder
     */
    public Builder suggestions(List<DialogSuggestion> suggestions) {
      this.suggestions = suggestions;
      return this;
    }

    /**
     * Set the header.
     *
     * @param header the header
     * @return the RuntimeResponseGeneric builder
     */
    public Builder header(String header) {
      this.header = header;
      return this;
    }

    /**
     * Set the results.
     * Existing results will be replaced.
     *
     * @param results the results
     * @return the RuntimeResponseGeneric builder
     */
    public Builder results(List<SearchResult> results) {
      this.results = results;
      return this;
    }
  }

  private RuntimeResponseGeneric(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.responseType,
        "responseType cannot be null");
    responseType = builder.responseType;
    text = builder.text;
    time = builder.time;
    typing = builder.typing;
    source = builder.source;
    title = builder.title;
    description = builder.description;
    preference = builder.preference;
    options = builder.options;
    messageToHumanAgent = builder.messageToHumanAgent;
    topic = builder.topic;
    suggestions = builder.suggestions;
    header = builder.header;
    results = builder.results;
  }

  /**
   * New builder.
   *
   * @return a RuntimeResponseGeneric builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the responseType.
   *
   * The type of response returned by the dialog node. The specified response type must be supported by the client
   * application or channel.
   *
   * **Note:** The **suggestion** response type is part of the disambiguation feature, which is only available for
   * Premium users.
   *
   * @return the responseType
   */
  public String responseType() {
    return responseType;
  }

  /**
   * Gets the text.
   *
   * The text of the response.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the time.
   *
   * How long to pause, in milliseconds.
   *
   * @return the time
   */
  public Long time() {
    return time;
  }

  /**
   * Gets the typing.
   *
   * Whether to send a "user is typing" event during the pause.
   *
   * @return the typing
   */
  public Boolean typing() {
    return typing;
  }

  /**
   * Gets the source.
   *
   * The URL of the image.
   *
   * @return the source
   */
  public String source() {
    return source;
  }

  /**
   * Gets the title.
   *
   * The title or introductory text to show before the response.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the description.
   *
   * The description to show with the the response.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the preference.
   *
   * The preferred type of control to display.
   *
   * @return the preference
   */
  public String preference() {
    return preference;
  }

  /**
   * Gets the options.
   *
   * An array of objects describing the options from which the user can choose.
   *
   * @return the options
   */
  public List<DialogNodeOutputOptionsElement> options() {
    return options;
  }

  /**
   * Gets the messageToHumanAgent.
   *
   * A message to be sent to the human agent who will be taking over the conversation.
   *
   * @return the messageToHumanAgent
   */
  public String messageToHumanAgent() {
    return messageToHumanAgent;
  }

  /**
   * Gets the topic.
   *
   * A label identifying the topic of the conversation, derived from the **user_label** property of the relevant node.
   *
   * @return the topic
   */
  public String topic() {
    return topic;
  }

  /**
   * Gets the suggestions.
   *
   * An array of objects describing the possible matching dialog nodes from which the user can choose.
   *
   * **Note:** The **suggestions** property is part of the disambiguation feature, which is only available for Premium
   * users.
   *
   * @return the suggestions
   */
  public List<DialogSuggestion> suggestions() {
    return suggestions;
  }

  /**
   * Gets the header.
   *
   * The title or introductory text to show before the response. This text is defined in the search skill configuration.
   *
   * @return the header
   */
  public String header() {
    return header;
  }

  /**
   * Gets the results.
   *
   * An array of objects containing search results.
   *
   * @return the results
   */
  public List<SearchResult> results() {
    return results;
  }
}
