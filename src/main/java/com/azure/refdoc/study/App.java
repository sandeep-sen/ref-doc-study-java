package com.azure.refdoc.study;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String azureStorageConnectionString = System.getenv("AZURE_STORAGE_CONNECTION_STRING");
        String storageContainerName = System.getenv("CONTAINER_NAME");

        String eventHubConnectionString = System.getenv("EVENTHUB_CONNECTION_STRING");
        String eventHubName = System.getenv("EVENTHUB_NAME");

        String cosmosContainerName = System.getenv("COSMOS_CONTAINER");
        String cosmosDatabase = System.getenv("COSMOS_DATABASE");
        String cosmosEndpoint = System.getenv("COSMOS_ENDPOINT");
        String cosmosKey = System.getenv("COSMOS_KEY");

        // getBlobContent is a demo method comment it out for the task
        // You will need to run getBlobList
        Storage storage = new Storage(azureStorageConnectionString, storageContainerName);
        try {
            storage.getBlobContent("2022-12-22-09-00.txt");
            // storage.getBlobList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // getBlobContent is a demo method comment it out for the task
        // Create clients in constructor
        // You will need to run queryVolcano with evelation = 0 and limit =5
        CosmosDB cosmosDB = new CosmosDB(cosmosEndpoint, cosmosKey, cosmosDatabase, cosmosContainerName);
        // cosmosDB.queryVolcano("0", "5");

        // produceMessages is a demo method comment it out for the task
        // You will need to run consumeMessages
        EventHub eventHub = new EventHub(eventHubConnectionString, eventHubName);
        eventHub.produceMessages();
        // eventHub.consumeMessages();

    }
}
