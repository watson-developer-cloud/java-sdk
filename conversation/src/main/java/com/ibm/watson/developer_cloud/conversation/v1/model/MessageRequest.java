/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * Object that represents the input and context of a conversation. This is used by the
 * {@link ConversationService#message(String, MessageRequest)} method
 *
 * @see <a href="http://www.ibm.com/watson/developercloud/conversation.html"> http://www.ibm.com/
 *      watson/developercloud/conversation.html</a>
 *
 */
public class MessageRequest extends GenericModel {

  /**
   * The Class Builder.
   */
  public static class Builder {
    private static final String TEXT = "text";
    private Boolean alternateIntents;
    private Map<String, Object> context;
    private List<Entity> entities;
    private Map<String, Object> input;
    private List<Intent> intents;

    /**
     * Instantiates a new builder.
     *
     * @param messageRequest the message request
     */
    private Builder(MessageRequest messageRequest) {
      input = new HashMap<String, Object>(messageRequest.input);
      context = new HashMap<String, Object>(messageRequest.context);
      alternateIntents = messageRequest.alternateIntents;
    }

    /**
     * Instantiates a new Builder.
     */
    public Builder() { }

    /**
     * Sets the alternate intents flag. Set to true to return all matching intents
     *
     * @param alternateIntents the alternate intents flag
     * @return a builder object
     */
    public Builder alternateIntents(final Boolean alternateIntents) {
      this.alternateIntents = alternateIntents;
      return this;
    }

    /**
     * Generates a new {@link MessageRequest} object. It will contain the parameters set in the builder.
     *
     * @return a {@link MessageRequest} instance
     */
    public MessageRequest build() {
      return new MessageRequest(this);
    }

    /**
     * Sets the context/state which is to be sent to the message API as a part of the service request. Each response
     * from the message API returns a <code>context</code> object which represents the state as defined by the service.
     * The state is not maintained by the service, so the client must keep the state from each API call, and pass that
     * state in as a part of any subsequent requests.
     *
     * @param context a map containing key value pairs representing the state/context of the conversation
     *
     * @return a builder object
     */
    public Builder context(final Map<String, Object> context) {
      this.context = context != null ? new HashMap<String, Object>(context) : context;
      return this;
    }

    /**
     * Sets the input which is to be sent to the message API as a part of the service request. Typically the input will
     * contain a <code>text</code> property (key and value). The <code>text</code> property is generally interpreted as
     * being the user/system input which the service must parse for intents, entities etc..<br>
     * In advanced cases the client may pass in more than just text as a part of the service input. For the majority of
     * cases calling the {@link #inputText(String)} method is sufficient to send text to the service on behalf of the
     * user/system.
     *
     * @param input a map of properties to be sent to the service under the input property
     * @return a builder object
     */
    public Builder input(Map<String, Object> input) {
      this.input = input != null ? new HashMap<String, Object>(input) : null;
      return this;
    }

    /**
     * Adds an entity to the list of entities to be send as part of the request.
     *
     * @param entity the entity
     * @return the builder
     */
    public Builder entity(Entity entity) {
      if (entities == null) {
        entities = new ArrayList<Entity>();
      }

      entities.add(entity);
      return this;
    }

    /**
     * Adds an intent to the list of intents to be send as part of the request.
     *
     * @param intent the intent
     * @return the builder
     */
    public Builder intent(Intent intent) {
      if (intents == null) {
        intents = new ArrayList<Intent>();
      }

      intents.add(intent);
      return this;
    }

    /**
     * Sets the list the entities to be send as part of the request.<br>
     * Existing entities will be replaced.
     *
     * @param entities the entities
     * @return the builder
     */
    public Builder entities(List<Entity> entities) {
      this.entities = entities;
      return this;
    }

    /**
     * Sets the list the intents to be send as part of the request.<br>
     * Existing intents will be replaced.
     *
     * @param intents the intents
     * @return the builder
     */
    public Builder intents(List<Intent> intents) {
      this.intents = intents;
      return this;
    }

    /**
     * Sets the input text which is to be sent to the message API as a part of the service request.
     *
     * @param text the textual value to be assigned to the 'text' property on the input object.
     * @return a builder object
     */
    public Builder inputText(String text) {
      Validator.notNull(text, "text cannot be null");

      if (input == null) {
        input = new HashMap<String, Object>();
      }
      input.put(TEXT, text);
      return this;
    }
  }

  @SerializedName("alternate_intents")
  private Boolean alternateIntents;
  private Map<String, Object> context;
  private List<Entity> entities;
  private Map<String, Object> input;
  private List<Intent> intents;

  /**
   * Creates a new instance of the MessageRequest for the {@link ConversationService} service. Clients must use the
   * {@link Builder} class to construct new instances of the class.
   *
   * @param options a builder configured with the various parameters for the request
   */
  private MessageRequest(Builder options) {
    context = options.context;
    input = options.input;
    alternateIntents = options.alternateIntents;
    entities = options.entities;
    intents = options.intents;
  }

  /**
   * Whether to return more than one intent. Set to true to return all matching intents boolean<br>
   * Default: false
   *
   * @return the boolean indicating if alternate intents should be returned
   */
  public Boolean alternateIntents() {
    return alternateIntents;
  }

  /**
   * Returns a map used to store context/state for the message API. Each response from the message API will return a
   * context object as a part of the payload. This context must be maintained and passed in as a part of subsequent API
   * calls.
   *
   * @return a map of properties
   */
  public Map<String, Object> context() {
    return context;
  }


  /**
   * Returns a map storing the input which is to be sent to the service as a part of the API request.
   *
   * @return a map of properties
   */
  public Map<String, Object> input() {
    return input;
  }

  /**
   * Returns the intent list.
   *
   * @return the intent list
   */
  public List<Intent> intents() {
    return intents;
  }

  /**
   * Returns the entity list.
   *
   * @return the entity list
   */
  public List<Entity> entities() {
    return entities;
  }


  /**
   * Convenience method which allows the developer to quickly retrieve the 'text' property from the input object. This
   * is equivalent to calling:
   *
   * <pre>
   * Map&lt;String, Object&gt; input = request.getInput();
   * String text = null;
   * if (input != null) {
   *   text = input.get("text");
   * }
   * </pre>
   *
   * @return the value of the <code>input.text</code> property
   */
  public String inputText() {
    return ((input != null) && (input.get("text") != null)) ? input.get("text").toString() : null;
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
