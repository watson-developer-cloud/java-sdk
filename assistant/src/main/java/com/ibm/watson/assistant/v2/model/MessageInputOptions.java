/*
 * (C) Copyright IBM Corp. 2019.
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

/**
 * Optional properties that control how the assistant responds.
 */
public class MessageInputOptions extends GenericModel {

  private Boolean debug;
  private Boolean restart;
  @SerializedName("alternate_intents")
  private Boolean alternateIntents;
  @SerializedName("return_context")
  private Boolean returnContext;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean debug;
    private Boolean restart;
    private Boolean alternateIntents;
    private Boolean returnContext;

    private Builder(MessageInputOptions messageInputOptions) {
      this.debug = messageInputOptions.debug;
      this.restart = messageInputOptions.restart;
      this.alternateIntents = messageInputOptions.alternateIntents;
      this.returnContext = messageInputOptions.returnContext;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a MessageInputOptions.
     *
     * @return the messageInputOptions
     */
    public MessageInputOptions build() {
      return new MessageInputOptions(this);
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
     * Set the returnContext.
     *
     * @param returnContext the returnContext
     * @return the MessageInputOptions builder
     */
    public Builder returnContext(Boolean returnContext) {
      this.returnContext = returnContext;
      return this;
    }
  }

  private MessageInputOptions(Builder builder) {
    debug = builder.debug;
    restart = builder.restart;
    alternateIntents = builder.alternateIntents;
    returnContext = builder.returnContext;
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
   * Gets the debug.
   *
   * Whether to return additional diagnostic information. Set to `true` to return additional information under the
   * `output.debug` key.
   *
   * @return the debug
   */
  public Boolean debug() {
    return debug;
  }

  /**
   * Gets the restart.
   *
   * Whether to restart dialog processing at the root of the dialog, regardless of any previously visited nodes.
   * **Note:** This does not affect `turn_count` or any other context variables.
   *
   * @return the restart
   */
  public Boolean restart() {
    return restart;
  }

  /**
   * Gets the alternateIntents.
   *
   * Whether to return more than one intent. Set to `true` to return all matching intents.
   *
   * @return the alternateIntents
   */
  public Boolean alternateIntents() {
    return alternateIntents;
  }

  /**
   * Gets the returnContext.
   *
   * Whether to return session context with the response. If you specify `true`, the response will include the `context`
   * property.
   *
   * @return the returnContext
   */
  public Boolean returnContext() {
    return returnContext;
  }
}
