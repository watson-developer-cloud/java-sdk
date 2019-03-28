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
   * Gets the debug.
   *
   * Whether to return additional diagnostic information. Set to `true` to return additional information under the
   * `output.debug` key.
   *
   * @return the debug
   */
  public Boolean isDebug() {
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
  public Boolean isRestart() {
    return restart;
  }

  /**
   * Gets the alternateIntents.
   *
   * Whether to return more than one intent. Set to `true` to return all matching intents.
   *
   * @return the alternateIntents
   */
  public Boolean isAlternateIntents() {
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
  public Boolean isReturnContext() {
    return returnContext;
  }

  /**
   * Sets the debug.
   *
   * @param debug the new debug
   */
  public void setDebug(final Boolean debug) {
    this.debug = debug;
  }

  /**
   * Sets the restart.
   *
   * @param restart the new restart
   */
  public void setRestart(final Boolean restart) {
    this.restart = restart;
  }

  /**
   * Sets the alternateIntents.
   *
   * @param alternateIntents the new alternateIntents
   */
  public void setAlternateIntents(final Boolean alternateIntents) {
    this.alternateIntents = alternateIntents;
  }

  /**
   * Sets the returnContext.
   *
   * @param returnContext the new returnContext
   */
  public void setReturnContext(final Boolean returnContext) {
    this.returnContext = returnContext;
  }
}
