package com.ibm.watson.text_to_speech.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

import java.util.List;

public class Marks extends GenericModel {
  private List<MarkTiming> marks;

  public List<MarkTiming> getMarks() {
    return marks;
  }
}
