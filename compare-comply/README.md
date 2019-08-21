# Compare and Comply

## Installation

##### Maven
```xml
<dependency>
  <groupId>com.ibm.watson</groupId>
  <artifactId>compare-comply</artifactId>
  <version>7.4.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:compare-comply:7.4.0'
```

## Usage
Use the [Compare and Comply](https://cloud.ibm.com/docs/services/compare-comply/index.html#about) service to enable better and faster document understanding. Below is an example of converting a PDF file into HTML:
```java
CompareComply service = new CompareComply("2018-10-15");
IamOptions options = new IamOptions.Builder()
  .apiKey("<iam_api_key>")
  .build();
service.setIamCredentials(options);

ConvertToHtmlOptions convertToHtmlOptions = new ConvertToHtmlOptions.Builder()
  .file("~/path/to/file.pdf")
  .fileContentType(HttpMediaType.APPLICATION_PDF)
  .build();

// Response body with converted HTML
HTMLReturn response = service.convertToHtml(convertToHtmlOptions).execute().getResult();
```
