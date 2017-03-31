package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.entity;

import java.util.List;

public class CreateValue {

    private String value;

    private Object metadata;

    private List<String> synonyms;

    /**
     * @return The text of the entity value.
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            The text of the entity value.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return Any metadata related to the entity value.
     */
    public Object getMetadata() {
        return metadata;
    }

    /**
     * @param metadata
     *            Any metadata related to the entity value.
     */
    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    /**
     * @return An array containing any synonyms for the entity value.
     */
    public List<String> getSynonyms() {
        return synonyms;
    }

    /**
     * @param synonyms
     *            An array containing any synonyms for the entity value.
     */
    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

}
