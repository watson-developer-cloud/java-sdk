package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/** Utilities for serializing and deserializing JSON objects. */
public final class JsonSerializationUtils {
    private JsonSerializationUtils() {
        // prevent instantiation
    }

    /** Deserialize the given JSON string to the specified class. */
    public static <T> T fromJson(String jsonStr, Class<? extends T> valueType) {
        try {
            return getObjectMapper().readValue(jsonStr, valueType);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** Deserialize the given JSON string to the specified class. */
    public static <T> T fromJsonType(String jsonStr, TypeReference<? extends T> valueType) {
        try {
            return getObjectMapper().readValue(jsonStr, valueType);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** Serialize the given Object to a JSON string. */
    public static String toJsonString(Object obj) {
        try {
            return getObjectMapper().writeValueAsString(obj);
        } catch (final JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static ObjectMapper getObjectMapper() {
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

}