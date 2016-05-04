/* BEGIN_COPYRIGHT
 *
 * IBM Confidential
 * OCO Source Materials
 *
 * 5725-Y07
 * (C) Copyright IBM Corp. 2016 All Rights Reserved.
 *
 * The source code for this program is not published or otherwise
 * divested of its trade secrets, irrespective of what has been
 * deposited with the U.S. Copyright Office.
 *
 * END_COPYRIGHT
 */
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.ApiConstants.*;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class SolrClusterStats extends GenericModel {
  @SerializedName(DISK_USAGE)
  private final DiskUsageStats diskUsage;
  @SerializedName(MEMORY_USAGE)
  private final MemoryUsageStats memoryUsage;

  public SolrClusterStats(final DiskUsageStats diskUsage, final MemoryUsageStats memoryUsage) {
    this.diskUsage = diskUsage;
    this.memoryUsage = memoryUsage;
  }

  public DiskUsageStats getDiskUsage() {
    return diskUsage;
  }

  public MemoryUsageStats getMemoryUsage() {
    return memoryUsage;
  }
}