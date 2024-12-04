/*
 * (C) Copyright IBM Corp. 2023, 2024.
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

package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An optional object containing analytics data. Currently, this data is used only for events sent
 * to the Segment extension.
 */
public class RequestAnalytics extends GenericModel {

  protected String browser;
  protected String device;
  protected String pageUrl;

  /** Builder. */
  public static class Builder {
    private String browser;
    private String device;
    private String pageUrl;

    /**
     * Instantiates a new Builder from an existing RequestAnalytics instance.
     *
     * @param requestAnalytics the instance to initialize the Builder with
     */
    private Builder(RequestAnalytics requestAnalytics) {
      this.browser = requestAnalytics.browser;
      this.device = requestAnalytics.device;
      this.pageUrl = requestAnalytics.pageUrl;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a RequestAnalytics.
     *
     * @return the new RequestAnalytics instance
     */
    public RequestAnalytics build() {
      return new RequestAnalytics(this);
    }

    /**
     * Set the browser.
     *
     * @param browser the browser
     * @return the RequestAnalytics builder
     */
    public Builder browser(String browser) {
      this.browser = browser;
      return this;
    }

    /**
     * Set the device.
     *
     * @param device the device
     * @return the RequestAnalytics builder
     */
    public Builder device(String device) {
      this.device = device;
      return this;
    }

    /**
     * Set the pageUrl.
     *
     * @param pageUrl the pageUrl
     * @return the RequestAnalytics builder
     */
    public Builder pageUrl(String pageUrl) {
      this.pageUrl = pageUrl;
      return this;
    }
  }

  protected RequestAnalytics() {}

  protected RequestAnalytics(Builder builder) {
    browser = builder.browser;
    device = builder.device;
    pageUrl = builder.pageUrl;
  }

  /**
   * New builder.
   *
   * @return a RequestAnalytics builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the browser.
   *
   * <p>The browser that was used to send the message that triggered the event.
   *
   * @return the browser
   */
  public String browser() {
    return browser;
  }

  /**
   * Gets the device.
   *
   * <p>The type of device that was used to send the message that triggered the event.
   *
   * @return the device
   */
  public String device() {
    return device;
  }

  /**
   * Gets the pageUrl.
   *
   * <p>The URL of the web page that was used to send the message that triggered the event.
   *
   * @return the pageUrl
   */
  public String pageUrl() {
    return pageUrl;
  }
}
