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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * If you provide customization input, the normalized version of the row header texts according to
 * the customization; otherwise, the same value as `row_header_texts`.
 */
public class TableRowHeaderTextsNormalized extends GenericModel {

  @SerializedName("text_normalized")
  protected String textNormalized;

  protected TableRowHeaderTextsNormalized() {}

  /**
   * Gets the textNormalized.
   *
   * <p>The normalized version of a row header text.
   *
   * @return the textNormalized
   */
  public String getTextNormalized() {
    return textNormalized;
  }
}
