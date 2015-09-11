
/*
 * *
 *  * Copyright 2015 IBM Corp. All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.ibm.watson.developer_cloud.alchemy_vision.v1.model;

import com.ibm.watson.developer_cloud.alchemy_vision.v1.AlchemyVision;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import java.util.ArrayList;
import java.util.List;

/**
 * FaceTag by the {@link AlchemyVision} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class ImageFaces {


    private String url;

    private String totalTransactions;

    private List<ImageFace> imageFaces = new ArrayList<ImageFace>();

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public ImageFaces withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * @return The totalTransactions
     */
    public String getTotalTransactions() {
        return totalTransactions;
    }

    /**
     * @param totalTransactions The totalTransactions
     */
    public void setTotalTransactions(String totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public ImageFaces withTotalTransactions(String totalTransactions) {
        this.totalTransactions = totalTransactions;
        return this;
    }

    /**
     * @return The imageFaces
     */
    public List<ImageFace> getImageFaces() {
        return imageFaces;
    }

    /**
     * @param imageFaces The imageFaces
     */
    public void setImageFaces(List<ImageFace> imageFaces) {
        this.imageFaces = imageFaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageFaces faceTag = (ImageFaces) o;

        if (url != null ? !url.equals(faceTag.url) : faceTag.url != null) return false;
        if (totalTransactions != null ? !totalTransactions.equals(faceTag.totalTransactions) : faceTag.totalTransactions != null)
            return false;
        return !(imageFaces != null ? !imageFaces.equals(faceTag.imageFaces) : faceTag.imageFaces != null);

    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (totalTransactions != null ? totalTransactions.hashCode() : 0);
        result = 31 * result + (imageFaces != null ? imageFaces.hashCode() : 0);
        return result;
    }

    public ImageFaces withImageFaces(List<ImageFace> imageFaces) {
        this.imageFaces = imageFaces;
        return this;

    }

    @Override
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }

}
