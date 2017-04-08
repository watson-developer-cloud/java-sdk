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

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * ValueExportResponse.
 */
public class ValueExportResponse extends GenericModel {

  /** The name of the corresponding entity. */
  private String value;
  /** Any metadata related to the entity value. */
  private Object metadata;
  /** The timestamp for creation of the entity value. */
  private String created;
  /** The timestamp for the last update to the entity value. */
  private String updated;
  /** An array of synonyms. */
  private List<String> synonyms;

  /**
   * Gets the value.
   *
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public Object getMetadata() {
    return metadata;
  }

  /**
   * Gets the created.
   *
   * @return the created
   */
  public String getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * @return the updated
   */
  public String getUpdated() {
    return updated;
  }

  /**
   * Gets the synonyms.
   *
   * @return the synonyms
   */
  public List<String> getSynonyms() {
    return synonyms;
  }

  /**
   * Sets the value.
   *
   * @param value the new value
   */
  public void setValue(final String value) {
    this.value = value;
  }

  /**
   * Sets the metadata.
   *
   * @param metadata the new metadata
   */
  public void setMetadata(final Object metadata) {
    this.metadata = metadata;
  }

  /**
   * Sets the created.
   *
   * @param created the new created
   */
  public void setCreated(final String created) {
    this.created = created;
  }

  /**
   * Sets the updated.
   *
   * @param updated the new updated
   */
  public void setUpdated(final String updated) {
    this.updated = updated;
  }

  /**
   * Sets the synonyms.
   *
   * @param synonyms the new synonyms
   */
  public void setSynonyms(final List<String> synonyms) {
    this.synonyms = synonyms;
  }
}
