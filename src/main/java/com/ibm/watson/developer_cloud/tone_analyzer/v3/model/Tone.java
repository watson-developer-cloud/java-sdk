package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

public enum Tone {

  EMOTION("emotion"), SOCIAL("social"), LANGUAGE("language");

  String tone;

  Tone(String tone) {
    this.tone = tone;
  }

  public String toString() {
    return tone;
  }
}
