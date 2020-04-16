/*
 * (C) Copyright IBM Corp. 2018, 2019.
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
package com.ibm.watson.assistant.v1;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.common.WatsonServiceTest;
import java.util.Date;
import org.junit.Assume;
import org.junit.Before;

public class AssistantServiceTest extends WatsonServiceTest {

  private Assistant service;
  private String workspaceId;

  public Assistant getService() {
    return this.service;
  }

  public String getWorkspaceId() {
    return this.workspaceId;
  }

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String apiKey = getProperty("assistant.apikey");
    workspaceId = getProperty("assistant.workspace_id");

    Assume.assumeFalse("config.properties doesn't have valid credentials.", apiKey == null);

    Authenticator authenticator = new IamAuthenticator(apiKey);
    service = new Assistant("2019-02-28", authenticator);
    service.setServiceUrl(getProperty("assistant.url"));
    service.setDefaultHeaders(getDefaultHeaders());
  }

  private long tolerance = 2000; // 2 secs in ms

  /** return `true` if ldate before rdate within tolerance. */
  public boolean fuzzyBefore(Date ldate, Date rdate) {
    return (ldate.getTime() - rdate.getTime()) < tolerance;
  }

  /** return `true` if ldate after rdate within tolerance. */
  public boolean fuzzyAfter(Date ldate, Date rdate) {
    return (rdate.getTime() - ldate.getTime()) < tolerance;
  }
}
