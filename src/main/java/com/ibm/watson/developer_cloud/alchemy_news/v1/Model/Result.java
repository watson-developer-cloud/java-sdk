
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
 * Result by the {@link AlchemyDataNews} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Result {

    private String status;

    private String usage;

    private String totalTransactions;

    private Result_ result;

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

    public Result withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * @return The usage
     */
    public String getUsage() {
        return usage;
    }

    /**
     * @param usage The usage
     */
    public void setUsage(String usage) {
        this.usage = usage;
    }

    public Result withUsage(String usage) {
        this.usage = usage;
        return this;
    }

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

    public Result withTotalTransactions(String totalTransactions) {
        this.totalTransactions = totalTransactions;
        return this;
    }

    /**
     * @return The result
     */
    public Result_ getResult() {
        return result;
    }

    /**
     * @param result The result
     */
    public void setResult(Result_ result) {
        this.result = result;
    }

    public Result withResult(Result_ result) {
        this.result = result;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result1 = (Result) o;

        if (status != null ? !status.equals(result1.status) : result1.status != null) return false;
        if (usage != null ? !usage.equals(result1.usage) : result1.usage != null) return false;
        if (totalTransactions != null ? !totalTransactions.equals(result1.totalTransactions) : result1.totalTransactions != null)
            return false;
        return !(result != null ? !result.equals(result1.result) : result1.result != null);

    }

    @Override
    public int hashCode() {
        int result1 = status != null ? status.hashCode() : 0;
        result1 = 31 * result1 + (usage != null ? usage.hashCode() : 0);
        result1 = 31 * result1 + (totalTransactions != null ? totalTransactions.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return String.format("Result [status=%s,usage=%s,totalTransactions=%s]", status, usage, totalTransactions);
    }
}
