package com.ibm.watson.text_to_speech.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

public class Timings extends GenericModel {
  private List<WordTiming> words;

  public List<WordTiming> getWords() {
    return words;
  }
}
