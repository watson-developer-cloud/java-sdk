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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * A text string that appears within the entity text field.
 */
public class QueryEntitiesEntity extends GenericModel {

  private String text;
  private String type;

  /**
   * Gets the text.
   *
   * Entity text content.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the type.
   *
   * The type of the specified entity.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(final String text) {
    this.text = text;
  }

  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(final String type) {
    this.type = type;
  }
}
