/*
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.visual_recognition.v4.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The getJpegImage options. */
public class GetJpegImageOptions extends GenericModel {

  /**
   * The image size. Specify `thumbnail` to return a version that maintains the original aspect
   * ratio but is no larger than 200 pixels in the larger dimension. For example, an original 800 x
   * 1000 image is resized to 160 x 200 pixels.
   */
  public interface Size {
    /** full. */
    String FULL = "full";
    /** thumbnail. */
    String THUMBNAIL = "thumbnail";
  }

  protected String collectionId;
  protected String imageId;
  protected String size;

  /** Builder. */
  public static class Builder {
    private String collectionId;
    private String imageId;
    private String size;

    private Builder(GetJpegImageOptions getJpegImageOptions) {
      this.collectionId = getJpegImageOptions.collectionId;
      this.imageId = getJpegImageOptions.imageId;
      this.size = getJpegImageOptions.size;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param collectionId the collectionId
     * @param imageId the imageId
     */
    public Builder(String collectionId, String imageId) {
      this.collectionId = collectionId;
      this.imageId = imageId;
    }

    /**
     * Builds a GetJpegImageOptions.
     *
     * @return the getJpegImageOptions
     */
    public GetJpegImageOptions build() {
      return new GetJpegImageOptions(this);
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the GetJpegImageOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the imageId.
     *
     * @param imageId the imageId
     * @return the GetJpegImageOptions builder
     */
    public Builder imageId(String imageId) {
      this.imageId = imageId;
      return this;
    }

    /**
     * Set the size.
     *
     * @param size the size
     * @return the GetJpegImageOptions builder
     */
    public Builder size(String size) {
      this.size = size;
      return this;
    }
  }

  protected GetJpegImageOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.imageId, "imageId cannot be empty");
    collectionId = builder.collectionId;
    imageId = builder.imageId;
    size = builder.size;
  }

  /**
   * New builder.
   *
   * @return a GetJpegImageOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the collectionId.
   *
   * <p>The identifier of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the imageId.
   *
   * <p>The identifier of the image.
   *
   * @return the imageId
   */
  public String imageId() {
    return imageId;
  }

  /**
   * Gets the size.
   *
   * <p>The image size. Specify `thumbnail` to return a version that maintains the original aspect
   * ratio but is no larger than 200 pixels in the larger dimension. For example, an original 800 x
   * 1000 image is resized to 160 x 200 pixels.
   *
   * @return the size
   */
  public String size() {
    return size;
  }
}
