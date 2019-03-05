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
package com.ibm.watson.developer_cloud.assistant.v1.model;

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

  @SerializedName("response_type")
  private String responseType;
  private List<DialogNodeOutputTextValuesElement> values;
  @SerializedName("selection_policy")
  private String selectionPolicy;
  private String delimiter;
  private Long time;
  private Boolean typing;
  private String source;
  private String title;
  private String description;
  private String preference;
  private List<DialogNodeOutputOptionsElement> options;
  @SerializedName("message_to_human_agent")
  private String messageToHumanAgent;

  /**
   * Gets the responseType.
   *
   * The type of response returned by the dialog node. The specified response type must be supported by the client
   * application or channel.
   *
   * @return the responseType
   */
  public String getResponseType() {
    return responseType;
  }

  /**
   * Gets the values.
   *
   * A list of one or more objects defining text responses. Required when **response_type**=`text`.
   *
   * @return the values
   */
  public List<DialogNodeOutputTextValuesElement> getValues() {
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
  public String getSelectionPolicy() {
    return selectionPolicy;
  }

  /**
   * Gets the delimiter.
   *
   * The delimiter to use as a separator between responses when `selection_policy`=`multiline`.
   *
   * @return the delimiter
   */
  public String getDelimiter() {
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
  public Long getTime() {
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
  public Boolean isTyping() {
    return typing;
  }

  /**
   * Gets the source.
   *
   * The URL of the image. Required when **response_type**=`image`.
   *
   * @return the source
   */
  public String getSource() {
    return source;
  }

  /**
   * Gets the title.
   *
   * An optional title to show before the response. Valid only when **response_type**=`image` or `option`. This string
   * must be no longer than 512 characters.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the description.
   *
   * An optional description to show with the response. Valid only when **response_type**=`image` or `option`. This
   * string must be no longer than 256 characters.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the preference.
   *
   * The preferred type of control to display, if supported by the channel. Valid only when **response_type**=`option`.
   *
   * @return the preference
   */
  public String getPreference() {
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
  public List<DialogNodeOutputOptionsElement> getOptions() {
    return options;
  }

  /**
   * Gets the messageToHumanAgent.
   *
   * An optional message to be sent to the human agent who will be taking over the conversation. Valid only when
   * **reponse_type**=`connect_to_agent`. This string must be no longer than 256 characters.
   *
   * @return the messageToHumanAgent
   */
  public String getMessageToHumanAgent() {
    return messageToHumanAgent;
  }

  /**
   * Sets the responseType.
   *
   * @param responseType the new responseType
   */
  public void setResponseType(final String responseType) {
    this.responseType = responseType;
  }

  /**
   * Sets the values.
   *
   * @param values the new values
   */
  public void setValues(final List<DialogNodeOutputTextValuesElement> values) {
    this.values = values;
  }

  /**
   * Sets the selectionPolicy.
   *
   * @param selectionPolicy the new selectionPolicy
   */
  public void setSelectionPolicy(final String selectionPolicy) {
    this.selectionPolicy = selectionPolicy;
  }

  /**
   * Sets the delimiter.
   *
   * @param delimiter the new delimiter
   */
  public void setDelimiter(final String delimiter) {
    this.delimiter = delimiter;
  }

  /**
   * Sets the time.
   *
   * @param time the new time
   */
  public void setTime(final long time) {
    this.time = time;
  }

  /**
   * Sets the typing.
   *
   * @param typing the new typing
   */
  public void setTyping(final Boolean typing) {
    this.typing = typing;
  }

  /**
   * Sets the source.
   *
   * @param source the new source
   */
  public void setSource(final String source) {
    this.source = source;
  }

  /**
   * Sets the title.
   *
   * @param title the new title
   */
  public void setTitle(final String title) {
    this.title = title;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Sets the preference.
   *
   * @param preference the new preference
   */
  public void setPreference(final String preference) {
    this.preference = preference;
  }

  /**
   * Sets the options.
   *
   * @param options the new options
   */
  public void setOptions(final List<DialogNodeOutputOptionsElement> options) {
    this.options = options;
  }

  /**
   * Sets the messageToHumanAgent.
   *
   * @param messageToHumanAgent the new messageToHumanAgent
   */
  public void setMessageToHumanAgent(final String messageToHumanAgent) {
    this.messageToHumanAgent = messageToHumanAgent;
  }
}
