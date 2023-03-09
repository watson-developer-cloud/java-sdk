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
package com.ibm.watson.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Information about custom smart document understanding fields that exist in this collection. */
public class SduStatusCustomFields extends GenericModel {

  protected Long defined;

  @SerializedName("maximum_allowed")
  protected Long maximumAllowed;

  protected SduStatusCustomFields() {}

  /**
   * Gets the defined.
   *
   * <p>The number of custom fields defined for this collection.
   *
   * @return the defined
   */
  public Long getDefined() {
    return defined;
  }

  /**
   * Gets the maximumAllowed.
   *
   * <p>The maximum number of custom fields that are allowed in this collection.
   *
   * @return the maximumAllowed
   */
  public Long getMaximumAllowed() {
    return maximumAllowed;
  }
}
