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

import java.util.List;
import java.util.Map;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.RequestUtils;

/**
 * The response payload from the Conversation service's message API call
 * {@link ConversationService#message(String, MessageRequest)}.
 *
 * @see <a href="http://www.ibm.com/watson/developercloud/conversation.html"> http://www.ibm.com/
 *      watson/developercloud/conversation.html</a>
 */
public class MessageResponse extends GenericModel {
  private static final String TEXT = "text";

  private Map<String, Object> context;
  private List<Entity> entities;
  private List<Intent> intents;
  private Map<String, Object> output;
  private Map<String, Object> input;


  /**
   * Returns the context as returned by the service. At each step in the chat flow the conversation designer has the
   * ability to add information to the chat context. The context is a map of key value pairs, with the values being any
   * valid JSON objects/primitives.
   *
   * @return a map representing context/state
   */
  public Map<String, Object> getContext() {
    return context;
  }

  /**
   * Returns the list of entities as detected by the service.
   *
   * @return an array of {@link Entity} objects
   */
  public List<Entity> getEntities() {
    return entities;
  }

  /**
   * Returns the list of intents as detected by the service.
   *
   * @return an array of {@link Intent} objects.
   */
  public List<Intent> getIntents() {
    return intents;
  }

  /**
   * Returns the output as returned by the service, may be null.
   *
   * @return a map of objects representing the response from the Dialog portion of the service.
   */
  public Map<String, Object> getOutput() {
    return output;
  }

  /**
   * Sets the context as determined by the service.
   *
   * @param context a map of key value pairs
   */
  public void setContext(Map<String, Object> context) {
    this.context = context;
  }

  /**
   * Sets a list of entities as detected by the service.
   *
   * @param entities an array of entities
   */
  public void setEntities(List<Entity> entities) {
    this.entities = entities;
  }

  /**
   * Sets a list of intents as detected by the service.
   *
   * @param intents an array of intents
   */
  public void setIntents(List<Intent> intents) {
    this.intents = intents;
  }

  /**
   * Sets the output as returned by the service.
   *
   * @param output a map of outputs as defined by the conversation designer
   */
  public void setOutput(Map<String, Object> output) {
    this.output = output;
  }

  /**
   * A convenience method for getting the text property from the output object. This is equivalent to calling:
   *
   * <pre>
   * List&lt;?&gt; text = null;
   * Map&lt;String, Object&gt; output = response.getOutput();
   * if (output != null) {
   *   text = (List&lt;?&gt;) output.get("text");
   * }
   * </pre>
   *
   * @return an array of strings which is to be displayed/returned to the end user
   */
  @SuppressWarnings("unchecked")
  public List<String> getText() {
    if ((output != null) && output.containsKey(TEXT)) {
      List<?> text = (List<?>) output.get(TEXT);
      if (text != null) {
        return (List<String>) text;
      }
    }
    return null;
  }

  /**
   * A convenience method for getting the text property from the output object. The text property is an array of
   * strings. This convenience class concatenates the array, separating each entry with the separator string.
   *
   * @param separator the separator
   * @return a concatenation of the strings in the output array, with each string separated by the separator string
   */
  public String getTextConcatenated(String separator) {
    List<String> outputText = getText();
    if (outputText != null) {
      return RequestUtils.join(outputText, separator);
    }
    return null;
  }

  /**
   * Gets the input.
   *
   * @return the input
   */
  public Map<String, Object> getInput() {
    return input;
  }

  /**
   * Sets the input.
   *
   * @param input the input
   */
  public void setInput(Map<String, Object> input) {
    this.input = input;
  }

  /**
   * Gets the input text.
   *
   * @return the input text
   */
  public String getInputText() {
    if ((input != null) && input.containsKey(TEXT)) {
      return input.get(TEXT).toString();
    }
    return null;
  }
}
