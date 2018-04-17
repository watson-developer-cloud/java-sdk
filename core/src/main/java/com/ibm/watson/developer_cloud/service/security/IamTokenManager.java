package com.ibm.watson.developer_cloud.service.security;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.HttpClientSingleton;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.NameValue;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.Response;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import com.ibm.watson.developer_cloud.http.ServiceCallbackWithDetails;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import jersey.repackaged.jsr166e.CompletableFuture;
import okhttp3.Call;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IamTokenManager {
  private String apiKey;
  private String url;
  private IamToken tokenData;

  public IamTokenManager(String accessToken, String apiKey, String refreshToken, String url) {
    if (apiKey != null) {
      this.apiKey = apiKey;
    }
    this.url = (url != null) ? url : "https://iam.ng.bluemix.net/identity/token";

    tokenData = new IamToken.Builder()
        .accessToken(accessToken)
        .refreshToken(refreshToken)
        .build();
  }

  public String getToken() {
    String token;

    if (tokenData.getAccessToken() != null) {
      token = tokenData.getAccessToken();
    } else if (tokenData.getAccessToken() == null) {
      tokenData = requestToken(null);
      token = tokenData.getAccessToken();
    } else if (isTokenExpired()) {
      tokenData = refreshToken(null);
      token = tokenData.getAccessToken();
    } else {
      token = tokenData.getAccessToken();
    }

    return token;
  }

  public IamToken requestToken(String authorizationHeader) {
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(url, new String[0]));

    builder.header("Content-Type", HttpMediaType.APPLICATION_FORM_URLENCODED);
    builder.header("Authorization", (authorizationHeader != null) ? authorizationHeader : "Basic Yng6Yng=");

    //Map<String, String> formObject = new HashMap<>();
    //final JsonObject jsonContent = new JsonObject();
    //jsonContent.addProperty("grant_type", "urn:ibm:params:oauth:grant-type:apikey");
    List<NameValue> formObject = new ArrayList<>();
    formObject.add(new NameValue("grant_type", "urn:ibm:params:oauth:grant-type:apikey"));
    //formObject.put("grant_type", "urn:ibm:params:oauth:grant-type:apikey");
    //jsonContent.addProperty("apikey", apiKey);
    //formObject.put("apikey", apiKey);
    formObject.add(new NameValue("apikey", apiKey));
    //jsonContent.addProperty("response_type", "cloud_iam");
    //formObject.put("response_type", "cloud_iam");
    formObject.add(new NameValue("response_type", "cloud_iam"));
    //builder.bodyJson(jsonContent);
    builder.form(formObject);

    Call call = HttpClientSingleton.getInstance().createHttpClient().newCall(builder.build());
    IamToken tokenTest = new IamServiceCall<>(call, ResponseConverterUtils.getObject(IamToken.class)).execute();
    return tokenTest;
    //return new IamServiceCall<>(call, ResponseConverterUtils.getObject(IamToken.class)).execute();
  }

  public IamToken refreshToken(String authorizationHeader) {
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(url, new String[0]));

    builder.header("Content-Type", HttpMediaType.APPLICATION_FORM_URLENCODED);
    builder.header("Authorization", (authorizationHeader != null) ? authorizationHeader : "Basic Yng6Yng=");

    final JsonObject jsonContent = new JsonObject();
    jsonContent.addProperty("grant_type", "refresh_token");
    jsonContent.addProperty("refresh_token", tokenData.getRefreshToken());
    //builder.bodyJson(jsonContent);
    builder.form(jsonContent);

    Call call = HttpClientSingleton.getInstance().createHttpClient().newCall(builder.build());
    return new IamServiceCall<>(call, ResponseConverterUtils.getObject(IamToken.class)).execute();
  }

  private boolean isTokenExpired() {
    Double fractionOfTimeToLive = 0.8;
    Long timeToLive = tokenData.getExpiresIn();
    Long expirationTime = tokenData.getExpiration();

    return (expirationTime - (timeToLive * (1.0 - fractionOfTimeToLive)))
        < Math.floor(System.currentTimeMillis() / 1000);
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
