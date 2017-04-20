package com.ibm.watson.developer_cloud.conversation.v1.model.workspace;

import com.google.gson.annotations.SerializedName;

public enum WorkspaceStatus {
  @SerializedName("Non Existent") NonExistent,

  Training,

  Failed,

  Available,

  Unavailable
}
