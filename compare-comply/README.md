# Compare and Comply

## Installation

##### Maven
```xml
<dependency>
  <groupId>com.ibm.watson.developer_cloud</groupId>
  <artifactId>compare-comply</artifactId>
  <version>6.10.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:compare-comply:6.10.0'
```

## Usage
Use the [Compare and Comply](https://cloud.ibm.com/docs/services/compare-comply/index.html#about) service to enable better and faster document understanding. Below is an example of converting a PDF file into HTML:
```java
IamOptions iamOptions = new IamOptions.Builder()
  .apiKey(apiKey)
  .build();
CompareComply service = new CompareComply(VERSION, iamOptions);

ConvertToHtmlOptions convertToHtmlOptions = new ConvertToHtmlOptions.Builder()
  .file("~/path/to/file.pdf")
  .fileContentType(HttpMediaType.APPLICATION_PDF)
  .build();

// Response body with converted HTML
HTMLReturn response = service.convertToHtml(convertToHtmlOptions).execute();
```
