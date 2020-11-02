/*
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.discovery.v2.utils;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.RecordedRequest;

/** A class used by the unit tests containing utility functions. */
public class TestUtilities {
  public static Map<String, Object> createMockMap() {
    Map<String, Object> mockMap = new HashMap<>();
    mockMap.put("foo", "bar");
    return mockMap;
  }

  public static HashMap<String, InputStream> createMockStreamMap() {
    return new HashMap<String, InputStream>() {
      {
        put("key1", createMockStream("This is a mock file."));
      }
    };
  }

  public static Map<String, String> parseQueryString(RecordedRequest req) {
    Map<String, String> queryMap = new HashMap<>();

    try {
      HttpUrl requestUrl = req.getRequestUrl();

      if (requestUrl != null) {
        Set<String> queryParamsNames = requestUrl.queryParameterNames();
        // map the parameter name to its corresponding value
        for (String p : queryParamsNames) {
          // get the corresponding value for the parameter (p)
          List<String> val = requestUrl.queryParameterValues(p);
          if (val != null && !val.isEmpty()) {
            String joinedQuery = String.join(",", val);
            queryMap.put(p, joinedQuery);
          }
        }
      }
      if (queryMap.isEmpty()) {
        return null;
      }
    } catch (Exception e) {
      return null;
    }

    return queryMap;
  }

  public static String parseReqPath(RecordedRequest req) {
    String parsedPath = null;

    try {
      String fullPath = req.getPath();
      if (fullPath != null && !fullPath.isEmpty()) {
        // retrieve the path segment before the query parameter
        parsedPath = fullPath.split("\\?", 2)[0];
      }
      if (parsedPath.isEmpty() || parsedPath == null) {
        return null;
      }

    } catch (Exception e) {
      return null;
    }

    return parsedPath;
  }

  public static String serialize(Object obj) {
    return GsonSingleton.getGson().toJson(obj);
  }

  public static <T> T deserialize(String json, Class<T> clazz) {
    return GsonSingleton.getGson().fromJson(json, clazz);
  }

  public static InputStream createMockStream(String s) {
    return new ByteArrayInputStream(s.getBytes());
  }

  public static List<FileWithMetadata> creatMockListFileWithMetadata() {
    List<FileWithMetadata> list = new ArrayList<FileWithMetadata>();
    byte[] fileBytes = {(byte) 0xde, (byte) 0xad, (byte) 0xbe, (byte) 0xef};
    InputStream inputStream = new ByteArrayInputStream(fileBytes);
    FileWithMetadata.Builder builder = new FileWithMetadata.Builder();
    builder.data(inputStream);
    FileWithMetadata fileWithMetadata = builder.build();
    list.add(fileWithMetadata);

    return list;
  }

  public static byte[] createMockByteArray(String bytes) {
    return bytes.getBytes();
  }

  public static Date createMockDate(String date) throws Exception {
    return new SimpleDateFormat("yyyy-MM-dd").parse(date);
  }

  public static Date createMockDateTime(String date) throws Exception {
    return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(date);
  }
}
