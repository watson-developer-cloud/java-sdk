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
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * IntentExportResponse.
 */
public class IntentExportResponse extends GenericModel {

  /** The name of the intent. */
  private String intent;
  /** The description of the intent. */
  private String description;
  /** The timestamp for creation of the intent. */
  private Date created;
  /** The timestamp for the last update to the intent. */
  private Date updated;
  /** An array of Examples collection. */
  private List<ExampleResponse> examples;

  /**
   * Gets the intent.
   *
   * @return the intent
   */
  public String getIntent() {
    return intent;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the examples.
   *
   * @return the examples
   */
  public List<ExampleResponse> getExamples() {
    return examples;
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

  /**
   * Sets the created.
   *
   * @param created the new created
   */
  public void setCreated(final Date created) {
    this.created = created;
  }

  /**
   * Sets the updated.
   *
   * @param updated the new updated
   */
  public void setUpdated(final Date updated) {
    this.updated = updated;
  }

  /**
   * Sets the examples.
   *
   * @param examples the new examples
   */
  public void setExamples(final List<ExampleResponse> examples) {
    this.examples = examples;
  }
}
