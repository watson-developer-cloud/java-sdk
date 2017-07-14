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
 * Intent.
 */
public class Intent extends GenericModel {

  private String intent;
  private Date created;
  private Date updated;
  private String description;

  /**
   * Gets the intent.
   *
   * The name of the intent.
   *
   * @return the intent
   */
  public String getIntent() {
    return intent;
  }

  /**
   * Gets the created.
   *
   * The timestamp for creation of the intent.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The timestamp for the last update to the intent.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the description.
   *
   * The description of the intent.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the intent.
   *
   * @param intent the new intent
   */
  public void setIntent(final String intent) {
    this.intent = intent;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(final String description) {
    this.description = description;
  }
}
