package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models;

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.ApiConstants.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

/**
 * A value type for the JSON body provided when creating a Solr cluster.
 */
public class SolrClusterCreationRequest {

    @SerializedName(CLUSTER_NAME)
    private final String clusterName;
    @SerializedName(CLUSTER_SIZE)
    private final String clusterSize;

    public SolrClusterCreationRequest(String clusterName, String clusterSize) {
        this.clusterName = clusterName;
        this.clusterSize = clusterSize;
    }

    public String getClusterName() {
        return clusterName;
    }

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
