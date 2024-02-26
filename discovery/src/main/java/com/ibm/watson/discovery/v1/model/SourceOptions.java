/*
 * (C) Copyright IBM Corp. 2018, 2024.
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

/** The **options** object defines which items to crawl from the source system. */
public class SourceOptions extends GenericModel {

  protected List<SourceOptionsFolder> folders;
  protected List<SourceOptionsObject> objects;

  @SerializedName("site_collections")
  protected List<SourceOptionsSiteColl> siteCollections;

  protected List<SourceOptionsWebCrawl> urls;
  protected List<SourceOptionsBuckets> buckets;

  @SerializedName("crawl_all_buckets")
  protected Boolean crawlAllBuckets;

  /** Builder. */
  public static class Builder {
    private List<SourceOptionsFolder> folders;
    private List<SourceOptionsObject> objects;
    private List<SourceOptionsSiteColl> siteCollections;
    private List<SourceOptionsWebCrawl> urls;
    private List<SourceOptionsBuckets> buckets;
    private Boolean crawlAllBuckets;

    /**
     * Instantiates a new Builder from an existing SourceOptions instance.
     *
     * @param sourceOptions the instance to initialize the Builder with
     */
    private Builder(SourceOptions sourceOptions) {
      this.folders = sourceOptions.folders;
      this.objects = sourceOptions.objects;
      this.siteCollections = sourceOptions.siteCollections;
      this.urls = sourceOptions.urls;
      this.buckets = sourceOptions.buckets;
      this.crawlAllBuckets = sourceOptions.crawlAllBuckets;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a SourceOptions.
     *
     * @return the new SourceOptions instance
     */
    public SourceOptions build() {
      return new SourceOptions(this);
    }

    /**
     * Adds a new element to folders.
     *
     * @param folders the new element to be added
     * @return the SourceOptions builder
     */
    public Builder addFolders(SourceOptionsFolder folders) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(folders, "folders cannot be null");
      if (this.folders == null) {
        this.folders = new ArrayList<SourceOptionsFolder>();
      }
      this.folders.add(folders);
      return this;
    }

    /**
     * Adds a new element to objects.
     *
     * @param objects the new element to be added
     * @return the SourceOptions builder
     */
    public Builder addObjects(SourceOptionsObject objects) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(objects, "objects cannot be null");
      if (this.objects == null) {
        this.objects = new ArrayList<SourceOptionsObject>();
      }
      this.objects.add(objects);
      return this;
    }

    /**
     * Adds a new element to siteCollections.
     *
     * @param siteCollections the new element to be added
     * @return the SourceOptions builder
     */
    public Builder addSiteCollections(SourceOptionsSiteColl siteCollections) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(
          siteCollections, "siteCollections cannot be null");
      if (this.siteCollections == null) {
        this.siteCollections = new ArrayList<SourceOptionsSiteColl>();
      }
      this.siteCollections.add(siteCollections);
      return this;
    }

    /**
     * Adds a new element to urls.
     *
     * @param urls the new element to be added
     * @return the SourceOptions builder
     */
    public Builder addUrls(SourceOptionsWebCrawl urls) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(urls, "urls cannot be null");
      if (this.urls == null) {
        this.urls = new ArrayList<SourceOptionsWebCrawl>();
      }
      this.urls.add(urls);
      return this;
    }

    /**
     * Adds a new element to buckets.
     *
     * @param buckets the new element to be added
     * @return the SourceOptions builder
     */
    public Builder addBuckets(SourceOptionsBuckets buckets) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(buckets, "buckets cannot be null");
      if (this.buckets == null) {
        this.buckets = new ArrayList<SourceOptionsBuckets>();
      }
      this.buckets.add(buckets);
      return this;
    }

    /**
     * Set the folders. Existing folders will be replaced.
     *
     * @param folders the folders
     * @return the SourceOptions builder
     */
    public Builder folders(List<SourceOptionsFolder> folders) {
      this.folders = folders;
      return this;
    }

    /**
     * Set the objects. Existing objects will be replaced.
     *
     * @param objects the objects
     * @return the SourceOptions builder
     */
    public Builder objects(List<SourceOptionsObject> objects) {
      this.objects = objects;
      return this;
    }

    /**
     * Set the siteCollections. Existing siteCollections will be replaced.
     *
     * @param siteCollections the siteCollections
     * @return the SourceOptions builder
     */
    public Builder siteCollections(List<SourceOptionsSiteColl> siteCollections) {
      this.siteCollections = siteCollections;
      return this;
    }

    /**
     * Set the urls. Existing urls will be replaced.
     *
     * @param urls the urls
     * @return the SourceOptions builder
     */
    public Builder urls(List<SourceOptionsWebCrawl> urls) {
      this.urls = urls;
      return this;
    }

    /**
     * Set the buckets. Existing buckets will be replaced.
     *
     * @param buckets the buckets
     * @return the SourceOptions builder
     */
    public Builder buckets(List<SourceOptionsBuckets> buckets) {
      this.buckets = buckets;
      return this;
    }

    /**
     * Set the crawlAllBuckets.
     *
     * @param crawlAllBuckets the crawlAllBuckets
     * @return the SourceOptions builder
     */
    public Builder crawlAllBuckets(Boolean crawlAllBuckets) {
      this.crawlAllBuckets = crawlAllBuckets;
      return this;
    }
  }

  protected SourceOptions() {}

  protected SourceOptions(Builder builder) {
    folders = builder.folders;
    objects = builder.objects;
    siteCollections = builder.siteCollections;
    urls = builder.urls;
    buckets = builder.buckets;
    crawlAllBuckets = builder.crawlAllBuckets;
  }

  /**
   * New builder.
   *
   * @return a SourceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the folders.
   *
   * <p>Array of folders to crawl from the Box source. Only valid, and required, when the **type**
   * field of the **source** object is set to `box`.
   *
   * @return the folders
   */
  public List<SourceOptionsFolder> folders() {
    return folders;
  }

  /**
   * Gets the objects.
   *
   * <p>Array of Salesforce document object types to crawl from the Salesforce source. Only valid,
   * and required, when the **type** field of the **source** object is set to `salesforce`.
   *
   * @return the objects
   */
  public List<SourceOptionsObject> objects() {
    return objects;
  }

  /**
   * Gets the siteCollections.
   *
   * <p>Array of Microsoft SharePointoint Online site collections to crawl from the SharePoint
   * source. Only valid and required when the **type** field of the **source** object is set to
   * `sharepoint`.
   *
   * @return the siteCollections
   */
  public List<SourceOptionsSiteColl> siteCollections() {
    return siteCollections;
  }

  /**
   * Gets the urls.
   *
   * <p>Array of Web page URLs to begin crawling the web from. Only valid and required when the
   * **type** field of the **source** object is set to `web_crawl`.
   *
   * @return the urls
   */
  public List<SourceOptionsWebCrawl> urls() {
    return urls;
  }

  /**
   * Gets the buckets.
   *
   * <p>Array of cloud object store buckets to begin crawling. Only valid and required when the
   * **type** field of the **source** object is set to `cloud_object_store`, and the
   * **crawl_all_buckets** field is `false` or not specified.
   *
   * @return the buckets
   */
  public List<SourceOptionsBuckets> buckets() {
    return buckets;
  }

  /**
   * Gets the crawlAllBuckets.
   *
   * <p>When `true`, all buckets in the specified cloud object store are crawled. If set to `true`,
   * the **buckets** array must not be specified.
   *
   * @return the crawlAllBuckets
   */
  public Boolean crawlAllBuckets() {
    return crawlAllBuckets;
  }
}
