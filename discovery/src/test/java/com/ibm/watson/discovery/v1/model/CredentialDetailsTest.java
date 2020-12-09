/*
 * (C) Copyright IBM Corp. 2020.
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

/** Unit test class for the CredentialDetails model. */
public class CredentialDetailsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCredentialDetails() throws Throwable {
    CredentialDetails credentialDetailsModel =
        new CredentialDetails.Builder()
            .credentialType("oauth2")
            .clientId("testString")
            .enterpriseId("testString")
            .url("testString")
            .username("testString")
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
    assertEquals(credentialDetailsModel.credentialType(), "oauth2");
    assertEquals(credentialDetailsModel.clientId(), "testString");
    assertEquals(credentialDetailsModel.enterpriseId(), "testString");
    assertEquals(credentialDetailsModel.url(), "testString");
    assertEquals(credentialDetailsModel.username(), "testString");
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

    String json = TestUtilities.serialize(credentialDetailsModel);

    CredentialDetails credentialDetailsModelNew =
        TestUtilities.deserialize(json, CredentialDetails.class);
    assertTrue(credentialDetailsModelNew instanceof CredentialDetails);
    assertEquals(credentialDetailsModelNew.credentialType(), "oauth2");
    assertEquals(credentialDetailsModelNew.clientId(), "testString");
    assertEquals(credentialDetailsModelNew.enterpriseId(), "testString");
    assertEquals(credentialDetailsModelNew.url(), "testString");
    assertEquals(credentialDetailsModelNew.username(), "testString");
    assertEquals(credentialDetailsModelNew.organizationUrl(), "testString");
    assertEquals(credentialDetailsModelNew.siteCollectionPath(), "testString");
    assertEquals(credentialDetailsModelNew.clientSecret(), "testString");
    assertEquals(credentialDetailsModelNew.publicKeyId(), "testString");
    assertEquals(credentialDetailsModelNew.privateKey(), "testString");
    assertEquals(credentialDetailsModelNew.passphrase(), "testString");
    assertEquals(credentialDetailsModelNew.password(), "testString");
    assertEquals(credentialDetailsModelNew.gatewayId(), "testString");
    assertEquals(credentialDetailsModelNew.sourceVersion(), "online");
    assertEquals(credentialDetailsModelNew.webApplicationUrl(), "testString");
    assertEquals(credentialDetailsModelNew.domain(), "testString");
    assertEquals(credentialDetailsModelNew.endpoint(), "testString");
    assertEquals(credentialDetailsModelNew.accessKeyId(), "testString");
    assertEquals(credentialDetailsModelNew.secretAccessKey(), "testString");
  }
}
