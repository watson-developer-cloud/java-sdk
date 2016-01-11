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
package com.ibm.watson.developer_cloud.concept_expansion.v1.model;

import com.ibm.watson.developer_cloud.concept_expansion.v1.ConceptExpansion;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Dataset used by the {@link ConceptExpansion} service.
 */
public class Dataset extends GenericModel {

  /** Medical Transcriptions dataset (value is "mtsamples"). */
  public static final Dataset MT_SAMPLES = new Dataset("Medical Transcriptions", "mtsamples");

  /** Twitter dataset (value is "twitter"). */
  public static final Dataset TWITTER = new Dataset("Twitter", "twitter");

  private final String id;
  private final String name;

  /**
   * Instantiates a new dataset.
   * 
   * @param name the name
   * @param id the id
   */
  public Dataset(String name, String id) {
    this.name = name;
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

  /**
   * Gets the name.
   * 
   * 
   * @return the name
   */
  public String getName() {
    return name;
  }

}
