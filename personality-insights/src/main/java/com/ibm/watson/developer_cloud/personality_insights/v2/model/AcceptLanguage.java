/*
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
package com.ibm.watson.developer_cloud.personality_insights.v2.model;

import com.google.gson.annotations.SerializedName;

/**
 * Personality Insights supported languages for {@link Profile}s.
 */
public enum AcceptLanguage {
  
  /** english. */
  @SerializedName("en") ENGLISH("en"),
  
  /** spanish. */
  @SerializedName("es") SPANISH("es"),

  /** arabic. */
  @SerializedName("ar") ARABIC("ar"),

  /** japanese */
  @SerializedName("ja") JAPANESE("ja");

  private final String text;

  /**
   * @param text
   */
  private AcceptLanguage(final String text) {
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
