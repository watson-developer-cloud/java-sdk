package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils;

import com.google.gson.Gson;

/** Utilities for serializing and deserializing JSON objects. */
public final class JsonSerializationUtils {
    private JsonSerializationUtils() {
        // prevent instantiation
    }

    /** Deserialize the given JSON string to the specified class. */
    public static <T> T fromJson(String jsonStr, Class<? extends T> valueType) {
        return getGson().fromJson(jsonStr, valueType);
    }

    /** Serialize the given Object to a JSON string. */
    public static String toJsonString(Object obj) {
        return getGson().toJson(obj);
    }

    private static Gson getGson() {
        return new Gson();
    }

}