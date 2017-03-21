/**
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
package com.ibm.watson.developer_cloud.dialog.v1.model;

import com.ibm.watson.developer_cloud.dialog.v1.DialogService;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Name value class used by the {@link DialogService}.
 *
 */
public class NameValue extends GenericModel {
  private String name;
  private String value;


  /**
   * Instantiates a new name value.
   *
   * @param name the name
   * @param value the value
   */
  public NameValue(String name, String value) {
    super();
    this.name = name;
    this.value = value;
  }

  /**
   * Gets the name.
   *
   * @return The name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the value.
   *
   * @return The value
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets the name.
   *
   * @param name The name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the value.
   *
   * @param value The value
   */
  public void setValue(final String value) {
    this.value = value;
  }

  /**
   * Sets the name.
   *
   * @param name the name
   * @return the name value
   */
  public NameValue name(final String name) {
    this.name = name;
    return this;
  }

  /**
   * Sets the value.
   *
   * @param value the value
   * @return the name value
   */
  public NameValue value(final String value) {
    this.value = value;
    return this;
  }
}
