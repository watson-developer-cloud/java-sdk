package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models;

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.ApiConstants.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response from a provisioned Solr Cluster.
 */
public class SolrClusterResponse {
    public enum Status {
        READY,
        NOT_AVAILABLE
    }

    private final String solrClusterId;
    private final String solrClusterName;
    private final String solrClusterSize;
    private final Status solrClusterStatus;

    @JsonCreator
    public SolrClusterResponse(
            @JsonProperty(SOLR_CLUSTER_ID) final String solrClusterId,
            @JsonProperty(CLUSTER_NAME) final String solrClusterName,
            @JsonProperty(CLUSTER_SIZE) final String solrClusterSize,
            @JsonProperty(SOLR_CLUSTER_STATUS) final Status solrClusterStatus) {
        this.solrClusterId = solrClusterId;
        this.solrClusterName = solrClusterName;
        this.solrClusterSize = solrClusterSize;
        this.solrClusterStatus = solrClusterStatus;
    }

    @JsonProperty(SOLR_CLUSTER_ID)
    public String getSolrClusterId() {
        return solrClusterId;
    }

    @JsonIgnore
    public SolrCluster getSolrCluster() {
        return SolrCluster.fromString(solrClusterId);
    }

    @JsonProperty(CLUSTER_NAME)
    public String getSolrClusterName() {
        return solrClusterName;
    }

    @JsonProperty(CLUSTER_SIZE)
    public String getSolrClusterSize() {
        return solrClusterSize;
    }

    @JsonProperty(SOLR_CLUSTER_STATUS)
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