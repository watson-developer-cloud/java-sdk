
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
 * Text returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Text {


    /** The url. */
    private String url;

    /** The language. */
    private String language;

    /** The text. */
    private String text;

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
     * @return the text
     */
    public Text withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Gets the language.
     *
     * @return The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the language.
     *
     * @param language The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * With language.
     *
     * @param language the language
     * @return the text
     */
    public Text withLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     * Gets the text.
     *
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text.
     *
     * @param text The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * With text.
     *
     * @param text the text
     * @return the text
     */
    public Text withText(String text) {
        this.text = text;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text1 = (Text) o;

        if (url != null ? !url.equals(text1.url) : text1.url != null) return false;
        if (language != null ? !language.equals(text1.language) : text1.language != null) return false;
        return !(text != null ? !text.equals(text1.text) : text1.text != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Text [url=%s,language=%s,text=%s]", url, language, text);
    }
}
