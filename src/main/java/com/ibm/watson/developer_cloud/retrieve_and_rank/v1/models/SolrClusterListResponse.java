package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models;

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.ApiConstants.*;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response from requesting a list of provisioned Solr Clusters.
 */
public class SolrClusterListResponse {

    private final List<SolrClusterResponse> solrClusterResponses;

    @JsonCreator
    public SolrClusterListResponse(
            @JsonProperty(SOLR_CLUSTER_RESPONSES) final List<SolrClusterResponse> solrClusterResponses) {
        this.solrClusterResponses = solrClusterResponses;
    }

    @JsonProperty(SOLR_CLUSTER_RESPONSES)
    public List<SolrClusterResponse> getSolrClusterResponses() {
        return solrClusterResponses;
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
        final SolrClusterListResponse other = (SolrClusterListResponse) obj;
        return new EqualsBuilder()
                .append(solrClusterResponses, other.solrClusterResponses)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(solrClusterResponses)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("solrClusterResponses", solrClusterResponses)
                .toString();
    }
}