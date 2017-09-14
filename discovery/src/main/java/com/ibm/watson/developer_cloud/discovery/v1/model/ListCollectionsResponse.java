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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * ListCollectionsResponse.
 */
public class ListCollectionsResponse extends GenericModel {

  private List<Collection> collections;

  /**
   * Gets the collections.
   *
   * An array containing information about each collection in the environment.
   *
   * @return the collections
   */
  public List<Collection> getCollections() {
    return collections;
  }

  /**
   * Sets the collections.
   *
   * @param collections the new collections
   */
  public void setCollections(final List<Collection> collections) {
    this.collections = collections;
  }
}
