/*
 * Copyright © 2017 IBM Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.ibm.watson.developer_cloud.spring.boot.test;

import com.ibm.watson.developer_cloud.discovery.v1.Discovery;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.spring.boot.WatsonAutoConfiguration;
import okhttp3.Credentials;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {WatsonAutoConfiguration.class},loader=AnnotationConfigContextLoader.class)
@TestPropertySource(properties = {
    "watson.discovery.url="+DiscoveryAutoConfigTest.url,
    "watson.discovery.username="+DiscoveryAutoConfigTest.username,
    "watson.discovery.password="+DiscoveryAutoConfigTest.password,
    "watson.discovery.versionDate="+DiscoveryAutoConfigTest.versionDate
})
public class DiscoveryAutoConfigTest {

  static final String url = "http://watson.com/discovery";
  static final String username = "sam";
  static final String password = "secret";
  static final String versionDate = "2017-12-15";

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  public void discoveryBeanConfig() {
    Discovery discovery = (Discovery) applicationContext.getBean("discovery");

    assertNotNull(discovery);
    assertEquals(url, discovery.getEndPoint());

    // Verify the credentials and versionDate -- which are stored in private member variables
    try {
      Field apiKeyField = WatsonService.class.getDeclaredField("apiKey");
      apiKeyField.setAccessible(true);
      assertEquals(Credentials.basic(username, password), (String) apiKeyField.get(discovery));

      Field versionField = Discovery.class.getDeclaredField("versionDate");
      versionField.setAccessible(true);
      assertEquals(versionDate, (String) versionField.get(discovery));
    } catch (NoSuchFieldException|IllegalAccessException ex) {
      // This shouldn't happen
      assert(false);
    }
  }
}