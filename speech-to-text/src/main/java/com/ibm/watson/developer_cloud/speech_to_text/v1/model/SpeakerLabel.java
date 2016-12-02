package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by afaisman on 12/2/16.
 */
public class SpeakerLabel {

  private double from;
  private double to;
  private int speaker;

  @SerializedName("final")
  private boolean ffinal;

  public double getFrom() {
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

  public int getSpeaker() {
    return speaker;
  }

  public void setSpeaker(int speaker) {
    this.speaker = speaker;
  }

  public boolean isFfinal() {
    return ffinal;
  }

  public void setFfinal(boolean ffinal) {
    this.ffinal = ffinal;
  }

}
