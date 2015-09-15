package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyVision;

/**
 * ImageLink by the {@link AlchemyVision} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class ImageLink extends AlchemyGenericModel {

    /** The image. */
    private String image;

    /** The url. */
    private String url;

    /**
     * Gets the image.
     *
     * @return The image
     */
    public String getImage() {
        return image;
    }

    /**
     * Gets the url.
     *
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the image.
     *
     * @param image The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Sets the url.
     *
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
