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

package com.ibm.watson.developer_cloud.spring.boot;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(WatsonConversationConfigurationProperties.class)
public class WatsonAutoConfiguration {

  @Autowired
  private WatsonConversationConfigurationProperties config;

  @Bean
  @ConditionalOnMissingBean
  public Conversation conversation() {
    Conversation service = new Conversation(config.getVersionDate());
    String username = config.getUsername();
    String password = config.getPassword();
    if (username != null && password != null) {
      service.setUsernameAndPassword(username, password);
    }
    String url = config.getUrl();
    if (url != null) {
      service.setEndPoint(url);
    }
    return service;
  }

}
