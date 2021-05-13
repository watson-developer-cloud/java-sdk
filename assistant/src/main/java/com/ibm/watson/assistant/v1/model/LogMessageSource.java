/*
 * (C) Copyright IBM Corp. 2021.
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
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** An object that identifies the dialog element that generated the error message. */
public class LogMessageSource extends GenericModel {

  /** A string that indicates the type of dialog element that generated the error message. */
  public interface Type {
    /** dialog_node. */
    String DIALOG_NODE = "dialog_node";
  }

  protected String type;

  @SerializedName("dialog_node")
  protected String dialogNode;

  /** Builder. */
  public static class Builder {
    private String type;
    private String dialogNode;

    private Builder(LogMessageSource logMessageSource) {
      this.type = logMessageSource.type;
      this.dialogNode = logMessageSource.dialogNode;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a LogMessageSource.
     *
     * @return the new LogMessageSource instance
     */
    public LogMessageSource build() {
      return new LogMessageSource(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the LogMessageSource builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the dialogNode.
     *
     * @param dialogNode the dialogNode
     * @return the LogMessageSource builder
     */
    public Builder dialogNode(String dialogNode) {
      this.dialogNode = dialogNode;
      return this;
    }
  }

  protected LogMessageSource(Builder builder) {
    type = builder.type;
    dialogNode = builder.dialogNode;
  }

  /**
   * New builder.
   *
   * @return a LogMessageSource builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * <p>A string that indicates the type of dialog element that generated the error message.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the dialogNode.
   *
   * <p>The unique identifier of the dialog node that generated the error message.
   *
   * @return the dialogNode
   */
  public String dialogNode() {
    return dialogNode;
  }
}
