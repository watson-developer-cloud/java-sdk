/*
 * (C) Copyright IBM Corp. 2022.
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

/** DialogNodeVisitedDetails. */
public class DialogNodeVisitedDetails extends GenericModel {

  @SerializedName("dialog_node")
  protected String dialogNode;

  protected String title;
  protected String conditions;

  /** Builder. */
  public static class Builder {
    private String dialogNode;
    private String title;
    private String conditions;

    private Builder(DialogNodeVisitedDetails dialogNodeVisitedDetails) {
      this.dialogNode = dialogNodeVisitedDetails.dialogNode;
      this.title = dialogNodeVisitedDetails.title;
      this.conditions = dialogNodeVisitedDetails.conditions;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a DialogNodeVisitedDetails.
     *
     * @return the new DialogNodeVisitedDetails instance
     */
    public DialogNodeVisitedDetails build() {
      return new DialogNodeVisitedDetails(this);
    }

    /**
     * Set the dialogNode.
     *
     * @param dialogNode the dialogNode
     * @return the DialogNodeVisitedDetails builder
     */
    public Builder dialogNode(String dialogNode) {
      this.dialogNode = dialogNode;
      return this;
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the DialogNodeVisitedDetails builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the conditions.
     *
     * @param conditions the conditions
     * @return the DialogNodeVisitedDetails builder
     */
    public Builder conditions(String conditions) {
      this.conditions = conditions;
      return this;
    }
  }

  protected DialogNodeVisitedDetails() {}

  protected DialogNodeVisitedDetails(Builder builder) {
    dialogNode = builder.dialogNode;
    title = builder.title;
    conditions = builder.conditions;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeVisitedDetails builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the dialogNode.
   *
   * <p>The unique ID of a dialog node that was triggered during processing of the input message.
   *
   * @return the dialogNode
   */
  public String dialogNode() {
    return dialogNode;
  }

  /**
   * Gets the title.
   *
   * <p>The title of the dialog node.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the conditions.
   *
   * <p>The conditions that trigger the dialog node.
   *
   * @return the conditions
   */
  public String conditions() {
    return conditions;
  }
}
