package com.azure.refdoc.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.CosmosDatabase;

public class CosmosDB {
    private static final Logger logger = LoggerFactory.getLogger(CosmosDB.class);

    private CosmosClient cosmosClient;
    private CosmosDatabase cosmosDatabase;
    private CosmosContainer cosmosContainer;

    public CosmosDB(String cosmosEndpoint, String cosmosKey, String cosmosDatabaseName,
            String cosmosContainerName) {
        logger.info("Using Azure Cosmos DB endpoint: {}", cosmosEndpoint);
        
        // Cosmos client gives access to ther service, which contains a database
        // Database contains a container
        // Container == database table schema where you need to run the query
        
        // Build a cosmos client and assingn to class variable
        // Build a database client and assingn to class variable
        // Build a container client and assingn to class variable

    }

    public void queryVolcano(String elevation, String limit) {
        // TODO: query top 5 items from collection
        // where Elevation = input parameter (a number) in our case 0
        // order by ascending on Country
        // OFFSET 0 is to start at the begining
        // LIMIT 5 cuts off the result at 5 items
        // elevation and limit should be parameterized
        // The cosmos query to run
        // SELECT * FROM collection c WHERE c.Elevation = <input-param-from-func> ORDER
        // BY c.Country ASC OFFSET 0 LIMIT <input-param-from-func>
    }

}
