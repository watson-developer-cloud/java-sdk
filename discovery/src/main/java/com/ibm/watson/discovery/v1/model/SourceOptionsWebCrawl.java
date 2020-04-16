/*
 * (C) Copyright IBM Corp. 2019, 2020.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** Object defining which URL to crawl and how to crawl it. */
public class SourceOptionsWebCrawl extends GenericModel {

  /**
   * The number of concurrent URLs to fetch. `gentle` means one URL is fetched at a time with a
   * delay between each call. `normal` means as many as two URLs are fectched concurrently with a
   * short delay between fetch calls. `aggressive` means that up to ten URLs are fetched
   * concurrently with a short delay between fetch calls.
   */
  public interface CrawlSpeed {
    /** gentle. */
    String GENTLE = "gentle";
    /** normal. */
    String NORMAL = "normal";
    /** aggressive. */
    String AGGRESSIVE = "aggressive";
  }

  protected String url;

  @SerializedName("limit_to_starting_hosts")
  protected Boolean limitToStartingHosts;

  @SerializedName("crawl_speed")
  protected String crawlSpeed;

  @SerializedName("allow_untrusted_certificate")
  protected Boolean allowUntrustedCertificate;

  @SerializedName("maximum_hops")
  protected Long maximumHops;

  @SerializedName("request_timeout")
  protected Long requestTimeout;

  @SerializedName("override_robots_txt")
  protected Boolean overrideRobotsTxt;

  protected List<String> blacklist;

  /** Builder. */
  public static class Builder {
    private String url;
    private Boolean limitToStartingHosts;
    private String crawlSpeed;
    private Boolean allowUntrustedCertificate;
    private Long maximumHops;
    private Long requestTimeout;
    private Boolean overrideRobotsTxt;
    private List<String> blacklist;

    private Builder(SourceOptionsWebCrawl sourceOptionsWebCrawl) {
      this.url = sourceOptionsWebCrawl.url;
      this.limitToStartingHosts = sourceOptionsWebCrawl.limitToStartingHosts;
      this.crawlSpeed = sourceOptionsWebCrawl.crawlSpeed;
      this.allowUntrustedCertificate = sourceOptionsWebCrawl.allowUntrustedCertificate;
      this.maximumHops = sourceOptionsWebCrawl.maximumHops;
      this.requestTimeout = sourceOptionsWebCrawl.requestTimeout;
      this.overrideRobotsTxt = sourceOptionsWebCrawl.overrideRobotsTxt;
      this.blacklist = sourceOptionsWebCrawl.blacklist;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param url the url
     */
    public Builder(String url) {
      this.url = url;
    }

    /**
     * Builds a SourceOptionsWebCrawl.
     *
     * @return the sourceOptionsWebCrawl
     */
    public SourceOptionsWebCrawl build() {
      return new SourceOptionsWebCrawl(this);
    }

    /**
     * Adds an blacklist to blacklist.
     *
     * @param blacklist the new blacklist
     * @return the SourceOptionsWebCrawl builder
     */
    public Builder addBlacklist(String blacklist) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(blacklist, "blacklist cannot be null");
      if (this.blacklist == null) {
        this.blacklist = new ArrayList<String>();
      }
      this.blacklist.add(blacklist);
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the SourceOptionsWebCrawl builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the limitToStartingHosts.
     *
     * @param limitToStartingHosts the limitToStartingHosts
     * @return the SourceOptionsWebCrawl builder
     */
    public Builder limitToStartingHosts(Boolean limitToStartingHosts) {
      this.limitToStartingHosts = limitToStartingHosts;
      return this;
    }

    /**
     * Set the crawlSpeed.
     *
     * @param crawlSpeed the crawlSpeed
     * @return the SourceOptionsWebCrawl builder
     */
    public Builder crawlSpeed(String crawlSpeed) {
      this.crawlSpeed = crawlSpeed;
      return this;
    }

    /**
     * Set the allowUntrustedCertificate.
     *
     * @param allowUntrustedCertificate the allowUntrustedCertificate
     * @return the SourceOptionsWebCrawl builder
     */
    public Builder allowUntrustedCertificate(Boolean allowUntrustedCertificate) {
      this.allowUntrustedCertificate = allowUntrustedCertificate;
      return this;
    }

    /**
     * Set the maximumHops.
     *
     * @param maximumHops the maximumHops
     * @return the SourceOptionsWebCrawl builder
     */
    public Builder maximumHops(long maximumHops) {
      this.maximumHops = maximumHops;
      return this;
    }

    /**
     * Set the requestTimeout.
     *
     * @param requestTimeout the requestTimeout
     * @return the SourceOptionsWebCrawl builder
     */
    public Builder requestTimeout(long requestTimeout) {
      this.requestTimeout = requestTimeout;
      return this;
    }

    /**
     * Set the overrideRobotsTxt.
     *
     * @param overrideRobotsTxt the overrideRobotsTxt
     * @return the SourceOptionsWebCrawl builder
     */
    public Builder overrideRobotsTxt(Boolean overrideRobotsTxt) {
      this.overrideRobotsTxt = overrideRobotsTxt;
      return this;
    }

    /**
     * Set the blacklist. Existing blacklist will be replaced.
     *
     * @param blacklist the blacklist
     * @return the SourceOptionsWebCrawl builder
     */
    public Builder blacklist(List<String> blacklist) {
      this.blacklist = blacklist;
      return this;
    }
  }

  protected SourceOptionsWebCrawl(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.url, "url cannot be null");
    url = builder.url;
    limitToStartingHosts = builder.limitToStartingHosts;
    crawlSpeed = builder.crawlSpeed;
    allowUntrustedCertificate = builder.allowUntrustedCertificate;
    maximumHops = builder.maximumHops;
    requestTimeout = builder.requestTimeout;
    overrideRobotsTxt = builder.overrideRobotsTxt;
    blacklist = builder.blacklist;
  }

  /**
   * New builder.
   *
   * @return a SourceOptionsWebCrawl builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the url.
   *
   * <p>The starting URL to crawl.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the limitToStartingHosts.
   *
   * <p>When `true`, crawls of the specified URL are limited to the host part of the **url** field.
   *
   * @return the limitToStartingHosts
   */
  public Boolean limitToStartingHosts() {
    return limitToStartingHosts;
  }

  /**
   * Gets the crawlSpeed.
   *
   * <p>The number of concurrent URLs to fetch. `gentle` means one URL is fetched at a time with a
   * delay between each call. `normal` means as many as two URLs are fectched concurrently with a
   * short delay between fetch calls. `aggressive` means that up to ten URLs are fetched
   * concurrently with a short delay between fetch calls.
   *
   * @return the crawlSpeed
   */
  public String crawlSpeed() {
    return crawlSpeed;
  }

  /**
   * Gets the allowUntrustedCertificate.
   *
   * <p>When `true`, allows the crawl to interact with HTTPS sites with SSL certificates with
   * untrusted signers.
   *
   * @return the allowUntrustedCertificate
   */
  public Boolean allowUntrustedCertificate() {
    return allowUntrustedCertificate;
  }

  /**
   * Gets the maximumHops.
   *
   * <p>The maximum number of hops to make from the initial URL. When a page is crawled each link on
   * that page will also be crawled if it is within the **maximum_hops** from the initial URL. The
   * first page crawled is 0 hops, each link crawled from the first page is 1 hop, each link crawled
   * from those pages is 2 hops, and so on.
   *
   * @return the maximumHops
   */
  public Long maximumHops() {
    return maximumHops;
  }

  /**
   * Gets the requestTimeout.
   *
   * <p>The maximum milliseconds to wait for a response from the web server.
   *
   * @return the requestTimeout
   */
  public Long requestTimeout() {
    return requestTimeout;
  }

  /**
   * Gets the overrideRobotsTxt.
   *
   * <p>When `true`, the crawler will ignore any `robots.txt` encountered by the crawler. This
   * should only ever be done when crawling a web site the user owns. This must be be set to `true`
   * when a **gateway_id** is specied in the **credentials**.
   *
   * @return the overrideRobotsTxt
   */
  public Boolean overrideRobotsTxt() {
    return overrideRobotsTxt;
  }

  /**
   * Gets the blacklist.
   *
   * <p>Array of URL's to be excluded while crawling. The crawler will not follow links which
   * contains this string. For example, listing `https://ibm.com/watson` also excludes
   * `https://ibm.com/watson/discovery`.
   *
   * @return the blacklist
   */
  public List<String> blacklist() {
    return blacklist;
  }
}
