
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

package com.ibm.watson.developer_cloud.alchemy_news.v1.Model;

import com.ibm.watson.developer_cloud.alchemy_news.v1.AlchemyDataNews;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Url by the {@link AlchemyDataNews} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Url {

    private String author;

    private EnrichedTitle enrichedTitle;

    private PublicationDate publicationDate;

    private String title;

    private String url;

    /**
     * @return The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    public Url withAuthor(String author) {
        this.author = author;
        return this;
    }

    /**
     * @return The enrichedTitle
     */
    public EnrichedTitle getEnrichedTitle() {
        return enrichedTitle;
    }

    /**
     * @param enrichedTitle The enrichedTitle
     */
    public void setEnrichedTitle(EnrichedTitle enrichedTitle) {
        this.enrichedTitle = enrichedTitle;
    }

    public Url withEnrichedTitle(EnrichedTitle enrichedTitle) {
        this.enrichedTitle = enrichedTitle;
        return this;
    }

    /**
     * @return The publicationDate
     */
    public PublicationDate getPublicationDate() {
        return publicationDate;
    }

    /**
     * @param publicationDate The publicationDate
     */
    public void setPublicationDate(PublicationDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Url withPublicationDate(PublicationDate publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public Url withTitle(String title) {
        this.title = title;
        return this;
    }

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

    public Url withUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Url url1 = (Url) o;

        if (author != null ? !author.equals(url1.author) : url1.author != null) return false;
        if (enrichedTitle != null ? !enrichedTitle.equals(url1.enrichedTitle) : url1.enrichedTitle != null)
            return false;
        if (publicationDate != null ? !publicationDate.equals(url1.publicationDate) : url1.publicationDate != null)
            return false;
        if (title != null ? !title.equals(url1.title) : url1.title != null) return false;
        return !(url != null ? !url.equals(url1.url) : url1.url != null);

    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (enrichedTitle != null ? enrichedTitle.hashCode() : 0);
        result = 31 * result + (publicationDate != null ? publicationDate.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }
}
