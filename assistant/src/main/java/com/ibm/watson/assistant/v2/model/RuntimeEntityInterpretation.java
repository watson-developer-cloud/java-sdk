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
package com.ibm.watson.assistant.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * RuntimeEntityInterpretation.
 */
public class RuntimeEntityInterpretation extends GenericModel {

  /**
   * The precision or duration of a time range specified by a recognized `@sys-time` or `@sys-date` entity.
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
  private String calendarType;
  @SerializedName("datetime_link")
  private String datetimeLink;
  private String festival;
  private String granularity;
  @SerializedName("range_link")
  private String rangeLink;
  @SerializedName("range_modifier")
  private String rangeModifier;
  @SerializedName("relative_day")
  private Double relativeDay;
  @SerializedName("relative_month")
  private Double relativeMonth;
  @SerializedName("relative_week")
  private Double relativeWeek;
  @SerializedName("relative_weekend")
  private Double relativeWeekend;
  @SerializedName("relative_year")
  private Double relativeYear;
  @SerializedName("specific_day")
  private Double specificDay;
  @SerializedName("specific_day_of_week")
  private String specificDayOfWeek;
  @SerializedName("specific_month")
  private Double specificMonth;
  @SerializedName("specific_quarter")
  private Double specificQuarter;
  @SerializedName("specific_year")
  private Double specificYear;
  @SerializedName("numeric_value")
  private Double numericValue;
  private String subtype;
  @SerializedName("part_of_day")
  private String partOfDay;
  @SerializedName("relative_hour")
  private Double relativeHour;
  @SerializedName("relative_minute")
  private Double relativeMinute;
  @SerializedName("relative_second")
  private Double relativeSecond;
  @SerializedName("specific_hour")
  private Double specificHour;
  @SerializedName("specific_minute")
  private Double specificMinute;
  @SerializedName("specific_second")
  private Double specificSecond;
  private String timezone;

  /**
   * Gets the calendarType.
   *
   * The calendar used to represent a recognized date (for example, `Gregorian`).
   *
   * @return the calendarType
   */
  public String getCalendarType() {
    return calendarType;
  }

  /**
   * Gets the datetimeLink.
   *
   * A unique identifier used to associate a recognized time and date. If the user input contains a date and time that
   * are mentioned together (for example, `Today at 5`, the same **datetime_link** value is returned for both the
   * `@sys-date` and `@sys-time` entities).
   *
   * @return the datetimeLink
   */
  public String getDatetimeLink() {
    return datetimeLink;
  }

  /**
   * Gets the festival.
   *
   * A locale-specific holiday name (such as `thanksgiving` or `christmas`). This property is included when a
   * `@sys-date` entity is recognized based on a holiday name in the user input.
   *
   * @return the festival
   */
  public String getFestival() {
    return festival;
  }

  /**
   * Gets the granularity.
   *
   * The precision or duration of a time range specified by a recognized `@sys-time` or `@sys-date` entity.
   *
   * @return the granularity
   */
  public String getGranularity() {
    return granularity;
  }

  /**
   * Gets the rangeLink.
   *
   * A unique identifier used to associate multiple recognized `@sys-date`, `@sys-time`, or `@sys-number` entities that
   * are recognized as a range of values in the user's input (for example, `from July 4 until July 14` or `from 20 to
   * 25`).
   *
   * @return the rangeLink
   */
  public String getRangeLink() {
    return rangeLink;
  }

  /**
   * Gets the rangeModifier.
   *
   * The word in the user input that indicates that a `sys-date` or `sys-time` entity is part of an implied range where
   * only one date or time is specified (for example, `since` or `until`).
   *
   * @return the rangeModifier
   */
  public String getRangeModifier() {
    return rangeModifier;
  }

  /**
   * Gets the relativeDay.
   *
   * A recognized mention of a relative day, represented numerically as an offset from the current date (for example,
   * `-1` for `yesterday` or `10` for `in ten days`).
   *
   * @return the relativeDay
   */
  public Double getRelativeDay() {
    return relativeDay;
  }

  /**
   * Gets the relativeMonth.
   *
   * A recognized mention of a relative month, represented numerically as an offset from the current month (for example,
   * `1` for `next month` or `-3` for `three months ago`).
   *
   * @return the relativeMonth
   */
  public Double getRelativeMonth() {
    return relativeMonth;
  }

  /**
   * Gets the relativeWeek.
   *
   * A recognized mention of a relative week, represented numerically as an offset from the current week (for example,
   * `2` for `in two weeks` or `-1` for `last week).
   *
   * @return the relativeWeek
   */
  public Double getRelativeWeek() {
    return relativeWeek;
  }

  /**
   * Gets the relativeWeekend.
   *
   * A recognized mention of a relative date range for a weekend, represented numerically as an offset from the current
   * weekend (for example, `0` for `this weekend` or `-1` for `last weekend`).
   *
   * @return the relativeWeekend
   */
  public Double getRelativeWeekend() {
    return relativeWeekend;
  }

  /**
   * Gets the relativeYear.
   *
   * A recognized mention of a relative year, represented numerically as an offset from the current year (for example,
   * `1` for `next year` or `-5` for `five years ago`).
   *
   * @return the relativeYear
   */
  public Double getRelativeYear() {
    return relativeYear;
  }

  /**
   * Gets the specificDay.
   *
   * A recognized mention of a specific date, represented numerically as the date within the month (for example, `30`
   * for `June 30`.).
   *
   * @return the specificDay
   */
  public Double getSpecificDay() {
    return specificDay;
  }

  /**
   * Gets the specificDayOfWeek.
   *
   * A recognized mention of a specific day of the week as a lowercase string (for example, `monday`).
   *
   * @return the specificDayOfWeek
   */
  public String getSpecificDayOfWeek() {
    return specificDayOfWeek;
  }

  /**
   * Gets the specificMonth.
   *
   * A recognized mention of a specific month, represented numerically (for example, `7` for `July`).
   *
   * @return the specificMonth
   */
  public Double getSpecificMonth() {
    return specificMonth;
  }

  /**
   * Gets the specificQuarter.
   *
   * A recognized mention of a specific quarter, represented numerically (for example, `3` for `the third quarter`).
   *
   * @return the specificQuarter
   */
  public Double getSpecificQuarter() {
    return specificQuarter;
  }

  /**
   * Gets the specificYear.
   *
   * A recognized mention of a specific year (for example, `2016`).
   *
   * @return the specificYear
   */
  public Double getSpecificYear() {
    return specificYear;
  }

  /**
   * Gets the numericValue.
   *
   * A recognized numeric value, represented as an integer or double.
   *
   * @return the numericValue
   */
  public Double getNumericValue() {
    return numericValue;
  }

  /**
   * Gets the subtype.
   *
   * The type of numeric value recognized in the user input (`integer` or `rational`).
   *
   * @return the subtype
   */
  public String getSubtype() {
    return subtype;
  }

  /**
   * Gets the partOfDay.
   *
   * A recognized term for a time that was mentioned as a part of the day in the user's input (for example, `morning` or
   * `afternoon`). In addition, the returned entity value is set to a specific time:
   *
   * - `09:00:00` for `morning`
   * - `15:00:00` for `afternoon`
   * - `18:00:00` for `evening`
   * - `22:00:00` for `night`
   * - `00:00:00` for `midnight`.
   *
   * @return the partOfDay
   */
  public String getPartOfDay() {
    return partOfDay;
  }

  /**
   * Gets the relativeHour.
   *
   * A recognized mention of a relative hour, represented numerically as an offset from the current hour (for example,
   * `3` for `in three hours` or `-1` for `an hour ago`).
   *
   * @return the relativeHour
   */
  public Double getRelativeHour() {
    return relativeHour;
  }

  /**
   * Gets the relativeMinute.
   *
   * A recognized mention of a relative time, represented numerically as an offset in minutes from the current time (for
   * example, `5` for `in five minutes` or `-15` for `fifteen minutes ago`).
   *
   * @return the relativeMinute
   */
  public Double getRelativeMinute() {
    return relativeMinute;
  }

  /**
   * Gets the relativeSecond.
   *
   * A recognized mention of a relative time, represented numerically as an offset in seconds from the current time (for
   * example, `10` for `in ten seconds` or `-30` for `thirty seconds ago`).
   *
   * @return the relativeSecond
   */
  public Double getRelativeSecond() {
    return relativeSecond;
  }

  /**
   * Gets the specificHour.
   *
   * A recognized specific hour mentioned as part of a time value (for example, `10` for `10:15 AM`.).
   *
   * @return the specificHour
   */
  public Double getSpecificHour() {
    return specificHour;
  }

  /**
   * Gets the specificMinute.
   *
   * A recognized specific minute mentioned as part of a time value (for example, `15` for `10:15 AM`.).
   *
   * @return the specificMinute
   */
  public Double getSpecificMinute() {
    return specificMinute;
  }

  /**
   * Gets the specificSecond.
   *
   * A recognized specific second mentioned as part of a time value (for example, `30` for `10:15:30 AM`.).
   *
   * @return the specificSecond
   */
  public Double getSpecificSecond() {
    return specificSecond;
  }

  /**
   * Gets the timezone.
   *
   * A recognized time zone mentioned as part of a time value (for example, `EST`).
   *
   * @return the timezone
   */
  public String getTimezone() {
    return timezone;
  }

  /**
   * Sets the calendarType.
   *
   * @param calendarType the new calendarType
   */
  public void setCalendarType(final String calendarType) {
    this.calendarType = calendarType;
  }

  /**
   * Sets the datetimeLink.
   *
   * @param datetimeLink the new datetimeLink
   */
  public void setDatetimeLink(final String datetimeLink) {
    this.datetimeLink = datetimeLink;
  }

  /**
   * Sets the festival.
   *
   * @param festival the new festival
   */
  public void setFestival(final String festival) {
    this.festival = festival;
  }

  /**
   * Sets the granularity.
   *
   * @param granularity the new granularity
   */
  public void setGranularity(final String granularity) {
    this.granularity = granularity;
  }

  /**
   * Sets the rangeLink.
   *
   * @param rangeLink the new rangeLink
   */
  public void setRangeLink(final String rangeLink) {
    this.rangeLink = rangeLink;
  }

  /**
   * Sets the rangeModifier.
   *
   * @param rangeModifier the new rangeModifier
   */
  public void setRangeModifier(final String rangeModifier) {
    this.rangeModifier = rangeModifier;
  }

  /**
   * Sets the relativeDay.
   *
   * @param relativeDay the new relativeDay
   */
  public void setRelativeDay(final Double relativeDay) {
    this.relativeDay = relativeDay;
  }

  /**
   * Sets the relativeMonth.
   *
   * @param relativeMonth the new relativeMonth
   */
  public void setRelativeMonth(final Double relativeMonth) {
    this.relativeMonth = relativeMonth;
  }

  /**
   * Sets the relativeWeek.
   *
   * @param relativeWeek the new relativeWeek
   */
  public void setRelativeWeek(final Double relativeWeek) {
    this.relativeWeek = relativeWeek;
  }

  /**
   * Sets the relativeWeekend.
   *
   * @param relativeWeekend the new relativeWeekend
   */
  public void setRelativeWeekend(final Double relativeWeekend) {
    this.relativeWeekend = relativeWeekend;
  }

  /**
   * Sets the relativeYear.
   *
   * @param relativeYear the new relativeYear
   */
  public void setRelativeYear(final Double relativeYear) {
    this.relativeYear = relativeYear;
  }

  /**
   * Sets the specificDay.
   *
   * @param specificDay the new specificDay
   */
  public void setSpecificDay(final Double specificDay) {
    this.specificDay = specificDay;
  }

  /**
   * Sets the specificDayOfWeek.
   *
   * @param specificDayOfWeek the new specificDayOfWeek
   */
  public void setSpecificDayOfWeek(final String specificDayOfWeek) {
    this.specificDayOfWeek = specificDayOfWeek;
  }

  /**
   * Sets the specificMonth.
   *
   * @param specificMonth the new specificMonth
   */
  public void setSpecificMonth(final Double specificMonth) {
    this.specificMonth = specificMonth;
  }

  /**
   * Sets the specificQuarter.
   *
   * @param specificQuarter the new specificQuarter
   */
  public void setSpecificQuarter(final Double specificQuarter) {
    this.specificQuarter = specificQuarter;
  }

  /**
   * Sets the specificYear.
   *
   * @param specificYear the new specificYear
   */
  public void setSpecificYear(final Double specificYear) {
    this.specificYear = specificYear;
  }

  /**
   * Sets the numericValue.
   *
   * @param numericValue the new numericValue
   */
  public void setNumericValue(final Double numericValue) {
    this.numericValue = numericValue;
  }

  /**
   * Sets the subtype.
   *
   * @param subtype the new subtype
   */
  public void setSubtype(final String subtype) {
    this.subtype = subtype;
  }

  /**
   * Sets the partOfDay.
   *
   * @param partOfDay the new partOfDay
   */
  public void setPartOfDay(final String partOfDay) {
    this.partOfDay = partOfDay;
  }

  /**
   * Sets the relativeHour.
   *
   * @param relativeHour the new relativeHour
   */
  public void setRelativeHour(final Double relativeHour) {
    this.relativeHour = relativeHour;
  }

  /**
   * Sets the relativeMinute.
   *
   * @param relativeMinute the new relativeMinute
   */
  public void setRelativeMinute(final Double relativeMinute) {
    this.relativeMinute = relativeMinute;
  }

  /**
   * Sets the relativeSecond.
   *
   * @param relativeSecond the new relativeSecond
   */
  public void setRelativeSecond(final Double relativeSecond) {
    this.relativeSecond = relativeSecond;
  }

  /**
   * Sets the specificHour.
   *
   * @param specificHour the new specificHour
   */
  public void setSpecificHour(final Double specificHour) {
    this.specificHour = specificHour;
  }

  /**
   * Sets the specificMinute.
   *
   * @param specificMinute the new specificMinute
   */
  public void setSpecificMinute(final Double specificMinute) {
    this.specificMinute = specificMinute;
  }

  /**
   * Sets the specificSecond.
   *
   * @param specificSecond the new specificSecond
   */
  public void setSpecificSecond(final Double specificSecond) {
    this.specificSecond = specificSecond;
  }

  /**
   * Sets the timezone.
   *
   * @param timezone the new timezone
   */
  public void setTimezone(final String timezone) {
    this.timezone = timezone;
  }
}
