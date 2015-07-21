
package com.ibm.watson.developer_cloud.tone_analyzer.v1.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class ToneDimension {

    @Expose
    private String name;
    @Expose
    private String id;
    @Expose
    private List<ToneTrait> children = new ArrayList<ToneTrait>();

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public ToneDimension withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public ToneDimension withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The children
     */
    public List<ToneTrait> getChildren() {
        return children;
    }

    /**
     * 
     * @param children
     *     The children
     */
    public void setChildren(List<ToneTrait> children) {
        this.children = children;
    }

    public ToneDimension withChildren(List<ToneTrait> children) {
        this.children = children;
        return this;
    }

}
