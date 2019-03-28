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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Intent.
 */
public class Intent extends GenericModel {

  private String intent;
  private String description;
  private Date created;
  private Date updated;
  private List<Example> examples;

  /**
   * Gets the intent.
   *
   * The name of the intent. This string must conform to the following restrictions:
   * - It can contain only Unicode alphanumeric, underscore, hyphen, and dot characters.
   * - It cannot begin with the reserved prefix `sys-`.
   * - It must be no longer than 128 characters.
   *
   * @return the intent
   */
  public String getIntent() {
    return intent;
  }

  /**
   * Gets the description.
   *
   * The description of the intent. This string cannot contain carriage return, newline, or tab characters, and it must
   * be no longer than 128 characters.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the created.
   *
   * The timestamp for creation of the object.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The timestamp for the most recent update to the object.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the examples.
   *
   * An array of user input examples for the intent.
   *
   * @return the examples
   */
  public List<Example> getExamples() {
    return examples;
  }
}
