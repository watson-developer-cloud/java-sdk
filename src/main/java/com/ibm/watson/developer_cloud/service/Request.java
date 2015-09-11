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
package com.ibm.watson.developer_cloud.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.RequestUtil;

/**
 * Convenience class for constructing HTTP/HTTPS requests. <br>
 * Example: <pre>
 * {@code
 *  HttpRequestBase request = Request
 *     .Get("/v1/translate")
 *     .withQuery("from", "en", "to", "es", "text", "Good Morning")
 *     .build();
 * }</pre>
 * 
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class Request {

	/** The Constant UTF_8. */
	private static final String UTF_8 = "UTF-8";

	/**
	 * The DELETE method requests that the origin server delete the resource
	 * identified by the Request-URI.
	 * 
	 * @param url
	 *            the URL
	 * @param args
	 *            the list of arguments to format the URL
	 * 
	 * @return this
	 */
	public static Request Delete(String url, Object... args) {
		return new Request(HttpDelete.class, url, args);
	}

	/**
	 * The GET method means retrieve whatever information (in the form of an
	 * entity) is identified by the Request-URI.
	 * 
	 * @param url
	 *            the URL
	 * @param args
	 *            the list of arguments to format the URL
	 * 
	 * @return this
	 */
	public static Request Get(String url, Object... args) {
		return new Request(HttpGet.class, url, args);
	}

	/**
	 * The POST request method is designed to request that a web server accept
	 * the data enclosed in the request message's body for storage. It is often
	 * used when uploading a file or submitting a completed web form.
	 * 
	 * @param url
	 *            the URL
	 * @param args
	 *            the list of arguments to format the URL
	 * 
	 * @return this
	 */
	public static Request Post(String url, Object... args) {
		return new Request(HttpPost.class, url, args);
	}

	/**
	 * The PUT method requests that the enclosed entity be stored under the
	 * supplied Request-URI.
	 * 
	 * @param url
	 *            the URL
	 * @param args
	 *            the list of arguments to format the URL
	 * 
	 * @return this
	 */
	public static Request Put(String url, Object... args) {
		return new Request(HttpPut.class, url, args);
	}

	/** The form params. */
	private List<NameValuePair> formParams = new ArrayList<NameValuePair>();
	
	/** The headers. */
	private List<NameValuePair> headers = new ArrayList<NameValuePair>();
	
	/** The query params. */
	private List<NameValuePair> queryParams = new ArrayList<NameValuePair>();

	/** The body. */
	private HttpEntity body;
	
	/** The method. */
	private HttpRequestBase method;
	
	/** The url. */
	private String url;

	/**
	 * Instantiates a new request.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param method
	 *            the method, PUT, POST, GET or DELETE
	 * @param url
	 *            the request URL
	 * @param args
	 *            the list of arguments to format the URL
	 */
	private <T extends HttpRequestBase> Request(Class<T> method, String url,
			Object... args) {
		if (url == null)
			throw new IllegalArgumentException("url is null");
		if (method == null)
			throw new IllegalArgumentException("method is null");

		try {
			this.method = method.newInstance();
			// format url
			if (args != null && args.length > 0) {
				url = String.format(Locale.ENGLISH, url, args);
			}

			if (url.contains("?")) {
				String query = url.substring(
						Math.min(url.length(), url.indexOf("?") + 1),
						url.length());
				for (String s : query.split("&")) {
					String[] kv = s.split("=", 2);
					if (kv != null) {
						try {
							if (kv.length == 2) {
								queryParams.add(new BasicNameValuePair(
										URLDecoder.decode(kv[0], UTF_8),
										URLDecoder.decode(kv[1], UTF_8)));
							} else if (kv.length == 1) {
								queryParams.add(new BasicNameValuePair(
										URLDecoder.decode(kv[0], UTF_8), null));
							}
						} catch (UnsupportedEncodingException e) {
							throw new RuntimeException(e);
						}
					}
				}
				this.url = url.substring(0, url.indexOf("?"));
			} else {
				this.url = url;
			}
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Adds a key/value pair.
	 * 
	 * <pre>
	 * <code>
	 * Request r = new Request.get("https://foo.bar").add("singleParam", "value")
	 * 		.add("multiParam", new String[] { "1", "2", "3" })
	 * 		.add("singleParamWithOutValue", null);
	 * </code>
	 * </pre>
	 * 
	 * @param params
	 *            the parameters
	 * @param name
	 *            the parameter name
	 * @param value
	 *            the value to set, will be obtained via
	 *            {@link String#valueOf(boolean)}. If null, only the parameter
	 *            is set. It can also be a collection or array, in which case
	 *            all elements are added as query parameters
	 * 
	 * @return this
	 */
	private Request add(List<NameValuePair> params, String name, Object value) {
		if (value instanceof Iterable) {
			for (Object o : (Iterable<?>) value) {
				addParam(params, name, o);
			}
		} else if (value instanceof Object[]) {
			for (Object o : (Object[]) value) {
				addParam(params, name, o);
			}
		} else {
			addParam(params, name, value);
		}
		return this;
	}

	/**
	 * Adds the headers.
	 * 
	 * @param method
	 *            the method
	 * @param headers
	 *            the headers
	 */
	private void addHeaders(HttpRequestBase method, List<NameValuePair> headers) {
		for (NameValuePair header : headers) {
			method.addHeader(header.getName(), header.getValue());
		}
	}

	/**
	 * Adds the name, value par to the parameter list as
	 * <b>BasicNameValuePair</b>.
	 * 
	 * @param params
	 *            the parameter list
	 * @param name
	 *            the parameter name
	 * @param value
	 *            the parameter value
	 */
	private void addParam(List<NameValuePair> params, String name, Object value) {
		params.add(new BasicNameValuePair(name, value == null ? null : String
				.valueOf(value)));
	}

	/**
	 * Builds a request with the given set of parameters and files.
	 * 
	 * 
	 * @return HTTP request, prepared to be executed
	 */
	public HttpRequestBase build() {
		// GET
		method.setURI(URI.create(toUrl()));

		// POST/PUT
		if (method instanceof HttpPost || method instanceof HttpPut) {
			HttpEntityEnclosingRequestBase enclosingRequest = (HttpEntityEnclosingRequestBase) method;

			if (!formParams.isEmpty()) {
				// application/x-www-form-urlencoded
				withContent(RequestUtil.formatQueryString(formParams, UTF_8),
						MediaType.APPLICATION_FORM_URLENCODED);
			}

			if (body != null) {
				enclosingRequest.setHeader(body.getContentType());
				enclosingRequest.setEntity(body);

			}
		}
		if (!headers.isEmpty()) {
			// headers
			addHeaders(method, headers);
		}

		return method;
	}

	/**
	 * Create and return the URL being used in the request.
	 * 
	 * 
	 * @return the URL as string
	 */
	public String toUrl() {
		return toUrl(url);
	}

	/**
	 * Creates a URL and append the query parameters if exists.
	 * 
	 * @param url
	 *            the URL
	 * 
	 * @return an URL with the query string parameters appended
	 */
	private String toUrl(String url) {
		return queryParams.isEmpty() ? url : url + "?"
				+ RequestUtil.formatQueryString(queryParams, UTF_8);
	}

	/**
	 * Adds a name-value par to a given list.
	 * 
	 * @param params
	 *            a list of parameters
	 * @param args
	 *            a list of arguments
	 * 
	 * @return this
	 */
	private Request with(List<NameValuePair> params, Object... args) {
		if (args != null) {
			if (args.length % 2 != 0)
				throw new IllegalArgumentException(
						"need even number of arguments");
			for (int i = 0; i < args.length; i += 2) {
				add(params, args[i].toString(), args[i + 1]);
			}
		}
		return this;
	}

	/**
	 * Adds a JSON content to the request (used with POST/PUT). This will
	 * encapsulate the json into a
	 * {@link org.apache.http.entity.StringEntity StringEntity}
	 * encoded with UTF-8 and use "application/json" as Content-Type
	 * @param json
	 *            the JsonObject json
	 * 
	 * @return this
	 */
	public Request withContent(JsonObject json) {
		return withContent(json.toString(), MediaType.APPLICATION_JSON);
	}

	/**
	 * Adds string content to the request (used with POST/PUT). This will
	 * encapsulate the string into a
	 * {@link org.apache.http.entity.StringEntity StringEntity}
	 * encoded with UTF-8
	 * 
	 * @param content
	 *            the content to POST/PUT
	 * @param contentType
	 *            the HTTP contentType to use.
	 * 
	 * @return this
	 */
	public Request withContent(String content, String contentType) {
		StringEntity stringEntity = new StringEntity(content, UTF_8);
		if (contentType != null) {
			stringEntity.setContentType(contentType);
		}
		return withEntity(stringEntity);
	}

	/**
	 * Adds an arbitrary entity to the request (used with POST/PUT).
	 * 
	 * @param entity
	 *            the entity to POST/PUT
	 * 
	 * @return this
	 */
	public Request withEntity(HttpEntity entity) {
		body = entity;
		return this;
	}

	/**
	 * Adds form parameters.
	 * 
	 * @param args
	 *            a list of name-value form parameters
	 * 
	 * @return this
	 */
	public Request withForm(Object... args) {
		return with(formParams, args);
	}

	/**
	 * Adds header parameters.
	 * 
	 * @param args
	 *            a list of name-value headers
	 * 
	 * @return this
	 */
	public Request withHeader(Object... args) {
		return with(headers, args);
	}

	/**
	 * Adds query parameters.
	 * 
	 * @param args
	 *            a list of name-value query parameters
	 * 
	 * @return this
	 */
	public Request withQuery(Object... args) {
		return with(queryParams, args);
	}
}
