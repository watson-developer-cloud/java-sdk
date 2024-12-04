/*
 * (C) Copyright IBM Corp. 2017, 2024.
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
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;
import java.util.HashMap;
import java.util.Map;

/**
 * State information for the conversation. To maintain state, include the context from the previous
 * response.
 *
 * <p>This type supports additional properties of type Object. Any context variable.
 */
public class Context extends DynamicModel<Object> {

  @SerializedName("conversation_id")
  protected String conversationId;

  @SerializedName("system")
  protected Map<String, Object> system;

  @SerializedName("metadata")
  protected MessageContextMetadata metadata;

  public Context() {
    super(new TypeToken<Object>() {});
  }

  /** Builder. */
  public static class Builder {
    private String conversationId;
    private Map<String, Object> system;
    private MessageContextMetadata metadata;
    private Map<String, Object> dynamicProperties;

    /**
     * Instantiates a new Builder from an existing Context instance.
     *
     * @param context the instance to initialize the Builder with
     */
    private Builder(Context context) {
      this.conversationId = context.conversationId;
      this.system = context.system;
      this.metadata = context.metadata;
      this.dynamicProperties = context.getProperties();
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a Context.
     *
     * @return the new Context instance
     */
    public Context build() {
      return new Context(this);
    }

    /**
     * Set the conversationId.
     *
     * @param conversationId the conversationId
     * @return the Context builder
     */
    public Builder conversationId(String conversationId) {
      this.conversationId = conversationId;
      return this;
    }

    /**
     * Set the system.
     *
     * @param system the system
     * @return the Context builder
     */
    public Builder system(Map<String, Object> system) {
      this.system = system;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the Context builder
     */
    public Builder metadata(MessageContextMetadata metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Add an arbitrary property. Any context variable.
     *
     * @param name the name of the property to add
     * @param value the value of the property to add
     * @return the Context builder
     */
    public Builder add(String name, Object value) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(name, "name cannot be null");
      if (this.dynamicProperties == null) {
        this.dynamicProperties = new HashMap<String, Object>();
      }
      this.dynamicProperties.put(name, value);
      return this;
    }
  }

  protected Context(Builder builder) {
    super(new TypeToken<Object>() {});
    conversationId = builder.conversationId;
    system = builder.system;
    metadata = builder.metadata;
    this.setProperties(builder.dynamicProperties);
  }

  /**
   * New builder.
   *
   * @return a Context builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the conversationId.
   *
   * <p>The unique identifier of the conversation. The conversation ID cannot contain any of the
   * following characters: `+` `=` `&amp;&amp;` `||` `&gt;` `&lt;` `!` `(` `)` `{` `}` `[` `]` `^`
   * `"` `~` `*` `?` `:` `\` `/`.
   *
   * @return the conversationId
   */
  public String getConversationId() {
    return this.conversationId;
  }

  /**
   * Sets the conversationId.
   *
   * @param conversationId the new conversationId
   */
  public void setConversationId(final String conversationId) {
    this.conversationId = conversationId;
  }

  /**
   * Gets the system.
   *
   * <p>For internal use only.
   *
   * @return the system
   */
  public Map<String, Object> getSystem() {
    return this.system;
  }

  /**
   * Sets the system.
   *
   * @param system the new system
   */
  public void setSystem(final Map<String, Object> system) {
    this.system = system;
  }

  /**
   * Gets the metadata.
   *
   * <p>Metadata related to the message.
   *
   * @return the metadata
   */
  public MessageContextMetadata getMetadata() {
    return this.metadata;
  }

  /**
   * Sets the metadata.
   *
   * @param metadata the new metadata
   */
  public void setMetadata(final MessageContextMetadata metadata) {
    this.metadata = metadata;
  }
}
