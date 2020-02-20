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
package com.ibm.watson.assistant.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * DialogNodeOutputGeneric.
 */
public class DialogNodeOutputGeneric extends GenericModel {

  /**
   * The type of response returned by the dialog node. The specified response type must be supported by the client
   * application or channel.
   *
   * **Note:** The **search_skill** response type is available only for Plus and Premium users, and is used only by the
   * v2 runtime API.
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
    /** search_skill. */
    String SEARCH_SKILL = "search_skill";
  }

  /**
   * How a response is selected from the list, if more than one response is specified. Valid only when
   * **response_type**=`text`.
   */
  public interface SelectionPolicy {
    /** sequential. */
    String SEQUENTIAL = "sequential";
    /** random. */
    String RANDOM = "random";
    /** multiline. */
    String MULTILINE = "multiline";
  }

  /**
   * The preferred type of control to display, if supported by the channel. Valid only when **response_type**=`option`.
   */
  public interface Preference {
    /** dropdown. */
    String DROPDOWN = "dropdown";
    /** button. */
    String BUTTON = "button";
  }

  /**
   * The type of the search query. Required when **response_type**=`search_skill`.
   */
  public interface QueryType {
    /** natural_language. */
    String NATURAL_LANGUAGE = "natural_language";
    /** discovery_query_language. */
    String DISCOVERY_QUERY_LANGUAGE = "discovery_query_language";
  }

  @SerializedName("response_type")
  protected String responseType;
  protected List<DialogNodeOutputTextValuesElement> values;
  @SerializedName("selection_policy")
  protected String selectionPolicy;
  protected String delimiter;
  protected Long time;
  protected Boolean typing;
  protected String source;
  protected String title;
  protected String description;
  protected String preference;
  protected List<DialogNodeOutputOptionsElement> options;
  @SerializedName("message_to_human_agent")
  protected String messageToHumanAgent;
  protected String query;
  @SerializedName("query_type")
  protected String queryType;
  protected String filter;
  @SerializedName("discovery_version")
  protected String discoveryVersion;

  /**
   * Builder.
   */
  public static class Builder {
    private String responseType;
    private List<DialogNodeOutputTextValuesElement> values;
    private String selectionPolicy;
    private String delimiter;
    private Long time;
    private Boolean typing;
    private String source;
    private String title;
    private String description;
    private String preference;
    private List<DialogNodeOutputOptionsElement> options;
    private String messageToHumanAgent;
    private String query;
    private String queryType;
    private String filter;
    private String discoveryVersion;

    private Builder(DialogNodeOutputGeneric dialogNodeOutputGeneric) {
      this.responseType = dialogNodeOutputGeneric.responseType;
      this.values = dialogNodeOutputGeneric.values;
      this.selectionPolicy = dialogNodeOutputGeneric.selectionPolicy;
      this.delimiter = dialogNodeOutputGeneric.delimiter;
      this.time = dialogNodeOutputGeneric.time;
      this.typing = dialogNodeOutputGeneric.typing;
      this.source = dialogNodeOutputGeneric.source;
      this.title = dialogNodeOutputGeneric.title;
      this.description = dialogNodeOutputGeneric.description;
      this.preference = dialogNodeOutputGeneric.preference;
      this.options = dialogNodeOutputGeneric.options;
      this.messageToHumanAgent = dialogNodeOutputGeneric.messageToHumanAgent;
      this.query = dialogNodeOutputGeneric.query;
      this.queryType = dialogNodeOutputGeneric.queryType;
      this.filter = dialogNodeOutputGeneric.filter;
      this.discoveryVersion = dialogNodeOutputGeneric.discoveryVersion;
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
     * Builds a DialogNodeOutputGeneric.
     *
     * @return the dialogNodeOutputGeneric
     */
    public DialogNodeOutputGeneric build() {
      return new DialogNodeOutputGeneric(this);
    }

    /**
     * Adds an values to values.
     *
     * @param values the new values
     * @return the DialogNodeOutputGeneric builder
     */
    public Builder addValues(DialogNodeOutputTextValuesElement values) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(values,
          "values cannot be null");
      if (this.values == null) {
        this.values = new ArrayList<DialogNodeOutputTextValuesElement>();
      }
      this.values.add(values);
      return this;
    }

    /**
     * Adds an options to options.
     *
     * @param options the new options
     * @return the DialogNodeOutputGeneric builder
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
     * Set the responseType.
     *
     * @param responseType the responseType
     * @return the DialogNodeOutputGeneric builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the values.
     * Existing values will be replaced.
     *
     * @param values the values
     * @return the DialogNodeOutputGeneric builder
     */
    public Builder values(List<DialogNodeOutputTextValuesElement> values) {
      this.values = values;
      return this;
    }

    /**
     * Set the selectionPolicy.
     *
     * @param selectionPolicy the selectionPolicy
     * @return the DialogNodeOutputGeneric builder
     */
    public Builder selectionPolicy(String selectionPolicy) {
      this.selectionPolicy = selectionPolicy;
      return this;
    }

    /**
     * Set the delimiter.
     *
     * @param delimiter the delimiter
     * @return the DialogNodeOutputGeneric builder
     */
    public Builder delimiter(String delimiter) {
      this.delimiter = delimiter;
      return this;
    }

    /**
     * Set the time.
     *
     * @param time the time
     * @return the DialogNodeOutputGeneric builder
     */
    public Builder time(long time) {
      this.time = time;
      return this;
    }

    /**
     * Set the typing.
     *
     * @param typing the typing
     * @return the DialogNodeOutputGeneric builder
     */
    public Builder typing(Boolean typing) {
      this.typing = typing;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the DialogNodeOutputGeneric builder
     */
    public Builder source(String source) {
      this.source = source;
      return this;
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the DialogNodeOutputGeneric builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the DialogNodeOutputGeneric builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the preference.
     *
     * @param preference the preference
     * @return the DialogNodeOutputGeneric builder
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
     * @return the DialogNodeOutputGeneric builder
     */
    public Builder options(List<DialogNodeOutputOptionsElement> options) {
      this.options = options;
      return this;
    }

    /**
     * Set the messageToHumanAgent.
     *
     * @param messageToHumanAgent the messageToHumanAgent
     * @return the DialogNodeOutputGeneric builder
     */
    public Builder messageToHumanAgent(String messageToHumanAgent) {
      this.messageToHumanAgent = messageToHumanAgent;
      return this;
    }

    /**
     * Set the query.
     *
     * @param query the query
     * @return the DialogNodeOutputGeneric builder
     */
    public Builder query(String query) {
      this.query = query;
      return this;
    }

    /**
     * Set the queryType.
     *
     * @param queryType the queryType
     * @return the DialogNodeOutputGeneric builder
     */
    public Builder queryType(String queryType) {
      this.queryType = queryType;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the DialogNodeOutputGeneric builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the discoveryVersion.
     *
     * @param discoveryVersion the discoveryVersion
     * @return the DialogNodeOutputGeneric builder
     */
    public Builder discoveryVersion(String discoveryVersion) {
      this.discoveryVersion = discoveryVersion;
      return this;
    }
  }

  protected DialogNodeOutputGeneric(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.responseType,
        "responseType cannot be null");
    responseType = builder.responseType;
    values = builder.values;
    selectionPolicy = builder.selectionPolicy;
    delimiter = builder.delimiter;
    time = builder.time;
    typing = builder.typing;
    source = builder.source;
    title = builder.title;
    description = builder.description;
    preference = builder.preference;
    options = builder.options;
    messageToHumanAgent = builder.messageToHumanAgent;
    query = builder.query;
    queryType = builder.queryType;
    filter = builder.filter;
    discoveryVersion = builder.discoveryVersion;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeOutputGeneric builder
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
   * **Note:** The **search_skill** response type is available only for Plus and Premium users, and is used only by the
   * v2 runtime API.
   *
   * @return the responseType
   */
  public String responseType() {
    return responseType;
  }

  /**
   * Gets the values.
   *
   * A list of one or more objects defining text responses. Required when **response_type**=`text`.
   *
   * @return the values
   */
  public List<DialogNodeOutputTextValuesElement> values() {
    return values;
  }

  /**
   * Gets the selectionPolicy.
   *
   * How a response is selected from the list, if more than one response is specified. Valid only when
   * **response_type**=`text`.
   *
   * @return the selectionPolicy
   */
  public String selectionPolicy() {
    return selectionPolicy;
  }

  /**
   * Gets the delimiter.
   *
   * The delimiter to use as a separator between responses when `selection_policy`=`multiline`.
   *
   * @return the delimiter
   */
  public String delimiter() {
    return delimiter;
  }

  /**
   * Gets the time.
   *
   * How long to pause, in milliseconds. The valid values are from 0 to 10000. Valid only when
   * **response_type**=`pause`.
   *
   * @return the time
   */
  public Long time() {
    return time;
  }

  /**
   * Gets the typing.
   *
   * Whether to send a "user is typing" event during the pause. Ignored if the channel does not support this event.
   * Valid only when **response_type**=`pause`.
   *
   * @return the typing
   */
  public Boolean typing() {
    return typing;
  }

  /**
   * Gets the source.
   *
   * The URL of the image. Required when **response_type**=`image`.
   *
   * @return the source
   */
  public String source() {
    return source;
  }

  /**
   * Gets the title.
   *
   * An optional title to show before the response. Valid only when **response_type**=`image` or `option`.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the description.
   *
   * An optional description to show with the response. Valid only when **response_type**=`image` or `option`.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the preference.
   *
   * The preferred type of control to display, if supported by the channel. Valid only when **response_type**=`option`.
   *
   * @return the preference
   */
  public String preference() {
    return preference;
  }

  /**
   * Gets the options.
   *
   * An array of objects describing the options from which the user can choose. You can include up to 20 options.
   * Required when **response_type**=`option`.
   *
   * @return the options
   */
  public List<DialogNodeOutputOptionsElement> options() {
    return options;
  }

  /**
   * Gets the messageToHumanAgent.
   *
   * An optional message to be sent to the human agent who will be taking over the conversation. Valid only when
   * **reponse_type**=`connect_to_agent`.
   *
   * @return the messageToHumanAgent
   */
  public String messageToHumanAgent() {
    return messageToHumanAgent;
  }

  /**
   * Gets the query.
   *
   * The text of the search query. This can be either a natural-language query or a query that uses the Discovery query
   * language syntax, depending on the value of the **query_type** property. For more information, see the [Discovery
   * service documentation](https://cloud.ibm.com/docs/discovery/query-operators.html#query-operators).
   * Required when **response_type**=`search_skill`.
   *
   * @return the query
   */
  public String query() {
    return query;
  }

  /**
   * Gets the queryType.
   *
   * The type of the search query. Required when **response_type**=`search_skill`.
   *
   * @return the queryType
   */
  public String queryType() {
    return queryType;
  }

  /**
   * Gets the filter.
   *
   * An optional filter that narrows the set of documents to be searched. For more information, see the [Discovery
   * service documentation]([Discovery service
   * documentation](https://cloud.ibm.com/docs/discovery/query-parameters.html#filter).
   *
   * @return the filter
   */
  public String filter() {
    return filter;
  }

  /**
   * Gets the discoveryVersion.
   *
   * The version of the Discovery service API to use for the query.
   *
   * @return the discoveryVersion
   */
  public String discoveryVersion() {
    return discoveryVersion;
  }
}
