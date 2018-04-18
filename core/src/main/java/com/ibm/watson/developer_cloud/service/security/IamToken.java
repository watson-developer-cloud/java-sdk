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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.ObjectModel;

/**
 * Represents response from IAM API.
 */
class IamToken implements ObjectModel {
  @SerializedName("access_token")
  private String accessToken;
  @SerializedName("refresh_token")
  private String refreshToken;
  @SerializedName("token_type")
  private String tokenType;
  @SerializedName("expires_in")
  private Long expiresIn;
  private Long expiration;

  public static class Builder {
    private String accessToken;
    private String refreshToken;

    public IamToken build() {
      return new IamToken(this);
    }

    public Builder accessToken(String accessToken) {
      this.accessToken = accessToken;
      return this;
    }

    public Builder refreshToken(String refreshToken) {
      this.refreshToken = refreshToken;
      return this;
    }
  }

  private IamToken(Builder builder) {
    this.accessToken = builder.accessToken;
    this.refreshToken = builder.refreshToken;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public String getTokenType() {
    return tokenType;
  }

  public Long getExpiresIn() {
    return expiresIn;
  }

  public Long getExpiration() {
    return expiration;
  }
}
