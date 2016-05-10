/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import com.ibm.watson.developer_cloud.service.WatsonService;

import okhttp3.Request;

/**
 * Utility functions to use when creating a
 * {@link com.ibm.watson.developer_cloud.http.RequestBuilder }
 * 
 */
public class RequestUtils {

  /**
   * Default end point for relative request. It will be updated by {@link WatsonService} with the
   * real service end point.
   */
  public static final String DEFAULT_ENDPOINT = "http://do.not.use";

  /**
   * Encode a string into a valid URL string
   * 
   * @param content the content
   * @return the string
   */
  public static String encode(String content) {
    try {
      return URLEncoder.encode(content, "UTF-8");
    } catch (final UnsupportedEncodingException e) {
      return null;
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
   * @return the map with the omitted key-value pars
   */
  public static Map<String, Object> omit(Map<String, Object> params, String... toOmit) {
    if (params == null)
      return null;
    if (toOmit == null || toOmit.length == 0)
      return params;

    final Map<String, Object> ret = new HashMap<String, Object>();

    for (final String key : params.keySet()) {
      if (!ArrayUtils.contains(toOmit, key))
        ret.put(key, params.get(key));
    }
    return ret;
  }


  /**
   * Return a copy of a {@link Map} with only the specified given key, or array of keys.
   * 
   * @param params the parameters
   * @param toPick the keys to pick
   * @return the map with the picked key-value pars
   */

  public static Map<String, Object> pick(Map<String, Object> params, String... toPick) {
    if (params == null)
      return null;
    if (toPick == null || toPick.length == 0)
      return params;

    final Map<String, Object> ret = new HashMap<String, Object>();

    for (final String key : params.keySet()) {
      if (ArrayUtils.contains(toPick, key))
        ret.put(key, params.get(key));
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
}
