package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * This object represents the input for Tone Chat analysis. It contains a list of utterances.
 */
public class ToneChatInput {

    @SerializedName("utterances")
    List<Utterance> utterances;

    /**
     * Gets the utterances.
     * @return the utterances
     */
    public List<Utterance> getUtterances() {
        return utterances;
    }

    /**
     * Sets the utterances.
     * @param utterances the new utterances
     */
    public void setUtterances(List<Utterance> utterances) {
        this.utterances = utterances;
    }
}
