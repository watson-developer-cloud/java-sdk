/**
 * (C) Copyright IBM Corp. 2019, 2021.
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

package com.ibm.watson.common;

import java.io.InputStream;
import java.net.Proxy;
import java.util.Map;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.TokenRequestBasedAuthenticator;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.http.HttpHeaders;
import com.ibm.cloud.sdk.core.http.RequestBuilder;

/**
 * This class provides an Authenticator implementation for the "CloudPakForData" environment.
 * This authenticator will use the configured url and other properties to automatically fetch
 * an access token from the CloudPakForData token service.
 * When the access token expires, a new access token will be fetched.
 *
 * This authenticator uses the "POST /v1/authorize" operation supported by the CloudPakForData token service.
 * As such, you can configure either the username and passord properies, or the username and apikey
 * properties.  The url, username and one of password/apikey are required.
 */
public class CloudPakForDataIamAuthenticator extends TokenRequestBasedAuthenticator<Cp4dToken, IamCp4dTokenResponse>
        implements Authenticator {

  // Properties specific to a CloudPakForData authenticator.
  private String commonServicesRouteUrl;
  private String cpdRouteUrl;
  private String username;
  private String password;
  private String apikey;

  public static final String ERRORMSG_EXCLUSIVE_PROP_ERROR = "Exactly one of %s or %s must be specified.";

  static String COMMON_SERVICES_ROUTE_URL = "COMMON_SERVICES_ROUTE_URL";
  static String CPD_ROUTE_URL = "CPD_ROUTE_URL";


  /**
   * This Builder class is used to construct CloudPakForDataAuthenticator instances.
   */
  public static class Builder {
    private String commonServicesRouteUrl;
    private String cpdRouteUrl;
    private String username;
    private String password;
    private String apikey;
    private boolean disableSSLVerification;
    private Map<String, String> headers;
    private Proxy proxy;
    private okhttp3.Authenticator proxyAuthenticator;

    // Default ctor.
    public Builder() { }

    // Builder ctor which copies config from an existing authenticator instance.
    private Builder(CloudPakForDataIamAuthenticator obj) {
      this.commonServicesRouteUrl = obj.commonServicesRouteUrl;
      this.cpdRouteUrl = obj.cpdRouteUrl;

      this.username = obj.username;
      this.password = obj.password;
      this.apikey = obj.apikey;

      this.disableSSLVerification = obj.getDisableSSLVerification();
      this.headers = obj.getHeaders();
      this.proxy = obj.getProxy();
      this.proxyAuthenticator = obj.getProxyAuthenticator();
    }

    /**
     * Constructs a new instance of CloudPakForDataAuthenticator from the builder's configuration.
     *
     * @return the CloudPakForDataAuthenticator instance
     */
    public CloudPakForDataIamAuthenticator build() {
      return new CloudPakForDataIamAuthenticator(this);
    }

    /**
     * Sets the commonServicesRouteUrl property.
     * @param url the route to access IBM Cloud Pak® foundational services.
     * @return the Builder
     */
    public Builder commonServicesRouteUrl(String url) {
      this.commonServicesRouteUrl = url;
      return this;
    }

    /**
     * Sets the cpdRouteUrl property.
     * @param url the route to the Cloud Pak for Data web client
     * @return the Builder
     */
    public Builder cpdRouteUrl(String url) {
      this.cpdRouteUrl = url;
      return this;
    }

    /**
     * Sets the username property.
     * @param username the username to use when retrieving an access token
     * @return the Builder
     */
    public Builder username(String username) {
      this.username = username;
      return this;
    }

    /**
     * Sets the password property.
     * @param password the password to use when retrieving an access token
     * @return the Builder
     */
    public Builder password(String password) {
      this.password = password;
      return this;
    }

    /**
     * Sets the apikey property.
     * @param apikey the apikey to use when retrieving an access token
     * @return the Builder
     */
    public Builder apikey(String apikey) {
      this.apikey = apikey;
      return this;
    }

    /**
     * Sets the disableSSLVerification property.
     * @param disableSSLVerification a boolean flag indicating whether or not SSL verification should be disabled
     * when interacting with the CloudPakForData token service
     * @return the Builder
     */
    public Builder disableSSLVerification(boolean disableSSLVerification) {
      this.disableSSLVerification = disableSSLVerification;
      return this;
    }

    /**
     * Sets the headers property.
     * @param headers the set of custom headers to include in requests sent to the CloudPakForData token service
     * @return the Builder
     */
    public Builder headers(Map<String, String> headers) {
      this.headers = headers;
      return this;
    }

    /**
     * Sets the proxy property.
     * @param proxy the java.net.Proxy instance to be used when interacting with the CloudPakForData token service
     * @return the Builder
     */
    public Builder proxy(Proxy proxy) {
      this.proxy = proxy;
      return this;
    }

    /**
     * Sets the proxyAuthenticator property.
     * @param proxyAuthenticator the okhttp3.Authenticator instance to be used with the proxy when
     * interacting with the CloudPakForData token service
     * @return the Builder
     */
    public Builder proxyAuthenticator(okhttp3.Authenticator proxyAuthenticator) {
      this.proxyAuthenticator = proxyAuthenticator;
      return this;
    }
  }

  // The default ctor is hidden to force the use of the non-default ctors.
  protected CloudPakForDataIamAuthenticator() {
  }

  /**
   * Constructs a CloudPakForDataAuthenticator instance from the configuration
   * contained in "builder".
   *
   * @param builder the Builder instance containing the configuration to be used
   */
  protected CloudPakForDataIamAuthenticator(Builder builder) {
    this.commonServicesRouteUrl = builder.commonServicesRouteUrl;
    this.cpdRouteUrl = builder.cpdRouteUrl;
    this.username = builder.username;
    this.password = builder.password;
    this.apikey = builder.apikey;

    setDisableSSLVerification(builder.disableSSLVerification);
    setHeaders(builder.headers);
    setProxy(builder.proxy);
    setProxyAuthenticator(builder.proxyAuthenticator);

    this.validate();
  }

  /**
   * Returns a new Builder instance pre-loaded with the configuration from "this".
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Constructs a CloudPakForDataAuthenticator with required properties configured with username/password.
   *
   * @param commonServicesRouteUrl
   *          the route to access IBM Cloud Pak® foundational services.
   * @param cpdRouteUrl
   *          the route to the Cloud Pak for Data web client
   * @param username
   *          the username to be used when retrieving the access token
   * @param password
   *          the password to be used when retrieving the access token
   *
   * @deprecated As of 9.7.0, use CloudPakForDataAuthenticator.Builder() instead.
   *
   */
  @Deprecated
  public CloudPakForDataIamAuthenticator(String commonServicesRouteUrl, String cpdRouteUrl, String username, String password) {
    init(commonServicesRouteUrl, cpdRouteUrl, username, password, false, null);
  }

  /**
   * Constructs a CloudPakForDataAuthenticator with all properties configured with username/password.
   *
   * @param commonServicesRouteUrl
   *          the route to access IBM Cloud Pak® foundational services.
   * @param cpdRouteUrl
   *          the route to the Cloud Pak for Data web client
   * @param username
   *          the username to be used when retrieving the access token
   * @param password
   *          the password to be used when retrieving the access token
   * @param disableSSLVerification
   *          a flag indicating whether SSL hostname verification should be disabled
   * @param headers
   *          a set of user-supplied headers to be included in token service interactions
   *
   * @deprecated As of 9.7.0, use CloudPakForDataAuthenticator.Builder() instead.
   *
   */
  @Deprecated
  public CloudPakForDataIamAuthenticator(String commonServicesRouteUrl, String cpdRouteUrl, String username, String password,
                                         boolean disableSSLVerification, Map<String, String> headers) {
    init(commonServicesRouteUrl, cpdRouteUrl, username, password, disableSSLVerification, headers);
  }

  /**
   * Construct a CloudPakForDataIamAuthenticator instance using properties retrieved from the specified Map.
   *
   * @param config a map containing the configuration properties
   *
   * @deprecated As of 9.7.0, use CloudPakForDataIamAuthenticator.fromConfiguration() instead.
   *
   */
  @Deprecated
  public CloudPakForDataIamAuthenticator(Map<String, String> config) {
    this.apikey = config.get(PROPNAME_APIKEY);
    init(config.get(COMMON_SERVICES_ROUTE_URL), config.get(CPD_ROUTE_URL), config.get(PROPNAME_USERNAME),
            config.get(PROPNAME_PASSWORD), Boolean.valueOf(config.get(PROPNAME_DISABLE_SSL)).booleanValue(), null);
  }

  /**
   * Construct a CloudPakForDataIamAuthenticator instance using properties retrieved from the specified Map.
   *
   * @param config a map containing the configuration properties
   *
   * @return the CloudPakForDataIamAuthenticator instance
   *
   */
  public static CloudPakForDataIamAuthenticator fromConfiguration(Map<String, String> config) {
    return new Builder()
            .commonServicesRouteUrl(config.get(COMMON_SERVICES_ROUTE_URL))
            .cpdRouteUrl(config.get(CPD_ROUTE_URL))
            .username(config.get(PROPNAME_USERNAME))
            .password(config.get(PROPNAME_PASSWORD))
            .apikey(config.get(PROPNAME_APIKEY))
            .disableSSLVerification(Boolean.valueOf(config.get(PROPNAME_DISABLE_SSL)).booleanValue())
            .build();
  }

  /**
   * Initializes the authenticator with all the specified properties.
   * @param commonServicesRouteUrl
   *          the route to access IBM Cloud Pak® foundational services.
   * @param cpdRouteUrl
   *          the route to the Cloud Pak for Data web client
   * @param username
   *          the username to be used when retrieving the access token
   * @param password
   *          the password to be used when retrieving the access token
   * @param disableSSLVerification
   *          a flag indicating whether SSL hostname verification should be disabled
   * @param headers
   *          a set of user-supplied headers to be included in token service interactions
   */
  protected void init(String commonServicesRouteUrl, String cpdRouteUrl, String username, String password,
                      boolean disableSSLVerification, Map<String, String> headers) {
    this.commonServicesRouteUrl = commonServicesRouteUrl;
    this.cpdRouteUrl = cpdRouteUrl;
    this.username = username;
    this.password = password;

    setDisableSSLVerification(disableSSLVerification);
    setHeaders(headers);

    this.validate();
  }

  /**
   * Returns the authentication type associated with this Authenticator.
   * @return the authentication type
   */
  @Override
  public String authenticationType() {
    return Authenticator.AUTHTYPE_CP4D;
  }

  /**
   * Validates the configuration of this authenticator.
   */
  @Override
  public void validate() {
    if (StringUtils.isEmpty(this.commonServicesRouteUrl)) {
      throw new IllegalArgumentException(String.format(ERRORMSG_PROP_MISSING, "commonServicesRouteUrl"));
    }

    if (StringUtils.isEmpty(this.cpdRouteUrl)) {
      throw new IllegalArgumentException(String.format(ERRORMSG_PROP_MISSING, "cpdRouteUrl"));
    }

    if (StringUtils.isEmpty(this.username)) {
      throw new IllegalArgumentException(String.format(ERRORMSG_PROP_MISSING, "username"));
    }

    // Either password or apikey need to be specified, but not both.
    if ((StringUtils.isEmpty(this.password) && StringUtils.isEmpty(this.apikey))
            || (StringUtils.isNotEmpty(this.password) && StringUtils.isNotEmpty(this.apikey))) {
      throw new IllegalArgumentException(String.format(ERRORMSG_EXCLUSIVE_PROP_ERROR, "password", "apikey"));
    }
  }

  /**
   * @return the Common Services Route URL configured for this authenticator
   */
  public String getCommonServicesRouteUrl() {
    return this.commonServicesRouteUrl;
  }

  /**
   * @return the CPD Route URL configured for this authenticator
   */
  public String getCpdRouteUrl() {
    return this.cpdRouteUrl;
  }

  /**
   * @return the username configured for this authenticator
   */
  public String getUsername() {
    return this.username;
  }

  /**
   * @return the password configured for this authenticator
   */
  public String getPassword() {
    return this.password;
  }

  /**
   * @return the apikey configured for this authenticator
   */
  public String getApikey() {
    return this.apikey;
  }

  /**
   * Obtains a CP4D access token for the configured authenticator.
   *
   * @return a Cp4dToken instance that contains the access token
   */
  @Override
  public Cp4dToken requestToken() {
    // Form a POST request to retrieve the access token.
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(this.commonServicesRouteUrl, "/icp4d-api/v1/authorize"));

    // Add the Content-Type header.
    builder.header(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");

    // Add the request body.
    CP4DRequestBody requestBody = new CP4DRequestBody(this.username, this.password, this.apikey);
    builder.bodyContent("application/json", requestBody, null, (InputStream) null);

    // Invoke the POST request.
    Cp4dToken token;
    try {
      IamCp4dTokenResponse response = invokeRequest(builder, IamCp4dTokenResponse.class);
      token = new Cp4dToken(response);
    } catch (Throwable t) {
      token = new Cp4dToken(t);
    }

    // Form a POST request to retrieve the IAM access token.
    RequestBuilder iamBuilder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(this.CPD_ROUTE_URL, "/v1/preauth/validateAuth"));

    // Add the Content-Type header.
    iamBuilder.header("username", username);
    iamBuilder.header("iam-token", token.getAccessToken());

    // Add the request body.
    CP4DRequestBody iamRequestBody = new CP4DRequestBody(this.username, this.password, this.apikey);
    iamBuilder.bodyContent("application/json", iamRequestBody, null, (InputStream) null);

    // Invoke the POST request.
    Cp4dToken iamToken;
    try {
      IamCp4dTokenResponse response = invokeRequest(iamBuilder, IamCp4dTokenResponse.class);
      iamToken = new Cp4dToken(response);
    } catch (Throwable t) {
      iamToken = new Cp4dToken(t);
    }

    // Construct a new Cp4dToken object from the response and return it.
    return iamToken;
  }

  // This class models the "POST /v1/authorize" request body.
  // Only one of "password" or "apikey" will be non-null so we can use this
  // class for both scenarios (username/password and username/apikey).
  @SuppressWarnings("unused")
  private static class CP4DRequestBody {
    private String username;
    private String password;

    @SerializedName("api_key")
    private String apikey;

    CP4DRequestBody(String username, String password, String apikey) {
      this.username = username;
      this.password = password;
      this.apikey = apikey;
    }
  }
}
