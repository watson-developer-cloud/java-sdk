package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import com.google.gson.annotations.JsonAdapter;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.MarkTimingTypeAdapter;

@JsonAdapter(MarkTimingTypeAdapter.class)
public class MarkTiming extends GenericModel {
  private String mark;
  private Double time;

  public String getMark() {
    return mark;
  }

  public Double getTime() {
    return time;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }

  public void setTime(Double time) {
    this.time = time;
  }
}
