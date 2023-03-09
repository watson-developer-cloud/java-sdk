/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The numeric location of the identified element in the document, represented with two integers
 * labeled `begin` and `end`.
 */
public class TableElementLocation extends GenericModel {

  protected Long begin;
  protected Long end;

  protected TableElementLocation() {}

  /**
   * Gets the begin.
   *
   * <p>The element's `begin` index.
   *
   * @return the begin
   */
  public Long getBegin() {
    return begin;
  }

  /**
   * Gets the end.
   *
   * <p>The element's `end` index.
   *
   * @return the end
   */
  public Long getEnd() {
    return end;
  }
}
