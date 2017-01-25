package com.ibm.watson.developer_cloud.android.library.audio.utils;

/**
 * Audio content type presets for use with Watson Developer Cloud Java SDK Speech to Text
 */
public enum ContentType {
  RAW("audio/l16;rate=16000"), OPUS("audio/ogg;codec=opus");

  private String value;
  ContentType(String theValue) {
    value = theValue;
  }

  @Override
  public String toString() {
    return value;
  }
}
