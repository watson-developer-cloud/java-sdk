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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The next step to execute following this dialog node.
 */
public class DialogNodeNextStep extends GenericModel {

  /**
   * How the `next_step` reference is processed.
   */
  public interface Behavior {
    /** jump_to. */
    String JUMP_TO = "jump_to";
  }

  /**
   * Which part of the dialog node to process next.
   */
  public interface Selector {
    /** condition. */
    String CONDITION = "condition";
    /** client. */
    String CLIENT = "client";
    /** user_input. */
    String USER_INPUT = "user_input";
    /** body. */
    String BODY = "body";
  }

  private String behavior;
  @SerializedName("dialog_node")
  private String dialogNode;
  private String selector;

  /**
   * Builder.
   */
  public static class Builder {
    private String behavior;
    private String dialogNode;
    private String selector;

    private Builder(DialogNodeNextStep dialogNodeNextStep) {
      behavior = dialogNodeNextStep.behavior;
      dialogNode = dialogNodeNextStep.dialogNode;
      selector = dialogNodeNextStep.selector;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param behavior the behavior
     */
    public Builder(String behavior) {
      this.behavior = behavior;
    }

    /**
     * Builds a DialogNodeNextStep.
     *
     * @return the dialogNodeNextStep
     */
    public DialogNodeNextStep build() {
      return new DialogNodeNextStep(this);
    }

    /**
     * Set the behavior.
     *
     * @param behavior the behavior
     * @return the DialogNodeNextStep builder
     */
    public Builder behavior(String behavior) {
      this.behavior = behavior;
      return this;
    }

    /**
     * Set the dialogNode.
     *
     * @param dialogNode the dialogNode
     * @return the DialogNodeNextStep builder
     */
    public Builder dialogNode(String dialogNode) {
      this.dialogNode = dialogNode;
      return this;
    }

    /**
     * Set the selector.
     *
     * @param selector the selector
     * @return the DialogNodeNextStep builder
     */
    public Builder selector(String selector) {
      this.selector = selector;
      return this;
    }
  }

  private DialogNodeNextStep(Builder builder) {
    Validator.notNull(builder.behavior, "behavior cannot be null");
    behavior = builder.behavior;
    dialogNode = builder.dialogNode;
    selector = builder.selector;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeNextStep builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the behavior.
   *
   * How the `next_step` reference is processed.
   *
   * @return the behavior
   */
  public String behavior() {
    return behavior;
  }

  /**
   * Gets the dialogNode.
   *
   * The ID of the dialog node to process next.
   *
   * @return the dialogNode
   */
  public String dialogNode() {
    return dialogNode;
  }

  /**
   * Gets the selector.
   *
   * Which part of the dialog node to process next.
   *
   * @return the selector
   */
  public String selector() {
    return selector;
  }
}
