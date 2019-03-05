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
package com.ibm.watson.developer_cloud.assistant.v1.model;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Example.
 */
public class Example extends GenericModel {

  @SerializedName("text")
  private String exampleText;
  private Date created;
  private Date updated;
  private List<Mentions> mentions;

  /**
   * Gets the exampleText.
   *
   * The text of the user input example.
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
   * Gets the mentions.
   *
   * An array of contextual entity mentions.
   *
   * @return the mentions
   */
  public List<Mentions> getMentions() {
    return mentions;
  }
}
