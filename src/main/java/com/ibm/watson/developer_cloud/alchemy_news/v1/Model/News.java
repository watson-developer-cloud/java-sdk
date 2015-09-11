
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
 * News returned by the {@link AlchemyDataNews} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class News {

    private String totalTransactions;

    private Result result;

    /**
     * @return The totalTransactions
     */
    public String getTotalTransactions() {
        return totalTransactions;
    }

    /**
     * @param totalTransactions The totalTransactions
     */
    public void setTotalTransactions(String totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public News withTotalTransactions(String totalTransactions) {
        this.totalTransactions = totalTransactions;
        return this;
    }

    /**
     * @return The result
     */
    public Result getResult() {
        return result;
    }

    /**
     * @param result The result
     */
    public void setResult(Result result) {
        this.result = result;
    }

    public News withResult(Result result) {
        this.result = result;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (totalTransactions != null ? !totalTransactions.equals(news.totalTransactions) : news.totalTransactions != null)
            return false;
        return !(result != null ? !result.equals(news.result) : news.result != null);

    }

    @Override
    public int hashCode() {
        int result1 = totalTransactions != null ? totalTransactions.hashCode() : 0;
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }
}
