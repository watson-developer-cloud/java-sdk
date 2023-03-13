/*
 * (C) Copyright IBM Corp. 2019, 2023.
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
 * An array of values, each being the `id` value of a column header that is applicable to the
 * current cell.
 */
public class TableColumnHeaderIds extends GenericModel {

  protected String id;

  protected TableColumnHeaderIds() {}

  /**
   * Gets the id.
   *
   * <p>The `id` value of a column header.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }
}
