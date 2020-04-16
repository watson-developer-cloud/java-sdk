import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.BearerTokenAuthenticator;
import com.ibm.watson.discovery.v2.Discovery;
import com.ibm.watson.discovery.v2.model.AddDocumentOptions;
import com.ibm.watson.discovery.v2.model.DeleteDocumentOptions;
import com.ibm.watson.discovery.v2.model.DocumentAccepted;
import com.ibm.watson.discovery.v2.model.QueryOptions;
import com.ibm.watson.discovery.v2.model.QueryResponse;
import com.ibm.watson.discovery.v2.model.QueryResult;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DiscoveryV2Example {

  public static void main(String[] args) throws IOException {
    Authenticator authenticator = new BearerTokenAuthenticator("{bearer_token}");
    Discovery service = new Discovery("2019-11-22", authenticator);
    service.setServiceUrl("{url}");

    // This example assumes you have a project and collection set up which can accept documents.
    // Paste those
    // IDs below.
    String projectId = "";
    String collectionId = "";

    // Add a new document to our collection. Fill in the file path with the file you want to send.
    InputStream file = new FileInputStream("");
    AddDocumentOptions addDocumentOptions =
        new AddDocumentOptions.Builder()
            .projectId(projectId)
            .collectionId(collectionId)
            .file(file)
            .filename("example-file")
            // .fileContentType(HttpMediaType.APPLICATION_PDF) // Fill in the content type of your
            // chosen file here!
            .build();
    DocumentAccepted addResponse = service.addDocument(addDocumentOptions).execute().getResult();
    String documentId = addResponse.getDocumentId();

    // Query your collection with the new document inside.
    QueryOptions queryOptoins =
        new QueryOptions.Builder()
            .projectId(projectId)
            .addCollectionIds(collectionId)
            .naturalLanguageQuery(
                "Watson") // Feel free to replace this to query something different.
            .build();
    QueryResponse queryResponse = service.query(options).execute().getResult();

    System.out.println(queryResponse.getMatchingResults() + " results were returned by the query!");

    // See if the added document got returned by the query.
    for (QueryResult result : queryResponse.getResults()) {
      if (result.getDocumentId().equals(documentId)) {
        System.out.println("Our new document matched the query!");
      }
    }

    // Delete our uploaded document from the collection.
    DeleteDocumentOptions deleteDocumentOptions =
        new DeleteDocumentOptions.Builder()
            .projectId(projectId)
            .collectionId(collectionId)
            .documentId(documentId)
            .build();
    service.deleteDocument(deleteDocumentOptions).execute();
  }
}
