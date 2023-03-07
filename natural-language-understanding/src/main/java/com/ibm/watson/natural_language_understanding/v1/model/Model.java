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

/** Model. */
public class Model extends GenericModel {

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

  protected String status;

  @SerializedName("model_id")
  protected String modelId;

  protected String language;
  protected String description;

  @SerializedName("workspace_id")
  protected String workspaceId;

  @SerializedName("model_version")
  protected String modelVersion;

  protected String version;

  @SerializedName("version_description")
  protected String versionDescription;

  protected Date created;

  protected Model() {}

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
   * Gets the language.
   *
   * <p>ISO 639-1 code that indicates the language of the model.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the description.
   *
   * <p>Model description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
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
   * Gets the modelVersion.
   *
   * <p>The model version, if it was manually provided in Watson Knowledge Studio.
   *
   * @return the modelVersion
   */
  public String getModelVersion() {
    return modelVersion;
  }

  /**
   * Gets the version.
   *
   * <p>Deprecated — use `model_version`.
   *
   * @return the version
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public String getVersion() {
    return version;
  }

  /**
   * Gets the versionDescription.
   *
   * <p>The description of the version, if it was manually provided in Watson Knowledge Studio.
   *
   * @return the versionDescription
   */
  public String getVersionDescription() {
    return versionDescription;
  }

  /**
   * Gets the created.
   *
   * <p>A dateTime indicating when the model was created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }
}
