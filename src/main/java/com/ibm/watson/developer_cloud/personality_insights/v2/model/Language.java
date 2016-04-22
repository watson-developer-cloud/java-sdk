package com.ibm.watson.developer_cloud.personality_insights.v2.model;

import com.google.gson.annotations.SerializedName;

/**
 * Personality Insights supported languages.
 */
public enum Language {
  @SerializedName("en") ENGLISH("en"),
  @SerializedName("es") SPANISH("es");

  private final String text;

  /**
   * @param text
   */
  private Language(final String text) {
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
