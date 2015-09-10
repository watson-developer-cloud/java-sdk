package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A value type for the JSON body provided when creating a Solr cluster.
 */
public class SolrClusterCreationRequest {
    public static final String CLUSTER_SIZE_PROP = "cluster_size";
    public static final String CLUSTER_NAME_PROP = "cluster_name";

    private final String clusterName;
    private final String clusterSize;

    public SolrClusterCreationRequest(@JsonProperty(CLUSTER_NAME_PROP) String clusterName,
            @JsonProperty(CLUSTER_SIZE_PROP) String clusterSize) {
        this.clusterName = clusterName;
        this.clusterSize = clusterSize;
    }

    @JsonProperty(CLUSTER_NAME_PROP)
    public String getClusterName() {
        return clusterName;
    }

    @JsonProperty(CLUSTER_SIZE_PROP)
    public String getClusterSize() {
        return clusterSize;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }

        final SolrClusterCreationRequest rhs = (SolrClusterCreationRequest) object;
        return new EqualsBuilder()
                .append(clusterName, rhs.clusterName)
                .append(clusterSize, rhs.clusterSize)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(clusterName)
                .append(clusterSize)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("optionalClusterName", clusterName)
                .append("clusterSize", clusterSize)
                .toString();
    }
}
