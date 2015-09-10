
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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.alchemy_language.v1.AlchemyLanguage;

/**
 * Language returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Language {

    /** The url. */
    private String url;

    /** The language. */
    private String language;

    /** The iso6391. */
    @SerializedName("iso-639-1")
    private String iso6391;

    /** The iso6392. */
    @SerializedName("iso-639-2")
    private String iso6392;

    /** The iso6393. */
    @SerializedName("iso-639-3")
    private String iso6393;

    /** The ethnologue. */
    private String ethnologue;

    /** The native speakers. */
    @SerializedName("native-speakers")
    private String nativeSpeakers;

    /** The wikipedia. */
    private String wikipedia;

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
     * @return the language
     */
    public Language withUrl(String url) {
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
     * @return the language
     */
    public Language withLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     * Gets the iso6391.
     *
     * @return The iso6391
     */
    public String getIso6391() {
        return iso6391;
    }

    /**
     * Sets the iso6391.
     *
     * @param iso6391 The iso-639-1
     */
    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    /**
     * With iso6391.
     *
     * @param iso6391 the iso6391
     * @return the language
     */
    public Language withIso6391(String iso6391) {
        this.iso6391 = iso6391;
        return this;
    }

    /**
     * Gets the iso6392.
     *
     * @return The iso6392
     */
    public String getIso6392() {
        return iso6392;
    }

    /**
     * Sets the iso6392.
     *
     * @param iso6392 The iso-639-2
     */
    public void setIso6392(String iso6392) {
        this.iso6392 = iso6392;
    }

    /**
     * With iso6392.
     *
     * @param iso6392 the iso6392
     * @return the language
     */
    public Language withIso6392(String iso6392) {
        this.iso6392 = iso6392;
        return this;
    }

    /**
     * Gets the iso6393.
     *
     * @return The iso6393
     */
    public String getIso6393() {
        return iso6393;
    }

    /**
     * Sets the iso6393.
     *
     * @param iso6393 The iso-639-3
     */
    public void setIso6393(String iso6393) {
        this.iso6393 = iso6393;
    }

    /**
     * With iso6393.
     *
     * @param iso6393 the iso6393
     * @return the language
     */
    public Language withIso6393(String iso6393) {
        this.iso6393 = iso6393;
        return this;
    }

    /**
     * Gets the ethnologue.
     *
     * @return The ethnologue
     */
    public String getEthnologue() {
        return ethnologue;
    }

    /**
     * Sets the ethnologue.
     *
     * @param ethnologue The ethnologue
     */
    public void setEthnologue(String ethnologue) {
        this.ethnologue = ethnologue;
    }

    /**
     * With ethnologue.
     *
     * @param ethnologue the ethnologue
     * @return the language
     */
    public Language withEthnologue(String ethnologue) {
        this.ethnologue = ethnologue;
        return this;
    }

    /**
     * Gets the native speakers.
     *
     * @return The nativeSpeakers
     */
    public String getNativeSpeakers() {
        return nativeSpeakers;
    }

    /**
     * Sets the native speakers.
     *
     * @param nativeSpeakers The native-speakers
     */
    public void setNativeSpeakers(String nativeSpeakers) {
        this.nativeSpeakers = nativeSpeakers;
    }

    /**
     * With native speakers.
     *
     * @param nativeSpeakers the native speakers
     * @return the language
     */
    public Language withNativeSpeakers(String nativeSpeakers) {
        this.nativeSpeakers = nativeSpeakers;
        return this;
    }

    /**
     * Gets the wikipedia.
     *
     * @return The wikipedia
     */
    public String getWikipedia() {
        return wikipedia;
    }

    /**
     * Sets the wikipedia.
     *
     * @param wikipedia The wikipedia
     */
    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    /**
     * With wikipedia.
     *
     * @param wikipedia the wikipedia
     * @return the language
     */
    public Language withWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Language language1 = (Language) o;

        if (url != null ? !url.equals(language1.url) : language1.url != null) return false;
        if (language != null ? !language.equals(language1.language) : language1.language != null) return false;
        if (iso6391 != null ? !iso6391.equals(language1.iso6391) : language1.iso6391 != null) return false;
        if (iso6392 != null ? !iso6392.equals(language1.iso6392) : language1.iso6392 != null) return false;
        if (iso6393 != null ? !iso6393.equals(language1.iso6393) : language1.iso6393 != null) return false;
        if (ethnologue != null ? !ethnologue.equals(language1.ethnologue) : language1.ethnologue != null) return false;
        if (nativeSpeakers != null ? !nativeSpeakers.equals(language1.nativeSpeakers) : language1.nativeSpeakers != null)
            return false;
        return !(wikipedia != null ? !wikipedia.equals(language1.wikipedia) : language1.wikipedia != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (iso6391 != null ? iso6391.hashCode() : 0);
        result = 31 * result + (iso6392 != null ? iso6392.hashCode() : 0);
        result = 31 * result + (iso6393 != null ? iso6393.hashCode() : 0);
        result = 31 * result + (ethnologue != null ? ethnologue.hashCode() : 0);
        result = 31 * result + (nativeSpeakers != null ? nativeSpeakers.hashCode() : 0);
        result = 31 * result + (wikipedia != null ? wikipedia.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Language [url=%s,language=%s,ethnologue=%s,nativeSpeakers=%s,wikipedia=%s]", url, language, ethnologue, nativeSpeakers, wikipedia);
    }
}
