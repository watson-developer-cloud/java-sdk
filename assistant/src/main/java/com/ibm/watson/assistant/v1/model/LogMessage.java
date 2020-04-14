/*
 * (C) Copyright IBM Corp. 2020.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Log message details. */
public class LogMessage extends GenericModel {

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
  protected String msg;

  /** Builder. */
  public static class Builder {
    private String level;
    private String msg;

    private Builder(LogMessage logMessage) {
      this.level = logMessage.level;
      this.msg = logMessage.msg;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param level the level
     * @param msg the msg
     */
    public Builder(String level, String msg) {
      this.level = level;
      this.msg = msg;
    }

    /**
     * Builds a LogMessage.
     *
     * @return the logMessage
     */
    public LogMessage build() {
      return new LogMessage(this);
    }

    /**
     * Set the level.
     *
     * @param level the level
     * @return the LogMessage builder
     */
    public Builder level(String level) {
      this.level = level;
      return this;
    }

    /**
     * Set the msg.
     *
     * @param msg the msg
     * @return the LogMessage builder
     */
    public Builder msg(String msg) {
      this.msg = msg;
      return this;
    }
  }

  protected LogMessage(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.level, "level cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.msg, "msg cannot be null");
    level = builder.level;
    msg = builder.msg;
  }

  /**
   * New builder.
   *
   * @return a LogMessage builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the level.
   *
   * <p>The severity of the log message.
   *
   * @return the level
   */
  public String level() {
    return level;
  }

  /**
   * Gets the msg.
   *
   * <p>The text of the log message.
   *
   * @return the msg
   */
  public String msg() {
    return msg;
  }
}
