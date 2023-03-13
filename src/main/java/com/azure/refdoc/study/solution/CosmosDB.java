package com.azure.refdoc.study.solution;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.CosmosDatabase;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.util.CosmosPagedIterable;
import com.azure.refdoc.study.models.Volcano;

public class CosmosDB {
        private static final Logger logger = LoggerFactory.getLogger(CosmosDB.class);

        private CosmosClient cosmosClient;
        private CosmosDatabase cosmosDatabase;
        private CosmosContainer cosmosContainer;

        public CosmosDB(String cosmosEndpoint, String cosmosKey, String cosmosDatabaseName,
                        String cosmosContainerName) {
                logger.info("Using Azure Cosmos DB endpoint: {}", cosmosEndpoint);

                this.cosmosClient = new CosmosClientBuilder()
                                .endpoint(cosmosEndpoint)
                                .key(cosmosKey)
                                .consistencyLevel(ConsistencyLevel.EVENTUAL)
                                .buildClient();

                this.cosmosDatabase = this.cosmosClient.getDatabase(cosmosDatabaseName);

                this.cosmosContainer = this.cosmosDatabase.getContainer(cosmosContainerName);
        }

        public void queryVolcano(String elevation, String limit) {
                CosmosQueryRequestOptions queryOptions = new CosmosQueryRequestOptions();
                queryOptions.setQueryMetricsEnabled(true);

                String query = String.format(
                                "SELECT * FROM collection c WHERE c.Elevation = %s ORDER BY c.Country ASC OFFSET 0 LIMIT %s",
                                elevation, limit);

                CosmosPagedIterable<Volcano> volcanoesPagedIterable = this.cosmosContainer.queryItems(
                                query, queryOptions, Volcano.class);

                volcanoesPagedIterable.iterableByPage(10).forEach(cosmosItemPropertiesFeedResponse -> {
                        logger.info("Got a page of query result with {} items(s) and request charge of {}",
                                        cosmosItemPropertiesFeedResponse.getResults().size(),
                                        cosmosItemPropertiesFeedResponse.getRequestCharge());

                        logger.info("Item Ids {}", cosmosItemPropertiesFeedResponse
                                        .getResults()
                                        .stream()
                                        .map(Volcano::toJsonString)
                                        .collect(Collectors.toList()));
                });
        }

}
