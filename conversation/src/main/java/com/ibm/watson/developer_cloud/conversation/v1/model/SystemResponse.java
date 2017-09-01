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

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * For internal use only.
 */
public class SystemResponse extends GenericModel {

  @SerializedName("SystemResponseObject")
  private Map systemResponseObject;

  /**
   * Gets the systemResponseObject.
   *
   * @return the systemResponseObject
   */
  public Map getSystemResponseObject() {
    return systemResponseObject;
  }

  /**
   * Sets the systemResponseObject.
   *
   * @param systemResponseObject the new systemResponseObject
   */
  public void setSystemResponseObject(final Map systemResponseObject) {
    this.systemResponseObject = systemResponseObject;
  }
}
