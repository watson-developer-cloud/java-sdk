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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Details about an environment.
 */
public class Environment extends GenericModel {

  /**
   * Status of the environment.
   */
  public interface Status {
    /** active. */
    String ACTIVE = "active";
    /** pending. */
    String PENDING = "pending";
  }

  /** Unique identifier for this environment. */
  @SerializedName("environment_id")
  private String environmentId;
  /** Name that identifies this environment. */
  private String name;
  /** Description of the environment. */
  private String description;
  /** Creation date of the environment, in the format yyyy-MM-dd'T'HH:mm:ss.SSS'Z'. */
  private Date created;
  /** Date of most recent environment update, in the format yyyy-MM-dd'T'HH:mm:ss.SSS'Z'. */
  private Date updated;
  /** Status of the environment. */
  private String status;
  /** If true, then the environment contains read-only collections which are maintained by IBM. */
  @SerializedName("read_only")
  private Boolean readOnly;
  /** Size of the environment. */
  private Long size;
  /** Object containing information about disk and memory usage. */
  @SerializedName("index_capacity")
  private IndexCapacity indexCapacity;

  /**
   * Gets the environmentId.
   *
   * @return the environmentId
   */
  public String getEnvironmentId() {
    return environmentId;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the readOnly.
   *
   * @return the readOnly
   */
  public Boolean isReadOnly() {
    return readOnly;
  }

  /**
   * Gets the size.
   *
   * @return the size
   */
  public Long getSize() {
    return size;
  }

  /**
   * Gets the indexCapacity.
   *
   * @return the indexCapacity
   */
  public IndexCapacity getIndexCapacity() {
    return indexCapacity;
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
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Sets the size.
   *
   * @param size the new size
   */
  public void setSize(final Long size) {
    this.size = size;
  }

  /**
   * Sets the indexCapacity.
   *
   * @param indexCapacity the new indexCapacity
   */
  public void setIndexCapacity(final IndexCapacity indexCapacity) {
    this.indexCapacity = indexCapacity;
  }
}
