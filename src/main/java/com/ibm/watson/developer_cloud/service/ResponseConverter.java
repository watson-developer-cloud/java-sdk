package com.ibm.watson.developer_cloud.service;

import okhttp3.Response;

public interface ResponseConverter<T> {
  T convert(Response response);
}
