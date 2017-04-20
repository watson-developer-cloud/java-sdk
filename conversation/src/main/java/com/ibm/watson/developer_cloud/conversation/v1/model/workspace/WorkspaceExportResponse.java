package com.ibm.watson.developer_cloud.conversation.v1.model.workspace;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.entity.CreateEntity;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.entity.EntityExportResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.example.CreateExample;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.example.ExampleResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent.CreateIntent;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent.IntentExportResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.nodes.CreateDialogNode;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.nodes.DialogNodeResponse;

public class WorkspaceExportResponse extends WorkspaceResponse {

  @SerializedName("counterexamples")
  private List<ExampleResponse> counterExamples;
  @SerializedName("dialog_nodes")
  private List<DialogNodeResponse> dialogNodes;
  private List<EntityExportResponse> entities;
  private List<IntentExportResponse> intents;

  /**
   * lists the workspace counter examples.
   * @return An array of CreateExample objects defining input examples that have
   *         been marked as irrelevant input.
   */
  public List<ExampleResponse> getCounterExamples() {
    return counterExamples;
  }

  /**
   * lists the workspace root nodes.
   * @return An array of CreateDialogNode objects defining the nodes in the
   *         workspace dialog.
   */
  public List<DialogNodeResponse> getDialogNodes() {
    return dialogNodes;
  }

  /**
   * lists the workspace entities.
   * @return An array of CreateEntity objects defining the entities for the
   *         workspace.
   */
  public List<EntityExportResponse> getEntities() {
    return entities;
  }

  /**
   * lists the workspace intents.
   * @return An array of CreateIntent objects defining the intents for the
   *         workspace.
   */
  public List<IntentExportResponse> getIntents() {
    return intents;
  }

}
