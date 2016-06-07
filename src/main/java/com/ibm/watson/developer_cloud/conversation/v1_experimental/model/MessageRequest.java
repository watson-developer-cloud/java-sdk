package com.ibm.watson.developer_cloud.conversation.v1_experimental.model;

import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.conversation.v1_experimental.ConversationService;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The request payload to the Conversation service's message API call
 * {@link ConversationService#message(String, MessageRequest)}
 * @see <a href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/conversation.html">
 * http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/conversation.html</a>
 */
public class MessageRequest extends GenericModel {
  public static class Builder {
    private Map<String, Object> context;
    private Map<String, Object> input;
    private String text;

    /**
     * Instantiates a new Builder
     */
    public Builder() {}

    public Builder(String text, Map<String, Object> context) {
      this.text = text;
      if (context != null)
        this.context = new HashMap<>(context);
    }

    /**
     * Generates a new {@link MessageRequest} payload object. The payload will contain the
     * parameters set in the builder.
     * 
     * @return a message API request payload object.
     */
    public MessageRequest build() {
      return new MessageRequest(this);
    }

    /**
     * Sets the context for the message API request.
     * 
     * @param context a map containing key value pairs representing the state/context of the
     *        conversation
     * 
     * @return a builder object
     */
    public Builder context(Map<String, Object> context) {
      if (context != null)
        this.context = new HashMap<>(context);
      else
        this.context = null;
      return this;
    }

    /**
     * Sets the input property of the message API request payload. <br/>
     * <b>NOTE</b>: The input property will OVERWRITE the value set via the
     * {@link Builder#text(String)} method. The input, if set, will always be used before the value
     * set via {@link #text(String)} method.
     * 
     * @param input a map of properties to be sent to the service under the input property
     * @return a builder object
     */
    public Builder input(Map<String, Object> input) {
      if (input != null)
        this.input = new HashMap<>(input);
      else {
        this.input = null;
      }
      return this;
    }

    /**
     * A helper method to allow the caller to quickly/easily set the text input property. This is a
     * convenience method which is equivalent to calling:
     * 
     * <pre>
     * // Using helper method:
     * MessageRequest.Builder builder = new MessageRequest.Builder();
     * builder.text("Hello world");
     * 
     * // is equivalent to...
     * Map<String, Object> input = new HashMap<>();
     * input.put("text", "Hello world");
     * MessageRequest.Builder builder = new MessageRequest.Builder();
     * builder.input(input);
     * </pre>
     * 
     * <b>Note</b>: The value of input takes precedence over the value of the text field.
     * 
     * @param text the textual value to be assigned to the 'text' property on the input object.
     * @return a builder object
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  private Map<String, Object> context;

  private Map<String, Object> input;

  /**
   * Creates a new instance of the MessageRequest payload object for the {@link ConversationService}
   * service. Clients must use the {@link Builder} class to construct new instances of the class.
   * 
   * @param options a builder configured with the various parameters for the request
   */
  private MessageRequest(Builder options) {
    this.context = options.context;
    if (options.text != null)
      this.setText(options.text);
    if (options.input != null)
      this.setInput(input);
  }

  /**
   * Returns a map used to store context/state for the message API. Each response from the message
   * API will return a context object as a part of the payload. This context must be maintained and
   * passed in as a part of subsequet API calls.
   * 
   * @return a map of properties
   */
  public Map<String, Object> getContext() {
    return context;
  }

  /**
   * Returns a map storing the input which is to be sent to the service as a part of the API
   * request.
   * 
   * @return a map of properties
   */
  public Map<String, Object> getInput() {
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
   * @return the value of the input.text property which is to be sent to the message API as a part
   *         of the request payload
   */
  public String getText() {
    if (this.input != null) {
      return (String) this.input.get("text");
    }
    return null;
  }

  /**
   * Sets the context/state which is to be sent to the message API as a part of the service request.
   * Each response from the message API returns a <code>context</code> object which represents the
   * state as defined by the service. The state is not maintained by the service, so the client must
   * keep the state from each API call, and pass that state in as a part of any subsequent requests.
   * 
   * @param context a map with key-value pairs representing state
   */
  public void setContext(Map<String, Object> context) {
    this.context = context;
  }

  /**
   * Sets the input which is to be sent to the message API as a part of the service request.
   * Typically the input will contain a <code>text</code> property (key and value). The
   * <code>text</code> property is generally interpreted as being the user/system input which the
   * service must parse for intents, entities etc..<br>
   * In advanced cases the client may pass in more than just text as a part of the service input.
   * For the majority of cases calling the {@link #setText(String)} method is sufficient to send
   * text to the service on behalf of the user/system.
   * 
   * @param input a map of key value pairs
   */
  public void setInput(Map<String, Object> input) {
    this.input = input;
  }

  /**
   * A convenience method that allows the developer to quickly set the <code>text</code> property
   * on the <code>input</code> object in the payload. Calling this method is equivalent to calling:
   * <pre>
   * Map<String, Object> input = new HashMap<>();
   * input.put("text", "Hello world");
   * request.setInput(input);
   * </pre>
   * 
   * @param text a string representing input from the user or system
   */
  public void setText(String text) {
    if (this.input == null) {
      this.input = new HashMap<>();
    }
    if (text == null) {
      this.input.remove("text");
      return;
    }
    this.input.put("text", text);
  }
}
