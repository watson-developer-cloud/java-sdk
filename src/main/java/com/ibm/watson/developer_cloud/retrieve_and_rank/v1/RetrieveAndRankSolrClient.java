/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.Preconditions.*;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.HttpClientFactory;

/** An {@link HttpSolrClient} for interacting with Watson Solr clusters. */
public class RetrieveAndRankSolrClient extends HttpSolrClient {

    private static final long serialVersionUID = -5787191484698145448L;

    private static final String SOLR_PATH = "solr";

    private final boolean createdHttpClient;

    private static URI getSolrUri(URI serviceUri) {
        checkArgumentNotNull(serviceUri, "solrUri");
        return UriBuilder.fromUri(serviceUri).path(SOLR_PATH).build();
    }

    private static CloseableHttpClient getHttpClient(URI serviceUri, String username, String password) {
        checkArgumentNotNull(serviceUri, "serviceUri");
        checkArgumentNotNull(username, "username");
        checkArgumentNotNull(password, "password");

        return new HttpClientFactory(serviceUri, username, password).createHttpClient();
    }

    private static CloseableHttpClient validateHttpClient(CloseableHttpClient httpClient) {
        checkArgumentNotNull(httpClient, "httpClient");
        return httpClient;
    }

    /** Creates a new client for interacting with a Solr cluster. */
    public RetrieveAndRankSolrClient(URI serviceUri, String username, String password) {
        super(getSolrUri(serviceUri).toString(), getHttpClient(serviceUri, username, password));

        this.createdHttpClient = true;
    }

    /**
     * Creates a new client for interacting with a Solr cluster. The provided httpClient will not be closed by the
     * SolrConfigManager.
     */
    public RetrieveAndRankSolrClient(URI serviceUri, CloseableHttpClient httpClient) {
        super(getSolrUri(serviceUri).toString(), validateHttpClient(httpClient));
        this.createdHttpClient = false;
    }

    @Override
    public void close() throws IOException {
        if (createdHttpClient) {
            try {
                ((CloseableHttpClient) getHttpClient()).close();
            } finally {
                super.close();
            }
        }
    }
}