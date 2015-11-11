/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column;

/**
 * Numeric column.
 * 
 */
public class NumericColumn extends Column {

  /** The high. */
  private Double high;

  /** The low. */
  private Double low;

  /**
   * Instantiates a new date column.
   */
  public NumericColumn() {
    super(ColumnType.NUMERIC);
  }

  /**
   * Gets the high.
   * 
   * @return the high
   */
  public Double getHigh() {
    return high;
  }

  /**
   * Gets the low.
   * 
   * @return the low
   */
  public Double getLow() {
    return low;
  }

  /**
   * With numeric range.
   * 
   * @param low the low
   * @param high the high
   * @return the numeric column
   */
  public NumericColumn withRange(Double low, Double high) {
    this.low = low;
    this.high = high;
    return this;
  }

  /**
   * With numeric range.
   * 
   * @param low the low
   * @param high the high
   * @return the numeric column
   */
  public NumericColumn withRange(Integer low, Integer high) {
    this.low = (double) low;
    this.high = (double) high;
    return this;
  }

}
