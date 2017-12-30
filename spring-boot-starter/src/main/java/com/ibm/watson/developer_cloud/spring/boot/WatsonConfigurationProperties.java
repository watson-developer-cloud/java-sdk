/*
 * Copyright © 2017 IBM Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.ibm.watson.developer_cloud.spring.boot;

public class WatsonConfigurationProperties {

  /** URL for Watson service. This URL should not include the username or password. **/
  private String url;

  /** Watson service username */
  private String username;

  /** Watson service password */
  private String password;

  /** Watson service API key */
  private String apiKey;

  /** Watson service versionDate */
  private String versionDate;

  public void setUrl(String url) {
    this.url = url;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setApiKey(String apiKey) { this.apiKey = apiKey; }

  public void setVersionDate(String versionDate) {
    this.versionDate = versionDate;
  }

  public String getUrl() {
    return this.url;
  }

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }

  public String getApiKey() {
    return apiKey;
  }

  public String getVersionDate() {
    return this.versionDate;
  }
}
