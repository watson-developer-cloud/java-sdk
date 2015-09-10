package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Error class for remote failures.
 *
 * Meant to copy Solr's error format.
 */

public class RemoteError {
    @JsonProperty("msg")
    private final String message;
    private final int code;

    @JsonCreator
    public RemoteError(@JsonProperty("msg") String message, @JsonProperty("code") int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
