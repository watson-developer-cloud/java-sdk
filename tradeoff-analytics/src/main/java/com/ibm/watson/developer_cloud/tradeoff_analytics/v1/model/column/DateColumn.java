/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
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

package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column;

import java.util.Date;

import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.TradeoffAnalytics;

/**
 * Date column. See {@link TradeoffAnalytics}
 */
public class DateColumn extends Column {

  /** The high. */
  private Date high;

  /** The range. */
  private Date low;

  /**
   * Instantiates a new date column.
   */
  public DateColumn() {
    super(ColumnType.DATETIME);
  }

  /**
   * Gets the high.
   *
   * @return the high
   */
  public Date getHigh() {
    return high;
  }

  /**
   * Gets the low.
   *
   * @return the low
   */
  public Date getLow() {
    return low;
  }

  /**
   * With range.
   *
   * @param low the low
   * @param high the high
   * @return the date column
   */
  public DateColumn withRange(Date low, Date high) {
    this.low = low;
    this.high = high;
    return this;
  }

}
