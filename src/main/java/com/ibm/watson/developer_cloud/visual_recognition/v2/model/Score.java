package com.ibm.watson.developer_cloud.visual_recognition.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class Score.
 */
public class Score extends GenericModel {

    /**
     * The classifier id.
     */
    @SerializedName("classifier_id")
    private String classifier_id;

    /**
     * The classifier name.
     */
    @SerializedName("name")
    private String name;

    /**
     * The classifier score.
     */
    @SerializedName("score")
    private double score;

    /**
     * Gets the classifier id.
     *
     * @return The classifier id
     */
    public String getClassifier_id() {
        return classifier_id;
    }

    /**
     * Sets the classifier id.
     *
     * @param classifier_id The classifier id
     */
    public void setClassifier_id(String classifier_id) {
        this.classifier_id = classifier_id;
    }

    /**
     * Gets the classifier name.
     *
     * @return The classifier name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the classifier name.
     *
     * @param name The classifier name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the classifier score.
     *
     * @return The classifier score
     */
    public double getScore() {
        return score;
    }

    /**
     * Sets the classifier score.
     *
     * @param score The classifier score
     */
    public void setScore(double score) {
        this.score = score;
    }
}
