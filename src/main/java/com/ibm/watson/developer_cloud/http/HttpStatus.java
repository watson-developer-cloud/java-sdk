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
package com.ibm.watson.developer_cloud.http;

/**
 * Constants enumerating the HTTP status codes. All status codes defined in RFC1945 (HTTP/1.0),
 * RFC2616 (HTTP/1.1), and RFC2518 (WebDAV) are listed.
 * 
 * Adapted from the Apache Software Foundation
 */
public interface HttpStatus {

  /** 202 Accepted (HTTP/1.0 - RFC 1945) */
  public static final int ACCEPTED = 202;

  // --- 2xx Success ---

  /** 502 Bad Gateway (HTTP/1.0 - RFC 1945) */
  public static final int BAD_GATEWAY = 502;
  /** 400 Bad Request (HTTP/1.1 - RFC 2616) */
  public static final int BAD_REQUEST = 400;
  /** 409 Conflict (HTTP/1.1 - RFC 2616) */
  public static final int CONFLICT = 409;
  /** 100 Continue (HTTP/1.1 - RFC 2616) */
  public static final int CONTINUE = 100;
  /** 201 Created (HTTP/1.0 - RFC 1945) */
  public static final int CREATED = 201;
  /** 417 Expectation Failed (HTTP/1.1 - RFC 2616) */
  public static final int EXPECTATION_FAILED = 417;
  /** 424 Failed Dependency (WebDAV - RFC 2518). */
  public static final int FAILED_DEPENDENCY = 424;

  /** 403 Forbidden (HTTP/1.0 - RFC 1945) */
  public static final int FORBIDDEN = 403;

  // --- 3xx Redirection ---

  /** 504 Gateway Timeout (HTTP/1.1 - RFC 2616) */
  public static final int GATEWAY_TIMEOUT = 504;
  /** 410 Gone (HTTP/1.1 - RFC 2616) */
  public static final int GONE = 410;
  /** 505 HTTP Version Not Supported (HTTP/1.1 - RFC 2616) */
  public static final int HTTP_VERSION_NOT_SUPPORTED = 505;
  /** 507 Insufficient Storage (WebDAV - RFC 2518). */
  public static final int INSUFFICIENT_STORAGE = 507;
  /** 500 Server Error (HTTP/1.0 - RFC 1945) */
  public static final int INTERNAL_SERVER_ERROR = 500;
  /** 411 Length Required (HTTP/1.1 - RFC 2616) */
  public static final int LENGTH_REQUIRED = 411;
  /** 423 Locked (WebDAV - RFC 2518). */
  public static final int LOCKED = 423;

  // --- 4xx Client Error ---

  /** 405 Method Not Allowed (HTTP/1.1 - RFC 2616) */
  public static final int METHOD_NOT_ALLOWED = 405;
  /** 301 Moved Permanently (HTTP/1.0 - RFC 1945) */
  public static final int MOVED_PERMANENTLY = 301;
  /** 302 Moved Temporarily (Sometimes Found) (HTTP/1.0 - RFC 1945) */
  public static final int MOVED_TEMPORARILY = 302;
  /**
   * 207 Multi-Status (WebDAV - RFC 2518) or 207 Partial Update OK (HTTP/1.1 -
   * draft-ietf-http-v11-spec-rev-01?)
   */
  public static final int MULTI_STATUS = 207;
  /** 300 Mutliple Choices (HTTP/1.1 - RFC 2616) */
  public static final int MULTIPLE_CHOICES = 300;
  /** 204 No Content (HTTP/1.0 - RFC 1945) */
  public static final int NO_CONTENT = 204;
  /** 203 Non Authoritative Information (HTTP/1.1 - RFC 2616) */
  public static final int NON_AUTHORITATIVE_INFORMATION = 203;
  /** 406 Not Acceptable (HTTP/1.1 - RFC 2616) */
  public static final int NOT_ACCEPTABLE = 406;
  /** 404 Not Found (HTTP/1.0 - RFC 1945) */
  public static final int NOT_FOUND = 404;
  /** 501 Not Implemented (HTTP/1.0 - RFC 1945) */
  public static final int NOT_IMPLEMENTED = 501;
  /** 304 Not Modified (HTTP/1.0 - RFC 1945) */
  public static final int NOT_MODIFIED = 304;
  /** 200 OK (HTTP/1.0 - RFC 1945) */
  public static final int OK = 200;
  /** 206 Partial Content (HTTP/1.1 - RFC 2616) */
  public static final int PARTIAL_CONTENT = 206;
  /** 402 Payment Required (HTTP/1.1 - RFC 2616) */
  public static final int PAYMENT_REQUIRED = 402;
  /** 412 Precondition Failed (HTTP/1.1 - RFC 2616) */
  public static final int PRECONDITION_FAILED = 412;
  /** 407 Proxy Authentication Required (HTTP/1.1 - RFC 2616) */
  public static final int PROXY_AUTHENTICATION_REQUIRED = 407;
  /** 408 Request Timeout (HTTP/1.1 - RFC 2616) */
  public static final int REQUEST_TIMEOUT = 408;
  /** 413 Request Entity Too Large (HTTP/1.1 - RFC 2616) */
  public static final int REQUEST_TOO_LONG = 413;

  /** 414 Request-URI Too Long (HTTP/1.1 - RFC 2616) */
  public static final int REQUEST_URI_TOO_LONG = 414;

  /** 416 Requested Range Not Satisfiable (HTTP/1.1 - RFC 2616) */
  public static final int REQUESTED_RANGE_NOT_SATISFIABLE = 416;

  /** 205 Reset Content (HTTP/1.1 - RFC 2616) */
  public static final int RESET_CONTENT = 205;

  /** 303 See Other (HTTP/1.1 - RFC 2616) */
  public static final int SEE_OTHER = 303;

  // --- 5xx Server Error ---

  /** 503 Service Unavailable (HTTP/1.0 - RFC 1945) */
  public static final int SERVICE_UNAVAILABLE = 503;
  /** 307 Temporary Redirect (HTTP/1.1 - RFC 2616) */
  public static final int TEMPORARY_REDIRECT = 307;
  /** 429 Too Many Requests. */
  public static final int TOO_MANY_REQUESTS = 429;
  /** 401 Unauthorized (HTTP/1.0 - RFC 1945) */
  public static final int UNAUTHORIZED = 401;
  /** 422 Unprocessable Entity (WebDAV - RFC 2518). */
  public static final int UNPROCESSABLE_ENTITY = 422;
  /** 415 Unsupported Media Type (HTTP/1.1 - RFC 2616) */
  public static final int UNSUPPORTED_MEDIA_TYPE = 415;

  /** 305 Use Proxy (HTTP/1.1 - RFC 2616) */
  public static final int USE_PROXY = 305;

}
