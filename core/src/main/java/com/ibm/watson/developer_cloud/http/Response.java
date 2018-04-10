package com.ibm.watson.developer_cloud.http;

import okhttp3.Headers;

/**
 * Class holding the converted service call result along with some HTTP response data.
 *
 * @param <T> the generic type
 */
public class Response<T> {

  private T result;
  private Headers headers;

  public Response (T result, okhttp3.Response httpResponse) {
    this.result = result;
    this.headers = httpResponse.headers();
  }

  public T getResult() {
    return this.result;
  }

  public Headers getHeaders() {
    return this.headers;
  }
}
