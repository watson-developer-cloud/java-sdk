package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models;

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.ApiConstants.*;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SolrConfigList {
    private final List<String> solrConfigs;

    @JsonCreator
    public SolrConfigList(@JsonProperty(SOLR_CONFIGS) final List<String> solrConfigs) {
        this.solrConfigs = solrConfigs;
    }

    @JsonProperty(SOLR_CONFIGS)
    public Collection<String> getSolrConfigs() {
        return solrConfigs;
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
        final SolrConfigList other = (SolrConfigList) obj;
        return new EqualsBuilder()
                .append(solrConfigs, other.solrConfigs)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(solrConfigs)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("solrConfigs", solrConfigs)
                .toString();
    }
}