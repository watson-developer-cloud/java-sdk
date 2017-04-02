package com.ibm.watson.developer_cloud.conversation.v1.model.workspace;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.entity.CreateEntity;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent.CreateExample;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent.CreateIntent;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.nodes.CreateDialogNode;

public class WorkspaceExportResponse extends WorkspaceResponse {

  @SerializedName("counterexamples")
  private List<CreateExample> counterExamples;
  @SerializedName("dialog_nodes")
  private List<CreateDialogNode> dialogNodes;
  private List<CreateEntity> entities;
  private List<CreateIntent> intents;

  /**
   * lists the workspace counter examples.
   * @return An array of CreateExample objects defining input examples that have
   *         been marked as irrelevant input.
   */
  public List<CreateExample> getCounterExamples() {
    return counterExamples;
  }

  /**
   * lists the workspace root nodes.
   * @return An array of CreateDialogNode objects defining the nodes in the
   *         workspace dialog.
   */
  public List<CreateDialogNode> getDialogNodes() {
    return dialogNodes;
  }

  /**
   * lists the workspace entities.
   * @return An array of CreateEntity objects defining the entities for the
   *         workspace.
   */
  public List<CreateEntity> getEntities() {
    return entities;
  }

  /**
   * lists the workspace intents.
   * @return An array of CreateIntent objects defining the intents for the
   *         workspace.
   */
  public List<CreateIntent> getIntents() {
    return intents;
  }

}
