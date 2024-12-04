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

/**
 * An object that identifies the dialog element that generated the error message.
 *
 * <p>Classes which extend this class: - LogMessageSourceDialogNode - LogMessageSourceAction -
 * LogMessageSourceStep - LogMessageSourceHandler
 */
public class LogMessageSource extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "type";

  protected static java.util.Map<String, Class<?>> discriminatorMapping;

  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put("dialog_node", LogMessageSourceDialogNode.class);
    discriminatorMapping.put("action", LogMessageSourceAction.class);
    discriminatorMapping.put("step", LogMessageSourceStep.class);
    discriminatorMapping.put("handler", LogMessageSourceHandler.class);
  }

  protected String type;

  @SerializedName("dialog_node")
  protected String dialogNode;

  protected String action;
  protected String step;
  protected String handler;

  protected LogMessageSource() {}

  /**
   * Gets the type.
   *
   * <p>A string that indicates the type of dialog element that generated the error message.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the dialogNode.
   *
   * <p>The unique identifier of the dialog node that generated the error message.
   *
   * @return the dialogNode
   */
  public String getDialogNode() {
    return dialogNode;
  }

  /**
   * Gets the action.
   *
   * <p>The unique identifier of the action that generated the error message.
   *
   * @return the action
   */
  public String getAction() {
    return action;
  }

  /**
   * Gets the step.
   *
   * <p>The unique identifier of the step that generated the error message.
   *
   * @return the step
   */
  public String getStep() {
    return step;
  }

  /**
   * Gets the handler.
   *
   * <p>The unique identifier of the handler that generated the error message.
   *
   * @return the handler
   */
  public String getHandler() {
    return handler;
  }
}
