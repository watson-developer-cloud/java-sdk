package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

import java.util.List;

/**
 * Created by Focuson on 16-7-13.
 */
public class SpeechWordAlternative extends GenericModel {
    @SerializedName("start_time")
    private Double startTime;

    /*
     * alternative in word_alternatives
     */
    List<WordAlternative> alternatives;

    @SerializedName("end_time")
    private Double endTime;

    public Double getStartTime() {
        return startTime;
    }

    public void setStartTime(Double startTime) {
        this.startTime = startTime;
    }

    public List<WordAlternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<WordAlternative> alternatives) {
        this.alternatives = alternatives;
    }

    public Double getEndTime() {
        return endTime;
    }

    public void setEndTime(Double endTime) {
        this.endTime = endTime;
    }
}
