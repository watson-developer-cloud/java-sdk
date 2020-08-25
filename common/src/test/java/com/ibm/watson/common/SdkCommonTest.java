/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
package com.ibm.watson.common;

import static org.junit.Assert.assertTrue;

import com.ibm.cloud.sdk.core.http.HttpHeaders;
import java.util.Map;
import org.junit.Test;

/** The Class SdkCommonTest. */
public class SdkCommonTest {

  /** Test get sdk headers. */
  @Test
  public void testGetSdkHeaders() {
    String serviceName = "test_name";
    String serviceVersion = "v1";
    String operationId = "test_method";
    Map<String, String> defaultHeaders =
        SdkCommon.getSdkHeaders(serviceName, serviceVersion, operationId);

    assertTrue(defaultHeaders.containsKey(WatsonHttpHeaders.X_IBMCLOUD_SDK_ANALYTICS));
    String analyticsHeaderValue = defaultHeaders.get(WatsonHttpHeaders.X_IBMCLOUD_SDK_ANALYTICS);
    assertTrue(analyticsHeaderValue.contains(serviceName));
    assertTrue(analyticsHeaderValue.contains(serviceVersion));
    assertTrue(analyticsHeaderValue.contains(operationId));
    assertTrue(defaultHeaders.containsKey(HttpHeaders.USER_AGENT));
    assertTrue(defaultHeaders.get(HttpHeaders.USER_AGENT).startsWith("watson-apis-java-sdk/"));
  }
}
