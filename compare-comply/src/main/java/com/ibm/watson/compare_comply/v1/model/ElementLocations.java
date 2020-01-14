/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.compare_comply.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A list of `begin` and `end` indexes that indicate the locations of the elements in the input document.
 */
public class ElementLocations extends GenericModel {

  protected Long begin;
  protected Long end;

  /**
   * Gets the begin.
   *
   * An integer that indicates the starting position of the element in the input document.
   *
   * @return the begin
   */
  public Long getBegin() {
    return begin;
  }

  /**
   * Gets the end.
   *
   * An integer that indicates the ending position of the element in the input document.
   *
   * @return the end
   */
  public Long getEnd() {
    return end;
  }
}
