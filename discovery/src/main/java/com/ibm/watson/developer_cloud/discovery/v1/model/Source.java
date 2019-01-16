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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Object containing source parameters for the configuration.
 */
public class Source extends GenericModel {

  /**
   * The type of source to connect to.
   * - `box` indicates the configuration is to connect an instance of Enterprise Box.
   * - `salesforce` indicates the configuration is to connect to Salesforce.
   * - `sharepoint` indicates the configuration is to connect to Microsoft SharePoint Online.
   * - `web_crawl` indicates the configuration is to perform a web page crawl.
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
  }

  private String type;
  @SerializedName("credential_id")
  private String credentialId;
  private SourceSchedule schedule;
  private SourceOptions options;

  /**
   * Gets the type.
   *
   * The type of source to connect to.
   * - `box` indicates the configuration is to connect an instance of Enterprise Box.
   * - `salesforce` indicates the configuration is to connect to Salesforce.
   * - `sharepoint` indicates the configuration is to connect to Microsoft SharePoint Online.
   * - `web_crawl` indicates the configuration is to perform a web page crawl.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the credentialId.
   *
   * The **credential_id** of the credentials to use to connect to the source. Credentials are defined using the
   * **credentials** method. The **source_type** of the credentials used must match the **type** field specified in this
   * object.
   *
   * @return the credentialId
   */
  public String getCredentialId() {
    return credentialId;
  }

  /**
   * Gets the schedule.
   *
   * Object containing the schedule information for the source.
   *
   * @return the schedule
   */
  public SourceSchedule getSchedule() {
    return schedule;
  }

  /**
   * Gets the options.
   *
   * The **options** object defines which items to crawl from the source system.
   *
   * @return the options
   */
  public SourceOptions getOptions() {
    return options;
  }

  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(final String type) {
    this.type = type;
  }

  /**
   * Sets the credentialId.
   *
   * @param credentialId the new credentialId
   */
  public void setCredentialId(final String credentialId) {
    this.credentialId = credentialId;
  }

  /**
   * Sets the schedule.
   *
   * @param schedule the new schedule
   */
  public void setSchedule(final SourceSchedule schedule) {
    this.schedule = schedule;
  }

  /**
   * Sets the options.
   *
   * @param options the new options
   */
  public void setOptions(final SourceOptions options) {
    this.options = options;
  }
}
