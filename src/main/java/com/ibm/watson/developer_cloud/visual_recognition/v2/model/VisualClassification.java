package com.ibm.watson.developer_cloud.visual_recognition.v2.model;

import java.io.File;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.visual_recognition.v2.VisualRecognition;

/**
 * The visual classification of images used by the
 * {@link VisualRecognition#classify(File, VisualClassifier...)} method.
 * 
 */
public class VisualClassification extends GenericModel {

  /**
   * The classified image
   */
  public class Image {

    private String image;

    private List<Score> scores;

    /**
     * Gets the image.
     * 
     * @return The image
     */
    public String getImage() {
      return image;
    }

    /**
     * Gets the scores.
     * 
     * @return The scores
     */
    public List<Score> getScores() {
      return scores;
    }

    /**
     * Sets the image.
     * 
     * @param image The image
     */
    public void setImage(String image) {
      this.image = image;
    }

    /**
     * Sets the scores.
     * 
     * @param scores The scores
     */
    public void setScores(List<Score> scores) {
      this.scores = scores;
    }

  }

  /**
   * The classification scores.
   */
  public class Score {

    @SerializedName("classifier_id")
    private String classifierId;
    private String name;
    private Double score;

    /**
     * Gets the classifier id.
     * 
     * @return The classifierId
     */
    public String getClassifierId() {
      return classifierId;
    }

    /**
     * Gets the name.
     * 
     * @return The name
     */
    public String getName() {
      return name;
    }

    /**
     * Gets the score.
     * 
     * @return The score
     */
    public Double getScore() {
      return score;
    }

    /**
     * Sets the classifier id.
     * 
     * @param classifierId The classifier_id
     */
    public void setClassifierId(String classifierId) {
      this.classifierId = classifierId;
    }

    /**
     * Sets the name.
     * 
     * @param name The name
     */
    public void setName(String name) {
      this.name = name;
    }

    /**
     * Sets the score.
     * 
     * @param score The score
     */
    public void setScore(Double score) {
      this.score = score;
    }

  }

  private List<Image> images;

  /**
   * Gets the images.
   * 
   * @return The images
   */
  public List<Image> getImages() {
    return images;
  }

  /**
   * Sets the images.
   * 
   * @param images The images
   */
  public void setImages(List<Image> images) {
    this.images = images;
  }

}
