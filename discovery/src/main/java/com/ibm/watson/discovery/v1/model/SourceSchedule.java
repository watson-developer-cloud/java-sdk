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
   * -  `five_minutes`: Runs every five minutes.
   * -  `hourly`: Runs every hour.
   * -  `daily`: Runs every day between 00:00 and 06:00.
   * -  `weekly`: Runs every week on Sunday between 00:00 and 06:00.
   * -  `monthly`: Runs the on the first Sunday of every month between 00:00 and 06:00.
   */
  public interface Frequency {
    /** daily. */
    String DAILY = "daily";
    /** weekly. */
    String WEEKLY = "weekly";
    /** monthly. */
    String MONTHLY = "monthly";
    /** five_minutes. */
    String FIVE_MINUTES = "five_minutes";
    /** hourly. */
    String HOURLY = "hourly";
  }

  protected Boolean enabled;
  @SerializedName("time_zone")
  protected String timeZone;
  protected String frequency;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean enabled;
    private String timeZone;
    private String frequency;

    private Builder(SourceSchedule sourceSchedule) {
      this.enabled = sourceSchedule.enabled;
      this.timeZone = sourceSchedule.timeZone;
      this.frequency = sourceSchedule.frequency;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a SourceSchedule.
     *
     * @return the sourceSchedule
     */
    public SourceSchedule build() {
      return new SourceSchedule(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the SourceSchedule builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the timeZone.
     *
     * @param timeZone the timeZone
     * @return the SourceSchedule builder
     */
    public Builder timeZone(String timeZone) {
      this.timeZone = timeZone;
      return this;
    }

    /**
     * Set the frequency.
     *
     * @param frequency the frequency
     * @return the SourceSchedule builder
     */
    public Builder frequency(String frequency) {
      this.frequency = frequency;
      return this;
    }
  }

  protected SourceSchedule(Builder builder) {
    enabled = builder.enabled;
    timeZone = builder.timeZone;
    frequency = builder.frequency;
  }

  /**
   * New builder.
   *
   * @return a SourceSchedule builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * When `true`, the source is re-crawled based on the **frequency** field in this object. When `false` the source is
   * not re-crawled; When `false` and connecting to Salesforce the source is crawled annually.
   *
   * @return the enabled
   */
  public Boolean enabled() {
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
  public String timeZone() {
    return timeZone;
  }

  /**
   * Gets the frequency.
   *
   * The crawl schedule in the specified **time_zone**.
   *
   * -  `five_minutes`: Runs every five minutes.
   * -  `hourly`: Runs every hour.
   * -  `daily`: Runs every day between 00:00 and 06:00.
   * -  `weekly`: Runs every week on Sunday between 00:00 and 06:00.
   * -  `monthly`: Runs the on the first Sunday of every month between 00:00 and 06:00.
   *
   * @return the frequency
   */
  public String frequency() {
    return frequency;
  }
}

