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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Map;

/** The updateDialogNodeNullable options. */
public class UpdateDialogNodeNullableOptions extends GenericModel {

  protected String workspaceId;
  protected String dialogNode;
  protected Map<String, Object> body;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String dialogNode;
    private Map<String, Object> body;
    private Boolean includeAudit;

    private Builder(UpdateDialogNodeNullableOptions updateDialogNodeNullableOptions) {
      this.workspaceId = updateDialogNodeNullableOptions.workspaceId;
      this.dialogNode = updateDialogNodeNullableOptions.dialogNode;
      this.body = updateDialogNodeNullableOptions.body;
      this.includeAudit = updateDialogNodeNullableOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     * @param dialogNode the dialogNode
     * @param body the body
     */
    public Builder(String workspaceId, String dialogNode, Map<String, Object> body) {
      this.workspaceId = workspaceId;
      this.dialogNode = dialogNode;
      this.body = body;
    }

    /**
     * Builds a UpdateDialogNodeNullableOptions.
     *
     * @return the new UpdateDialogNodeNullableOptions instance
     */
    public UpdateDialogNodeNullableOptions build() {
      return new UpdateDialogNodeNullableOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the UpdateDialogNodeNullableOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the dialogNode.
     *
     * @param dialogNode the dialogNode
     * @return the UpdateDialogNodeNullableOptions builder
     */
    public Builder dialogNode(String dialogNode) {
      this.dialogNode = dialogNode;
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the UpdateDialogNodeNullableOptions builder
     */
    public Builder body(Map<String, Object> body) {
      this.body = body;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the UpdateDialogNodeNullableOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected UpdateDialogNodeNullableOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
            builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
            builder.dialogNode, "dialogNode cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.body, "body cannot be null");
    workspaceId = builder.workspaceId;
    dialogNode = builder.dialogNode;
    body = builder.body;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a UpdateDialogNodeNullableOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the workspaceId.
   *
   * <p>Unique identifier of the workspace.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the dialogNode.
   *
   * <p>The dialog node ID (for example, `node_1_1479323581900`).
   *
   * @return the dialogNode
   */
  public String dialogNode() {
    return dialogNode;
  }

  /**
   * Gets the body.
   *
   * <p>The updated content of the dialog node.
   *
   * <p>Any elements included in the new data will completely replace the equivalent existing
   * elements, including all subelements. (Previously existing subelements are not retained unless
   * they are also included in the new data.) For example, if you update the actions for a dialog
   * node, the previously existing actions are discarded and replaced with the new actions specified
   * in the update.
   *
   * @return the body
   */
  public Map<String, Object> body() {
    return body;
  }

  /**
   * Gets the includeAudit.
   *
   * <p>Whether to include the audit properties (`created` and `updated` timestamps) in the
   * response.
   *
   * @return the includeAudit
   */
  public Boolean includeAudit() {
    return includeAudit;
  }
}

