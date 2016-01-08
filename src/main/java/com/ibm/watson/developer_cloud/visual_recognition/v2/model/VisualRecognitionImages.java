/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.watson.developer_cloud.visual_recognition.v2.model;

import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class VisualRecognitionImages.
 */
public class VisualRecognitionImages extends GenericModel {

    /** The images. */
    @Expose
    private List<com.ibm.watson.developer_cloud.visual_recognition.v2.model.RecognizedImage> images = new ArrayList<com.ibm.watson.developer_cloud.visual_recognition.v2.model.RecognizedImage>();

    /**
     * Gets the first recognized image.
     *
     * @return the first recognized image
     */
    public com.ibm.watson.developer_cloud.visual_recognition.v2.model.RecognizedImage getFirstImage() {
        if (images != null && !images.isEmpty())
            return images.get(0);
        else
            return null;
    }

    /**
     * Gets the images.
     *
     * @return The images
     */
    public List<com.ibm.watson.developer_cloud.visual_recognition.v2.model.RecognizedImage> getImages() {
        return images;
    }

    /**
     * Sets the images.
     *
     * @param images The images
     */
    public void setImages(List<com.ibm.watson.developer_cloud.visual_recognition.v2.model.RecognizedImage> images) {
        this.images = images;
    }
}
