/**
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

package com.ibm.watson.developer_cloud.dialog.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class HitNode.
 */
public class HitNode extends GenericModel {
  private String details;
  private String label;

  /**
   * The node id.
   */
  @SerializedName("node_id")
  private Integer nodeId;

  /** The type. */
  private String type;

  /**
   * Gets the details.
   *
   * @return The details
   */
  public String getDetails() {
    return details;
  }

  /**
   * Gets the label.
   *
   * @return The label
   */
  public String getLabel() {
    return label;
  }

  /**
   * Gets the node id.
   *
   * @return The nodeId
   */
  public Integer getNodeId() {
    return nodeId;
  }

  /**
   * Gets the type.
   *
   * @return The type
   */
  public String getType() {
    return type;
  }

  /**
   * Sets the details.
   *
   * @param details The details
   */
  public void setDetails(final String details) {
    this.details = details;
  }

  /**
   * Sets the label.
   *
   * @param label The label
   */
  public void setLabel(final String label) {
    this.label = label;
  }

  /**
   * Sets the node id.
   *
   * @param nodeId The node_id
   */
  public void setNodeId(final Integer nodeId) {
    this.nodeId = nodeId;
  }

  /**
   * Sets the type.
   *
   * @param type The type
   */
  public void setType(final String type) {
    this.type = type;
  }
}
