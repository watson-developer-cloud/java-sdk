package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.entity;

import java.util.Date;
import java.util.List;

/**
 *  describes an entity in a workspace
 * @author davidbo
 *
 */
public class EntityExportResponse extends Entity{
  protected Date created;
  protected Date updated;
  private List<ValueExportResponse> values;
  
  /**
   * Returns the time stamp for when the example was created.
   *
   * @return a time stamp of example creation
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Returns the time stamp for when the example was last updated.
   *
   * @return a time stamp of example's last update
   */
  public Date getUpdated() {
    return updated;
  }
  
  /**
   * @return An array of entity values.
   */
  public List<ValueExportResponse> getValues() {
    return values;
  }
}
