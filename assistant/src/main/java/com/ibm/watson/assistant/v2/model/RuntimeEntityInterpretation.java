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
package com.ibm.watson.assistant.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** RuntimeEntityInterpretation. */
public class RuntimeEntityInterpretation extends GenericModel {

  /**
   * The precision or duration of a time range specified by a recognized `@sys-time` or `@sys-date`
   * entity.
   */
  public interface Granularity {
    /** day. */
    String DAY = "day";
    /** fortnight. */
    String FORTNIGHT = "fortnight";
    /** hour. */
    String HOUR = "hour";
    /** instant. */
    String INSTANT = "instant";
    /** minute. */
    String MINUTE = "minute";
    /** month. */
    String MONTH = "month";
    /** quarter. */
    String QUARTER = "quarter";
    /** second. */
    String SECOND = "second";
    /** week. */
    String WEEK = "week";
    /** weekend. */
    String WEEKEND = "weekend";
    /** year. */
    String YEAR = "year";
  }

  @SerializedName("calendar_type")
  protected String calendarType;

  @SerializedName("datetime_link")
  protected String datetimeLink;

  protected String festival;
  protected String granularity;

  @SerializedName("range_link")
  protected String rangeLink;

  @SerializedName("range_modifier")
  protected String rangeModifier;

  @SerializedName("relative_day")
  protected Double relativeDay;

  @SerializedName("relative_month")
  protected Double relativeMonth;

  @SerializedName("relative_week")
  protected Double relativeWeek;

  @SerializedName("relative_weekend")
  protected Double relativeWeekend;

  @SerializedName("relative_year")
  protected Double relativeYear;

  @SerializedName("specific_day")
  protected Double specificDay;

  @SerializedName("specific_day_of_week")
  protected String specificDayOfWeek;

  @SerializedName("specific_month")
  protected Double specificMonth;

  @SerializedName("specific_quarter")
  protected Double specificQuarter;

  @SerializedName("specific_year")
  protected Double specificYear;

  @SerializedName("numeric_value")
  protected Double numericValue;

  protected String subtype;

  @SerializedName("part_of_day")
  protected String partOfDay;

  @SerializedName("relative_hour")
  protected Double relativeHour;

  @SerializedName("relative_minute")
  protected Double relativeMinute;

  @SerializedName("relative_second")
  protected Double relativeSecond;

  @SerializedName("specific_hour")
  protected Double specificHour;

  @SerializedName("specific_minute")
  protected Double specificMinute;

  @SerializedName("specific_second")
  protected Double specificSecond;

  protected String timezone;

  /** Builder. */
  public static class Builder {
    private String calendarType;
    private String datetimeLink;
    private String festival;
    private String granularity;
    private String rangeLink;
    private String rangeModifier;
    private Double relativeDay;
    private Double relativeMonth;
    private Double relativeWeek;
    private Double relativeWeekend;
    private Double relativeYear;
    private Double specificDay;
    private String specificDayOfWeek;
    private Double specificMonth;
    private Double specificQuarter;
    private Double specificYear;
    private Double numericValue;
    private String subtype;
    private String partOfDay;
    private Double relativeHour;
    private Double relativeMinute;
    private Double relativeSecond;
    private Double specificHour;
    private Double specificMinute;
    private Double specificSecond;
    private String timezone;

    private Builder(RuntimeEntityInterpretation runtimeEntityInterpretation) {
      this.calendarType = runtimeEntityInterpretation.calendarType;
      this.datetimeLink = runtimeEntityInterpretation.datetimeLink;
      this.festival = runtimeEntityInterpretation.festival;
      this.granularity = runtimeEntityInterpretation.granularity;
      this.rangeLink = runtimeEntityInterpretation.rangeLink;
      this.rangeModifier = runtimeEntityInterpretation.rangeModifier;
      this.relativeDay = runtimeEntityInterpretation.relativeDay;
      this.relativeMonth = runtimeEntityInterpretation.relativeMonth;
      this.relativeWeek = runtimeEntityInterpretation.relativeWeek;
      this.relativeWeekend = runtimeEntityInterpretation.relativeWeekend;
      this.relativeYear = runtimeEntityInterpretation.relativeYear;
      this.specificDay = runtimeEntityInterpretation.specificDay;
      this.specificDayOfWeek = runtimeEntityInterpretation.specificDayOfWeek;
      this.specificMonth = runtimeEntityInterpretation.specificMonth;
      this.specificQuarter = runtimeEntityInterpretation.specificQuarter;
      this.specificYear = runtimeEntityInterpretation.specificYear;
      this.numericValue = runtimeEntityInterpretation.numericValue;
      this.subtype = runtimeEntityInterpretation.subtype;
      this.partOfDay = runtimeEntityInterpretation.partOfDay;
      this.relativeHour = runtimeEntityInterpretation.relativeHour;
      this.relativeMinute = runtimeEntityInterpretation.relativeMinute;
      this.relativeSecond = runtimeEntityInterpretation.relativeSecond;
      this.specificHour = runtimeEntityInterpretation.specificHour;
      this.specificMinute = runtimeEntityInterpretation.specificMinute;
      this.specificSecond = runtimeEntityInterpretation.specificSecond;
      this.timezone = runtimeEntityInterpretation.timezone;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a RuntimeEntityInterpretation.
     *
     * @return the runtimeEntityInterpretation
     */
    public RuntimeEntityInterpretation build() {
      return new RuntimeEntityInterpretation(this);
    }

    /**
     * Set the calendarType.
     *
     * @param calendarType the calendarType
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder calendarType(String calendarType) {
      this.calendarType = calendarType;
      return this;
    }

    /**
     * Set the datetimeLink.
     *
     * @param datetimeLink the datetimeLink
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder datetimeLink(String datetimeLink) {
      this.datetimeLink = datetimeLink;
      return this;
    }

    /**
     * Set the festival.
     *
     * @param festival the festival
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder festival(String festival) {
      this.festival = festival;
      return this;
    }

    /**
     * Set the granularity.
     *
     * @param granularity the granularity
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder granularity(String granularity) {
      this.granularity = granularity;
      return this;
    }

    /**
     * Set the rangeLink.
     *
     * @param rangeLink the rangeLink
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder rangeLink(String rangeLink) {
      this.rangeLink = rangeLink;
      return this;
    }

    /**
     * Set the rangeModifier.
     *
     * @param rangeModifier the rangeModifier
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder rangeModifier(String rangeModifier) {
      this.rangeModifier = rangeModifier;
      return this;
    }

    /**
     * Set the relativeDay.
     *
     * @param relativeDay the relativeDay
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder relativeDay(Double relativeDay) {
      this.relativeDay = relativeDay;
      return this;
    }

    /**
     * Set the relativeMonth.
     *
     * @param relativeMonth the relativeMonth
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder relativeMonth(Double relativeMonth) {
      this.relativeMonth = relativeMonth;
      return this;
    }

    /**
     * Set the relativeWeek.
     *
     * @param relativeWeek the relativeWeek
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder relativeWeek(Double relativeWeek) {
      this.relativeWeek = relativeWeek;
      return this;
    }

    /**
     * Set the relativeWeekend.
     *
     * @param relativeWeekend the relativeWeekend
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder relativeWeekend(Double relativeWeekend) {
      this.relativeWeekend = relativeWeekend;
      return this;
    }

    /**
     * Set the relativeYear.
     *
     * @param relativeYear the relativeYear
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder relativeYear(Double relativeYear) {
      this.relativeYear = relativeYear;
      return this;
    }

    /**
     * Set the specificDay.
     *
     * @param specificDay the specificDay
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder specificDay(Double specificDay) {
      this.specificDay = specificDay;
      return this;
    }

    /**
     * Set the specificDayOfWeek.
     *
     * @param specificDayOfWeek the specificDayOfWeek
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder specificDayOfWeek(String specificDayOfWeek) {
      this.specificDayOfWeek = specificDayOfWeek;
      return this;
    }

    /**
     * Set the specificMonth.
     *
     * @param specificMonth the specificMonth
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder specificMonth(Double specificMonth) {
      this.specificMonth = specificMonth;
      return this;
    }

    /**
     * Set the specificQuarter.
     *
     * @param specificQuarter the specificQuarter
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder specificQuarter(Double specificQuarter) {
      this.specificQuarter = specificQuarter;
      return this;
    }

    /**
     * Set the specificYear.
     *
     * @param specificYear the specificYear
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder specificYear(Double specificYear) {
      this.specificYear = specificYear;
      return this;
    }

    /**
     * Set the numericValue.
     *
     * @param numericValue the numericValue
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder numericValue(Double numericValue) {
      this.numericValue = numericValue;
      return this;
    }

    /**
     * Set the subtype.
     *
     * @param subtype the subtype
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder subtype(String subtype) {
      this.subtype = subtype;
      return this;
    }

    /**
     * Set the partOfDay.
     *
     * @param partOfDay the partOfDay
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder partOfDay(String partOfDay) {
      this.partOfDay = partOfDay;
      return this;
    }

    /**
     * Set the relativeHour.
     *
     * @param relativeHour the relativeHour
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder relativeHour(Double relativeHour) {
      this.relativeHour = relativeHour;
      return this;
    }

    /**
     * Set the relativeMinute.
     *
     * @param relativeMinute the relativeMinute
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder relativeMinute(Double relativeMinute) {
      this.relativeMinute = relativeMinute;
      return this;
    }

    /**
     * Set the relativeSecond.
     *
     * @param relativeSecond the relativeSecond
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder relativeSecond(Double relativeSecond) {
      this.relativeSecond = relativeSecond;
      return this;
    }

    /**
     * Set the specificHour.
     *
     * @param specificHour the specificHour
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder specificHour(Double specificHour) {
      this.specificHour = specificHour;
      return this;
    }

    /**
     * Set the specificMinute.
     *
     * @param specificMinute the specificMinute
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder specificMinute(Double specificMinute) {
      this.specificMinute = specificMinute;
      return this;
    }

    /**
     * Set the specificSecond.
     *
     * @param specificSecond the specificSecond
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder specificSecond(Double specificSecond) {
      this.specificSecond = specificSecond;
      return this;
    }

    /**
     * Set the timezone.
     *
     * @param timezone the timezone
     * @return the RuntimeEntityInterpretation builder
     */
    public Builder timezone(String timezone) {
      this.timezone = timezone;
      return this;
    }
  }

  protected RuntimeEntityInterpretation(Builder builder) {
    calendarType = builder.calendarType;
    datetimeLink = builder.datetimeLink;
    festival = builder.festival;
    granularity = builder.granularity;
    rangeLink = builder.rangeLink;
    rangeModifier = builder.rangeModifier;
    relativeDay = builder.relativeDay;
    relativeMonth = builder.relativeMonth;
    relativeWeek = builder.relativeWeek;
    relativeWeekend = builder.relativeWeekend;
    relativeYear = builder.relativeYear;
    specificDay = builder.specificDay;
    specificDayOfWeek = builder.specificDayOfWeek;
    specificMonth = builder.specificMonth;
    specificQuarter = builder.specificQuarter;
    specificYear = builder.specificYear;
    numericValue = builder.numericValue;
    subtype = builder.subtype;
    partOfDay = builder.partOfDay;
    relativeHour = builder.relativeHour;
    relativeMinute = builder.relativeMinute;
    relativeSecond = builder.relativeSecond;
    specificHour = builder.specificHour;
    specificMinute = builder.specificMinute;
    specificSecond = builder.specificSecond;
    timezone = builder.timezone;
  }

  /**
   * New builder.
   *
   * @return a RuntimeEntityInterpretation builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the calendarType.
   *
   * <p>The calendar used to represent a recognized date (for example, `Gregorian`).
   *
   * @return the calendarType
   */
  public String calendarType() {
    return calendarType;
  }

  /**
   * Gets the datetimeLink.
   *
   * <p>A unique identifier used to associate a recognized time and date. If the user input contains
   * a date and time that are mentioned together (for example, `Today at 5`, the same
   * **datetime_link** value is returned for both the `@sys-date` and `@sys-time` entities).
   *
   * @return the datetimeLink
   */
  public String datetimeLink() {
    return datetimeLink;
  }

  /**
   * Gets the festival.
   *
   * <p>A locale-specific holiday name (such as `thanksgiving` or `christmas`). This property is
   * included when a `@sys-date` entity is recognized based on a holiday name in the user input.
   *
   * @return the festival
   */
  public String festival() {
    return festival;
  }

  /**
   * Gets the granularity.
   *
   * <p>The precision or duration of a time range specified by a recognized `@sys-time` or
   * `@sys-date` entity.
   *
   * @return the granularity
   */
  public String granularity() {
    return granularity;
  }

  /**
   * Gets the rangeLink.
   *
   * <p>A unique identifier used to associate multiple recognized `@sys-date`, `@sys-time`, or
   * `@sys-number` entities that are recognized as a range of values in the user's input (for
   * example, `from July 4 until July 14` or `from 20 to 25`).
   *
   * @return the rangeLink
   */
  public String rangeLink() {
    return rangeLink;
  }

  /**
   * Gets the rangeModifier.
   *
   * <p>The word in the user input that indicates that a `sys-date` or `sys-time` entity is part of
   * an implied range where only one date or time is specified (for example, `since` or `until`).
   *
   * @return the rangeModifier
   */
  public String rangeModifier() {
    return rangeModifier;
  }

  /**
   * Gets the relativeDay.
   *
   * <p>A recognized mention of a relative day, represented numerically as an offset from the
   * current date (for example, `-1` for `yesterday` or `10` for `in ten days`).
   *
   * @return the relativeDay
   */
  public Double relativeDay() {
    return relativeDay;
  }

  /**
   * Gets the relativeMonth.
   *
   * <p>A recognized mention of a relative month, represented numerically as an offset from the
   * current month (for example, `1` for `next month` or `-3` for `three months ago`).
   *
   * @return the relativeMonth
   */
  public Double relativeMonth() {
    return relativeMonth;
  }

  /**
   * Gets the relativeWeek.
   *
   * <p>A recognized mention of a relative week, represented numerically as an offset from the
   * current week (for example, `2` for `in two weeks` or `-1` for `last week).
   *
   * @return the relativeWeek
   */
  public Double relativeWeek() {
    return relativeWeek;
  }

  /**
   * Gets the relativeWeekend.
   *
   * <p>A recognized mention of a relative date range for a weekend, represented numerically as an
   * offset from the current weekend (for example, `0` for `this weekend` or `-1` for `last
   * weekend`).
   *
   * @return the relativeWeekend
   */
  public Double relativeWeekend() {
    return relativeWeekend;
  }

  /**
   * Gets the relativeYear.
   *
   * <p>A recognized mention of a relative year, represented numerically as an offset from the
   * current year (for example, `1` for `next year` or `-5` for `five years ago`).
   *
   * @return the relativeYear
   */
  public Double relativeYear() {
    return relativeYear;
  }

  /**
   * Gets the specificDay.
   *
   * <p>A recognized mention of a specific date, represented numerically as the date within the
   * month (for example, `30` for `June 30`.).
   *
   * @return the specificDay
   */
  public Double specificDay() {
    return specificDay;
  }

  /**
   * Gets the specificDayOfWeek.
   *
   * <p>A recognized mention of a specific day of the week as a lowercase string (for example,
   * `monday`).
   *
   * @return the specificDayOfWeek
   */
  public String specificDayOfWeek() {
    return specificDayOfWeek;
  }

  /**
   * Gets the specificMonth.
   *
   * <p>A recognized mention of a specific month, represented numerically (for example, `7` for
   * `July`).
   *
   * @return the specificMonth
   */
  public Double specificMonth() {
    return specificMonth;
  }

  /**
   * Gets the specificQuarter.
   *
   * <p>A recognized mention of a specific quarter, represented numerically (for example, `3` for
   * `the third quarter`).
   *
   * @return the specificQuarter
   */
  public Double specificQuarter() {
    return specificQuarter;
  }

  /**
   * Gets the specificYear.
   *
   * <p>A recognized mention of a specific year (for example, `2016`).
   *
   * @return the specificYear
   */
  public Double specificYear() {
    return specificYear;
  }

  /**
   * Gets the numericValue.
   *
   * <p>A recognized numeric value, represented as an integer or double.
   *
   * @return the numericValue
   */
  public Double numericValue() {
    return numericValue;
  }

  /**
   * Gets the subtype.
   *
   * <p>The type of numeric value recognized in the user input (`integer` or `rational`).
   *
   * @return the subtype
   */
  public String subtype() {
    return subtype;
  }

  /**
   * Gets the partOfDay.
   *
   * <p>A recognized term for a time that was mentioned as a part of the day in the user's input
   * (for example, `morning` or `afternoon`).
   *
   * @return the partOfDay
   */
  public String partOfDay() {
    return partOfDay;
  }

  /**
   * Gets the relativeHour.
   *
   * <p>A recognized mention of a relative hour, represented numerically as an offset from the
   * current hour (for example, `3` for `in three hours` or `-1` for `an hour ago`).
   *
   * @return the relativeHour
   */
  public Double relativeHour() {
    return relativeHour;
  }

  /**
   * Gets the relativeMinute.
   *
   * <p>A recognized mention of a relative time, represented numerically as an offset in minutes
   * from the current time (for example, `5` for `in five minutes` or `-15` for `fifteen minutes
   * ago`).
   *
   * @return the relativeMinute
   */
  public Double relativeMinute() {
    return relativeMinute;
  }

  /**
   * Gets the relativeSecond.
   *
   * <p>A recognized mention of a relative time, represented numerically as an offset in seconds
   * from the current time (for example, `10` for `in ten seconds` or `-30` for `thirty seconds
   * ago`).
   *
   * @return the relativeSecond
   */
  public Double relativeSecond() {
    return relativeSecond;
  }

  /**
   * Gets the specificHour.
   *
   * <p>A recognized specific hour mentioned as part of a time value (for example, `10` for `10:15
   * AM`.).
   *
   * @return the specificHour
   */
  public Double specificHour() {
    return specificHour;
  }

  /**
   * Gets the specificMinute.
   *
   * <p>A recognized specific minute mentioned as part of a time value (for example, `15` for `10:15
   * AM`.).
   *
   * @return the specificMinute
   */
  public Double specificMinute() {
    return specificMinute;
  }

  /**
   * Gets the specificSecond.
   *
   * <p>A recognized specific second mentioned as part of a time value (for example, `30` for
   * `10:15:30 AM`.).
   *
   * @return the specificSecond
   */
  public Double specificSecond() {
    return specificSecond;
  }

  /**
   * Gets the timezone.
   *
   * <p>A recognized time zone mentioned as part of a time value (for example, `EST`).
   *
   * @return the timezone
   */
  public String timezone() {
    return timezone;
  }
}
