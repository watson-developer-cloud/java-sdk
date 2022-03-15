/*
 * (C) Copyright IBM Corp. 2022.
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
 * RuntimeResponseGeneric.
 *
 * <p>Classes which extend this class: - RuntimeResponseGenericRuntimeResponseTypeText -
 * RuntimeResponseGenericRuntimeResponseTypePause - RuntimeResponseGenericRuntimeResponseTypeImage -
 * RuntimeResponseGenericRuntimeResponseTypeOption -
 * RuntimeResponseGenericRuntimeResponseTypeConnectToAgent -
 * RuntimeResponseGenericRuntimeResponseTypeSuggestion -
 * RuntimeResponseGenericRuntimeResponseTypeChannelTransfer -
 * RuntimeResponseGenericRuntimeResponseTypeUserDefined -
 * RuntimeResponseGenericRuntimeResponseTypeVideo - RuntimeResponseGenericRuntimeResponseTypeAudio -
 * RuntimeResponseGenericRuntimeResponseTypeIframe
 */
public class RuntimeResponseGeneric extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "response_type";

  protected static java.util.Map<String, Class<?>> discriminatorMapping;

  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put("audio", RuntimeResponseGenericRuntimeResponseTypeAudio.class);
    discriminatorMapping.put(
        "channel_transfer", RuntimeResponseGenericRuntimeResponseTypeChannelTransfer.class);
    discriminatorMapping.put(
        "connect_to_agent", RuntimeResponseGenericRuntimeResponseTypeConnectToAgent.class);
    discriminatorMapping.put("iframe", RuntimeResponseGenericRuntimeResponseTypeIframe.class);
    discriminatorMapping.put("image", RuntimeResponseGenericRuntimeResponseTypeImage.class);
    discriminatorMapping.put("option", RuntimeResponseGenericRuntimeResponseTypeOption.class);
    discriminatorMapping.put(
        "suggestion", RuntimeResponseGenericRuntimeResponseTypeSuggestion.class);
    discriminatorMapping.put("pause", RuntimeResponseGenericRuntimeResponseTypePause.class);
    discriminatorMapping.put("text", RuntimeResponseGenericRuntimeResponseTypeText.class);
    discriminatorMapping.put(
        "user_defined", RuntimeResponseGenericRuntimeResponseTypeUserDefined.class);
    discriminatorMapping.put("video", RuntimeResponseGenericRuntimeResponseTypeVideo.class);
  }

  /** The preferred type of control to display. */
  public interface Preference {
    /** dropdown. */
    String DROPDOWN = "dropdown";
    /** button. */
    String BUTTON = "button";
  }

  @SerializedName("response_type")
  protected String responseType;

  protected String text;
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

  protected String topic;

  @SerializedName("dialog_node")
  protected String dialogNode;

  protected List<DialogSuggestion> suggestions;

  @SerializedName("message_to_user")
  protected String messageToUser;

  @SerializedName("user_defined")
  protected Map<String, Object> userDefined;

  @SerializedName("channel_options")
  protected Map<String, Object> channelOptions;

  @SerializedName("image_url")
  protected String imageUrl;

  protected RuntimeResponseGeneric() {}

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
   * Gets the text.
   *
   * <p>The text of the response.
   *
   * @return the text
   */
  public String text() {
    return text;
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
   * Gets the time.
   *
   * <p>How long to pause, in milliseconds.
   *
   * @return the time
   */
  public Long time() {
    return time;
  }

  /**
   * Gets the typing.
   *
   * <p>Whether to send a "user is typing" event during the pause.
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
   * <p>The title or introductory text to show before the response.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the description.
   *
   * <p>The description to show with the the response.
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
   * <p>The preferred type of control to display.
   *
   * @return the preference
   */
  public String preference() {
    return preference;
  }

  /**
   * Gets the options.
   *
   * <p>An array of objects describing the options from which the user can choose.
   *
   * @return the options
   */
  public List<DialogNodeOutputOptionsElement> options() {
    return options;
  }

  /**
   * Gets the messageToHumanAgent.
   *
   * <p>A message to be sent to the human agent who will be taking over the conversation.
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
   * Gets the topic.
   *
   * <p>A label identifying the topic of the conversation, derived from the **title** property of
   * the relevant node or the **topic** property of the dialog node response.
   *
   * @return the topic
   */
  public String topic() {
    return topic;
  }

  /**
   * Gets the dialogNode.
   *
   * <p>The unique ID of the dialog node that the **topic** property is taken from. The **topic**
   * property is populated using the value of the dialog node's **title** property.
   *
   * @return the dialogNode
   */
  public String dialogNode() {
    return dialogNode;
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
   * <p>An object containing any properties for the user-defined response type.
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
