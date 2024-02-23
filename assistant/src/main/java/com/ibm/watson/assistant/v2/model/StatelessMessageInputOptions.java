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
public class StatelessMessageInputOptions extends GenericModel {

  protected Boolean restart;

  @SerializedName("alternate_intents")
  protected Boolean alternateIntents;

  @SerializedName("async_callout")
  protected Boolean asyncCallout;

  protected MessageInputOptionsSpelling spelling;
  protected Boolean debug;

  /** Builder. */
  public static class Builder {
    private Boolean restart;
    private Boolean alternateIntents;
    private Boolean asyncCallout;
    private MessageInputOptionsSpelling spelling;
    private Boolean debug;

    /**
     * Instantiates a new Builder from an existing StatelessMessageInputOptions instance.
     *
     * @param statelessMessageInputOptions the instance to initialize the Builder with
     */
    private Builder(StatelessMessageInputOptions statelessMessageInputOptions) {
      this.restart = statelessMessageInputOptions.restart;
      this.alternateIntents = statelessMessageInputOptions.alternateIntents;
      this.asyncCallout = statelessMessageInputOptions.asyncCallout;
      this.spelling = statelessMessageInputOptions.spelling;
      this.debug = statelessMessageInputOptions.debug;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a StatelessMessageInputOptions.
     *
     * @return the new StatelessMessageInputOptions instance
     */
    public StatelessMessageInputOptions build() {
      return new StatelessMessageInputOptions(this);
    }

    /**
     * Set the restart.
     *
     * @param restart the restart
     * @return the StatelessMessageInputOptions builder
     */
    public Builder restart(Boolean restart) {
      this.restart = restart;
      return this;
    }

    /**
     * Set the alternateIntents.
     *
     * @param alternateIntents the alternateIntents
     * @return the StatelessMessageInputOptions builder
     */
    public Builder alternateIntents(Boolean alternateIntents) {
      this.alternateIntents = alternateIntents;
      return this;
    }

    /**
     * Set the asyncCallout.
     *
     * @param asyncCallout the asyncCallout
     * @return the StatelessMessageInputOptions builder
     */
    public Builder asyncCallout(Boolean asyncCallout) {
      this.asyncCallout = asyncCallout;
      return this;
    }

    /**
     * Set the spelling.
     *
     * @param spelling the spelling
     * @return the StatelessMessageInputOptions builder
     */
    public Builder spelling(MessageInputOptionsSpelling spelling) {
      this.spelling = spelling;
      return this;
    }

    /**
     * Set the debug.
     *
     * @param debug the debug
     * @return the StatelessMessageInputOptions builder
     */
    public Builder debug(Boolean debug) {
      this.debug = debug;
      return this;
    }
  }

  protected StatelessMessageInputOptions() {}

  protected StatelessMessageInputOptions(Builder builder) {
    restart = builder.restart;
    alternateIntents = builder.alternateIntents;
    asyncCallout = builder.asyncCallout;
    spelling = builder.spelling;
    debug = builder.debug;
  }

  /**
   * New builder.
   *
   * @return a StatelessMessageInputOptions builder
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
   * information in the `output.debug` property.
   *
   * @return the debug
   */
  public Boolean debug() {
    return debug;
  }
}
