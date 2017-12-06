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

import java.util.Date;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Workspace.
 */
public class Workspace extends GenericModel {

  private String name;
  private String language;
  private Date created;
  private Date updated;
  @SerializedName("workspace_id")
  private String workspaceId;
  private String description;
  private Map metadata;
  @SerializedName("learning_opt_out")
  private Boolean learningOptOut;

  /**
   * Gets the name.
   *
   * The name of the workspace.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the language.
   *
   * The language of the workspace.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the created.
   *
   * The timestamp for creation of the workspace.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The timestamp for the last update to the workspace.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the workspaceId.
   *
   * The workspace ID.
   *
   * @return the workspaceId
   */
  public String getWorkspaceId() {
    return workspaceId;
  }

  /**
   * Gets the description.
   *
   * The description of the workspace.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the metadata.
   *
   * Any metadata that is required by the workspace.
   *
   * @return the metadata
   */
  public Map getMetadata() {
    return metadata;
  }

  /**
   * Gets the learningOptOut.
   *
   * Whether training data from the workspace can be used by IBM for general service improvements. `true` indicates that
   * workspace training data is not to be used.
   *
   * @return the learningOptOut
   */
  public Boolean isLearningOptOut() {
    return learningOptOut;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the language.
   *
   * @param language the new language
   */
  public void setLanguage(final String language) {
    this.language = language;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Sets the metadata.
   *
   * @param metadata the new metadata
   */
  public void setMetadata(final Map metadata) {
    this.metadata = metadata;
  }

  /**
   * Sets the learningOptOut.
   *
   * @param learningOptOut the new learningOptOut
   */
  public void setLearningOptOut(final Boolean learningOptOut) {
    this.learningOptOut = learningOptOut;
  }
}
