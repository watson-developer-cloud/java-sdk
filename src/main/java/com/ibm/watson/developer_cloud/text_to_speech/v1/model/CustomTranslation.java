package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class CustomTranslation extends GenericModel {

  private String word;

  private String translation;

  public CustomTranslation() {
    super();
  }

  public CustomTranslation(String word, String translation) {
    this();
    setWord(word);
    setTranslation(translation);
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public String getTranslation() {
    return translation;
  }

  public void setTranslation(String translation) {
    this.translation = translation;
  }

}
