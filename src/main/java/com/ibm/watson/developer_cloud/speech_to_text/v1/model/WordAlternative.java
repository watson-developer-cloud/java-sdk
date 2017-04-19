package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.JsonAdapter;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Created by Focuson on 16-7-13.
 */
@JsonAdapter(WordAlternativeTypeAdapter.class)
public class WordAlternative extends GenericModel {

    private Double confidence;
    private String word;

    public WordAlternative(Double confidence, String word) {
        this.confidence = confidence;
        this.word = word;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
