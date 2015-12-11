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
package com.ibm.watson.developer_cloud;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;

import org.junit.After;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;

import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;

/**
 * Utility class to Mock the Watson Services.
 * 
 */
public abstract class WatsonServiceUnitTest extends WatsonServiceTest {

  protected static final Header APPLICATION_JSON = new Header(HttpHeaders.CONTENT_TYPE,
      HttpMediaType.APPLICATION_JSON);
  protected static final Header TEXT_PLAIN = new Header(HttpHeaders.CONTENT_TYPE,
      HttpMediaType.TEXT.toString());

  protected static final String DELETE = "DELETE";
  protected static final String GET = "GET";
  protected static final String POST = "POST";
  protected static final String PUT = "PUT";

  protected static final int MOCK_SERVER_PORT = 9898;
  protected static final String MOCK_SERVER_URL = "http://localhost:" + MOCK_SERVER_PORT;

  protected ClientAndServer mockServer;

  /**
   * Setups and starts the mock server.
   * 
   * @throws Exception the exception
   */
  @Override
  public void setUp() throws Exception {
    mockServer = startClientAndServer(MOCK_SERVER_PORT);
  }

  /**
   * Stops the mock server
   */
  @After
  public void tearDown() {
    mockServer.stop();
  }

}
