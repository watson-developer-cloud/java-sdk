/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.relationship_extraction.v1.model;

import javax.management.relation.RelationException;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Dataset to be use in the {@link RelationException} service.
 */
public class Dataset extends GenericModel {

  /**
   * Field ENGLISH_NEWS.
   */
  public static final Dataset ENGLISH_NEWS = new Dataset("ie-en-news");
  /**
   * Field SPANISH_NEWS.
   */
  public static final Dataset SPANISH_NEWS = new Dataset("ie-es-news");


  private final String id;

  /**
   * Instantiates a new dataset.
   * 
   * @param id the id
   */
  public Dataset(String id) {
    this.id = id;
  }

  /**
   * Gets the id.
   * 
   * 
   * @return the id
   */
  public String getId() {
    return id;
  }
}
