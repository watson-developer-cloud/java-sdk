package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models;

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.ApiConstants.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.gson.annotations.SerializedName;

/**
 * Response from a provisioned Solr Cluster.
 */
public class SolrClusterResponse {
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

    public SolrClusterResponse(final String solrClusterId, final String solrClusterName, final String solrClusterSize,
            final Status solrClusterStatus) {
        this.solrClusterId = solrClusterId;
        this.solrClusterName = solrClusterName;
        this.solrClusterSize = solrClusterSize;
        this.solrClusterStatus = solrClusterStatus;
    }

    public String getSolrClusterId() {
        return solrClusterId;
    }

    public SolrCluster getSolrCluster() {
        return SolrCluster.fromString(solrClusterId);
    }

    public String getSolrClusterName() {
        return solrClusterName;
    }

    public String getSolrClusterSize() {
        return solrClusterSize;
    }

    public Status getSolrClusterStatus() {
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
        final SolrClusterResponse other = (SolrClusterResponse) obj;
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