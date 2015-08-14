/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.util;

 /**
  * Http constant headers.
  */
 public interface HttpHeaders {
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.1">HTTP/1.1 documentation</a>.
     */
    public static final String ACCEPT = "Accept";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.2">HTTP/1.1 documentation</a>.
     */
    public static final String ACCEPT_CHARSET = "Accept-Charset";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.3">HTTP/1.1 documentation</a>.
     */
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.4">HTTP/1.1 documentation</a>.
     */
    public static final String ACCEPT_LANGUAGE = "Accept-Language";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.8">HTTP/1.1 documentation</a>.
     */
    public static final String AUTHORIZATION = "Authorization";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.9">HTTP/1.1 documentation</a>.
     */
    public static final String CACHE_CONTROL = "Cache-Control";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.11">HTTP/1.1 documentation</a>.
     */
    public static final String CONTENT_ENCODING = "Content-Encoding";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.12">HTTP/1.1 documentation</a>.
     */
    public static final String CONTENT_LANGUAGE = "Content-Language";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.13">HTTP/1.1 documentation</a>.
     */
    public static final String CONTENT_LENGTH = "Content-Length";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.14">HTTP/1.1 documentation</a>.
     */
    public static final String CONTENT_LOCATION = "Content-Location";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.17">HTTP/1.1 documentation</a>.
     */
    public static final String CONTENT_TYPE = "Content-Type";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.18">HTTP/1.1 documentation</a>.
     */
    public static final String DATE = "Date";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.19">HTTP/1.1 documentation</a>.
     */
    public static final String ETAG = "ETag";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.21">HTTP/1.1 documentation</a>.
     */
    public static final String EXPIRES = "Expires";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.23">HTTP/1.1 documentation</a>.
     */
    public static final String HOST = "Host";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.24">HTTP/1.1 documentation</a>.
     */
    public static final String IF_MATCH = "If-Match";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.25">HTTP/1.1 documentation</a>.
     */
    public static final String IF_MODIFIED_SINCE = "If-Modified-Since";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.26">HTTP/1.1 documentation</a>.
     */
    public static final String IF_NONE_MATCH = "If-None-Match";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.28">HTTP/1.1 documentation</a>.
     */
    public static final String IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.29">HTTP/1.1 documentation</a>.
     */
    public static final String LAST_MODIFIED = "Last-Modified";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.30">HTTP/1.1 documentation</a>.
     */
    public static final String LOCATION = "Location";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.43">HTTP/1.1 documentation</a>.
     */
    public static final String USER_AGENT = "User-Agent";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.44">HTTP/1.1 documentation</a>.
     */
    public static final String VARY = "Vary";
    
    /**
     * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.47">HTTP/1.1 documentation</a>.
     */
    public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
    
    /**
     * See <a href="http://www.ietf.org/rfc/rfc2109.txt">IETF RFC 2109</a>.
     */
    public static final String COOKIE = "Cookie";
    
    /**
     * See <a href="http://www.ietf.org/rfc/rfc2109.txt">IETF RFC 2109</a>.
     */
    public static final String SET_COOKIE = "Set-Cookie";
    
}