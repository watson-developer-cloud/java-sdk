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
package com.ibm.watson.developer_cloud.http;

/**
 * Constants enumerating the HTTP status codes. All status codes defined in RFC1945 (HTTP/1.0), RFC2616 (HTTP/1.1), and
 * RFC2518 (WebDAV) are listed.
 *
 * Adapted from the Apache Software Foundation
 */
public interface HttpStatus {

  /** 202 Accepted (HTTP/1.0 - RFC 1945). */
  int ACCEPTED = 202;

  // --- 2xx Success ---

  /** 502 Bad Gateway (HTTP/1.0 - RFC 1945). */
  int BAD_GATEWAY = 502;
  /** 400 Bad Request (HTTP/1.1 - RFC 2616). */
  int BAD_REQUEST = 400;
  /** 409 Conflict (HTTP/1.1 - RFC 2616). */
  int CONFLICT = 409;
  /** 100 Continue (HTTP/1.1 - RFC 2616). */
  int CONTINUE = 100;
  /** 201 Created (HTTP/1.0 - RFC 1945). */
  int CREATED = 201;
  /** 417 Expectation Failed (HTTP/1.1 - RFC 2616). */
  int EXPECTATION_FAILED = 417;
  /** 424 Failed Dependency (WebDAV - RFC 2518). */
  int FAILED_DEPENDENCY = 424;

  /** 403 Forbidden (HTTP/1.0 - RFC 1945). */
  int FORBIDDEN = 403;

  // --- 3xx Redirection ---

  /** 504 Gateway Timeout (HTTP/1.1 - RFC 2616). */
  int GATEWAY_TIMEOUT = 504;
  /** 410 Gone (HTTP/1.1 - RFC 2616). */
  int GONE = 410;
  /** 505 HTTP Version Not Supported (HTTP/1.1 - RFC 2616). */
  int HTTP_VERSION_NOT_SUPPORTED = 505;
  /** 507 Insufficient Storage (WebDAV - RFC 2518). */
  int INSUFFICIENT_STORAGE = 507;
  /** 500 Server Error (HTTP/1.0 - RFC 1945). */
  int INTERNAL_SERVER_ERROR = 500;
  /** 411 Length Required (HTTP/1.1 - RFC 2616). */
  int LENGTH_REQUIRED = 411;
  /** 423 Locked (WebDAV - RFC 2518). */
  int LOCKED = 423;

  // --- 4xx Client Error ---

  /** 405 Method Not Allowed (HTTP/1.1 - RFC 2616). */
  int METHOD_NOT_ALLOWED = 405;
  /** 301 Moved Permanently (HTTP/1.0 - RFC 1945). */
  int MOVED_PERMANENTLY = 301;
  /** 302 Moved Temporarily (Sometimes Found) (HTTP/1.0 - RFC 1945). */
  int MOVED_TEMPORARILY = 302;
  /**
   * 207 Multi-Status (WebDAV - RFC 2518) or 207 Partial Update OK (HTTP/1.1 - draft-ietf-http-v11-spec-rev-01?).
   */
  int MULTI_STATUS = 207;
  /** 300 Mutliple Choices (HTTP/1.1 - RFC 2616). */
  int MULTIPLE_CHOICES = 300;
  /** 204 No Content (HTTP/1.0 - RFC 1945). */
  int NO_CONTENT = 204;
  /** 203 Non Authoritative Information (HTTP/1.1 - RFC 2616). */
  int NON_AUTHORITATIVE_INFORMATION = 203;
  /** 406 Not Acceptable (HTTP/1.1 - RFC 2616). */
  int NOT_ACCEPTABLE = 406;
  /** 404 Not Found (HTTP/1.0 - RFC 1945). */
  int NOT_FOUND = 404;
  /** 501 Not Implemented (HTTP/1.0 - RFC 1945). */
  int NOT_IMPLEMENTED = 501;
  /** 304 Not Modified (HTTP/1.0 - RFC 1945). */
  int NOT_MODIFIED = 304;
  /** 200 OK (HTTP/1.0 - RFC 1945). */
  int OK = 200;
  /** 206 Partial Content (HTTP/1.1 - RFC 2616). */
  int PARTIAL_CONTENT = 206;
  /** 402 Payment Required (HTTP/1.1 - RFC 2616). */
  int PAYMENT_REQUIRED = 402;
  /** 412 Precondition Failed (HTTP/1.1 - RFC 2616). */
  int PRECONDITION_FAILED = 412;
  /** 407 Proxy Authentication Required (HTTP/1.1 - RFC 2616). */
  int PROXY_AUTHENTICATION_REQUIRED = 407;
  /** 408 Request Timeout (HTTP/1.1 - RFC 2616). */
  int REQUEST_TIMEOUT = 408;
  /** 413 Request Entity Too Large (HTTP/1.1 - RFC 2616). */
  int REQUEST_TOO_LONG = 413;

  /** 414 Request-URI Too Long (HTTP/1.1 - RFC 2616). */
  int REQUEST_URI_TOO_LONG = 414;

  /** 416 Requested Range Not Satisfiable (HTTP/1.1 - RFC 2616). */
  int REQUESTED_RANGE_NOT_SATISFIABLE = 416;

  /** 205 Reset Content (HTTP/1.1 - RFC 2616). */
  int RESET_CONTENT = 205;

  /** 303 See Other (HTTP/1.1 - RFC 2616). */
  int SEE_OTHER = 303;

  // --- 5xx Server Error ---

  /** 503 Service Unavailable (HTTP/1.0 - RFC 1945). */
  int SERVICE_UNAVAILABLE = 503;
  /** 307 Temporary Redirect (HTTP/1.1 - RFC 2616). */
  int TEMPORARY_REDIRECT = 307;
  /** 429 Too Many Requests. */
  int TOO_MANY_REQUESTS = 429;
  /** 401 Unauthorized (HTTP/1.0 - RFC 1945). */
  int UNAUTHORIZED = 401;
  /** 422 Unprocessable Entity (WebDAV - RFC 2518). */
  int UNPROCESSABLE_ENTITY = 422;
  /** 415 Unsupported Media Type (HTTP/1.1 - RFC 2616). */
  int UNSUPPORTED_MEDIA_TYPE = 415;

  /** 305 Use Proxy (HTTP/1.1 - RFC 2616). */
  int USE_PROXY = 305;

}
