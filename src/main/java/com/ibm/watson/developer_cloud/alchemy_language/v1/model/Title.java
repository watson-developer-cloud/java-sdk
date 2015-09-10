
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

/**
 * Title returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Title {

    /** The url. */
    private String url;

    /** The title. */
    private String title;

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
     * @return the title
     */
    public Title withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Gets the title.
     *
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * With title.
     *
     * @param title the title
     * @return the title
     */
    public Title withTitle(String title) {
        this.title = title;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Title title1 = (Title) o;

        if (url != null ? !url.equals(title1.url) : title1.url != null) return false;
        return !(title != null ? !title.equals(title1.title) : title1.title != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Title [url=%s,title=%s]", url, title);
    }
}
