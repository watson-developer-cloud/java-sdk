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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Disambiguation information for the entity.
 */
public class DisambiguationResult extends GenericModel {

  private String name;
  @SerializedName("dbpedia_resource")
  private String dbpediaResource;
  private List<String> subtype;

  /**
   * Gets the name.
   *
   * Common entity name
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the dbpediaResource.
   *
   * Link to the corresponding DBpedia resource
   *
   * @return the dbpediaResource
   */
  public String getDbpediaResource() {
    return dbpediaResource;
  }

  /**
   * Gets the subtype.
   *
   * Entity subtype information
   *
   * @return the subtype
   */
  public List<String> getSubtype() {
    return subtype;
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
   * Sets the dbpediaResource.
   *
   * @param dbpediaResource the new dbpediaResource
   */
  public void setDbpediaResource(final String dbpediaResource) {
    this.dbpediaResource = dbpediaResource;
  }

  /**
   * Sets the subtype.
   *
   * @param subtype the new subtype
   */
  public void setSubtype(final List<String> subtype) {
    this.subtype = subtype;
  }
}
