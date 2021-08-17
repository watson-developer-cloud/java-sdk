# Compare and Comply

## Installation

##### Maven

```xml
<dependency>
  <groupId>com.ibm.watson</groupId>
  <artifactId>compare-comply</artifactId>
  <version>9.2.1</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.watson:compare-comply:9.2.1'
```

## Usage

Use the [Compare and Comply](https://cloud.ibm.com/docs/compare-comply?topic=compare-comply-about#about) service to enable better and faster document understanding. Below is an example of converting a PDF file into HTML:

```java
Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
CompareComply service = new CompareComply("2018-10-15", authenticator);

ConvertToHtmlOptions convertToHtmlOptions = new ConvertToHtmlOptions.Builder()
  .file("~/path/to/file.pdf")
  .fileContentType(HttpMediaType.APPLICATION_PDF)
  .build();

// Response body with converted HTML
HTMLReturn response = service.convertToHtml(convertToHtmlOptions).execute().getResult();
```
