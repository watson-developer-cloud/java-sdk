# Tradeoff Analytics

## Installation

##### Maven
```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>tradeoff-analytics</artifactId>
	<version>4.1.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:tradeoff-analytics:4.1.0'
```

## Usage
Use the [Tradeoff Analytics][tradeoff_analytics] service to find the best
phone that minimizes price and weight and maximizes screen size.

```java
TradeoffAnalytics service = new TradeoffAnalytics();
service.setUsernameAndPassword("<username>", "<password>");

Problem problem = new Problem("phone");

String price = "price";
String ram = "ram";
String screen = "screen";

// Define the objectives
List<Column> columns = new ArrayList<Column>();
problem.setColumns(columns);

columns.add(new NumericColumn()
    .range(0, 100)
    .key(price)
    .goal(Goal.MIN)
    .objective(true));
columns.add(new NumericColumn()
    .key(screen)
    .goal(Goal.MAX)
    .objective(true));
columns.add(new NumericColumn()
    .key(ram)
    .goal(Goal.MAX));

// Define the options to choose
List<Option> options = new ArrayList<Option>();
problem.setOptions(options);

HashMap<String, Object> galaxySpecs = new HashMap<String, Object>();
galaxySpecs.put(price, 50);
galaxySpecs.put(ram, 45);
galaxySpecs.put(screen, 5);
options.add(new Option("1", "Galaxy S4").values(galaxySpecs));

HashMap<String, Object> iphoneSpecs = new HashMap<String, Object>();
iphoneSpecs.put(price, 99);
iphoneSpecs.put(ram, 40);
iphoneSpecs.put(screen, 4);
options.add(new Option("2", "iPhone 5").values(iphoneSpecs));

HashMap<String, Object> optimusSpecs = new HashMap<String, Object>();
optimusSpecs.put(price, 10);
optimusSpecs.put(ram, 300);
optimusSpecs.put(screen, 5);
options.add(new Option("3", "LG Optimus G").values(optimusSpecs));

// Call the service and get the resolution
Dilemma dilemma = service.dilemmas(problem).execute();
System.out.println(dilemma);
```

[tradeoff_analytics]: https://console.bluemix.net/docs/services/tradeoff-analytics/index.html
