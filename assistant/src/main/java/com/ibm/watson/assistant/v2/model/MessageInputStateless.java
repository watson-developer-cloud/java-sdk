/*
 * (C) Copyright IBM Corp. 2020, 2023.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** An input object that includes the input text. */
public class MessageInputStateless extends GenericModel {

  /**
   * The type of the message:
   *
   * <p>- `text`: The user input is processed normally by the assistant. - `search`: Only search
   * results are returned. (Any dialog or action skill is bypassed.)
   *
   * <p>**Note:** A `search` message results in an error if no search skill is configured for the
   * assistant.
   */
  public interface MessageType {
    /** text. */
    String TEXT = "text";
    /** search. */
    String SEARCH = "search";
  }

  @SerializedName("message_type")
  protected String messageType;

  protected String text;
  protected List<RuntimeIntent> intents;
  protected List<RuntimeEntity> entities;

  @SerializedName("suggestion_id")
  protected String suggestionId;

  protected List<MessageInputAttachment> attachments;
  protected RequestAnalytics analytics;
  protected MessageInputOptionsStateless options;

  /** Builder. */
  public static class Builder {
    private String messageType;
    private String text;
    private List<RuntimeIntent> intents;
    private List<RuntimeEntity> entities;
    private String suggestionId;
    private List<MessageInputAttachment> attachments;
    private RequestAnalytics analytics;
    private MessageInputOptionsStateless options;

    /**
     * Instantiates a new Builder from an existing MessageInputStateless instance.
     *
     * @param messageInputStateless the instance to initialize the Builder with
     */
    private Builder(MessageInputStateless messageInputStateless) {
      this.messageType = messageInputStateless.messageType;
      this.text = messageInputStateless.text;
      this.intents = messageInputStateless.intents;
      this.entities = messageInputStateless.entities;
      this.suggestionId = messageInputStateless.suggestionId;
      this.attachments = messageInputStateless.attachments;
      this.analytics = messageInputStateless.analytics;
      this.options = messageInputStateless.options;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a MessageInputStateless.
     *
     * @return the new MessageInputStateless instance
     */
    public MessageInputStateless build() {
      return new MessageInputStateless(this);
    }

    /**
     * Adds an intent to intents.
     *
     * @param intent the new intent
     * @return the MessageInputStateless builder
     */
    public Builder addIntent(RuntimeIntent intent) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(intent, "intent cannot be null");
      if (this.intents == null) {
        this.intents = new ArrayList<RuntimeIntent>();
      }
      this.intents.add(intent);
      return this;
    }

    /**
     * Adds an entity to entities.
     *
     * @param entity the new entity
     * @return the MessageInputStateless builder
     */
    public Builder addEntity(RuntimeEntity entity) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(entity, "entity cannot be null");
      if (this.entities == null) {
        this.entities = new ArrayList<RuntimeEntity>();
      }
      this.entities.add(entity);
      return this;
    }

    /**
     * Adds an attachments to attachments.
     *
     * @param attachments the new attachments
     * @return the MessageInputStateless builder
     */
    public Builder addAttachments(MessageInputAttachment attachments) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attachments, "attachments cannot be null");
      if (this.attachments == null) {
        this.attachments = new ArrayList<MessageInputAttachment>();
      }
      this.attachments.add(attachments);
      return this;
    }

    /**
     * Set the messageType.
     *
     * @param messageType the messageType
     * @return the MessageInputStateless builder
     */
    public Builder messageType(String messageType) {
      this.messageType = messageType;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the MessageInputStateless builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the intents. Existing intents will be replaced.
     *
     * @param intents the intents
     * @return the MessageInputStateless builder
     */
    public Builder intents(List<RuntimeIntent> intents) {
      this.intents = intents;
      return this;
    }

    /**
     * Set the entities. Existing entities will be replaced.
     *
     * @param entities the entities
     * @return the MessageInputStateless builder
     */
    public Builder entities(List<RuntimeEntity> entities) {
      this.entities = entities;
      return this;
    }

    /**
     * Set the suggestionId.
     *
     * @param suggestionId the suggestionId
     * @return the MessageInputStateless builder
     */
    public Builder suggestionId(String suggestionId) {
      this.suggestionId = suggestionId;
      return this;
    }

    /**
     * Set the attachments. Existing attachments will be replaced.
     *
     * @param attachments the attachments
     * @return the MessageInputStateless builder
     */
    public Builder attachments(List<MessageInputAttachment> attachments) {
      this.attachments = attachments;
      return this;
    }

    /**
     * Set the analytics.
     *
     * @param analytics the analytics
     * @return the MessageInputStateless builder
     */
    public Builder analytics(RequestAnalytics analytics) {
      this.analytics = analytics;
      return this;
    }

    /**
     * Set the options.
     *
     * @param options the options
     * @return the MessageInputStateless builder
     */
    public Builder options(MessageInputOptionsStateless options) {
      this.options = options;
      return this;
    }
  }

  protected MessageInputStateless() {}

  protected MessageInputStateless(Builder builder) {
    messageType = builder.messageType;
    text = builder.text;
    intents = builder.intents;
    entities = builder.entities;
    suggestionId = builder.suggestionId;
    attachments = builder.attachments;
    analytics = builder.analytics;
    options = builder.options;
  }

  /**
   * New builder.
   *
   * @return a MessageInputStateless builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the messageType.
   *
   * <p>The type of the message:
   *
   * <p>- `text`: The user input is processed normally by the assistant. - `search`: Only search
   * results are returned. (Any dialog or action skill is bypassed.)
   *
   * <p>**Note:** A `search` message results in an error if no search skill is configured for the
   * assistant.
   *
   * @return the messageType
   */
  public String messageType() {
    return messageType;
  }

  /**
   * Gets the text.
   *
   * <p>The text of the user input. This string cannot contain carriage return, newline, or tab
   * characters.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the intents.
   *
   * <p>Intents to use when evaluating the user input. Include intents from the previous response to
   * continue using those intents rather than trying to recognize intents in the new input.
   *
   * @return the intents
   */
  public List<RuntimeIntent> intents() {
    return intents;
  }

  /**
   * Gets the entities.
   *
   * <p>Entities to use when evaluating the message. Include entities from the previous response to
   * continue using those entities rather than detecting entities in the new input.
   *
   * @return the entities
   */
  public List<RuntimeEntity> entities() {
    return entities;
  }

  /**
   * Gets the suggestionId.
   *
   * <p>For internal use only.
   *
   * @return the suggestionId
   */
  public String suggestionId() {
    return suggestionId;
  }

  /**
   * Gets the attachments.
   *
   * <p>An array of multimedia attachments to be sent with the message. Attachments are not
   * processed by the assistant itself, but can be sent to external services by webhooks.
   *
   * <p>**Note:** Attachments are not supported on IBM Cloud Pak for Data.
   *
   * @return the attachments
   */
  public List<MessageInputAttachment> attachments() {
    return attachments;
  }

  /**
   * Gets the analytics.
   *
   * <p>An optional object containing analytics data. Currently, this data is used only for events
   * sent to the Segment extension.
   *
   * @return the analytics
   */
  public RequestAnalytics analytics() {
    return analytics;
  }

  /**
   * Gets the options.
   *
   * <p>Optional properties that control how the assistant responds.
   *
   * @return the options
   */
  public MessageInputOptionsStateless options() {
    return options;
  }
}
