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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

import java.util.List;



/**
 * CaptureGroup.
 */
public class CaptureGroup extends GenericModel {

  private String group;
  private List<Long> location;

  /**
   * Gets the group.
   *
   * A recognized capture group for the entity.
   *
   * @return the group
   */
  public String getGroup() {
    return group;
  }

  /**
   * Gets the location.
   *
   * Zero-based character offsets that indicate where the entity value begins and ends in the input text.
   *
   * @return the location
   */
  public List<Long> getLocation() {
    return location;
  }

  /**
   * Sets the group.
   *
   * @param group the new group
   */
  public void setGroup(final String group) {
    this.group = group;
  }

  /**
   * Sets the location.
   *
   * @param location the new location
   */
  public void setLocation(final List<Long> location) {
    this.location = location;
  }
}
