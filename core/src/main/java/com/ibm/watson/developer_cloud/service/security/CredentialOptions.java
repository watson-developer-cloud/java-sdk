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

public class CredentialOptions {
  private String username;
  private String password;
  private String apiKey;
  private String iamApiKey;
  private String accessToken;
  private String refreshToken;
  private String iamUrl;

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getApiKey() {
    return apiKey;
  }

  public String getIamApiKey() {
    return iamApiKey;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public String getIamUrl() {
    return iamUrl;
  }

  public static class Builder {
    private String username;
    private String password;
    private String apiKey;
    private String iamApiKey;
    private String accessToken;
    private String refreshToken;
    private String iamUrl;

    public CredentialOptions build() {
      return new CredentialOptions(this);
    }

    public Builder username(String username) {
      this.username = username;
      return this;
    }

    public Builder password(String password) {
      this.password = password;
      return this;
    }

    public Builder apiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    public Builder iamApiKey(String iamApiKey) {
      this.iamApiKey = iamApiKey;
      return this;
    }

    public Builder accessToken(String accessToken) {
      this.accessToken = accessToken;
      return this;
    }

    public Builder refreshToken(String refreshToken) {
      this.refreshToken = refreshToken;
      return this;
    }

    public Builder iamUrl(String iamUrl) {
      this.iamUrl = iamUrl;
      return this;
    }
  }

  private CredentialOptions(Builder builder) {
    this.username = builder.username;
    this.password = builder.password;
    this.apiKey = builder.apiKey;
    this.iamApiKey = builder.iamApiKey;
    this.accessToken = builder.accessToken;
    this.refreshToken = builder.refreshToken;
    this.iamUrl = builder.iamUrl;
  }
}
