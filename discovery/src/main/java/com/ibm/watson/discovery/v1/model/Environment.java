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
package com.ibm.watson.discovery.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Details about an environment.
 */
public class Environment extends GenericModel {

  /**
   * Current status of the environment. `resizing` is displayed when a request to increase the environment size has been
   * made, but is still in the process of being completed.
   */
  public interface Status {
    /** active. */
    String ACTIVE = "active";
    /** pending. */
    String PENDING = "pending";
    /** maintenance. */
    String MAINTENANCE = "maintenance";
    /** resizing. */
    String RESIZING = "resizing";
  }

  /**
   * Current size of the environment.
   */
  public interface Size {
    /** LT. */
    String LT = "LT";
    /** XS. */
    String XS = "XS";
    /** S. */
    String S = "S";
    /** MS. */
    String MS = "MS";
    /** M. */
    String M = "M";
    /** ML. */
    String ML = "ML";
    /** L. */
    String L = "L";
    /** XL. */
    String XL = "XL";
    /** XXL. */
    String XXL = "XXL";
    /** XXXL. */
    String XXXL = "XXXL";
  }

  @SerializedName("environment_id")
  protected String environmentId;
  protected String name;
  protected String description;
  protected Date created;
  protected Date updated;
  protected String status;
  @SerializedName("read_only")
  protected Boolean readOnly;
  protected String size;
  @SerializedName("requested_size")
  protected String requestedSize;
  @SerializedName("index_capacity")
  protected IndexCapacity indexCapacity;
  @SerializedName("search_status")
  protected SearchStatus searchStatus;

  /**
   * Gets the environmentId.
   *
   * Unique identifier for the environment.
   *
   * @return the environmentId
   */
  public String getEnvironmentId() {
    return environmentId;
  }

  /**
   * Gets the name.
   *
   * Name that identifies the environment.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Description of the environment.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the created.
   *
   * Creation date of the environment, in the format `yyyy-MM-dd'T'HH:mm:ss.SSS'Z'`.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * Date of most recent environment update, in the format `yyyy-MM-dd'T'HH:mm:ss.SSS'Z'`.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the status.
   *
   * Current status of the environment. `resizing` is displayed when a request to increase the environment size has been
   * made, but is still in the process of being completed.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the readOnly.
   *
   * If `true`, the environment contains read-only collections that are maintained by IBM.
   *
   * @return the readOnly
   */
  public Boolean isReadOnly() {
    return readOnly;
  }

  /**
   * Gets the size.
   *
   * Current size of the environment.
   *
   * @return the size
   */
  public String getSize() {
    return size;
  }

  /**
   * Gets the requestedSize.
   *
   * The new size requested for this environment. Only returned when the environment *status* is `resizing`.
   *
   * *Note:* Querying and indexing can still be performed during an environment upsize.
   *
   * @return the requestedSize
   */
  public String getRequestedSize() {
    return requestedSize;
  }

  /**
   * Gets the indexCapacity.
   *
   * Details about the resource usage and capacity of the environment.
   *
   * @return the indexCapacity
   */
  public IndexCapacity getIndexCapacity() {
    return indexCapacity;
  }

  /**
   * Gets the searchStatus.
   *
   * Information about the Continuous Relevancy Training for this environment.
   *
   * @return the searchStatus
   */
  public SearchStatus getSearchStatus() {
    return searchStatus;
  }
}
