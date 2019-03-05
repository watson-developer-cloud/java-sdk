package com.ibm.watson.text_to_speech.v1.model;

import com.google.gson.annotations.JsonAdapter;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.watson.text_to_speech.v1.util.WordTimingTypeAdapter;

@JsonAdapter(WordTimingTypeAdapter.class)
public class WordTiming extends GenericModel {
  private String word;
  private Double startTime;
  private Double endTime;

  public String getWord() {
    return word;
  }

  public Double getStartTime() {
    return startTime;
  }

  public Double getEndTime() {
    return endTime;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public void setStartTime(Double startTime) {
    this.startTime = startTime;
  }

  public void setEndTime(Double endTime) {
    this.endTime = endTime;
  }
}
