/*
 * (C) Copyright IBM Corp. 2020, 2021.
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

package com.ibm.watson.discovery.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.discovery.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the Credentials model. */
public class CredentialsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCredentials() throws Throwable {
    CredentialDetails credentialDetailsModel =
        new CredentialDetails.Builder()
            .credentialType("username_password")
            .clientId("testString")
            .enterpriseId("testString")
            .url("login.salesforce.com")
            .username("user@email.address")
            .organizationUrl("testString")
            .siteCollectionPath("testString")
            .clientSecret("testString")
            .publicKeyId("testString")
            .privateKey("testString")
            .passphrase("testString")
            .password("testString")
            .gatewayId("testString")
            .sourceVersion("online")
            .webApplicationUrl("testString")
            .domain("testString")
            .endpoint("testString")
            .accessKeyId("testString")
            .secretAccessKey("testString")
            .build();
    assertEquals(credentialDetailsModel.credentialType(), "username_password");
    assertEquals(credentialDetailsModel.clientId(), "testString");
    assertEquals(credentialDetailsModel.enterpriseId(), "testString");
    assertEquals(credentialDetailsModel.url(), "login.salesforce.com");
    assertEquals(credentialDetailsModel.username(), "user@email.address");
    assertEquals(credentialDetailsModel.organizationUrl(), "testString");
    assertEquals(credentialDetailsModel.siteCollectionPath(), "testString");
    assertEquals(credentialDetailsModel.clientSecret(), "testString");
    assertEquals(credentialDetailsModel.publicKeyId(), "testString");
    assertEquals(credentialDetailsModel.privateKey(), "testString");
    assertEquals(credentialDetailsModel.passphrase(), "testString");
    assertEquals(credentialDetailsModel.password(), "testString");
    assertEquals(credentialDetailsModel.gatewayId(), "testString");
    assertEquals(credentialDetailsModel.sourceVersion(), "online");
    assertEquals(credentialDetailsModel.webApplicationUrl(), "testString");
    assertEquals(credentialDetailsModel.domain(), "testString");
    assertEquals(credentialDetailsModel.endpoint(), "testString");
    assertEquals(credentialDetailsModel.accessKeyId(), "testString");
    assertEquals(credentialDetailsModel.secretAccessKey(), "testString");

    StatusDetails statusDetailsModel =
        new StatusDetails.Builder().authenticated(true).errorMessage("testString").build();
    assertEquals(statusDetailsModel.authenticated(), Boolean.valueOf(true));
    assertEquals(statusDetailsModel.errorMessage(), "testString");

    Credentials credentialsModel =
        new Credentials.Builder()
            .sourceType("box")
            .credentialDetails(credentialDetailsModel)
            .status(statusDetailsModel)
            .build();
    assertEquals(credentialsModel.sourceType(), "box");
    assertEquals(credentialsModel.credentialDetails(), credentialDetailsModel);
    assertEquals(credentialsModel.status(), statusDetailsModel);

    String json = TestUtilities.serialize(credentialsModel);

    Credentials credentialsModelNew = TestUtilities.deserialize(json, Credentials.class);
    assertTrue(credentialsModelNew instanceof Credentials);
    assertEquals(credentialsModelNew.sourceType(), "box");
    assertEquals(
        credentialsModelNew.credentialDetails().toString(), credentialDetailsModel.toString());
    assertEquals(credentialsModelNew.status().toString(), statusDetailsModel.toString());
  }
}
