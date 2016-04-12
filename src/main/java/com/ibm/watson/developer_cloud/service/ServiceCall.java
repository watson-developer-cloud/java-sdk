package com.ibm.watson.developer_cloud.service;

/**
 * Created by harrisonsaylor on 4/12/16.
 */
public interface ServiceCall<T> {
    T execute();
    void enqueue(ServiceCallback<T> callback);
}
