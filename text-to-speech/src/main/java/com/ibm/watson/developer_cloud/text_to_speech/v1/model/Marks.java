package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

import java.util.List;

public class Marks extends GenericModel {
  private List<MarkTiming> marks;

  public List<MarkTiming> getMarks() {
    return marks;
  }
}
