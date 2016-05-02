/* ***************************************************************** */
/*                                                                   */
/* IBM Confidential                                                  */
/* OCO Source Materials                                              */
/*                                                                   */
/* (C) Copyright IBM Corp. 2015, 2016                                */
/*                                                                   */
/* The source code for this program is not published or otherwise    */
/* divested of its trade secrets, irrespective of what has been      */
/* deposited with the U.S. Copyright Office.                         */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.developer_cloud.conversation_helper.dialog;

import com.ibm.watson.developer_cloud.service.ServiceResponseException;
import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import java.io.IOException;
import java.net.Proxy;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Thin wrapper around the Dialog v2 Service REST API.
 */
public final class DialogService {
  private static final String URL = "http://wea-orchestratorv2.mybluemix.net/conversation/";
  private final OkHttpClient wclient;
  private String endPoint;
  private String apiKey;

  /**
   * Returns an instance of the Dialog v2 Service using the service's default endpoint (URL).
   */
  public DialogService() {
    client = new OkHttpClient();
    setEndPoint(URL);
  }

  /**
   * @return The endpoint (URL) for the service.
   */
  public String getEndPoint() {
    return endPoint;
  }

  /**
   * @param endPoint Custom endpoint (URL) for the service.
   */
  public void setEndPoint(String endPoint) {
    if (endPoint != null && !endPoint.endsWith("/")) {
      endPoint = endPoint + "/";
    }
    this.endPoint = endPoint;
  }

  /**
   * Creates API key with basic authentication using the specified {@code username} and
   * {@code password}.
   *
   * @param username Username credential for basic authentication.
   * @param password Password credential for basic authentication.
   *
   * @see #getApiKey()
   */
  public void setUsernameAndPassword(String username, String password) {
    apiKey = Credentials.basic(username, password);
  }

  /**
   * @return API key for using the service.
   *
   * @see #setUsernameAndPassword(String, String)
   */
  public String getApiKey() {
    return apiKey;
  }

  /**
   * Sends a message to the service through a {@link DialogRequest} for the given
   * {@code workspaceId}. This call is blocking and performs networking on the thread it's invoked
   * from.
   *
   * @param workspaceId Workspace ID for the Dialogs v2 Service API.
   * @param body Body request parameter containing an embedded message
   *
   * @return Response for the given {@code workspaceId} and {@link DialogRequest}.
   */
  public DialogResponse message(String workspaceId, DialogRequest body) {
    try {
      Response<DialogResponse> response = createRestService().message(workspaceId, body).execute();
      if (response.isSuccess()) {
        return response.body();
      } else {
        throw new ServiceResponseException(response.code(), response.errorBody().string(),
            response.raw());
      }
    } catch (IOException e) {
      throw new ServiceResponseException(0, "Unknown Error", null);
    }
  }

  private RestService createRestService() {
    if (apiKey != null) {
      // add Authorization header
      client.setAuthenticator(new Authenticator() {
        @Override public Request authenticate(Proxy proxy, com.squareup.okhttp.Response response)
            throws IOException {
          return response.request().newBuilder().addHeader("Authorization", apiKey).build();
        }

        @Override
        public Request authenticateProxy(Proxy proxy, com.squareup.okhttp.Response response)
            throws IOException {
          return null; // ignored
        }
      });
    }

    return new Retrofit.Builder()
        .client(client)
        .baseUrl(endPoint)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RestService.class);
  }

  private interface RestService {
    @POST("v2/workspaces/{workspace_id}/message")
    Call<DialogResponse> message(@Path("workspace_id") String workspaceId,
        @Body DialogRequest body);
  }
}
