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

import java.util.List;

import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.TradeoffAnalytics;

/**
 * The Class Column. See {@link TradeoffAnalytics}
 */
public class CategoricalColumn extends Column {

  /** The preference. */
  private List<String> preference;

  /** The range. */
  private List<String> range;

  /**
   * Instantiates a new categorical column.
   */
  public CategoricalColumn() {
    super(ColumnType.CATEGORICAL);
  }

  /**
   * Gets the preference.
   *
   * @return the preference
   */
  public List<String> getPreference() {
    return preference;
  }

  /**
   * Gets the range.
   *
   * @return the range
   */
  public List<String> getRange() {
    return range;
  }

  /**
   * Sets the range.
   *
   * @param range the range
   * @return the categorical column
   */
  public CategoricalColumn range(List<String> range) {
    setRange(range);
    return this;
  }

  /**
   * Sets the preference.
   *
   * @param preference the preference to set
   */
  public void setPreference(List<String> preference) {
    this.preference = preference;
  }

  /**
   * Sets the range.
   *
   * @param range the new range
   */
  public void setRange(List<String> range) {
    this.range = range;
  }

}
