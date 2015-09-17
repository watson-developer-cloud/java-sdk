
package com.ibm.watson.developer_cloud.visual_Insights.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

import java.util.ArrayList;
import java.util.List;


public class Attribtes extends GenericModel {


    private List<Attribute> attributes = new ArrayList<Attribute>();

    /**
     * 
     * @return
     *     The attributes
     */
    public List<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param attributes
     *     The attributes
     */
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public static class Attribute extends GenericModel {

        private String name;

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
    }

}
