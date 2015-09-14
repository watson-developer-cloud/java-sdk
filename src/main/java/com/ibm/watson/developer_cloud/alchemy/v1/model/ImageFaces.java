/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibm.watson.developer_cloud.alchemy.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyVision;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * FaceTag by the {@link AlchemyVision} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class ImageFaces {

    /** The url. */
    private String url;

    /** The image faces. */
    private List<ImageFace> imageFaces = new ArrayList<ImageFace>();

    /**
     * Gets the url.
     *
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url.
     *
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * With url.
     *
     * @param url the url
     * @return the image faces
     */
    public ImageFaces withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Gets the image faces.
     *
     * @return The imageFaces
     */
    public List<ImageFace> getImageFaces() {
        return imageFaces;
    }

    /**
     * Sets the image faces.
     *
     * @param imageFaces The imageFaces
     */
    public void setImageFaces(List<ImageFace> imageFaces) {
        this.imageFaces = imageFaces;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageFaces faceTag = (ImageFaces) o;

        if (url != null ? !url.equals(faceTag.url) : faceTag.url != null) return false;
        return !(imageFaces != null ? !imageFaces.equals(faceTag.imageFaces) : faceTag.imageFaces != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (imageFaces != null ? imageFaces.hashCode() : 0);
        return result;
    }

    /**
     * With image faces.
     *
     * @param imageFaces the image faces
     * @return the image faces
     */
    public ImageFaces withImageFaces(List<ImageFace> imageFaces) {
        this.imageFaces = imageFaces;
        return this;

    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }

}
