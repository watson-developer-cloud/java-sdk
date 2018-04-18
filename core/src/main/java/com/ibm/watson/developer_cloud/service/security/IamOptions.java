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
package com.ibm.watson.developer_cloud.service.security;

/**
 * Options for authenticating using IAM.
 */
public class IamOptions {
  private String apiKey;
  private String accessToken;
  private String url;

  public String getApiKey() {
    return apiKey;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public String getUrl() {
    return url;
  }

  public static class Builder {
    private String apiKey;
    private String accessToken;
    private String url;

    public IamOptions build() {
      return new IamOptions(this);
    }

    public Builder apiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    public Builder accessToken(String accessToken) {
      this.accessToken = accessToken;
      return this;
    }

    public Builder url(String url) {
      this.url = url;
      return this;
    }
  }

  private IamOptions(Builder builder) {
    this.apiKey = builder.apiKey;
    this.accessToken = builder.accessToken;
    this.url = builder.url;
  }
}
