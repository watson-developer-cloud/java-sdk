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

import com.ibm.watson.developer_cloud.http.HttpClientSingleton;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.Response;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import com.ibm.watson.developer_cloud.http.ServiceCallbackWithDetails;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import jersey.repackaged.jsr166e.CompletableFuture;
import okhttp3.Call;
import okhttp3.FormBody;
import java.io.IOException;

/**
 * Retrieves, stores, and refreshes IAM tokens.
 */
public class IamTokenManager {
  private String apiKey;
  private String url;
  private IamToken tokenData;

  private static final String DEFAULT_AUTHORIZATION = "Basic Yng6Yng=";

  public IamTokenManager(String accessToken, String apiKey, String refreshToken, String url) {
    if (apiKey != null) {
      this.apiKey = apiKey;
    }
    this.url = (url != null) ? url : "https://iam.ng.bluemix.net/identity/token";

    tokenData = new IamToken(accessToken, refreshToken);
  }

  /**
   * This function returns an access token. The source of the token is determined by the following logic:
   * 1. If user provides their own managed access token, assume it is valid and send it
   * 2. If this class is managing tokens and does not yet have one, make a request for one
   * 3. If this class is managing tokens and the token has expired, refresh it
   * 4. If this class is managing tokens and has a valid token stored, send it
   *
   * @return the valid access token
   */
  public String getToken() {
    String token;

    if (tokenData.getAccessToken() != null) {
      // use user-managed access token
      token = tokenData.getAccessToken();
    } else if (tokenData.getAccessToken() == null) {
      // request first-time token
      token = requestToken();
    } else if (isTokenExpired()) {
      // refresh current token
      token = refreshToken();
    } else {
      // use valid managed token
      token = tokenData.getAccessToken();
    }

    return token;
  }

  /**
   * Request an IAM token using an API key. Also updates internal managed IAM token information.
   *
   * @return the new access token
   */
  public String requestToken() {
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(url, new String[0]));

    builder.header(HttpHeaders.CONTENT_TYPE, HttpMediaType.APPLICATION_FORM_URLENCODED);
    builder.header(HttpHeaders.AUTHORIZATION, DEFAULT_AUTHORIZATION);

    FormBody formBody = new FormBody.Builder()
        .add("grant_type", "urn:ibm:params:oauth:grant-type:apikey")
        .add("apikey", apiKey)
        .add("response_type", "cloud_iam")
        .build();
    builder.body(formBody);

    Call call = HttpClientSingleton.getInstance().createHttpClient().newCall(builder.build());
    tokenData = new IamServiceCall<>(call, ResponseConverterUtils.getObject(IamToken.class)).execute();
    return tokenData.getAccessToken();
  }

  /**
   * Refresh an IAM token using a refresh token. Also updates internal managed IAM token information.
   *
   * @return the new access token
   */
  public String refreshToken() {
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(url, new String[0]));

    builder.header(HttpHeaders.CONTENT_TYPE, HttpMediaType.APPLICATION_FORM_URLENCODED);
    builder.header(HttpHeaders.AUTHORIZATION, DEFAULT_AUTHORIZATION);

    FormBody formBody = new FormBody.Builder()
        .add("grant_type", "refresh_token")
        .add("refresh_token", tokenData.getRefreshToken())
        .build();
    builder.body(formBody);

    Call call = HttpClientSingleton.getInstance().createHttpClient().newCall(builder.build());
    tokenData = new IamServiceCall<>(call, ResponseConverterUtils.getObject(IamToken.class)).execute();
    return tokenData.getAccessToken();
  }


  /**
   * Check if currently stored token is expired.
   *
   * Using a buffer to prevent the edge case of the
   * token expiring before the request could be made.
   *
   * The buffer will be a fraction of the total TTL. Using 80%.
   *
   * @return whether the current managed token is expired or not
   */
  private boolean isTokenExpired() {
    if (tokenData.getExpiresIn() == null || tokenData.getExpiration() == null) {
      return true;
    }

    Double fractionOfTimeToLive = 0.8;
    Long timeToLive = tokenData.getExpiresIn();
    Long expirationTime = tokenData.getExpiration();
    Double refreshTime = expirationTime - (timeToLive * (1.0 - fractionOfTimeToLive));
    Double currentTime = Math.floor(System.currentTimeMillis() / 1000);

    return refreshTime < currentTime;
  }

  private class IamServiceCall<IamToken> implements ServiceCall<IamToken> {

    private Call call;
    private ResponseConverter<IamToken> converter;

    IamServiceCall(Call call, ResponseConverter<IamToken> converter) {
      this.call = call;
      this.converter = converter;
    }

    @Override
    public ServiceCall<IamToken> addHeader(String name, String value) {
      return null;
    }

    @Override
    public IamToken execute() throws RuntimeException {
      try {
        okhttp3.Response response = call.execute();
        return converter.convert(response);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public Response<IamToken> executeWithDetails() throws RuntimeException {
      return null;
    }

    @Override
    public void enqueue(ServiceCallback<? super IamToken> callback) {

    }

    @Override
    public void enqueueWithDetails(ServiceCallbackWithDetails<IamToken> callback) {

    }

    @Override
    public CompletableFuture<IamToken> rx() {
      return null;
    }

    @Override
    public CompletableFuture<Response<IamToken>> rxWithDetails() {
      return null;
    }
  }

}
