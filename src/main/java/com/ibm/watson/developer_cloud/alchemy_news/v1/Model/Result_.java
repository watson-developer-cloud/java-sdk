
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

import java.util.ArrayList;
import java.util.List;

/**
 * Result_ by the {@link AlchemyDataNews} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Result_ {

    private List<Doc> docs = new ArrayList<Doc>();

    private String next;

    private String status;

    /**
     * @return The docs
     */
    public List<Doc> getDocs() {
        return docs;
    }

    /**
     * @param docs The docs
     */
    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

    public Result_ withDocs(List<Doc> docs) {
        this.docs = docs;
        return this;
    }

    /**
     * @return The next
     */
    public String getNext() {
        return next;
    }

    /**
     * @param next The next
     */
    public void setNext(String next) {
        this.next = next;
    }

    public Result_ withNext(String next) {
        this.next = next;
        return this;
    }

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public Result_ withStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result_ result_ = (Result_) o;

        if (docs != null ? !docs.equals(result_.docs) : result_.docs != null) return false;
        if (next != null ? !next.equals(result_.next) : result_.next != null) return false;
        return !(status != null ? !status.equals(result_.status) : result_.status != null);

    }

    @Override
    public int hashCode() {
        int result = docs != null ? docs.hashCode() : 0;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }
}
