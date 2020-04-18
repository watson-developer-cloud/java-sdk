/*
 * (C) Copyright IBM Corp. 2019, 2020.
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

/** A contact. */
public class Contact extends GenericModel {

  protected String name;
  protected String role;

  /**
   * Gets the name.
   *
   * <p>A string listing the name of the contact.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the role.
   *
   * <p>A string listing the role of the contact.
   *
   * @return the role
   */
  public String getRole() {
    return role;
  }
}
