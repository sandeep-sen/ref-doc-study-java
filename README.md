# ref-doc-study-java
Repository to run study on Microsoft Reference docs for Java

# Tasks
You need to run 3 tasks for this study, for each task a sample task has been provided.
|#|Sample|Task|
|---|---|---|
1|[Print contents of a blob in Azure Storage](src/main/java/com/azure/refdoc/study/App.java?plain=1#27)| Print name of all blob files in Azure Storage container|
2|[Send 10 messages to Azure Event Hub](src/main/java/com/azure/refdoc/study/App.java?plain=1#42)| Recieve and print messages from Azure Event Hub|
3|[Update an item in Cosmos DB (NoSQL)](src/main/java/com/azure/refdoc/study/App.java?plain=1#36)| Query and print top 5 items, where elevation = 0


# Executing the tasks

## Codespace environment
Codespace has the following environment variables already set and you can acccess them from `System.getenv("var_name");`
```properties
COSMOS_ENDPOINT  = <value>
COSMOS_DATABASE = <value>
COSMOS_CONTAINER = <value>
COSMOS_KEY = <value>

CONTAINER_NAME = <value>
AZURE_STORAGE_CONNECTION_STRING = <value>

EVENTHUB_NAME = <value>
EVENTHUB_CONNECTION_STRING = <value>
```
These values will be configured by your study coordinator

## Clean build directories
```bash
mvn clean
```
## Compile
```bash
mvn install
```
## Clean and compile together
```bash
mvn clean install
```

## Executing tasks
The maven build will generate a fat executable jar
```bash
java -jar target/ref-doc-study-1.0-SNAPSHOT-jar-with-dependencies.jar
```
# Solutions
If you are stuck check the solutions in the [solution directory](src/main/java/com/azure/refdoc/study/solution).
## Executing solutions
Replace the currents imports with imports from the solutions package, compile and run