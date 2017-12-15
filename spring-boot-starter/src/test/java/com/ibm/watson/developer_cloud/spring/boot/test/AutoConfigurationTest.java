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

import com.ibm.watson.developer_cloud.spring.boot.WatsonAutoConfiguration;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class AutoConfigurationTest {

  private AnnotationConfigApplicationContext context;

  @Before
  public void setUp() {
    this.context = new AnnotationConfigApplicationContext();
  }

  @After
  public void cleanup() {
    if (this.context != null) {
      this.context.close();
    }
  }

  private static Conversation mockConversation = mock(Conversation.class);

  @Test
  public void conversationBeanCreation() {
    this.context.register(MockConversationConfig.class, WatsonAutoConfiguration.class);
    EnvironmentTestUtils.addEnvironment(this.context, "watson.url=http://watson.com");
    this.context.refresh();
    Conversation service = this.context.getBean(Conversation.class);
    assertNotNull(service);
  }

  @Configuration
  protected static class MockConversationConfig {
    @Bean
    public Conversation builder() {
      return mockConversation;
    }
  }

}