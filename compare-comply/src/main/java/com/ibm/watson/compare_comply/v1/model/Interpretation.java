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
package com.ibm.watson.compare_comply.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The details of the normalized text, if applicable. This element is optional; that is, the service output lists it
 * only if normalized text exists.
 */
public class Interpretation extends GenericModel {

  private String value;
  @SerializedName("numeric_value")
  private Double numericValue;
  private String unit;

  /**
   * Gets the value.
   *
   * The value that was located in the normalized text.
   *
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * Gets the numericValue.
   *
   * An integer or float expressing the numeric value of the `value` key.
   *
   * @return the numericValue
   */
  public Double getNumericValue() {
    return numericValue;
  }

  /**
   * Gets the unit.
   *
   * A string listing the unit of the value that was found in the normalized text.
   *
   * **Note:** The value of `unit` is the [ISO-4217 currency code](https://www.iso.org/iso-4217-currency-codes.html)
   * identified for the currency amount (for example, `USD` or `EUR`). If the service cannot disambiguate a currency
   * symbol (for example, `$` or `£`), the value of `unit` contains the ambiguous symbol as-is.
   *
   * @return the unit
   */
  public String getUnit() {
    return unit;
  }
}
