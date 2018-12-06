package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

import java.util.List;

public class Timings extends GenericModel {
  private List<WordTiming> words;

  public List<WordTiming> getWords() {
    return words;
  }
}
