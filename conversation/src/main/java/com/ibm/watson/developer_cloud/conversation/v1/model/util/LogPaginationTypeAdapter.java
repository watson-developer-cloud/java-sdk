/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.conversation.v1.model.util;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.ibm.watson.developer_cloud.conversation.v1.model.LogPagination;
import com.ibm.watson.developer_cloud.util.RequestUtils;

import okhttp3.HttpUrl;

/**
 * Type adapter to transform JSON into a {@link LogPagination} and vice versa.
 */
public class LogPaginationTypeAdapter extends TypeAdapter<LogPagination> {
  private static final String MATCHED = "matched";
  private static final String NEXT_URL = "next_url";
  private static final String CURSOR = "cursor";

  /*
   * (non-Javadoc)
   * @see com.google.gson.TypeAdapter#write(com.google.gson.stream.JsonWriter, java.lang.Object)
   */
  @Override
  public void write(JsonWriter writer, LogPagination pagination) throws IOException {
    writer.beginObject();
    writer.name(NEXT_URL).value(pagination.getNextUrl());
    writer.name(MATCHED).value(pagination.getMatched());
    writer.endObject();
    writer.flush();
  }

  /*
   * (non-Javadoc)
   * @see com.google.gson.TypeAdapter#read(com.google.gson.stream.JsonReader)
   */
  @Override
  public LogPagination read(JsonReader reader) throws IOException {
    if (reader.peek() == JsonToken.NULL) {
      reader.nextNull();
      return null;
    }
    reader.beginObject();
    LogPagination pagination = new LogPagination();
    while (reader.hasNext()) {
      String name = reader.nextName();
      if (name.equals(NEXT_URL)) {
        String nextUrl = reader.nextString();
        HttpUrl url = HttpUrl.parse(RequestUtils.DEFAULT_ENDPOINT + nextUrl);
        pagination.setCursor(url.queryParameter(CURSOR));
        pagination.setNextUrl(nextUrl);
      } else if (name.equals(MATCHED)) {
        pagination.setMatched(reader.nextLong());
      } else {
        reader.skipValue();
      }
    }
    reader.endObject();

    return pagination;
  }
}
