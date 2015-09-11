
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
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Feeds returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Feeds {

    /** The url. */
    private String url;

    /** The feeds. */
    private List<Object> feeds = new ArrayList<Object>();

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
     * @return the feeds
     */
    public Feeds withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Gets the feeds.
     *
     * @return The feeds
     */
    public List<Object> getFeeds() {
        return feeds;
    }

    /**
     * Sets the feeds.
     *
     * @param feeds The feeds
     */
    public void setFeeds(List<Object> feeds) {
        this.feeds = feeds;
    }

    /**
     * With feeds.
     *
     * @param feeds the feeds
     * @return the feeds
     */
    public Feeds withFeeds(List<Object> feeds) {
        this.feeds = feeds;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feeds feeds1 = (Feeds) o;

        if (url != null ? !url.equals(feeds1.url) : feeds1.url != null) return false;
        return !(feeds != null ? !feeds.equals(feeds1.feeds) : feeds1.feeds != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (feeds != null ? feeds.hashCode() : 0);
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
