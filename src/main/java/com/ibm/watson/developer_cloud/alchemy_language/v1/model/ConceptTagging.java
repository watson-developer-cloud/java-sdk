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

import java.util.ArrayList;
import java.util.List;

/**
 * ConceptTagging returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class ConceptTagging {

    private String status;

    private String usage;

    private String url;

    private String language;

    private String text;

    private List<Concept> concepts = new ArrayList<Concept>();

    /**
     *
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public ConceptTagging withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     *
     * @return
     *     The usage
     */
    public String getUsage() {
        return usage;
    }

    /**
     *
     * @param usage
     *     The usage
     */
    public void setUsage(String usage) {
        this.usage = usage;
    }

    public ConceptTagging withUsage(String usage) {
        this.usage = usage;
        return this;
    }

    /**
     *
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public ConceptTagging withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     *
     * @return
     *     The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     *
     * @param language
     *     The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    public ConceptTagging withLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     *
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    public ConceptTagging withText(String text) {
        this.text = text;
        return this;
    }

    /**
     *
     * @return
     *     The concepts
     */
    public List<Concept> getConcepts() {
        return concepts;
    }

    /**
     *
     * @param concepts
     *     The concepts
     */
    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }

    public ConceptTagging withConcepts(List<Concept> concepts) {
        this.concepts = concepts;
        return this;
    }

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

    @Override
    public String toString() {
        return String.format("ConceptTagging [status=%s,usage=%s,url=%s,language=%s,text=%s]", status, usage, url, language, text);
    }
}
