# Retrieve and Rank

## Installation

##### Maven
```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>retrieve-and-rank</artifactId>
	<version>4.1.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:retrieve-and-rank:4.1.0'
```

## Usage
The [Retrieve and Rank][retrieve_and_rank] service helps users find the most
relevant information for their query by using a  combination of search and
machine learning to find "signals" in the data.


```java
RetrieveAndRank service = new RetrieveAndRank();
service.setUsernameAndPassword("<username>", "<password>");

// 1 create the Solr Cluster
SolrClusterOptions options = new SolrClusterOptions("my-cluster-name", 1);
SolrCluster cluster = service.createSolrCluster(options).execute();
System.out.println("Solr cluster: " + cluster);

// 2 wait until the Solr Cluster is available
while (cluster.getStatus() == Status.NOT_AVAILABLE) {
  Thread.sleep(10000); // sleep 10 seconds
  cluster = service.getSolrCluster(cluster.getId()).execute();
  System.out.println("Solr cluster status: " + cluster.getStatus());
}

// 3 list Solr Clusters
System.out.println("Solr clusters: " + service.getSolrClusters().execute());
```

Retrieve and Rank is built on top of Apache Solr.
Look at [this](https://github.com/watson-developer-cloud/java-sdk/tree/master/examples/retrieve-and-rank-solrj) example to learn how to use Solrj.

[retrieve_and_rank]: https://console.bluemix.net/docs/services/retrieve-and-rank/index.html
