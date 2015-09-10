
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

import java.util.ArrayList;
import java.util.List;

/**
 * Image by the {@link AlchemyVision} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Image {

    private String url;

    private String totalTransactions;

    private List<ImageKeyword> imageKeywords = new ArrayList<ImageKeyword>();

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

    public Image withUrl(String url) {
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

    public Image withTotalTransactions(String totalTransactions) {
        this.totalTransactions = totalTransactions;
        return this;
    }

    /**
     * @return The imageKeywords
     */
    public List<ImageKeyword> getImageKeywords() {
        return imageKeywords;
    }

    /**
     * @param imageKeywords The imageKeywords
     */
    public void setImageKeywords(List<ImageKeyword> imageKeywords) {
        this.imageKeywords = imageKeywords;
    }

    public Image withImageKeywords(List<ImageKeyword> imageKeywords) {
        this.imageKeywords = imageKeywords;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (url != null ? !url.equals(image.url) : image.url != null) return false;
        if (totalTransactions != null ? !totalTransactions.equals(image.totalTransactions) : image.totalTransactions != null)
            return false;
        return !(imageKeywords != null ? !imageKeywords.equals(image.imageKeywords) : image.imageKeywords != null);

    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (totalTransactions != null ? totalTransactions.hashCode() : 0);
        result = 31 * result + (imageKeywords != null ? imageKeywords.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Image [url=%s,totalTransactions=%s,image=%s]", url, totalTransactions);
    }
}
