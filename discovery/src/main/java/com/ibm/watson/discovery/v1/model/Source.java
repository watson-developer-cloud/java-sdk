/*
 * (C) Copyright IBM Corp. 2023.
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

/** Object containing source parameters for the configuration. */
public class Source extends GenericModel {

  /**
   * The type of source to connect to. - `box` indicates the configuration is to connect an instance
   * of Enterprise Box. - `salesforce` indicates the configuration is to connect to Salesforce. -
   * `sharepoint` indicates the configuration is to connect to Microsoft SharePoint Online. -
   * `web_crawl` indicates the configuration is to perform a web page crawl. -
   * `cloud_object_storage` indicates the configuration is to connect to a cloud object store.
   */
  public interface Type {
    /** box. */
    String BOX = "box";
    /** salesforce. */
    String SALESFORCE = "salesforce";
    /** sharepoint. */
    String SHAREPOINT = "sharepoint";
    /** web_crawl. */
    String WEB_CRAWL = "web_crawl";
    /** cloud_object_storage. */
    String CLOUD_OBJECT_STORAGE = "cloud_object_storage";
  }

  protected String type;

  @SerializedName("credential_id")
  protected String credentialId;

  protected SourceSchedule schedule;
  protected SourceOptions options;

  /** Builder. */
  public static class Builder {
    private String type;
    private String credentialId;
    private SourceSchedule schedule;
    private SourceOptions options;

    /**
     * Instantiates a new Builder from an existing Source instance.
     *
     * @param source the instance to initialize the Builder with
     */
    private Builder(Source source) {
      this.type = source.type;
      this.credentialId = source.credentialId;
      this.schedule = source.schedule;
      this.options = source.options;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a Source.
     *
     * @return the new Source instance
     */
    public Source build() {
      return new Source(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the Source builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the credentialId.
     *
     * @param credentialId the credentialId
     * @return the Source builder
     */
    public Builder credentialId(String credentialId) {
      this.credentialId = credentialId;
      return this;
    }

    /**
     * Set the schedule.
     *
     * @param schedule the schedule
     * @return the Source builder
     */
    public Builder schedule(SourceSchedule schedule) {
      this.schedule = schedule;
      return this;
    }

    /**
     * Set the options.
     *
     * @param options the options
     * @return the Source builder
     */
    public Builder options(SourceOptions options) {
      this.options = options;
      return this;
    }
  }

  protected Source() {}

  protected Source(Builder builder) {
    type = builder.type;
    credentialId = builder.credentialId;
    schedule = builder.schedule;
    options = builder.options;
  }

  /**
   * New builder.
   *
   * @return a Source builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * <p>The type of source to connect to. - `box` indicates the configuration is to connect an
   * instance of Enterprise Box. - `salesforce` indicates the configuration is to connect to
   * Salesforce. - `sharepoint` indicates the configuration is to connect to Microsoft SharePoint
   * Online. - `web_crawl` indicates the configuration is to perform a web page crawl. -
   * `cloud_object_storage` indicates the configuration is to connect to a cloud object store.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the credentialId.
   *
   * <p>The **credential_id** of the credentials to use to connect to the source. Credentials are
   * defined using the **credentials** method. The **source_type** of the credentials used must
   * match the **type** field specified in this object.
   *
   * @return the credentialId
   */
  public String credentialId() {
    return credentialId;
  }

  /**
   * Gets the schedule.
   *
   * <p>Object containing the schedule information for the source.
   *
   * @return the schedule
   */
  public SourceSchedule schedule() {
    return schedule;
  }

  /**
   * Gets the options.
   *
   * <p>The **options** object defines which items to crawl from the source system.
   *
   * @return the options
   */
  public SourceOptions options() {
    return options;
  }
}
