/*
 * (C) Copyright IBM Corp. 2019.
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
package com.ibm.watson.compare_comply.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The analysis of the document's tables.
 */
public class TableReturn extends GenericModel {

  private DocInfo document;
  @SerializedName("model_id")
  private String modelId;
  @SerializedName("model_version")
  private String modelVersion;
  private List<Tables> tables;

  /**
   * Gets the document.
   *
   * Information about the parsed input document.
   *
   * @return the document
   */
  public DocInfo getDocument() {
    return document;
  }

  /**
   * Gets the modelId.
   *
   * The ID of the model used to extract the table contents. The value for table extraction is `tables`.
   *
   * @return the modelId
   */
  public String getModelId() {
    return modelId;
  }

  /**
   * Gets the modelVersion.
   *
   * The version of the `tables` model ID.
   *
   * @return the modelVersion
   */
  public String getModelVersion() {
    return modelVersion;
  }

  /**
   * Gets the tables.
   *
   * Definitions of the tables identified in the input document.
   *
   * @return the tables
   */
  public List<Tables> getTables() {
    return tables;
  }
}
