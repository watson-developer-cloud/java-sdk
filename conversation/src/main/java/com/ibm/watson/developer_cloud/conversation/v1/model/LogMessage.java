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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * Log message details.
 */
public class LogMessage extends DynamicModel {
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

  private Type levelType = new TypeToken<String>() {
  }.getType();
  private Type msgType = new TypeToken<String>() {
  }.getType();

  /**
   * Builder.
   */
  public static class Builder {
    private String level;
    private String msg;

    private Builder(LogMessage logMessage) {
      level = logMessage.level;
      msg = logMessage.msg;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

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
      LogMessage logMessage = new LogMessage();
      logMessage.put("level", this.level);
      logMessage.put("msg", this.msg);
      return logMessage;
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

  private LogMessage(Builder builder) {
    Validator.notNull(builder.level, "level cannot be null");
    Validator.notNull(builder.msg, "msg cannot be null");
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
   * @return the level
   */
  public String level() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("level"), levelType);
  }

  /**
   * Gets the msg.
   *
   * @return the msg
   */
  public String msg() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("msg"), msgType);
  }
}
