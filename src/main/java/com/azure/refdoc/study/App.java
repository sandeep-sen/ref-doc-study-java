package com.azure.refdoc.study;

import java.io.IOException;

import com.azure.refdoc.study.solution.CosmosDB;
import com.azure.refdoc.study.solution.EventHub;
import com.azure.refdoc.study.solution.Storage;

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

        Storage storage = new Storage(azureStorageConnectionString, storageContainerName);
        try {
            storage.getBlobContent("eventHubName");
            storage.getBlobList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CosmosDB cosmosDB = new CosmosDB(cosmosEndpoint, cosmosKey, cosmosDatabase, cosmosContainerName);
        cosmosDB.queryVolcano("0", "5");

        EventHub eventHub = new EventHub(eventHubConnectionString, eventHubName);
        eventHub.produceMessages();
        eventHub.consumeMessages();

    }
}
