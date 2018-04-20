/**
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.service;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.service.security.IamToken;
import com.ibm.watson.developer_cloud.service.security.IamTokenManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IamManagerTest extends WatsonServiceUnitTest {

  private IamToken expiredTokenData;
  private IamToken validTokenData;
  private String url;

  private static final String ACCESS_TOKEN = "abcd-1234";
  private static final String API_KEY = "123456789";

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    url = getMockWebServerUrl();
    expiredTokenData = loadFixture("src/test/resources/expired_iam_token.json", IamToken.class);
    validTokenData = loadFixture("src/test/resources/valid_iam_token.json", IamToken.class);
  }

  /**
   * Tests that if a user passes in an access token during initial IAM setup, that access token is passed back
   * during later retrieval.
   */
  @Test
  public void getUserManagedTokenFromConstructor() {
    IamOptions options = new IamOptions.Builder()
        .accessToken(ACCESS_TOKEN)
        .url(url)
        .build();
    IamTokenManager manager = new IamTokenManager(options);

    String token = manager.getToken();
    assertEquals(ACCESS_TOKEN, token);
  }

  /**
   * Tests that if only an API key is stored, the user can get back a valid access token.
   */
  @Test
  public void getTokenFromApiKey() throws InterruptedException {
    server.enqueue(jsonResponse(validTokenData));

    IamOptions options = new IamOptions.Builder()
        .apiKey(API_KEY)
        .url(url)
        .build();
    IamTokenManager manager = new IamTokenManager(options);

    String token = manager.getToken();
    assertEquals(validTokenData.getAccessToken(), token);
  }

  /**
   * Tests that if the stored access token is expired, it can be refreshed properly.
   */
  @Test
  public void getTokenAfterRefresh() {
    server.enqueue(jsonResponse(expiredTokenData));

    IamOptions options = new IamOptions.Builder()
        .apiKey(API_KEY)
        .url(url)
        .build();
    IamTokenManager manager = new IamTokenManager(options);

    // setting expired token
    manager.getToken();

    // getting valid token
    server.enqueue(jsonResponse(validTokenData));
    String newToken = manager.getToken();

    assertEquals(validTokenData.getAccessToken(), newToken);
  }
}
