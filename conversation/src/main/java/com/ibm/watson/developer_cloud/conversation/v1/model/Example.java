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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Example.
 */
public class Example extends GenericModel {

  @SerializedName("text")
  private String exampleText;
  private Date created;
  private Date updated;

  /**
   * Gets the exampleText.
   *
   * The text of the example.
   *
   * @return the exampleText
   */
  public String getExampleText() {
    return exampleText;
  }

  /**
   * Gets the created.
   *
   * The timestamp for creation of the example.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The timestamp for the last update to the example.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Sets the exampleText.
   *
   * @param exampleText the new exampleText
   */
  public void setExampleText(final String exampleText) {
    this.exampleText = exampleText;
  }
}
