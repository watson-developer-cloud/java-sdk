package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import com.google.gson.annotations.SerializedName;

/**
 * This object represents an utterance of a conversation. It has the text and the user who said this utterance.
 * The user field is optional
 */
public class Utterance {

    @SerializedName("text")
    String text;

    @SerializedName("user")
    String user;

    private Utterance(Builder builder) {
        this.text = builder.text;
        this.user = builder.user;
    }

    /**
     * Gets the text.
     * @return the text
     */
    public String getText() {

        return text;
    }

    /**
     * Gets the user.
     * @return the user
     */
    public String getUser() {
        return user;
    }

    public static class Builder {
        String text;

        String user;

        public Builder(String text, String user) {
            this.text = text;
            this.user = user;
        }

        public Builder(String text) {
            this.text = text;
        }

        public Utterance build() {
            return new Utterance(this);
        }
    }
}
