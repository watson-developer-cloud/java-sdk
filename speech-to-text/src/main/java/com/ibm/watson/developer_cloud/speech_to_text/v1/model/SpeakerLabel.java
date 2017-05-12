package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Speaker labels.
 */
public class SpeakerLabel extends GenericModel {

  private Double from;
  private Double to;
  private Double confidence;
  private int speaker;

  @SerializedName("final")
  private boolean ffinal;

  public Double getFrom() {
    return from;
  }

  public void setFrom(Double from) {
    this.from = from;
  }

  public Double getTo() {
    return to;
  }

  public void setTo(Double to) {
    this.to = to;
  }

  public Double getConfidence() {
    return confidence;
  }

  public void setConfidence(Double confidence) {
    this.confidence = confidence;
  }

  public int getSpeaker() {
    return speaker;
  }

  public void setSpeaker(int speaker) {
    this.speaker = speaker;
  }

  public boolean isFinal() {
    return ffinal;
  }

  public void setFinal(boolean ffinal) {
    this.ffinal = ffinal;
  }

}
