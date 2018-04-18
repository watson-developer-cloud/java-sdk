package com.ibm.watson.developer_cloud.service.security;

import com.ibm.watson.developer_cloud.http.HttpClientSingleton;
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
      tokenData = requestToken();
      token = tokenData.getAccessToken();
    } else if (isTokenExpired()) {
      tokenData = refreshToken();
      token = tokenData.getAccessToken();
    } else {
      token = tokenData.getAccessToken();
    }

    return token;
  }

  public IamToken requestToken() {
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(url, new String[0]));

    builder.header("Content-Type", HttpMediaType.APPLICATION_FORM_URLENCODED);
    builder.header("Authorization", "Basic Yng6Yng=");

    FormBody formBody = new FormBody.Builder()
        .add("grant_type", "urn:ibm:params:oauth:grant-type:apikey")
        .add("apikey", apiKey)
        .add("response_type", "cloud_iam")
        .build();
    builder.body(formBody);

    Call call = HttpClientSingleton.getInstance().createHttpClient().newCall(builder.build());
    return new IamServiceCall<>(call, ResponseConverterUtils.getObject(IamToken.class)).execute();
  }

  public IamToken refreshToken() {
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(url, new String[0]));

    builder.header("Content-Type", HttpMediaType.APPLICATION_FORM_URLENCODED);
    builder.header("Authorization", "Basic Yng6Yng=");

    FormBody formBody = new FormBody.Builder()
        .add("grant_type", "refresh_token")
        .add("refresh_token", tokenData.getRefreshToken())
        .build();
    builder.body(formBody);

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
