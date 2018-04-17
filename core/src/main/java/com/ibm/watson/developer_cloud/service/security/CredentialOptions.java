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
