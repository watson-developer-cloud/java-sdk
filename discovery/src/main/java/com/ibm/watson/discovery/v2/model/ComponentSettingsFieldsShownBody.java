/*
 * (C) Copyright IBM Corp. 2019, 2024.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Body label. */
public class ComponentSettingsFieldsShownBody extends GenericModel {

  @SerializedName("use_passage")
  protected Boolean usePassage;

  protected String field;

  protected ComponentSettingsFieldsShownBody() {}

  /**
   * Gets the usePassage.
   *
   * <p>Use the whole passage as the body.
   *
   * @return the usePassage
   */
  public Boolean isUsePassage() {
    return usePassage;
  }

  /**
   * Gets the field.
   *
   * <p>Use a specific field as the title.
   *
   * @return the field
   */
  public String getField() {
    return field;
  }
}
