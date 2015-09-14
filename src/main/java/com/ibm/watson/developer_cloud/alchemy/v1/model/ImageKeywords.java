
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

package com.ibm.watson.developer_cloud.alchemy.v1.model;


import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyVision;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Image by the {@link AlchemyVision} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class ImageKeywords {

    /** The url. */
    private String url;

    /** The total transactions. */
    private Integer totalTransactions;

    /** The image keywords. */
    private List<ImageKeyword> imageKeywords = new ArrayList<ImageKeyword>();

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
     * @return the image keywords
     */
    public ImageKeywords withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Gets the total transactions.
     *
     * @return The totalTransactions
     */
    public Integer getTotalTransactions() {
        return totalTransactions;
    }

    /**
     * Sets the total transactions.
     *
     * @param totalTransactions The totalTransactions
     */
    public void setTotalTransactions(Integer totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    /**
     * Gets the image keywords.
     *
     * @return The imageKeywords
     */
    public List<ImageKeyword> getImageKeywords() {
        return imageKeywords;
    }

    /**
     * Sets the image keywords.
     *
     * @param imageKeywords The imageKeywords
     */
    public void setImageKeywords(List<ImageKeyword> imageKeywords) {
        this.imageKeywords = imageKeywords;
    }

    /**
     * With image keywords.
     *
     * @param imageKeywords the image keywords
     * @return the image keywords
     */
    public ImageKeywords withImageKeywords(List<ImageKeyword> imageKeywords) {
        this.imageKeywords = imageKeywords;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageKeywords image = (ImageKeywords) o;

        if (url != null ? !url.equals(image.url) : image.url != null) return false;
        if (totalTransactions != null ? !totalTransactions.equals(image.totalTransactions) : image.totalTransactions != null)
            return false;
        return !(imageKeywords != null ? !imageKeywords.equals(image.imageKeywords) : image.imageKeywords != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (totalTransactions != null ? totalTransactions.hashCode() : 0);
        result = 31 * result + (imageKeywords != null ? imageKeywords.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }
}
