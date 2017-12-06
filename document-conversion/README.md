# Document Conversion

## Installation

##### Maven
```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>document-conversion</artifactId>
	<version>4.1.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:document-conversion:4.1.0'
```

## Usage
The [Document Conversion][document_conversion] service allows to convert pdf, word, and html documents into formats useful to other Watson Cognitive services. Target formats include normalized html, plain text, and sets of potential answers for Watson question answering. You can convert documents synchronously one at a time, or asynchronously in batches

Returns the document list using the [Document Conversion][document_conversion] service.

```java
DocumentConversion service = new DocumentConversion("2015-12-01");
service.setUsernameAndPassword("<username>", "<password>");

File doc = new File("src/test/resources/document_conversion/word-document-heading-input.doc");
Answers htmlToAnswers = service.convertDocumentToAnswer(doc).execute();
System.out.println(htmlToAnswers);
```

[document_conversion]: https://console.bluemix.net/docs/services/document-conversion/index.html
