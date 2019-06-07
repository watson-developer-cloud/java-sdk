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
package com.ibm.watson.assistant.v1.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * Log message details.
 */
public class LogMessage extends DynamicModel<Object> {
  /**
   * The severity of the log message.
   */
  public interface Level {
    /** info. */
    String INFO = "info";
    /** error. */
    String ERROR = "error";
    /** warn. */
    String WARN = "warn";
  }

  @SerializedName("level")
  private String level;
  @SerializedName("msg")
  private String msg;

  public LogMessage() {
    super(new TypeToken<Object>() {
    });
  }

  /**
   * Gets the level.
   *
   * The severity of the log message.
   *
   * @return the level
   */
  public String getLevel() {
    return this.level;
  }

  /**
   * Sets the level.
   *
   * @param level the new level
   */
  public void setLevel(final String level) {
    this.level = level;
  }

  /**
   * Gets the msg.
   *
   * The text of the log message.
   *
   * @return the msg
   */
  public String getMsg() {
    return this.msg;
  }

  /**
   * Sets the msg.
   *
   * @param msg the new msg
   */
  public void setMsg(final String msg) {
    this.msg = msg;
  }
}
