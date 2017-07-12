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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Synonym.
 */
public class Synonym extends GenericModel {

  private String synonym;
  private Date created;
  private Date updated;

  /**
   * Gets the synonym.
   *
   * The text of the synonym.
   *
   * @return the synonym
   */
  public String getSynonym() {
    return synonym;
  }

  /**
   * Gets the created.
   *
   * The timestamp for creation of the synonym.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The timestamp for the most recent update to the synonym.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Sets the synonym.
   *
   * @param synonym the new synonym
   */
  public void setSynonym(final String synonym) {
    this.synonym = synonym;
  }
}
