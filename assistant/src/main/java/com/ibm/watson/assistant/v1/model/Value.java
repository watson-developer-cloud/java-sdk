/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.assistant.v1.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Value.
 */
public class Value extends GenericModel {

  /**
   * Specifies the type of value.
   */
  public interface ValueType {
    /** synonyms. */
    String SYNONYMS = "synonyms";
    /** patterns. */
    String PATTERNS = "patterns";
  }

  @SerializedName("value")
  private String valueText;
  private Map metadata;
  private Date created;
  private Date updated;
  private List<String> synonyms;
  private List<String> patterns;
  @SerializedName("type")
  private String valueType;

  /**
   * Gets the valueText.
   *
   * The text of the entity value.
   *
   * @return the valueText
   */
  public String getValueText() {
    return valueText;
  }

  /**
   * Gets the metadata.
   *
   * Any metadata related to the entity value.
   *
   * @return the metadata
   */
  public Map getMetadata() {
    return metadata;
  }

  /**
   * Gets the created.
   *
   * The timestamp for creation of the entity value.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The timestamp for the last update to the entity value.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the synonyms.
   *
   * An array containing any synonyms for the entity value.
   *
   * @return the synonyms
   */
  public List<String> getSynonyms() {
    return synonyms;
  }

  /**
   * Gets the patterns.
   *
   * An array containing any patterns for the entity value.
   *
   * @return the patterns
   */
  public List<String> getPatterns() {
    return patterns;
  }

  /**
   * Gets the valueType.
   *
   * Specifies the type of value.
   *
   * @return the valueType
   */
  public String getValueType() {
    return valueType;
  }
}
