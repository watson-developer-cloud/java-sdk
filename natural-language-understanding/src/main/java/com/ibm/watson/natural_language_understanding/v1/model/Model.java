/*
 * (C) Copyright IBM Corp. 2017, 2020.
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
package com.ibm.watson.natural_language_understanding.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Model.
 */
public class Model extends GenericModel {

  protected String status;
  @SerializedName("model_id")
  protected String modelId;
  protected String language;
  protected String description;
  @SerializedName("workspace_id")
  protected String workspaceId;
  protected String version;
  @SerializedName("version_description")
  protected String versionDescription;
  protected Date created;

  /**
   * Gets the status.
   *
   * When the status is `available`, the model is ready to use.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the modelId.
   *
   * Unique model ID.
   *
   * @return the modelId
   */
  public String getModelId() {
    return modelId;
  }

  /**
   * Gets the language.
   *
   * ISO 639-1 code indicating the language of the model.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the description.
   *
   * Model description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the workspaceId.
   *
   * ID of the Watson Knowledge Studio workspace that deployed this model to Natural Language Understanding.
   *
   * @return the workspaceId
   */
  public String getWorkspaceId() {
    return workspaceId;
  }

  /**
   * Gets the version.
   *
   * The model version, if it was manually provided in Watson Knowledge Studio.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the versionDescription.
   *
   * The description of the version, if it was manually provided in Watson Knowledge Studio.
   *
   * @return the versionDescription
   */
  public String getVersionDescription() {
    return versionDescription;
  }

  /**
   * Gets the created.
   *
   * A dateTime indicating when the model was created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }
}
