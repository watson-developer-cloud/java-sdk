package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

import java.util.List;

/**
 * Main object containing the result of running the Tone Analyzer Chat Analysis on a conversation. It contains a list
 * of utterance-level analysis results.
 */
public class UtterancesTone extends GenericModel {

  @SerializedName("utterances_tone")
  List<UtteranceAnalysis> utterancesTone;

  /**
   * Gets the utterances tone.
   * @return the utterances tone
   */
  public List<UtteranceAnalysis> getUtterancesTone() {
    return utterancesTone;
  }

  /**
   * Sets the utterances tone.
   * @param utterancesTone the new utterances tone
   */
  public void setUtterancesTone(List<UtteranceAnalysis> utterancesTone) {
    this.utterancesTone = utterancesTone;
  }

}
