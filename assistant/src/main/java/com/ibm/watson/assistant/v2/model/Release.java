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
package com.ibm.watson.assistant.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;
import java.util.List;

/** Release. */
public class Release extends GenericModel {

  /**
   * The current status of the release: - **Available**: The release is available for deployment. -
   * **Failed**: An asynchronous publish operation has failed. - **Processing**: An asynchronous
   * publish operation has not yet completed.
   */
  public interface Status {
    /** Available. */
    String AVAILABLE = "Available";
    /** Failed. */
    String FAILED = "Failed";
    /** Processing. */
    String PROCESSING = "Processing";
  }

  protected String release;
  protected String description;

  @SerializedName("environment_references")
  protected List<EnvironmentReference> environmentReferences;

  protected ReleaseContent content;
  protected String status;
  protected Date created;
  protected Date updated;

  /**
   * Gets the release.
   *
   * <p>The name of the release. The name is the version number (an integer), returned as a string.
   *
   * @return the release
   */
  public String getRelease() {
    return release;
  }

  /**
   * Gets the description.
   *
   * <p>The description of the release.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the environmentReferences.
   *
   * <p>An array of objects describing the environments where this release has been deployed.
   *
   * @return the environmentReferences
   */
  public List<EnvironmentReference> getEnvironmentReferences() {
    return environmentReferences;
  }

  /**
   * Gets the content.
   *
   * <p>An object describing the versionable content objects (such as skill snapshots) that are
   * included in the release.
   *
   * @return the content
   */
  public ReleaseContent getContent() {
    return content;
  }

  /**
   * Gets the status.
   *
   * <p>The current status of the release: - **Available**: The release is available for deployment.
   * - **Failed**: An asynchronous publish operation has failed. - **Processing**: An asynchronous
   * publish operation has not yet completed.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the created.
   *
   * <p>The timestamp for creation of the object.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * <p>The timestamp for the most recent update to the object.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }
}
