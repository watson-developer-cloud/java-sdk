package com.ibm.watson.common;

import com.ibm.cloud.sdk.core.http.HttpHeaders;
import com.ibm.cloud.sdk.core.test.WatsonServiceUnitTest;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class SdkCommonTest extends WatsonServiceUnitTest {
  @Test
  public void testGetDefaultHeaders() {
    String serviceName = "test_name";
    String serviceVersion = "v1";
    String operationId = "test_method";
    Map<String, String> defaultHeaders = SdkCommon.getDefaultHeaders(serviceName, serviceVersion, operationId);

    assertTrue(defaultHeaders.containsKey(HttpHeaders.X_IBMCLOUD_SDK_ANALYTICS));
    String analyticsHeaderValue = defaultHeaders.get(HttpHeaders.X_IBMCLOUD_SDK_ANALYTICS);
    assertTrue(analyticsHeaderValue.contains(serviceName));
    assertTrue(analyticsHeaderValue.contains(serviceVersion));
    assertTrue(analyticsHeaderValue.contains(operationId));
    assertTrue(defaultHeaders.containsKey(HttpHeaders.USER_AGENT));
    assertTrue(defaultHeaders.get(HttpHeaders.USER_AGENT).startsWith("watson-apis-java-sdk/"));
  }
}
