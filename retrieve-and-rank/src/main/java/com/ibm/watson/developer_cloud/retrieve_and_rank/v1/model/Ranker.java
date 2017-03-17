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
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.RetrieveAndRank;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * {@link Ranker} class used by {@link RetrieveAndRank}.
 *
 * @version v1
 */
public class Ranker extends GenericModel {
  /**
   * Ranker Status.
   */
  public enum Status {

    /** available. */
    @SerializedName("Available") AVAILABLE,

    /** failed. */
    @SerializedName("Failed") FAILED,

    /** non existent. */
    @SerializedName("Non Existent") NON_EXISTENT,

    /** training. */
    @SerializedName("Training") TRAINING,

    /** unavailable. */
    @SerializedName("Unavailable") UNAVAILABLE
  }

  private Date created;

  @SerializedName("ranker_id")
  private String id;
  private String name;
  private Status status;
  @SerializedName("status_description")
  private String statusDescription;
  private String url;

  /**
   * Gets the created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the ranker id.
   *
   * @return the ranker id
   */
  public String getId() {
    return id;
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
   * Gets the status.
   *
   * @return the status
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Gets the status description.
   *
   * @return the status description
   */
  public String getStatusDescription() {
    return statusDescription;
  }

  /**
   * Gets the url.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets the date when the ranker was created.
   *
   * @param created the date to set
   */
  public void setCreated(Date created) {
    this.created = created;
  }

  /**
   * Sets the ranker id.
   *
   * @param id the new ranker id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets the name.
   *
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(Status status) {
    this.status = status;
  }

  /**
   * Sets the status description.
   *
   * @param statusDescription the new status description
   */
  public void setStatusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
  }

  /**
   * Sets the url.
   *
   * @param url the new url
   */
  public void setUrl(String url) {
    this.url = url;
  }
}
