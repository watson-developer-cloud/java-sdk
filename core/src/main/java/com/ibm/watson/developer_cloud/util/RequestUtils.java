/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.util;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.InputStreamRequestBody;
import com.ibm.watson.developer_cloud.service.WatsonService;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Utility functions to use when creating a {@link com.ibm.watson.developer_cloud.http.RequestBuilder }.
 *
 */
public final class RequestUtils {

  /**
   * Default end point for relative request. It will be updated by {@link WatsonService} with the real service end
   * point.
   */
  public static final String DEFAULT_ENDPOINT = "http://do.not.use";

  private static final Logger LOG = Logger.getLogger(RequestUtils.class.getName());

  private static final String[] properties =
      new String[] { "java.vendor", "java.version", "os.arch", "os.name", "os.version" };
  private static String userAgent;

  private RequestUtils() {
    // This is a utility class - no instantiation allowed.
  }

  /**
   * Encode a string into a valid URL string.
   *
   * @param content the content
   * @return the string
   */
  public static String encode(String content) {
    try {
      return URLEncoder.encode(content, "UTF-8");
    } catch (final UnsupportedEncodingException e) {
      throw new AssertionError(e);
    }
  }

  /**
   * Checks if is relative.
   *
   * @param request the okhttp3 request
   * @return true, if is relative
   */
  public static boolean isRelative(Request request) {
    return request.url().toString().startsWith(DEFAULT_ENDPOINT);
  }

  /**
   * Return a copy of a {@link Map} excluding the given key, or array of keys.
   *
   * @param params the parameters
   * @param toOmit the keys to omit
   * @return the map with the omitted key-value pars, or null if params is null
   */
  public static Map<String, Object> omit(Map<String, Object> params, String... toOmit) {
    if (params == null) {
      return null;
    }

    final Map<String, Object> ret = new HashMap<String, Object>(params);

    if (toOmit != null) {
      ret.keySet().removeAll(Arrays.asList(toOmit));
    }

    return ret;
  }


  /**
   * Return a copy of a {@link Map} with only the specified given key, or array of keys. If {@code toPick} is empty all
   * keys will remain in the Map.
   *
   * @param params the parameters
   * @param toPick the keys to pick
   * @return the map with the picked key-value pars, or null if params is null
   */

  public static Map<String, Object> pick(Map<String, Object> params, String... toPick) {
    if (params == null) {
      return null;
    }

    final Map<String, Object> ret = new HashMap<String, Object>(params);

    if ((toPick != null) && (toPick.length > 0)) {
      ret.keySet().retainAll(Arrays.asList(toPick));
    }

    return ret;
  }

  /**
   * Replace the url end point (schema + host + port) with the given end point.
   *
   * @param url the url to update
   * @param endPoint the end point
   * @return the new url
   */
  public static String replaceEndPoint(String url, String endPoint) {
    return endPoint + url.replaceFirst(DEFAULT_ENDPOINT, "");
  }

  /**
   * Creates a String of all elements of an array, separated by a separator.
   *
   * @param <T> the generic type
   * @param array the array
   * @param separator the separator
   * @return the joined String
   */
  public static <T> String join(T[] array, String separator) {
    return join(Arrays.asList(array), separator);
  }

  /**
   * Creates a String of all elements of an iterable, separated by a separator.
   *
   * @param iterable the iterable
   * @param separator the separator
   * @return the joined String
   */
  public static String join(Iterable<?> iterable, String separator) {
    final StringBuilder sb = new StringBuilder();
    boolean first = true;

    for (Object item : iterable) {
      if (first) {
        first = false;
      } else {
        sb.append(separator);
      }

      sb.append(item.toString());
    }

    return sb.toString();
  }

  /**
   * Gets the user agent.
   *
   * @return the user agent
   */
  public static synchronized String getUserAgent() {
    if (userAgent == null) {
      userAgent = buildUserAgent();
    }
    return userAgent;
  }

  private static String loadSdkVersion() {
    ClassLoader classLoader = RequestUtils.class.getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream("version.properties");
    Properties properties = new Properties();

    try {
      properties.load(inputStream);
    } catch (Exception e) {
      LOG.log(Level.WARNING, "Could not load version.properties", e);
    }

    return properties.getProperty("version", "unknown-version");
  }

  /**
   * Builds the user agent using System properties.
   *
   * @return the string that represents the user agent
   */
  private static String buildUserAgent() {
    final List<String> details = new ArrayList<String>();
    for (String propertyName : properties) {
      details.add(propertyName + "=" + System.getProperty(propertyName));
    }

    return "watson-apis-java-sdk/" + loadSdkVersion() + " (" + RequestUtils.join(details, "; ") + ")";
  }

  /**
   * Returns a request body that encapsulates the specified file qualified with the specified content type.
   *
   * @param file the file content to POST/PUT
   * @param contentType the HTTP contentType to use.
   *
   * @return {@link RequestBody}
   */
  public static RequestBody fileBody(File file, String contentType) {
    MediaType mediaType = (contentType != null) ? MediaType.parse(contentType) : HttpMediaType.BINARY_FILE;
    return RequestBody.create(mediaType, file);
  }

  /**
   * Returns a request body the encapsulates the specified input stream qualified with the specified content type.
   *
   * @param stream the input stream content to POST/PUT
   * @param contentType the HTTP contentType to use.
   *
   * @return {@link RequestBody}
   */
  public static RequestBody inputStreamBody(InputStream stream, String contentType) {
    MediaType mediaType = (contentType != null) ? MediaType.parse(contentType) : HttpMediaType.BINARY_FILE;
    return InputStreamRequestBody.create(mediaType, stream);
  }
}
