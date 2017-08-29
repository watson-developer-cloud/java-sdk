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

import java.util.HashMap;

/**
 * Log message details.
 */
public class LogMessage extends HashMap<String, Object> {
  /**
   * The severity of the message.
   */
  public interface Level {
    /** info. */
    String INFO = "info";
    /** error. */
    String ERROR = "error";
    /** warn. */
    String WARN = "warn";
  }

  /**
   * Gets the level.
   *
   * @return the level
   */
  public String getLevel() {
    return (String) this.get("level");
  }

  /**
   * Gets the msg.
   *
   * @return the msg
   */
  public String getMsg() {
    return (String) this.get("msg");
  }

  /**
   * Sets the level.
   *
   * @param level the new level
   */
  public void setLevel(final String level) {
    this.put("level", level);
  }

  /**
   * Sets the msg.
   *
   * @param msg the new msg
   */
  public void setMsg(final String msg) {
    this.put("msg", msg);
  }
}
