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
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class MultipleRecordsOptions extends GenericModel {

    @SerializedName(JsonConstants.PAGE_LIMIT)
    private int pageLimit;

    @SerializedName(JsonConstants.INCLUDE_COUNT)
    private boolean includeCount;

    @SerializedName(JsonConstants.SORT)
    private String sort;

    @SerializedName(JsonConstants.CURSOR)
    private String cursor;

    /**
     * @return the number of records to return in each page of results.
     */
    public int getPageLimit() {
        return pageLimit;
    }

    /**
     * @param pageLimit
     *            the number of records to return in each page of results. The
     *            default page limit is 100.
     */
    public void setPageLimit(int pageLimit) {
        this.pageLimit = pageLimit;
    }

    /**
     * @return Whether to include information about the number of records
     *         returned.
     */
    public boolean getIncludeCount() {
        return includeCount;
    }

    /**
     * @param includeCount
     *            Whether to include information about the number of records
     *            returned.
     */
    public void setIncludeCount(boolean includeCount) {
        this.includeCount = includeCount;
    }

    /**
     * @return the sort attribute by which returned results will be sorted.
     */
    public String getSort() {
        return sort;
    }

    /**
     * @param sort
     *            the sort attribute by which returned results will be sorted.
     *            To reverse the sort order, prefix the value with a minus sign
     *            (-). Supported values are depends on the returned entity type.
     *            For example: text, modified, and example_id.
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * @return A token identifying the last value from the previous page of
     *         results.
     */
    public String getCursor() {
        return cursor;
    }

    /**
     * @param cursor
     *            A token identifying the last value from the previous page of
     *            results.
     */
    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

}
