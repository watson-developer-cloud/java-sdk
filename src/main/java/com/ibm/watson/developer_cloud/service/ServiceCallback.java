package com.ibm.watson.developer_cloud.service;

/**
 * Created by harrisonsaylor on 4/12/16.
 */
public interface ServiceCallback<T> {
    void onResponse(T response);
    void onFailure(Exception e);
}
