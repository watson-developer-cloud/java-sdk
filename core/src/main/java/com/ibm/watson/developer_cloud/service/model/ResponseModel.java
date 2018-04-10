package com.ibm.watson.developer_cloud.service.model;

import okhttp3.Headers;

public interface ResponseModel {
  @Override
  boolean equals(Object o);

  @Override
  int hashCode();

  @Override
  String toString();

  Headers getHeaders();
}
