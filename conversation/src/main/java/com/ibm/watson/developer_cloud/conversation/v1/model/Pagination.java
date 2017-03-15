/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.conversation.v1.model;

import com.google.gson.annotations.SerializedName;

/**
 * A class used to describe the pagination payload object.
 */
public class Pagination {

    @SerializedName(JsonConstants.REFRESH_URL)
    private String refreshURL;

    @SerializedName(JsonConstants.NEXT_URL)
    private String nextURL;

    private int total;
    private int matched;

    /**
     * Instantiates a new intent.
     *
     * @param refreshURL url to get this data again
     * @param nextURL url to get the next page
     * @param total number of available items
     * @param matched number of items that match the current criteria
     */
    public Pagination(String refreshURL, String nextURL, int total, int matched) {
        this.refreshURL = refreshURL;
        this.nextURL = nextURL;
        this.total = total;
        this.matched = matched;
    }

    /**
     * Returns the URL that can be used to obtain any updates to the list that
     * have been made.
     *
     * @return a string for the URL
     */
    public String getRefreshURL() {
        return refreshURL;
    }

    /**
     * Sets the refresh URL provided by the system.
     *
     * @param refreshURL string for the refresh URL
     */
    public void setRefreshURL(String refreshURL) {
        this.refreshURL = refreshURL;
    }

    /**
     * Returns the URL that can be used to obtain the next items available for a
     * given list.
     *
     * @return a string for the URL
     */
    public String getNextURL() {
        return nextURL;
    }

    /**
     * Sets the next URL provided by the system.
     *
     * @param nextURL string for the next URL
     */
    public void setNextURL(String nextURL) {
        this.nextURL = nextURL;
    }

    /**
     * Returns the total number of items available in the current list.
     *
     * @return an int for the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * Sets the total number of items available in the current list.
     *
     * @param total the number of items available in the current list.
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * Returns the total number of items that match the current criteria.
     *
     * @return an int for the matched
     */
    public int getMatched() {
        return matched;
    }

    /**
     * Sets matched the total number of items that match the current criteria.
     *
     * @param matched int for the matched
     */
    public void setMatched(int matched) {
        this.matched = matched;
    }
}
