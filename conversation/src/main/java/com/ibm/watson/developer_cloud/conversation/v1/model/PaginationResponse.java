/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.conversation.v1.model.util.PaginationResponseTypeAdapter;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The pagination data for the returned objects.
 */
@JsonAdapter(PaginationResponseTypeAdapter.class)
public class PaginationResponse extends GenericModel {

  /** The URL that will return the same page of results. */
  @SerializedName("refresh_url")
  private String refreshUrl;
  /** The URL that will return the next page of results. */
  @SerializedName("next_url")
  private String nextUrl;
  /** Reserved for future use. */
  private Long total;
  /** Reserved for future use. */
  private Long matched;

  /** A token identifying the last value from the previous page of results. */
  private String cursor;

  /**
   * Gets the cursor.
   * A token identifying the last value from the previous page of results.
   *
   * @return the cursor
   */
  public String getCursor() {
    return cursor;
  }

  /**
   * Sets the cursor.
   *
   * @param cursor the new cursor
   */
  public void setCursor(String cursor) {
    this.cursor = cursor;
  }

  /**
   * Gets the refreshUrl.
   *
   * @return the refreshUrl
   */
  public String getRefreshUrl() {
    return refreshUrl;
  }

  /**
   * Gets the nextUrl.
   *
   * @return the nextUrl
   */
  public String getNextUrl() {
    return nextUrl;
  }

  /**
   * Gets the total.
   *
   * @return the total
   */
  public Long getTotal() {
    return total;
  }

  /**
   * Gets the matched.
   *
   * @return the matched
   */
  public Long getMatched() {
    return matched;
  }

  /**
   * Sets the refreshUrl.
   *
   * @param refreshUrl the new refreshUrl
   */
  public void setRefreshUrl(final String refreshUrl) {
    this.refreshUrl = refreshUrl;
  }

  /**
   * Sets the nextUrl.
   *
   * @param nextUrl the new nextUrl
   */
  public void setNextUrl(final String nextUrl) {
    this.nextUrl = nextUrl;
  }

  /**
   * Sets the total.
   *
   * @param total the new total
   */
  public void setTotal(final Long total) {
    this.total = total;
  }

  /**
   * Sets the matched.
   *
   * @param matched the new matched
   */
  public void setMatched(final Long matched) {
    this.matched = matched;
  }
}
