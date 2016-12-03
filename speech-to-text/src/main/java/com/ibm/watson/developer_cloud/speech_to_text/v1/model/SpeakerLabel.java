package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by afaisman on 12/2/16.
 */
public class SpeakerLabel {

  private Double from;
  private Double to;
  private int speaker;

  @SerializedName("final")
  private boolean _final;

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

  public int getSpeaker() {
    return speaker;
  }

  public void setSpeaker(int speaker) {
    this.speaker = speaker;
  }

  public boolean isFinal() {
    return _final;
  }

  public void setFinal(boolean ffinal) {
    this._final = ffinal;
  }

}
