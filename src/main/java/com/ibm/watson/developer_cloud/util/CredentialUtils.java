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
package com.ibm.watson.developer_cloud.util;

import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.squareup.okhttp.Credentials;

/**
 * The Class CredentialUtils.
 */
public class CredentialUtils {

  /** The Constant ALCHEMY_API. */
  private static final String ALCHEMY_API = "alchemy_api";

  /** The Constant APIKEY. */
  private static final String APIKEY = "apikey";

  /** The Constant CREDENTIALS. */
  private static final String CREDENTIALS = "credentials";

  /** The Constant log. */
  private static final Logger log = Logger.getLogger(CredentialUtils.class.getName());

  /** The Constant PASSWORD. */
  private static final String PASSWORD = "password";

  /** The Constant PLAN. */
  private static final String PLAN = "plan";

  /** The Constant PLAN_EXPERIMENTAL. */
  public static final String PLAN_EXPERIMENTAL = "experimental";

  /** The Constant PLAN_FREE. */
  public static final String PLAN_FREE = "free";

  /** The Constant PLAN_STANDARD. */
  public static final String PLAN_STANDARD = "standard";

  /** The services. */
  private static String services;

  /** The Constant USERNAME. */
  private static final String USERNAME = "username";

  /**
   * Returns the apiKey from the VCAP_SERVICES or null if doesn't exists.
   * 
   * @param serviceName the service name
   * @return the API key or null if the service cannot be found.
   */
  public static String getAPIKey(String serviceName) {
    return getAPIKey(serviceName, null);
  }

  /**
   * Returns the apiKey from the VCAP_SERVICES or null if doesn't exists. If plan is specified, then
   * only credentials for the given plan will be returned.
   * 
   * @param serviceName the service name
   * @param plan the service plan: standard, free or experimental
   * @return the API key
   */
  public static String getAPIKey(String serviceName, String plan) {
    if (serviceName == null || serviceName.isEmpty())
      return null;

    final JsonObject services = getVCAPServices();
    if (services == null)
      return getKeyUsingJNDI(serviceName);

    for (final Entry<String, JsonElement> entry : services.entrySet()) {
      final String key = entry.getKey();
      if (key.startsWith(serviceName)) {
        final JsonArray servInstances = services.getAsJsonArray(key);
        for (final JsonElement instance : servInstances) {
          final JsonObject service = instance.getAsJsonObject();
          final String instancePlan = service.get(PLAN).getAsString();
          if (plan == null || plan.equalsIgnoreCase(instancePlan)) {
            final JsonObject credentials = instance.getAsJsonObject().getAsJsonObject(CREDENTIALS);
            if (serviceName.equalsIgnoreCase(ALCHEMY_API)) {
              return credentials.get(APIKEY).getAsString();
            } else {
              final String username = credentials.get(USERNAME).getAsString();
              final String password = credentials.get(PASSWORD).getAsString();
              return Credentials.basic(username, password);
            }
          }
        }
      }
    }
    return null;
  }

  /**
   * Attempt to get the Base64-encoded API key through JNDI
   * 
   * @param serviceName Name of the bluemix service
   * @return The encoded API Key
   */
  private static String getKeyUsingJNDI(String serviceName) {
    try {
      Class.forName("javax.naming.Context");
      try {
        Context context = new InitialContext();
        String lookupName = "watson-developer-cloud/" + serviceName + "/credentials";
        String apiKey = (String) context.lookup(lookupName);
        return apiKey;
      } catch (NamingException e) {
        return null;
      }
    } catch (ClassNotFoundException exception) {
      log.info("JNDI string lookups is not available.");
    }
    return null;
  }

  /**
   * Gets the <b>VCAP_SERVICES</b> environment variable and return it as a {@link JsonObject}.
   * 
   * @return the VCAP_SERVICES as a {@link JsonObject}.
   */
  private static JsonObject getVCAPServices() {
    final String envServices = services != null ? services : System.getenv("VCAP_SERVICES");
    if (envServices == null)
      return null;

    JsonObject vcapServices = null;

    try {
      final JsonParser parser = new JsonParser();
      vcapServices = (JsonObject) parser.parse(envServices);
    } catch (final JsonSyntaxException e) {
      log.log(Level.INFO, "Error parsing VCAP_SERVICES", e);
    }
    return vcapServices;
  }

  /**
   * Sets the VCAP_SERVICES variable. This is utility variable for testing
   * 
   * @param services the VCAP_SERVICES
   */
  public static void setServices(String services) {
    CredentialUtils.services = services;
  }
}
