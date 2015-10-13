package com.ibm.watson.developer_cloud.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.FileEntity;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.util.MediaType;

public class RequestTest {

	private String url = "http://www.example.com";
	private String urlWithQuery = url + "?foo=bar&p2=p2";

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException() {
		Request.Delete(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentExceptionEvenNumbers() {
		Request.Put(url).withForm("1","2","3").build();
	}
	
	@Test
	public void testDelete() {
		HttpRequestBase request = Request.Delete(urlWithQuery).build();
		assertEquals("DELETE", request.getMethod());
		assertEquals(urlWithQuery, request.getURI().toASCIIString());
	}

	@Test
	public void testGet() {
		HttpRequestBase request = Request.Get(urlWithQuery).build();
		assertEquals("GET", request.getMethod());
		assertEquals(urlWithQuery, request.getURI().toASCIIString());
	}

	@Test
	public void testPost() {
		HttpRequestBase request = Request.Post(url).build();
		assertEquals("POST", request.getMethod());
		assertEquals(url, request.getURI().toASCIIString());
	}

	@Test
	public void testPut() {
		HttpRequestBase request = Request.Put(urlWithQuery).build();
		assertEquals("PUT", request.getMethod());
		assertEquals(urlWithQuery, request.getURI().toASCIIString());
	}

	@Test
	public void testBuild() {
		HttpRequestBase request = Request.Post(urlWithQuery).withContent("body1", MediaType.TEXT_PLAIN)
				.withHeader("x-token", "token1").build();

		assertEquals("POST", request.getMethod());
		assertEquals("token1", request.getAllHeaders()[1].getValue());
	}

	/**
	 * Test with content json object.
	 */
	@Test
	public void testWithContentJsonObject() {
		JsonObject json = new JsonObject();
		json.addProperty("status", "ok");
		HttpRequestBase request = Request.Post(urlWithQuery).withContent(json).build();

		HttpEntityEnclosingRequestBase postRequest = (HttpEntityEnclosingRequestBase) request;

		String body = getBodyAsString(postRequest);

		assertEquals(json.toString(), body);
		assertEquals(MediaType.APPLICATION_JSON, postRequest.getEntity().getContentType().getValue());
	}

	/**
	 * Gets the request body as string.
	 * 
	 * @param request
	 *            the request
	 * @return the body as string
	 */
	private String getBodyAsString(HttpEntityEnclosingRequestBase request) {
		String ret = null;

		if (request != null && request.getEntity() != null) {

			StringWriter writer = new StringWriter();
			try {
				IOUtils.copy(request.getEntity().getContent(), writer);
			} catch (IllegalStateException | IOException e) {}
			ret = writer.toString();
		}
		return ret;
	}

	@Test
	public void testWithContentStringString() {
		String body = "test2";
		HttpRequestBase request = Request.Post(urlWithQuery).withContent(body, MediaType.TEXT_PLAIN).build();

		HttpEntityEnclosingRequestBase postRequest = (HttpEntityEnclosingRequestBase) request;

		assertEquals(body, getBodyAsString(postRequest));
		assertEquals(MediaType.TEXT_PLAIN, postRequest.getEntity().getContentType().getValue());

	}

	@Test
	public void testWithEntity() {
		File test = new File("src/test/resources/car.png");
		FileEntity entity = new FileEntity(test, MediaType.APPLICATION_OCTET_STREAM);

		HttpRequestBase request = Request.Post(urlWithQuery).withEntity(entity).build();

		HttpEntityEnclosingRequestBase postRequest = (HttpEntityEnclosingRequestBase) request;

		assertEquals(entity, postRequest.getEntity());
	}

	@Test
	public void testWithFormObjectArray() {
		String body = "foo=bar&test1=test2";
		HttpRequestBase request = Request.Post(urlWithQuery).withForm("foo", "bar", "test1", "test2").build();

		HttpEntityEnclosingRequestBase postRequest = (HttpEntityEnclosingRequestBase) request;

		assertEquals(body, getBodyAsString(postRequest));
		assertEquals(MediaType.APPLICATION_FORM_URLENCODED, postRequest.getEntity().getContentType().getValue());
	}

	@Test
	public void testWithQueryObjectArray() {
		HttpRequestBase request = Request.Post(url).withQuery("foo", "bar", "p2", "p2").build();
		assertEquals(urlWithQuery, request.getURI().toASCIIString());
	}

	@Test
	public void testWithQueryMapOfStringObject() {
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("p2", "p2");
		queryParams.put("foo", "bar");
		

		HttpRequestBase request = Request.Post(url).withQueryMap(queryParams).build();

		assertEquals("p2=p2&foo=bar", request.getURI().getQuery());
	}

	@Test
	public void testWithFormMapOfStringObject() {
		String body = "p2=p2&foo=bar";

		Map<String, Object> formParams = new HashMap<String, Object>();
		formParams.put("p2", "p2");
		formParams.put("foo", "bar");
		

		HttpRequestBase request = Request.Post(url).withFormMap(formParams).build();

		HttpEntityEnclosingRequestBase postRequest = (HttpEntityEnclosingRequestBase) request;

		assertEquals(body, getBodyAsString(postRequest));
		assertEquals(MediaType.APPLICATION_FORM_URLENCODED, postRequest.getEntity().getContentType().getValue());

	}

}
