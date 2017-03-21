/*
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

package com.ibm.watson.developer_cloud.personality_insights.v3.model;

import com.google.gson.annotations.SerializedName;

/**
 * Personality Insights supported languages for {@link Profile}s.
 */
public enum AcceptLanguage {

  @SerializedName("ar") ARABIC("ar"),
  @SerializedName("en") ENGLISH("en"),
  @SerializedName("es") SPANISH("es"),
  @SerializedName("ja") JAPANESE("ja"),
  @SerializedName("pt-br") BRAZILIAN_PORTUGUESE("pt-br"),
  @SerializedName("fr") FRENCH("fr"),
  @SerializedName("de") GERMAN("de"),
  @SerializedName("it") ITALIAN("it"),
  @SerializedName("ko") KOREAN("ko"),
  @SerializedName("zh-cn") SIMPLIFIED_CHINESE("zh-cn"),
  @SerializedName("zh-tw") TRADITIONAL_CHINESE("zh-tw");

  private final String text;

  /**
   * Instantiates a new accept language.
   *
   * @param text the text
   */
  AcceptLanguage(final String text) {
    this.text = text;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Enum#toString()
   */
  @Override
  public String toString() {
    return text;
  }
}
