/*
 * (C) Copyright IBM Corp. 2023.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;
import java.util.List;
import java.util.Map;

/** Classifications model. */
public class ClassificationsModel extends GenericModel {

  /** When the status is `available`, the model is ready to use. */
  public interface Status {
    /** starting. */
    String STARTING = "starting";
    /** training. */
    String TRAINING = "training";
    /** deploying. */
    String DEPLOYING = "deploying";
    /** available. */
    String AVAILABLE = "available";
    /** error. */
    String ERROR = "error";
    /** deleted. */
    String DELETED = "deleted";
  }

  protected String name;

  @SerializedName("user_metadata")
  protected Map<String, Object> userMetadata;

  protected String language;
  protected String description;

  @SerializedName("model_version")
  protected String modelVersion;

  @SerializedName("workspace_id")
  protected String workspaceId;

  @SerializedName("version_description")
  protected String versionDescription;

  protected List<String> features;
  protected String status;

  @SerializedName("model_id")
  protected String modelId;

  protected Date created;
  protected List<Notice> notices;

  @SerializedName("last_trained")
  protected Date lastTrained;

  @SerializedName("last_deployed")
  protected Date lastDeployed;

  protected ClassificationsModel() {}

  /**
   * Gets the name.
   *
   * <p>An optional name for the model.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the userMetadata.
   *
   * <p>An optional map of metadata key-value pairs to store with this model.
   *
   * @return the userMetadata
   */
  public Map<String, Object> getUserMetadata() {
    return userMetadata;
  }

  /**
   * Gets the language.
   *
   * <p>The 2-letter language code of this model.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the description.
   *
   * <p>An optional description of the model.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the modelVersion.
   *
   * <p>An optional version string.
   *
   * @return the modelVersion
   */
  public String getModelVersion() {
    return modelVersion;
  }

  /**
   * Gets the workspaceId.
   *
   * <p>ID of the Watson Knowledge Studio workspace that deployed this model to Natural Language
   * Understanding.
   *
   * @return the workspaceId
   */
  public String getWorkspaceId() {
    return workspaceId;
  }

  /**
   * Gets the versionDescription.
   *
   * <p>The description of the version.
   *
   * @return the versionDescription
   */
  public String getVersionDescription() {
    return versionDescription;
  }

  /**
   * Gets the features.
   *
   * <p>The service features that are supported by the custom model.
   *
   * @return the features
   */
  public List<String> getFeatures() {
    return features;
  }

  /**
   * Gets the status.
   *
   * <p>When the status is `available`, the model is ready to use.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the modelId.
   *
   * <p>Unique model ID.
   *
   * @return the modelId
   */
  public String getModelId() {
    return modelId;
  }

  /**
   * Gets the created.
   *
   * <p>dateTime indicating when the model was created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the notices.
   *
   * @return the notices
   */
  public List<Notice> getNotices() {
    return notices;
  }

  /**
   * Gets the lastTrained.
   *
   * <p>dateTime of last successful model training.
   *
   * @return the lastTrained
   */
  public Date getLastTrained() {
    return lastTrained;
  }

  /**
   * Gets the lastDeployed.
   *
   * <p>dateTime of last successful model deployment.
   *
   * @return the lastDeployed
   */
  public Date getLastDeployed() {
    return lastDeployed;
  }
}
