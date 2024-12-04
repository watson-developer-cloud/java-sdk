/*
 * (C) Copyright IBM Corp. 2024.
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

/** Optional properties that control how the assistant responds. */
public class MessageInputOptions extends GenericModel {

  protected Boolean restart;

  @SerializedName("alternate_intents")
  protected Boolean alternateIntents;

  @SerializedName("async_callout")
  protected Boolean asyncCallout;

  protected MessageInputOptionsSpelling spelling;
  protected Boolean debug;

  @SerializedName("return_context")
  protected Boolean returnContext;

  protected Boolean export;

  /** Builder. */
  public static class Builder {
    private Boolean restart;
    private Boolean alternateIntents;
    private Boolean asyncCallout;
    private MessageInputOptionsSpelling spelling;
    private Boolean debug;
    private Boolean returnContext;
    private Boolean export;

    /**
     * Instantiates a new Builder from an existing MessageInputOptions instance.
     *
     * @param messageInputOptions the instance to initialize the Builder with
     */
    private Builder(MessageInputOptions messageInputOptions) {
      this.restart = messageInputOptions.restart;
      this.alternateIntents = messageInputOptions.alternateIntents;
      this.asyncCallout = messageInputOptions.asyncCallout;
      this.spelling = messageInputOptions.spelling;
      this.debug = messageInputOptions.debug;
      this.returnContext = messageInputOptions.returnContext;
      this.export = messageInputOptions.export;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a MessageInputOptions.
     *
     * @return the new MessageInputOptions instance
     */
    public MessageInputOptions build() {
      return new MessageInputOptions(this);
    }

    /**
     * Set the restart.
     *
     * @param restart the restart
     * @return the MessageInputOptions builder
     */
    public Builder restart(Boolean restart) {
      this.restart = restart;
      return this;
    }

    /**
     * Set the alternateIntents.
     *
     * @param alternateIntents the alternateIntents
     * @return the MessageInputOptions builder
     */
    public Builder alternateIntents(Boolean alternateIntents) {
      this.alternateIntents = alternateIntents;
      return this;
    }

    /**
     * Set the asyncCallout.
     *
     * @param asyncCallout the asyncCallout
     * @return the MessageInputOptions builder
     */
    public Builder asyncCallout(Boolean asyncCallout) {
      this.asyncCallout = asyncCallout;
      return this;
    }

    /**
     * Set the spelling.
     *
     * @param spelling the spelling
     * @return the MessageInputOptions builder
     */
    public Builder spelling(MessageInputOptionsSpelling spelling) {
      this.spelling = spelling;
      return this;
    }

    /**
     * Set the debug.
     *
     * @param debug the debug
     * @return the MessageInputOptions builder
     */
    public Builder debug(Boolean debug) {
      this.debug = debug;
      return this;
    }

    /**
     * Set the returnContext.
     *
     * @param returnContext the returnContext
     * @return the MessageInputOptions builder
     */
    public Builder returnContext(Boolean returnContext) {
      this.returnContext = returnContext;
      return this;
    }

    /**
     * Set the export.
     *
     * @param export the export
     * @return the MessageInputOptions builder
     */
    public Builder export(Boolean export) {
      this.export = export;
      return this;
    }
  }

  protected MessageInputOptions() {}

  protected MessageInputOptions(Builder builder) {
    restart = builder.restart;
    alternateIntents = builder.alternateIntents;
    asyncCallout = builder.asyncCallout;
    spelling = builder.spelling;
    debug = builder.debug;
    returnContext = builder.returnContext;
    export = builder.export;
  }

  /**
   * New builder.
   *
   * @return a MessageInputOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the restart.
   *
   * <p>Whether to restart dialog processing at the root of the dialog, regardless of any previously
   * visited nodes. **Note:** This does not affect `turn_count` or any other context variables.
   *
   * @return the restart
   */
  public Boolean restart() {
    return restart;
  }

  /**
   * Gets the alternateIntents.
   *
   * <p>Whether to return more than one intent. Set to `true` to return all matching intents.
   *
   * @return the alternateIntents
   */
  public Boolean alternateIntents() {
    return alternateIntents;
  }

  /**
   * Gets the asyncCallout.
   *
   * <p>Whether custom extension callouts are executed asynchronously. Asynchronous execution means
   * the response to the extension callout will be processed on the subsequent message call, the
   * initial message response signals to the client that the operation may be long running. With
   * synchronous execution the custom extension is executed and returns the response in a single
   * message turn. **Note:** **async_callout** defaults to true for API versions earlier than
   * 2023-06-15.
   *
   * @return the asyncCallout
   */
  public Boolean asyncCallout() {
    return asyncCallout;
  }

  /**
   * Gets the spelling.
   *
   * <p>Spelling correction options for the message. Any options specified on an individual message
   * override the settings configured for the skill.
   *
   * @return the spelling
   */
  public MessageInputOptionsSpelling spelling() {
    return spelling;
  }

  /**
   * Gets the debug.
   *
   * <p>Whether to return additional diagnostic information. Set to `true` to return additional
   * information in the `output.debug` property. If you also specify **return_context**=`true`, the
   * returned skill context includes the `system.state` property.
   *
   * @return the debug
   */
  public Boolean debug() {
    return debug;
  }

  /**
   * Gets the returnContext.
   *
   * <p>Whether to return session context with the response. If you specify `true`, the response
   * includes the `context` property. If you also specify **debug**=`true`, the returned skill
   * context includes the `system.state` property.
   *
   * @return the returnContext
   */
  public Boolean returnContext() {
    return returnContext;
  }

  /**
   * Gets the export.
   *
   * <p>Whether to return session context, including full conversation state. If you specify `true`,
   * the response includes the `context` property, and the skill context includes the `system.state`
   * property.
   *
   * <p>**Note:** If **export**=`true`, the context is returned regardless of the value of
   * **return_context**.
   *
   * @return the export
   */
  public Boolean export() {
    return export;
  }
}
