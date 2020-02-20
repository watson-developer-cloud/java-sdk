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
package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Fields shown in the results section of the UI.
 */
public class ComponentSettingsFieldsShown extends GenericModel {

  protected ComponentSettingsFieldsShownBody body;
  protected ComponentSettingsFieldsShownTitle title;

  /**
   * Gets the body.
   *
   * Body label.
   *
   * @return the body
   */
  public ComponentSettingsFieldsShownBody getBody() {
    return body;
  }

  /**
   * Gets the title.
   *
   * Title label.
   *
   * @return the title
   */
  public ComponentSettingsFieldsShownTitle getTitle() {
    return title;
  }
}
