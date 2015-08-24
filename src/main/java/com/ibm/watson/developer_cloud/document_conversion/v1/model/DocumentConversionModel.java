package com.ibm.watson.developer_cloud.document_conversion.v1.model;

import com.ibm.watson.developer_cloud.util.GsonSingleton;

public class DocumentConversionModel {

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getClass().getName() + " "
                + GsonSingleton.getGson().toJson(this);
    }

}
