package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils;

import java.io.File;
import java.util.Collection;

/**
 * Manages Solr Clusters configuration.
 */
public interface SolrConfigManager extends AutoCloseable {

    /**
     * Uploads a configuration ZIP {@link File} to ZooKeeper's namespace, including schema.xml, solrconfig.xml, and all
     * other necessary config files to configure a SolrCloud collection.
     * <p>
     * For uploading a directory, use {@link #uploadConfigurationDirectory(String, File)} instead. Config files on the
     * xslt path will not be uploaded.
     *
     * @param configName
     *            the name of the config in ZooKeeper. This name is used when referencing the config when creating a
     *            collection.
     * @param zippedConfig
     *            the ZIP file to upload.
     */
    void uploadConfigurationZip(final String configName, final File zippedConfig);

    /**
     * Deletes a configuration namespace in ZooKeeper.
     *
     * @param configurationName
     *            the name of the configuration in ZooKeeper.
     */
    void deleteConfiguration(final String configurationName);

    /**
     * Gets the configuration from ZooKeeper.
     *
     * @param configurationName
     *            the name of the configuration in ZooKeeper
     * @return a ZIP file containing the configuration if it exists in ZooKeeper or null if it is not found
     */
    File getConfiguration(String configurationName);

    /**
     * Uploads a configuration {@link File} to ZooKeeper's namespace, including schema.xml, solrconfig.xml, and all
     * other necessary config files to configure a SolrCloud collection.
     * <p>
     * The configuration directory is sent to Solr as a ZIP file. For uploading a ZIP file directly, use
     * {@link #uploadConfigurationZip(String, File)} instead. Config files on the xslt path will not be uploaded.
     *
     * @param configName
     *            the name of the config in ZooKeeper. This name is used when referencing the config when creating a
     *            collection.
     * @param configDirectory
     *            the directory to upload.
     * @throws IllegalArgumentException
     *             if configDirectory is not a directory
     */
    void uploadConfigurationDirectory(final String configName, final File configDirectory);

    /**
     * Lists the configuration sets in ZooKeeper.
     *
     * @return a list of the names of the configuration sets
     */
    Collection<String> listConfigurations();
}
