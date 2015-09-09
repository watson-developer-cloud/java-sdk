
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

/**
 * Doc returned by the {@link AlchemyDataNews} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Doc {


    private String id;

    private Source source;

    private int timestamp;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Doc withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return The source
     */
    public Source getSource() {
        return source;
    }

    /**
     * @param source The source
     */
    public void setSource(Source source) {
        this.source = source;
    }

    public Doc withSource(Source source) {
        this.source = source;
        return this;
    }

    /**
     * @return The timestamp
     */
    public int getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp The timestamp
     */
    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public Doc withTimestamp(int timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doc doc = (Doc) o;

        if (timestamp != doc.timestamp) return false;
        if (id != null ? !id.equals(doc.id) : doc.id != null) return false;
        return !(source != null ? !source.equals(doc.source) : doc.source != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + timestamp;
        return result;
    }

    @Override
    public String toString() {
        return String.format("Doc [id=%s,source=%s]", id, source);
    }
}
