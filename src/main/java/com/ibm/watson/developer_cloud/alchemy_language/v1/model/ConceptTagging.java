/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibm.watson.developer_cloud.alchemy_language.v1.model;

import com.ibm.watson.developer_cloud.alchemy_language.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import java.util.ArrayList;
import java.util.List;

/**
 * ConceptTagging returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class ConceptTagging {

    /** The status. */
    private String status;

    /** The usage. */
    private String usage;

    /** The url. */
    private String url;

    /** The language. */
    private String language;

    /** The text. */
    private String text;

    /** The concepts. */
    private List<Concept> concepts = new ArrayList<Concept>();

    /**
     * Gets the status.
     *
     * @return     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * With status.
     *
     * @param status the status
     * @return the concept tagging
     */
    public ConceptTagging withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * Gets the usage.
     *
     * @return     The usage
     */
    public String getUsage() {
        return usage;
    }

    /**
     * Sets the usage.
     *
     * @param usage     The usage
     */
    public void setUsage(String usage) {
        this.usage = usage;
    }

    /**
     * With usage.
     *
     * @param usage the usage
     * @return the concept tagging
     */
    public ConceptTagging withUsage(String usage) {
        this.usage = usage;
        return this;
    }

    /**
     * Gets the url.
     *
     * @return     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url.
     *
     * @param url     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * With url.
     *
     * @param url the url
     * @return the concept tagging
     */
    public ConceptTagging withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Gets the language.
     *
     * @return     The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the language.
     *
     * @param language     The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * With language.
     *
     * @param language the language
     * @return the concept tagging
     */
    public ConceptTagging withLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     * Gets the text.
     *
     * @return     The text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text.
     *
     * @param text     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * With text.
     *
     * @param text the text
     * @return the concept tagging
     */
    public ConceptTagging withText(String text) {
        this.text = text;
        return this;
    }

    /**
     * Gets the concepts.
     *
     * @return     The concepts
     */
    public List<Concept> getConcepts() {
        return concepts;
    }

    /**
     * Sets the concepts.
     *
     * @param concepts     The concepts
     */
    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }

    /**
     * With concepts.
     *
     * @param concepts the concepts
     * @return the concept tagging
     */
    public ConceptTagging withConcepts(List<Concept> concepts) {
        this.concepts = concepts;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConceptTagging that = (ConceptTagging) o;

        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (usage != null ? !usage.equals(that.usage) : that.usage != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        return !(concepts != null ? !concepts.equals(that.concepts) : that.concepts != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (usage != null ? usage.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (concepts != null ? concepts.hashCode() : 0);
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
