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
  /**
   * The number of 10 Kilobytes of field data that was enriched. This can be used to estimate the cost of running a real
   * ingestion.
   */
  @SerializedName("enriched_field_units")
  private Double enrichedFieldUnits;
  /** Format of the test document. */
  @SerializedName("original_media_type")
  private String originalMediaType;
  private List<DocumentSnapshot> snapshots;
  private List<Notice> notices;

  /**
   * Gets the configurationId.
   *
   * @return the configurationId
   */
  public String getConfigurationId() {
    return configurationId;
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
   * Gets the enrichedFieldUnits.
   *
   * @return the enrichedFieldUnits
   */
  public Double getEnrichedFieldUnits() {
    return enrichedFieldUnits;
  }

  /**
   * Gets the originalMediaType.
   *
   * @return the originalMediaType
   */
  public String getOriginalMediaType() {
    return originalMediaType;
  }

  /**
   * Gets the snapshots.
   *
   * @return the snapshots
   */
  public List<DocumentSnapshot> getSnapshots() {
    return snapshots;
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
   * Sets the configurationId.
   *
   * @param configurationId the new configurationId
   */
  public void setConfigurationId(final String configurationId) {
    this.configurationId = configurationId;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(final String status) {
    this.status = status;
  }

  /**
   * Sets the enrichedFieldUnits.
   *
   * @param enrichedFieldUnits the new enrichedFieldUnits
   */
  public void setEnrichedFieldUnits(final Double enrichedFieldUnits) {
    this.enrichedFieldUnits = enrichedFieldUnits;
  }

  /**
   * Sets the originalMediaType.
   *
   * @param originalMediaType the new originalMediaType
   */
  public void setOriginalMediaType(final String originalMediaType) {
    this.originalMediaType = originalMediaType;
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
