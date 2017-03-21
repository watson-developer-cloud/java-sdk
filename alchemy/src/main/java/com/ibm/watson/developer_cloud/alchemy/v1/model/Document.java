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
package com.ibm.watson.developer_cloud.alchemy.v1.model;

import java.util.Date;

import com.google.gson.annotations.JsonAdapter;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyDataNews;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.LongToDateTypeAdapter;

/**
 * Doc returned by the {@link AlchemyDataNews} service.
 *
 */
public class Document extends GenericModel {

  /** The id. */
  private String id;

  /** The source. */
  private Source source;

  /** The timestamp. */
  @JsonAdapter(LongToDateTypeAdapter.class)
  private Date timestamp;

  /**
   * Gets the id.
   *
   * @return The id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the source.
   *
   * @return The source
   */
  public Source getSource() {
    return source;
  }

  /**
   * Gets the timestamp.
   *
   * @return The timestamp
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the id.
   *
   * @param id The id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets the source.
   *
   * @param source The source
   */
  public void setSource(Source source) {
    this.source = source;
  }

  /**
   * Sets the timestamp.
   *
   * @param timestamp The timestamp
   */
  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

}
