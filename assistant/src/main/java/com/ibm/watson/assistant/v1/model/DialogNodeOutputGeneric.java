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
package com.ibm.watson.assistant.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;
import java.util.Map;

/**
 * DialogNodeOutputGeneric.
 *
 * <p>Classes which extend this class: - DialogNodeOutputGenericDialogNodeOutputResponseTypeText -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypePause -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypeImage -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypeOption -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypeAudio -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe
 */
public class DialogNodeOutputGeneric extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "response_type";

  protected static java.util.Map<String, Class<?>> discriminatorMapping;

  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put(
        "audio", DialogNodeOutputGenericDialogNodeOutputResponseTypeAudio.class);
    discriminatorMapping.put(
        "channel_transfer",
        DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer.class);
    discriminatorMapping.put(
        "connect_to_agent",
        DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent.class);
    discriminatorMapping.put(
        "iframe", DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe.class);
    discriminatorMapping.put(
        "image", DialogNodeOutputGenericDialogNodeOutputResponseTypeImage.class);
    discriminatorMapping.put(
        "option", DialogNodeOutputGenericDialogNodeOutputResponseTypeOption.class);
    discriminatorMapping.put(
        "pause", DialogNodeOutputGenericDialogNodeOutputResponseTypePause.class);
    discriminatorMapping.put(
        "search_skill", DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.class);
    discriminatorMapping.put("text", DialogNodeOutputGenericDialogNodeOutputResponseTypeText.class);
    discriminatorMapping.put(
        "user_defined", DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined.class);
    discriminatorMapping.put(
        "video", DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo.class);
  }

  /** How a response is selected from the list, if more than one response is specified. */
  public interface SelectionPolicy {
    /** sequential. */
    String SEQUENTIAL = "sequential";
    /** random. */
    String RANDOM = "random";
    /** multiline. */
    String MULTILINE = "multiline";
  }

  /** The preferred type of control to display, if supported by the channel. */
  public interface Preference {
    /** dropdown. */
    String DROPDOWN = "dropdown";
    /** button. */
    String BUTTON = "button";
  }

  /** The type of the search query. */
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
  protected List<ResponseGenericChannel> channels;
  protected Long time;
  protected Boolean typing;
  protected String source;
  protected String title;
  protected String description;

  @SerializedName("alt_text")
  protected String altText;

  protected String preference;
  protected List<DialogNodeOutputOptionsElement> options;

  @SerializedName("message_to_human_agent")
  protected String messageToHumanAgent;

  @SerializedName("agent_available")
  protected AgentAvailabilityMessage agentAvailable;

  @SerializedName("agent_unavailable")
  protected AgentAvailabilityMessage agentUnavailable;

  @SerializedName("transfer_info")
  protected DialogNodeOutputConnectToAgentTransferInfo transferInfo;

  protected String query;

  @SerializedName("query_type")
  protected String queryType;

  protected String filter;

  @SerializedName("discovery_version")
  protected String discoveryVersion;

  @SerializedName("message_to_user")
  protected String messageToUser;

  @SerializedName("user_defined")
  protected Map<String, Object> userDefined;

  @SerializedName("channel_options")
  protected Map<String, Object> channelOptions;

  @SerializedName("image_url")
  protected String imageUrl;

  protected DialogNodeOutputGeneric() {}

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
   * Gets the values.
   *
   * <p>A list of one or more objects defining text responses.
   *
   * @return the values
   */
  public List<DialogNodeOutputTextValuesElement> values() {
    return values;
  }

  /**
   * Gets the selectionPolicy.
   *
   * <p>How a response is selected from the list, if more than one response is specified.
   *
   * @return the selectionPolicy
   */
  public String selectionPolicy() {
    return selectionPolicy;
  }

  /**
   * Gets the delimiter.
   *
   * <p>The delimiter to use as a separator between responses when `selection_policy`=`multiline`.
   *
   * @return the delimiter
   */
  public String delimiter() {
    return delimiter;
  }

  /**
   * Gets the channels.
   *
   * <p>An array of objects specifying channels for which the response is intended.
   *
   * @return the channels
   */
  public List<ResponseGenericChannel> channels() {
    return channels;
  }

  /**
   * Gets the time.
   *
   * <p>How long to pause, in milliseconds. The valid values are from 0 to 10000.
   *
   * @return the time
   */
  public Long time() {
    return time;
  }

  /**
   * Gets the typing.
   *
   * <p>Whether to send a "user is typing" event during the pause. Ignored if the channel does not
   * support this event.
   *
   * @return the typing
   */
  public Boolean typing() {
    return typing;
  }

  /**
   * Gets the source.
   *
   * <p>The `https:` URL of the image.
   *
   * @return the source
   */
  public String source() {
    return source;
  }

  /**
   * Gets the title.
   *
   * <p>An optional title to show before the response.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the description.
   *
   * <p>An optional description to show with the response.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the altText.
   *
   * <p>Descriptive text that can be used for screen readers or other situations where the image
   * cannot be seen.
   *
   * @return the altText
   */
  public String altText() {
    return altText;
  }

  /**
   * Gets the preference.
   *
   * <p>The preferred type of control to display, if supported by the channel.
   *
   * @return the preference
   */
  public String preference() {
    return preference;
  }

  /**
   * Gets the options.
   *
   * <p>An array of objects describing the options from which the user can choose. You can include
   * up to 20 options.
   *
   * @return the options
   */
  public List<DialogNodeOutputOptionsElement> options() {
    return options;
  }

  /**
   * Gets the messageToHumanAgent.
   *
   * <p>An optional message to be sent to the human agent who will be taking over the conversation.
   *
   * @return the messageToHumanAgent
   */
  public String messageToHumanAgent() {
    return messageToHumanAgent;
  }

  /**
   * Gets the agentAvailable.
   *
   * <p>An optional message to be displayed to the user to indicate that the conversation will be
   * transferred to the next available agent.
   *
   * @return the agentAvailable
   */
  public AgentAvailabilityMessage agentAvailable() {
    return agentAvailable;
  }

  /**
   * Gets the agentUnavailable.
   *
   * <p>An optional message to be displayed to the user to indicate that no online agent is
   * available to take over the conversation.
   *
   * @return the agentUnavailable
   */
  public AgentAvailabilityMessage agentUnavailable() {
    return agentUnavailable;
  }

  /**
   * Gets the transferInfo.
   *
   * <p>Routing or other contextual information to be used by target service desk systems.
   *
   * @return the transferInfo
   */
  public DialogNodeOutputConnectToAgentTransferInfo transferInfo() {
    return transferInfo;
  }

  /**
   * Gets the query.
   *
   * <p>The text of the search query. This can be either a natural-language query or a query that
   * uses the Discovery query language syntax, depending on the value of the **query_type**
   * property. For more information, see the [Discovery service
   * documentation](https://cloud.ibm.com/docs/discovery?topic=discovery-query-operators#query-operators).
   *
   * @return the query
   */
  public String query() {
    return query;
  }

  /**
   * Gets the queryType.
   *
   * <p>The type of the search query.
   *
   * @return the queryType
   */
  public String queryType() {
    return queryType;
  }

  /**
   * Gets the filter.
   *
   * <p>An optional filter that narrows the set of documents to be searched. For more information,
   * see the [Discovery service documentation]([Discovery service
   * documentation](https://cloud.ibm.com/docs/discovery?topic=discovery-query-parameters#filter).
   *
   * @return the filter
   */
  public String filter() {
    return filter;
  }

  /**
   * Gets the discoveryVersion.
   *
   * <p>The version of the Discovery service API to use for the query.
   *
   * @return the discoveryVersion
   */
  public String discoveryVersion() {
    return discoveryVersion;
  }

  /**
   * Gets the messageToUser.
   *
   * <p>The message to display to the user when initiating a channel transfer.
   *
   * @return the messageToUser
   */
  public String messageToUser() {
    return messageToUser;
  }

  /**
   * Gets the userDefined.
   *
   * <p>An object containing any properties for the user-defined response type. The total size of
   * this object cannot exceed 5000 bytes.
   *
   * @return the userDefined
   */
  public Map<String, Object> userDefined() {
    return userDefined;
  }

  /**
   * Gets the channelOptions.
   *
   * <p>For internal use only.
   *
   * @return the channelOptions
   */
  public Map<String, Object> channelOptions() {
    return channelOptions;
  }

  /**
   * Gets the imageUrl.
   *
   * <p>The URL of an image that shows a preview of the embedded content.
   *
   * @return the imageUrl
   */
  public String imageUrl() {
    return imageUrl;
  }
}
