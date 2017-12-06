/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.util;

import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import okhttp3.Credentials;

/**
 * CredentialUtils retrieves service credentials from the environment.
 */
public final class CredentialUtils {

  /**
   * A util class to easily store service credentials.
   *
   */
  public static class ServiceCredentials {
    private String password;
    private String username;

    private ServiceCredentials(String username, String password) {
      this.username = username;
      this.password = password;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
      return password;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
      return username;
    }
  }

  /** The Constant ALCHEMY_API. */
  private static final String ALCHEMY_API = "alchemy_api";

  /** The Constant VISUAL_RECOGNITION. */
  private static final String VISUAL_RECOGNITION = "watson_vision_combined";

  /** The Constant VCAP_SERVICES. */
  private static final String VCAP_SERVICES = "VCAP_SERVICES";

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

  /** The services. */
  private static String services;

  /** The context. */
  private static Context context;

  /** The Constant USERNAME. */
  private static final String USERNAME = "username";

  /** The Constant URL. */
  private static final String URL = "url";

  /** The Constant PLAN_EXPERIMENTAL. */
  public static final String PLAN_EXPERIMENTAL = "experimental";

  /** The Constant PLAN_FREE. */
  public static final String PLAN_FREE = "free";

  /** The Constant PLAN_STANDARD. */
  public static final String PLAN_STANDARD = "standard";

  /** The Constant API_KEY. */
  private static final String API_KEY = "api_key";

  /** The Constant LOOKUP_NAME_EXTENSION_API_KEY. */
  private static final String LOOKUP_NAME_EXTENSION_API_KEY = "/credentials";

  /** The Constant LOOKUP_NAME_EXTENSION_URL. */
  private static final String LOOKUP_NAME_EXTENSION_URL = "/url";

  private CredentialUtils() {
    // This is a utility class - no instantiation allowed.
  }

  /**
   * Builds the lookup name to be searched for in JDNI
   * and uses it to call the overloaded JDNI method.
   *
   * @param serviceName Name of the bluemix service
   * @param lookupNameExtension Extension to determine which value should be retrieved through JDNI
   * @return The encoded desired value
   */
  private static String getJDNIValue(String serviceName, String lookupNameExtension) {
    return getJDNIValue("watson-developer-cloud/" + serviceName + lookupNameExtension);
  }

  /**
   * Attempt to get the Base64-encoded value through JNDI.
   *
   * This method should always return null on Android due to the javax functions being unsupported
   *
   * @param lookupName Key to lookup in JDNI
   * @return The encoded desired value
   */
  private static String getJDNIValue(String lookupName) {
    if (!isClassAvailable("javax.naming.Context") || !isClassAvailable("javax.naming.InitialContext")) {
      log.info("JNDI string lookups is not available.");
      return null;
    }

    try {
      if (context == null) {
        context = new InitialContext();
      }
      return (String) context.lookup(lookupName);
    } catch (Exception e) {
      log.fine("JNDI " + lookupName + " not found.");
      return null;
    }
  }

  private static boolean isClassAvailable(String className) {
    try {
      Class.forName(className);
      return true;
    } catch (Throwable e) {
      return false;
    }
  }

  /**
   * Gets the <b>VCAP_SERVICES</b> environment variable and return it as a {@link JsonObject}.
   *
   * @return the VCAP_SERVICES as a {@link JsonObject}.
   */
  private static JsonObject getVCAPServices() {
    final String envServices = services != null ? services : System.getenv(VCAP_SERVICES);
    if (envServices == null) {
      return null;
    }

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
   * Returns the apiKey from the VCAP_SERVICES or null if doesn't exists.
   *
   * @param serviceName the service name
   * @return the API key or null if the service cannot be found.
   */
  public static String getAPIKey(String serviceName) {
    return getAPIKey(serviceName, null);
  }

  /**
   * Returns the apiKey from the VCAP_SERVICES or null if doesn't exists. If plan is specified, then only credentials
   * for the given plan will be returned.
   *
   * @param serviceName the service name
   * @param plan the service plan: standard, free or experimental
   * @return the API key
   */
  public static String getAPIKey(String serviceName, String plan) {
    if ((serviceName == null) || serviceName.isEmpty()) {
      return null;
    }

    final JsonObject services = getVCAPServices();
    if (services == null) {
      return getJDNIValue(serviceName, LOOKUP_NAME_EXTENSION_API_KEY);
    }
    if (serviceName.equalsIgnoreCase(ALCHEMY_API)) {
      final JsonObject credentials = getCredentialsObject(services, serviceName, plan);
      if (credentials != null) {
        return credentials.get(APIKEY).getAsString();
      }
    } else if (serviceName.equalsIgnoreCase(VISUAL_RECOGNITION)) {
      final JsonObject credentials = getCredentialsObject(services, serviceName, plan);
      if (credentials != null) {
        return credentials.get(API_KEY).getAsString();
      }
    } else {
      ServiceCredentials credentials = getUserNameAndPassword(serviceName, plan);
      if (credentials != null) {
        return Credentials.basic(credentials.getUsername(), credentials.getPassword());
      }
    }
    return null;
  }

  /**
   * Returns the username and password as defined in the VCAP_SERVICES or null if they do not exist or are not
   * accessible. This is a utility method for {@link #getUserNameAndPassword(String, String)}. Invoking this method is
   * identical to calling <code>getUserNameAndPassword(serviceName, null);</code>
   *
   * @param serviceName the name of the service whose credentials are sought
   * @return an object representing the service's credentials
   */
  public static ServiceCredentials getUserNameAndPassword(String serviceName) {
    return getUserNameAndPassword(serviceName, null);
  }

  /**
   * Returns the username and password as defined in the VCAP_SERVICES or null if they do not exist or are not
   * accessible. If a plan is provided then only the credentials for that plan (and service) will be returned. Null will
   * be returned if the plan does not exist.
   *
   * @param serviceName the name of the service whose credentials are sought
   * @param plan the plan name
   * @return an object representing the service's credentials
   */
  public static ServiceCredentials getUserNameAndPassword(String serviceName, String plan) {
    if ((serviceName == null) || serviceName.isEmpty()) {
      return null;
    }

    final JsonObject services = getVCAPServices();
    if (services == null) {
      return null;
    }

    JsonObject jsonCredentials = getCredentialsObject(services, serviceName, plan);
    if (jsonCredentials != null) {
      String username = null;
      if (jsonCredentials.has(USERNAME)) {
        username = jsonCredentials.get(USERNAME).getAsString();
      }
      String password = null;
      if (jsonCredentials.has(PASSWORD)) {
        password = jsonCredentials.get(PASSWORD).getAsString();
      }
      if ((username != null) || (password != null)) {
        // both will be null in the case of Alchemy API
        return new ServiceCredentials(username, password);
      }
    }
    return null;
  }

  /**
   * A helper method to retrieve the appropriate 'credentials' JSON property value from the VCAP_SERVICES.
   *
   * @param vcapServices JSON object representing the VCAP_SERVICES
   * @param serviceName the name of the service whose credentials are sought
   * @param plan the name of the plan for which the credentials are sought, e.g. 'standard', 'beta' etc, may be null
   * @return the first set of credentials that match the search criteria, service name and plan. May return null
   */
  private static JsonObject getCredentialsObject(JsonObject vcapServices, String serviceName, String plan) {
    for (final Entry<String, JsonElement> entry : vcapServices.entrySet()) {
      final String key = entry.getKey();
      if (key.startsWith(serviceName)) {
        final JsonArray servInstances = vcapServices.getAsJsonArray(key);
        for (final JsonElement instance : servInstances) {
          final JsonObject service = instance.getAsJsonObject();
          final String instancePlan = service.get(PLAN).getAsString();
          if ((plan == null) || plan.equalsIgnoreCase(instancePlan)) {
            return instance.getAsJsonObject().getAsJsonObject(CREDENTIALS);
          }
        }
      }
    }
    return null;
  }

  /**
   * Gets the API url.
   *
   * @param serviceName the service name
   * @return the API url
   */

  public static String getAPIUrl(String serviceName) {
    return getAPIUrl(serviceName, null);
  }

  /**
   * Returns the API URL from the VCAP_SERVICES, JDNI, or null if doesn't exists. If plan is specified, then only
   * credentials for the given plan will be returned.
   *
   * @param serviceName the service name
   * @param plan the service plan: standard, free or experimental
   * @return the API URL
   */
  public static String getAPIUrl(String serviceName, String plan) {
    if ((serviceName == null) || serviceName.isEmpty()) {
      return null;
    }

    final JsonObject services = getVCAPServices();
    if (services == null) {
      return getJDNIValue(serviceName, LOOKUP_NAME_EXTENSION_URL);
    }

    final JsonObject credentials = getCredentialsObject(services, serviceName, plan);
    if ((credentials != null) && credentials.has(URL)) {
      return credentials.get(URL).getAsString();
    }

    return null;
  }

  /**
   * Sets the VCAP_SERVICES variable. This is utility variable for testing
   *
   * @param services the VCAP_SERVICES
   */
  public static void setServices(String services) {
    CredentialUtils.services = services;
  }

  /**
   * Sets the context variable for JDNI. This is a utility method for testing.
   *
   * @param env Configuration options for the context
   */
  public static void setContext(Hashtable<String, String> env) {
    try {
      CredentialUtils.context = new InitialContext(env);
    } catch (Exception e) {
      log.fine("Error setting up JDNI context: " + e.getMessage());
    }
  }

  /**
   * Method for testing the getAPIUrl method that bypasses the VCAP
   * services to ensure retrieval from JDNI.
   *
   * @param serviceName the service name
   * @return the API URL
   */
  public static String getAPIUrlTest(String serviceName) {
    if ((serviceName == null) || serviceName.isEmpty()) {
      return null;
    }

    return getJDNIValue("jdni/watson-developer-cloud/" + serviceName + LOOKUP_NAME_EXTENSION_URL);
  }
}
