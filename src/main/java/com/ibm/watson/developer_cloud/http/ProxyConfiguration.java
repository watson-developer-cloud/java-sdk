/**
 * Copyright 2016 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.http;

import okhttp3.Credentials;

/**
 * Stores the proxy configuration in case a proxy needs to be used to access the services.
 */
public class ProxyConfiguration {

    private String hostname;
    private int port;
    private String credentials;
    
    /**
     * Creates a proxy configuration without authentication.
     * 
     * @param hostname     host name of the proxy
     * @param port        port of the proxy
     */
    public ProxyConfiguration(String hostname, int port) {
        this(hostname, port, null, null);
    }
    
    /**
     * Creates a proxy configuration with authentication.
     * 
     * @param hostname     host name of the proxy
     * @param port        port of the proxy
     * @param username    user for proxy authentication
     * @param password    password for proxy authentication
     */
    public ProxyConfiguration(String hostname, int port, String username, String password) {
        this.hostname = hostname;
        this.port = port;
        if (username != null)
            this.credentials = Credentials.basic(username, password);
    }

    /**
     * Gets the proxy host name.
     * 
     * @return the proxy host name
     */
    public String getHostname() {
        return hostname;
    }
    
    /**
     * Gets the proxy port.
     * 
     * @return the proxy port
     */
    public int getPort() {
        return port;
    }

    /**
     * Gets the credentials used for proxy authentication.
     * 
     * @return the credentials used for proxy authentication
     */
    public String getCredentials() {
        return credentials;
    }
    
}
