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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * TestDocument.
 */
public class TestDocument extends GenericModel {

  @SerializedName("configuration_id")
  private String configurationId;
  private String status;
  @SerializedName("enriched_field_units")
  private Long enrichedFieldUnits;
  @SerializedName("original_media_type")
  private String originalMediaType;
  private List<DocumentSnapshot> snapshots;
  private List<Notice> notices;

  /**
   * Gets the configurationId.
   *
   * The unique identifier for the configuration.
   *
   * @return the configurationId
   */
  public String getConfigurationId() {
    return configurationId;
  }

  /**
   * Gets the status.
   *
   * Status of the preview operation.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the enrichedFieldUnits.
   *
   * The number of 10-kB chunks of field data that were enriched. This can be used to estimate the cost of running a
   * real ingestion.
   *
   * @return the enrichedFieldUnits
   */
  public Long getEnrichedFieldUnits() {
    return enrichedFieldUnits;
  }

  /**
   * Gets the originalMediaType.
   *
   * Format of the test document.
   *
   * @return the originalMediaType
   */
  public String getOriginalMediaType() {
    return originalMediaType;
  }

  /**
   * Gets the snapshots.
   *
   * An array of objects that describe each step in the preview process.
   *
   * @return the snapshots
   */
  public List<DocumentSnapshot> getSnapshots() {
    return snapshots;
  }

  /**
   * Gets the notices.
   *
   * An array of notice messages about the preview operation.
   *
   * @return the notices
   */
  public List<Notice> getNotices() {
    return notices;
  }

  /**
   * Sets the snapshots.
   *
   * @param snapshots the new snapshots
   */
  public void setSnapshots(final List<DocumentSnapshot> snapshots) {
    this.snapshots = snapshots;
  }

  /**
   * Sets the notices.
   *
   * @param notices the new notices
   */
  public void setNotices(final List<Notice> notices) {
    this.notices = notices;
  }
}
