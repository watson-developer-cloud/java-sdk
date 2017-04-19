package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

import java.util.List;

/**
 * This object represents the results of Tone Chat analysis on an utterance. It has the utterance text from the original
 * input. It holds a list of scores for individual chat tones.
 */
public class UtteranceAnalysis extends GenericModel {

  @SerializedName("utterance_id")
  Integer id;

  @SerializedName("utterance_text")
  String text;

  List<ToneScore> tones;

  /**
   * Gets the id.
   * @return the id
   */
  public Integer getId() {
      return id;
  }

  /**
   * Sets the id.
   * @param id the new id
   */
  public void setId(int id) {
      this.id = id;
  }

  /**
   * Gets the text.
   * @return the text
   */
  public String getText() {
      return text;
  }

  /**
   * Sets the text.
   * @param text the new text
   */
  public void setText(String text) {
      this.text = text;
  }

  /**
   * Gets the chat tones.
   * @return the chat tones
   */
  public List<ToneScore> getTones() {
      return tones;
  }

  /**
   * Sets the chat tones.
   * @param tones the new chat tones
   */
  public void setTones(List<ToneScore> tones) {
      this.tones = tones;
  }
}
