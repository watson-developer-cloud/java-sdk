/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.conversation.v1_experimental.model;

import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.conversation.v1_experimental.ConversationService;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Object that represents the input and context of a conversation. This is used by the
 * {@link ConversationService#message(String, MessageRequest)} method
 * 
 * @see <a href="http://www.ibm.com/watson/developercloud/conversation.html">
 *      http://www.ibm.com/watson/developercloud/conversation.html</a>
 * 
 */
public class MessageRequest extends GenericModel {

  /**
   * The Class Builder.
   */
  public static class Builder {
    private static final String TEXT = "text";
    private Map<String, Object> context;
    private Map<String, Object> input;

    /**
     * Instantiates a new Builder.
     */
    public Builder() {}

    /**
     * Instantiates a new builder.
     *
     * @param messageRequest the message request
     */
    private Builder(MessageRequest messageRequest) {
      this.input = new HashMap<String, Object>(messageRequest.input);
      this.context = new HashMap<String, Object>(messageRequest.context);
    }

    /**
     * Generates a new {@link MessageRequest} object. It will contain the parameters set in the
     * builder.
     * 
     * @return a {@link MessageRequest} instance
     */
    public MessageRequest build() {
      return new MessageRequest(this);
    }

    /**
     * Sets the context/state which is to be sent to the message API as a part of the service
     * request. Each response from the message API returns a <code>context</code> object which
     * represents the state as defined by the service. The state is not maintained by the service,
     * so the client must keep the state from each API call, and pass that state in as a part of any
     * subsequent requests.
     * 
     * @param context a map containing key value pairs representing the state/context of the
     *        conversation
     * 
     * @return a builder object
     */
    public Builder context(final Map<String, Object> context) {
      this.context = context != null ? new HashMap<String, Object>(context) : context;
      return this;
    }

    /**
     * Sets the input which is to be sent to the message API as a part of the service request.
     * Typically the input will contain a <code>text</code> property (key and value). The
     * <code>text</code> property is generally interpreted as being the user/system input which the
     * service must parse for intents, entities etc..<br>
     * In advanced cases the client may pass in more than just text as a part of the service input.
     * For the majority of cases calling the {@link #inputText(String)} method is sufficient to send
     * text to the service on behalf of the user/system.
     * 
     * @param input a map of properties to be sent to the service under the input property
     * @return a builder object
     */
    public Builder input(Map<String, Object> input) {
      this.input = input !=null ? new HashMap<String, Object>(input) : null;
      return this;
    }

    /**
     * Sets the input text which is to be sent to the message API as a part of the service request.
     * 
     * @param text the textual value to be assigned to the 'text' property on the input object.
     * @return a builder object
     */
    public Builder inputText(String text) {
      if (input == null) {
        input = new HashMap<String, Object>();
      }
      input.put(TEXT, text);
      return this;
    }
  }

  private Map<String, Object> context;
  private Map<String, Object> input;

  /**
   * Creates a new instance of the MessageRequest for the {@link ConversationService} service.
   * Clients must use the {@link Builder} class to construct new instances of the class.
   * 
   * @param options a builder configured with the various parameters for the request
   */
  private MessageRequest(Builder options) {
    this.context = options.context;
    this.input = options.input;
  }

  /**
   * Returns a map used to store context/state for the message API. Each response from the message
   * API will return a context object as a part of the payload. This context must be maintained and
   * passed in as a part of subsequent API calls.
   * 
   * @return a map of properties
   */
  public Map<String, Object> context() {
    return context;
  }

  /**
   * Returns a map storing the input which is to be sent to the service as a part of the API
   * request.
   * 
   * @return a map of properties
   */
  public Map<String, Object> input() {
    return input;
  }

  /**
   * Convenience method which allows the developer to quickly retrieve the 'text' property from the
   * input object. This is equivalent to calling:
   * 
   * <pre>
   * Map<String, Object> input = request.getInput();
   * String text = null;
   * if (input != null) {
   *   text = input.get("text");
   * }
   * </pre>
   * 
   * @return the value of the <code>input.text</code> property
   */
  public String inputText() {
    return (input != null && input.get("text") != null) ? input.get("text").toString() : null;
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}
