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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Dialog log message details. */
public class DialogLogMessage extends GenericModel {

  /** The severity of the log message. */
  public interface Level {
    /** info. */
    String INFO = "info";
    /** error. */
    String ERROR = "error";
    /** warn. */
    String WARN = "warn";
  }

  protected String level;
  protected String message;
  protected String code;
  protected LogMessageSource source;

  protected DialogLogMessage() {}

  /**
   * Gets the level.
   *
   * <p>The severity of the log message.
   *
   * @return the level
   */
  public String getLevel() {
    return level;
  }

  /**
   * Gets the message.
   *
   * <p>The text of the log message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Gets the code.
   *
   * <p>A code that indicates the category to which the error message belongs.
   *
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * Gets the source.
   *
   * <p>An object that identifies the dialog element that generated the error message.
   *
   * @return the source
   */
  public LogMessageSource getSource() {
    return source;
  }
}
