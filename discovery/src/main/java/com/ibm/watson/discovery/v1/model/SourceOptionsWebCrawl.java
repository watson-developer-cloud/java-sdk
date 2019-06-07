/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.discovery.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object defining which URL to crawl and how to crawl it.
 */
public class SourceOptionsWebCrawl extends GenericModel {

  /**
   * The number of concurrent URLs to fetch. `gentle` means one URL is fetched at a time with a delay between each call.
   * `normal` means as many as two URLs are fectched concurrently with a short delay between fetch calls. `aggressive`
   * means that up to ten URLs are fetched concurrently with a short delay between fetch calls.
   */
  public interface CrawlSpeed {
    /** gentle. */
    String GENTLE = "gentle";
    /** normal. */
    String NORMAL = "normal";
    /** aggressive. */
    String AGGRESSIVE = "aggressive";
  }

  private String url;
  @SerializedName("limit_to_starting_hosts")
  private Boolean limitToStartingHosts;
  @SerializedName("crawl_speed")
  private String crawlSpeed;
  @SerializedName("allow_untrusted_certificate")
  private Boolean allowUntrustedCertificate;
  @SerializedName("maximum_hops")
  private Long maximumHops;
  @SerializedName("request_timeout")
  private Long requestTimeout;
  @SerializedName("override_robots_txt")
  private Boolean overrideRobotsTxt;
  private List<String> blacklist;

  /**
   * Gets the url.
   *
   * The starting URL to crawl.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the limitToStartingHosts.
   *
   * When `true`, crawls of the specified URL are limited to the host part of the **url** field.
   *
   * @return the limitToStartingHosts
   */
  public Boolean isLimitToStartingHosts() {
    return limitToStartingHosts;
  }

  /**
   * Gets the crawlSpeed.
   *
   * The number of concurrent URLs to fetch. `gentle` means one URL is fetched at a time with a delay between each call.
   * `normal` means as many as two URLs are fectched concurrently with a short delay between fetch calls. `aggressive`
   * means that up to ten URLs are fetched concurrently with a short delay between fetch calls.
   *
   * @return the crawlSpeed
   */
  public String getCrawlSpeed() {
    return crawlSpeed;
  }

  /**
   * Gets the allowUntrustedCertificate.
   *
   * When `true`, allows the crawl to interact with HTTPS sites with SSL certificates with untrusted signers.
   *
   * @return the allowUntrustedCertificate
   */
  public Boolean isAllowUntrustedCertificate() {
    return allowUntrustedCertificate;
  }

  /**
   * Gets the maximumHops.
   *
   * The maximum number of hops to make from the initial URL. When a page is crawled each link on that page will also be
   * crawled if it is within the **maximum_hops** from the initial URL. The first page crawled is 0 hops, each link
   * crawled from the first page is 1 hop, each link crawled from those pages is 2 hops, and so on.
   *
   * @return the maximumHops
   */
  public Long getMaximumHops() {
    return maximumHops;
  }

  /**
   * Gets the requestTimeout.
   *
   * The maximum milliseconds to wait for a response from the web server.
   *
   * @return the requestTimeout
   */
  public Long getRequestTimeout() {
    return requestTimeout;
  }

  /**
   * Gets the overrideRobotsTxt.
   *
   * When `true`, the crawler will ignore any `robots.txt` encountered by the crawler. This should only ever be done
   * when crawling a web site the user owns. This must be be set to `true` when a **gateway_id** is specied in the
   * **credentials**.
   *
   * @return the overrideRobotsTxt
   */
  public Boolean isOverrideRobotsTxt() {
    return overrideRobotsTxt;
  }

  /**
   * Gets the blacklist.
   *
   * Array of URL's to be excluded while crawling. The crawler will not follow links which contains this string. For
   * example, listing `https://ibm.com/watson` also excludes `https://ibm.com/watson/discovery`.
   *
   * @return the blacklist
   */
  public List<String> getBlacklist() {
    return blacklist;
  }

  /**
   * Sets the url.
   *
   * @param url the new url
   */
  public void setUrl(final String url) {
    this.url = url;
  }

  /**
   * Sets the limitToStartingHosts.
   *
   * @param limitToStartingHosts the new limitToStartingHosts
   */
  public void setLimitToStartingHosts(final Boolean limitToStartingHosts) {
    this.limitToStartingHosts = limitToStartingHosts;
  }

  /**
   * Sets the crawlSpeed.
   *
   * @param crawlSpeed the new crawlSpeed
   */
  public void setCrawlSpeed(final String crawlSpeed) {
    this.crawlSpeed = crawlSpeed;
  }

  /**
   * Sets the allowUntrustedCertificate.
   *
   * @param allowUntrustedCertificate the new allowUntrustedCertificate
   */
  public void setAllowUntrustedCertificate(final Boolean allowUntrustedCertificate) {
    this.allowUntrustedCertificate = allowUntrustedCertificate;
  }

  /**
   * Sets the maximumHops.
   *
   * @param maximumHops the new maximumHops
   */
  public void setMaximumHops(final long maximumHops) {
    this.maximumHops = maximumHops;
  }

  /**
   * Sets the requestTimeout.
   *
   * @param requestTimeout the new requestTimeout
   */
  public void setRequestTimeout(final long requestTimeout) {
    this.requestTimeout = requestTimeout;
  }

  /**
   * Sets the overrideRobotsTxt.
   *
   * @param overrideRobotsTxt the new overrideRobotsTxt
   */
  public void setOverrideRobotsTxt(final Boolean overrideRobotsTxt) {
    this.overrideRobotsTxt = overrideRobotsTxt;
  }

  /**
   * Sets the blacklist.
   *
   * @param blacklist the new blacklist
   */
  public void setBlacklist(final List<String> blacklist) {
    this.blacklist = blacklist;
  }
}
