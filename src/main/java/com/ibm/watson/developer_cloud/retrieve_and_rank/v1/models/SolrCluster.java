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
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models;

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.ApiConstants.CLUSTER_NAME;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.ApiConstants.CLUSTER_SIZE;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.ApiConstants.SOLR_CLUSTER_ID;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.ApiConstants.SOLR_CLUSTER_STATUS;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.gson.annotations.SerializedName;

/**
 * Response from a provisioned Solr Cluster.
 */
public class SolrCluster {
    public enum Status {
        READY,
        NOT_AVAILABLE
    }

    @SerializedName(SOLR_CLUSTER_ID)
    private final String solrClusterId;
    @SerializedName(CLUSTER_NAME)
    private final String solrClusterName;
    @SerializedName(CLUSTER_SIZE)
    private final String solrClusterSize;
    @SerializedName(SOLR_CLUSTER_STATUS)
    private final Status solrClusterStatus;

    public SolrCluster(final String solrClusterId, final String solrClusterName, final String solrClusterSize,
            final Status solrClusterStatus) {
        this.solrClusterId = solrClusterId;
        this.solrClusterName = solrClusterName;
        this.solrClusterSize = solrClusterSize;
        this.solrClusterStatus = solrClusterStatus;
    }

    public String getId() {
        return solrClusterId;
    }

    public String getName() {
        return solrClusterName;
    }

    public String getSize() {
        return solrClusterSize;
    }

    public Status getStatus() {
        return solrClusterStatus;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SolrCluster other = (SolrCluster) obj;
        return new EqualsBuilder()
                .append(solrClusterId, other.solrClusterId)
                .append(solrClusterName, other.solrClusterName)
                .append(solrClusterSize, other.solrClusterSize)
                .append(solrClusterStatus, other.solrClusterStatus)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(solrClusterId)
                .append(solrClusterName)
                .append(solrClusterSize)
                .append(solrClusterStatus)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("solrClusterId", solrClusterId)
                .append("solrClusterName", solrClusterName)
                .append("solrClusterSize", solrClusterSize)
                .append("solrClusterStatus", solrClusterStatus)
                .toString();
    }
}