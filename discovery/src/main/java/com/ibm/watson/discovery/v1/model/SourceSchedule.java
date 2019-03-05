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
package com.ibm.watson.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object containing the schedule information for the source.
 */
public class SourceSchedule extends GenericModel {

  /**
   * The crawl schedule in the specified **time_zone**.
   *
   * - `daily`: Runs every day between 00:00 and 06:00.
   * - `weekly`: Runs every week on Sunday between 00:00 and 06:00.
   * - `monthly`: Runs the on the first Sunday of every month between 00:00 and 06:00.
   */
  public interface Frequency {
    /** daily. */
    String DAILY = "daily";
    /** weekly. */
    String WEEKLY = "weekly";
    /** monthly. */
    String MONTHLY = "monthly";
  }

  private Boolean enabled;
  @SerializedName("time_zone")
  private String timeZone;
  private String frequency;

  /**
   * Gets the enabled.
   *
   * When `true`, the source is re-crawled based on the **frequency** field in this object. When `false` the source is
   * not re-crawled; When `false` and connecting to Salesforce the source is crawled annually.
   *
   * @return the enabled
   */
  public Boolean isEnabled() {
    return enabled;
  }

  /**
   * Gets the timeZone.
   *
   * The time zone to base source crawl times on. Possible values correspond to the IANA (Internet Assigned Numbers
   * Authority) time zones list.
   *
   * @return the timeZone
   */
  public String getTimeZone() {
    return timeZone;
  }

  /**
   * Gets the frequency.
   *
   * The crawl schedule in the specified **time_zone**.
   *
   * - `daily`: Runs every day between 00:00 and 06:00.
   * - `weekly`: Runs every week on Sunday between 00:00 and 06:00.
   * - `monthly`: Runs the on the first Sunday of every month between 00:00 and 06:00.
   *
   * @return the frequency
   */
  public String getFrequency() {
    return frequency;
  }

  /**
   * Sets the enabled.
   *
   * @param enabled the new enabled
   */
  public void setEnabled(final Boolean enabled) {
    this.enabled = enabled;
  }

  /**
   * Sets the timeZone.
   *
   * @param timeZone the new timeZone
   */
  public void setTimeZone(final String timeZone) {
    this.timeZone = timeZone;
  }

  /**
   * Sets the frequency.
   *
   * @param frequency the new frequency
   */
  public void setFrequency(final String frequency) {
    this.frequency = frequency;
  }
}
