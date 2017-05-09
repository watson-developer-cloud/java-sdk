/*
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
package com.ibm.watson.developer_cloud.http;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.JavaNetCookieJar;

/**
 * This is an adapter that uses {@link JavaNetCookieJar} and ignore Speech to Text sessions for session less requests.
 *
 */
public final class WatsonCookieJar implements CookieJar {
  private static final String SESSIONID = "SESSIONID";
  private static final String SESSIONS = "sessions";
  private static final String SPEECH_TO_TEXT = "speech-to-text";
  private JavaNetCookieJar adapter;

  /**
   * Instantiates a new Watson cookie jar.
   *
   * @param cookieHandler the cookie handler
   */
  public WatsonCookieJar(CookieHandler cookieHandler) {
    this.adapter = new JavaNetCookieJar(cookieHandler);
  }

  /*
   * (non-Javadoc)
   *
   * @see okhttp3.CookieJar#saveFromResponse(okhttp3.HttpUrl, java.util.List)
   */
  @Override
  public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
    this.adapter.saveFromResponse(url, cookies);
  }


  /*
   * (non-Javadoc)
   *
   * @see okhttp3.CookieJar#loadForRequest(okhttp3.HttpUrl)
   */
  @Override
  public List<Cookie> loadForRequest(HttpUrl url) {
    List<Cookie> cookies = this.adapter.loadForRequest(url);

    // TODO: Removes the SESSIONID for speech to text session lest requests
    if (url.encodedPathSegments().contains(SPEECH_TO_TEXT) && !url.encodedPathSegments().contains(SESSIONS)) {
      List<Cookie> sessionLessCookies = new ArrayList<Cookie>();
      for (Cookie cookie : cookies) {
        if (!cookie.name().equalsIgnoreCase(SESSIONID)) {
          sessionLessCookies.add(cookie);
        }
      }
      cookies = sessionLessCookies;
    }
    return cookies;
  }

}
