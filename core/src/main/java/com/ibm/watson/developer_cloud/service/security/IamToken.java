package com.ibm.watson.developer_cloud.service.security;

import com.ibm.watson.developer_cloud.service.model.ObjectModel;

class IamToken implements ObjectModel {
  private String accessToken;
  private String refreshToken;
  private String tokenType;
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
