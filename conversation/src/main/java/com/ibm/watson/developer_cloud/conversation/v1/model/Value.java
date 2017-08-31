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
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Value.
 */
public class Value extends GenericModel {

  @SerializedName("value")
  private String valueText;
  private Map metadata;
  private Date created;
  private Date updated;
  private List<String> patterns;

  /**
   * Gets the valueText.
   * <p>
   * The text of the entity value.
   *
   * @return the valueText
   */
  public String getValueText() {
    return valueText;
  }

  /**
   * Gets the metadata.
   * <p>
   * Any metadata related to the entity value.
   *
   * @return the metadata
   */
  public Map getMetadata() {
    return metadata;
  }

  /**
   * Gets the created.
   * <p>
   * The timestamp for creation of the entity value.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   * <p>
   * The timestamp for the last update to the entity value.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the patterns.
   * <p>
   * An array of patterns for the entity value. A pattern is specified as a regular expression.
   *
   * @return the patterns
   */
  public List<String> getPatterns() {
    return patterns;
  }

  /**
   * Sets the valueText.
   *
   * @param valueText the new valueText
   */
  public void setValueText(final String valueText) {
    this.valueText = valueText;
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
   * Sets the patterns.
   *
   * @param patterns the new patterns
   */
  public void setPatterns(final List<String> patterns) {
    this.patterns = patterns;
  }
}
