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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * CreateDialogNode.
 */
public class CreateDialogNode extends GenericModel {

  /** The dialog node ID. */
  @SerializedName("dialog_node")
  private String dialogNode;

  /**
   * Builder.
   */
  public static class Builder {
    private String dialogNode;

    private Builder(CreateDialogNode createDialogNode) {
      dialogNode = createDialogNode.dialogNode;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds the CreateDialogNode.
     *
     * @return the createDialogNode
     */
    public CreateDialogNode build() {
      return new CreateDialogNode(this);
    }

    /**
     * Set the dialogNode.
     *
     * @param dialogNode the dialogNode
     * @return a CreateDialogNode Builder
     */
    public Builder dialogNode(String dialogNode) {
      this.dialogNode = dialogNode;
      return this;
    }
  }

  private CreateDialogNode(Builder builder) {
    Validator.notNull(builder.dialogNode, "dialogNode cannot be null");
    dialogNode = builder.dialogNode;
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the dialogNode.
   *
   * @return the dialogNode
   */
  public String dialogNode() {
    return dialogNode;
  }
}
