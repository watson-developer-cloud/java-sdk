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

/**
 * Built-in system properties that apply to all skills used by the assistant.
 */
public class MessageContextGlobalSystem extends GenericModel {

  /**
   * The language code for localization in the user input. The specified locale overrides the default for the assistant,
   * and is used for interpreting entity values in user input such as date values. For example, `04/03/2018` might be
   * interpreted either as April 3 or March 4, depending on the locale.
   *
   *  This property is included only if the new system entities are enabled for the skill.
   */
  public interface Locale {
    /** en-us. */
    String EN_US = "en-us";
    /** en-ca. */
    String EN_CA = "en-ca";
    /** en-gb. */
    String EN_GB = "en-gb";
    /** ar-ar. */
    String AR_AR = "ar-ar";
    /** cs-cz. */
    String CS_CZ = "cs-cz";
    /** de-de. */
    String DE_DE = "de-de";
    /** es-es. */
    String ES_ES = "es-es";
    /** fr-fr. */
    String FR_FR = "fr-fr";
    /** it-it. */
    String IT_IT = "it-it";
    /** ja-jp. */
    String JA_JP = "ja-jp";
    /** ko-kr. */
    String KO_KR = "ko-kr";
    /** nl-nl. */
    String NL_NL = "nl-nl";
    /** pt-br. */
    String PT_BR = "pt-br";
    /** zh-cn. */
    String ZH_CN = "zh-cn";
    /** zh-tw. */
    String ZH_TW = "zh-tw";
  }

  protected String timezone;
  @SerializedName("user_id")
  protected String userId;
  @SerializedName("turn_count")
  protected Long turnCount;
  protected String locale;
  @SerializedName("reference_time")
  protected String referenceTime;

  /**
   * Builder.
   */
  public static class Builder {
    private String timezone;
    private String userId;
    private Long turnCount;
    private String locale;
    private String referenceTime;

    private Builder(MessageContextGlobalSystem messageContextGlobalSystem) {
      this.timezone = messageContextGlobalSystem.timezone;
      this.userId = messageContextGlobalSystem.userId;
      this.turnCount = messageContextGlobalSystem.turnCount;
      this.locale = messageContextGlobalSystem.locale;
      this.referenceTime = messageContextGlobalSystem.referenceTime;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a MessageContextGlobalSystem.
     *
     * @return the messageContextGlobalSystem
     */
    public MessageContextGlobalSystem build() {
      return new MessageContextGlobalSystem(this);
    }

    /**
     * Set the timezone.
     *
     * @param timezone the timezone
     * @return the MessageContextGlobalSystem builder
     */
    public Builder timezone(String timezone) {
      this.timezone = timezone;
      return this;
    }

    /**
     * Set the userId.
     *
     * @param userId the userId
     * @return the MessageContextGlobalSystem builder
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }

    /**
     * Set the turnCount.
     *
     * @param turnCount the turnCount
     * @return the MessageContextGlobalSystem builder
     */
    public Builder turnCount(long turnCount) {
      this.turnCount = turnCount;
      return this;
    }

    /**
     * Set the locale.
     *
     * @param locale the locale
     * @return the MessageContextGlobalSystem builder
     */
    public Builder locale(String locale) {
      this.locale = locale;
      return this;
    }

    /**
     * Set the referenceTime.
     *
     * @param referenceTime the referenceTime
     * @return the MessageContextGlobalSystem builder
     */
    public Builder referenceTime(String referenceTime) {
      this.referenceTime = referenceTime;
      return this;
    }
  }

  protected MessageContextGlobalSystem(Builder builder) {
    timezone = builder.timezone;
    userId = builder.userId;
    turnCount = builder.turnCount;
    locale = builder.locale;
    referenceTime = builder.referenceTime;
  }

  /**
   * New builder.
   *
   * @return a MessageContextGlobalSystem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the timezone.
   *
   * The user time zone. The assistant uses the time zone to correctly resolve relative time references.
   *
   * @return the timezone
   */
  public String timezone() {
    return timezone;
  }

  /**
   * Gets the userId.
   *
   * A string value that identifies the user who is interacting with the assistant. The client must provide a unique
   * identifier for each individual end user who accesses the application. For Plus and Premium plans, this user ID is
   * used to identify unique users for billing purposes. This string cannot contain carriage return, newline, or tab
   * characters.
   *
   * @return the userId
   */
  public String userId() {
    return userId;
  }

  /**
   * Gets the turnCount.
   *
   * A counter that is automatically incremented with each turn of the conversation. A value of 1 indicates that this is
   * the the first turn of a new conversation, which can affect the behavior of some skills (for example, triggering the
   * start node of a dialog).
   *
   * @return the turnCount
   */
  public Long turnCount() {
    return turnCount;
  }

  /**
   * Gets the locale.
   *
   * The language code for localization in the user input. The specified locale overrides the default for the assistant,
   * and is used for interpreting entity values in user input such as date values. For example, `04/03/2018` might be
   * interpreted either as April 3 or March 4, depending on the locale.
   *
   *  This property is included only if the new system entities are enabled for the skill.
   *
   * @return the locale
   */
  public String locale() {
    return locale;
  }

  /**
   * Gets the referenceTime.
   *
   * The base time for interpreting any relative time mentions in the user input. The specified time overrides the
   * current server time, and is used to calculate times mentioned in relative terms such as `now` or `tomorrow`. This
   * can be useful for simulating past or future times for testing purposes, or when analyzing documents such as news
   * articles.
   *
   * This value must be a UTC time value formatted according to ISO 8601 (for example, `2019-06-26T12:00:00Z` for noon
   * on 26 June 2019.
   *
   * This property is included only if the new system entities are enabled for the skill.
   *
   * @return the referenceTime
   */
  public String referenceTime() {
    return referenceTime;
  }
}

