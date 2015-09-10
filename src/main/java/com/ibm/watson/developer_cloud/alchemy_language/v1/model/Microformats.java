
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

package com.ibm.watson.developer_cloud.alchemy_language.v1.model;

import com.ibm.watson.developer_cloud.alchemy_language.v1.AlchemyLanguage;

import java.util.ArrayList;
import java.util.List;

/**
 * Microformats returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Microformats {

    /** The url. */
    private String url;

    /** The microformats. */
    private List<Object> microformats = new ArrayList<Object>();

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
     * @return the microformats
     */
    public Microformats withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Gets the microformats.
     *
     * @return The microformats
     */
    public List<Object> getMicroformats() {
        return microformats;
    }

    /**
     * Sets the microformats.
     *
     * @param microformats The microformats
     */
    public void setMicroformats(List<Object> microformats) {
        this.microformats = microformats;
    }

    /**
     * With microformats.
     *
     * @param microformats the microformats
     * @return the microformats
     */
    public Microformats withMicroformats(List<Object> microformats) {
        this.microformats = microformats;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Microformats that = (Microformats) o;

        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        return !(microformats != null ? !microformats.equals(that.microformats) : that.microformats != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (microformats != null ? microformats.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Microformats [url=%s]", url);
    }
}
