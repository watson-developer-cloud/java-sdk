package com.ibm.watson.common;

import com.ibm.cloud.sdk.core.security.TokenServerResponse;

class IamCp4dTokenResponse implements TokenServerResponse {

  // Platform UI access token
  private String token;
  // IAM access token
  private String accessToken;
  private String _messageCode_;
  private String message;

  public String getToken() {
    return token;
  }
  public void setToken(String token) {
    this.token = token;
  }
  public String get_messageCode_() {
    return _messageCode_;
  }
  public void set_messageCode_(String messageCode) {
    this._messageCode_ = messageCode;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public String getAccessToken() {
    return accessToken;
  }
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }
}