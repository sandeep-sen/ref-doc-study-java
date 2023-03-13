package com.azure.refdoc.study.solution;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azure.core.util.IterableStream;
import com.azure.messaging.eventhubs.EventData;
import com.azure.messaging.eventhubs.EventDataBatch;
import com.azure.messaging.eventhubs.EventHubClientBuilder;
import com.azure.messaging.eventhubs.EventHubConsumerClient;
import com.azure.messaging.eventhubs.EventHubProducerClient;
import com.azure.messaging.eventhubs.models.EventPosition;
import com.azure.messaging.eventhubs.models.PartitionEvent;

public class EventHub {
    private static final Logger logger = LoggerFactory.getLogger(CosmosDB.class);

    String eventHubConnectionString;
    String eventHubName;

    public EventHub(String eventHubConnectionString, String eventHubName) {
        this.eventHubConnectionString = eventHubConnectionString;
        this.eventHubName = eventHubName;
    }

    public void produceMessages() {
        logger.info("Producing messages for Event Hub");
        EventHubProducerClient producer = new EventHubClientBuilder()
                .connectionString(this.eventHubConnectionString, this.eventHubName)
                .buildProducerClient();

        EventDataBatch eventDataBatch = producer.createBatch();

        for (EventData eventData : createEventDataList()) {
            if (!eventDataBatch.tryAdd(eventData)) {
                producer.send(eventDataBatch);
                eventDataBatch = producer.createBatch();

                if (!eventDataBatch.tryAdd(eventData)) {
                    throw new IllegalArgumentException("Event is too large for an empty batch. Max size: "
                            + eventDataBatch.getMaxSizeInBytes());
                }
            }
        }

        if (eventDataBatch.getCount() > 0) {
            producer.send(eventDataBatch);
        }
    }

    private List<EventData> createEventDataList() {
        Date date = new Date(System.currentTimeMillis());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        sdf.setTimeZone(TimeZone.getTimeZone("PDT"));
        String dateString = sdf.format(date);

        List<EventData> allEvents = Arrays.asList(new EventData("First (" + dateString + ")"),
                new EventData("Second (" + dateString + ")"),
                new EventData("Third (" + dateString + ")"),
                new EventData("Fourth (" + dateString + ")"),
                new EventData("Fifth (" + dateString + ")"),
                new EventData("Sixth (" + dateString + ")"),
                new EventData("Seventh (" + dateString + ")"),
                new EventData("Eighth (" + dateString + ")"),
                new EventData("Ninth (" + dateString + ")"),
                new EventData("Tenth (" + dateString + ")"));

        return allEvents;
    }

    public void consumeMessages() {
        EventHubConsumerClient consumer = new EventHubClientBuilder()
                .connectionString(this.eventHubConnectionString)
                .eventHubName(this.eventHubName)
                .consumerGroup(EventHubClientBuilder.DEFAULT_CONSUMER_GROUP_NAME)
                .buildConsumerClient();

        String partitionId = "0";

        IterableStream<PartitionEvent> events = consumer.receiveFromPartition(partitionId, 15,
                EventPosition.earliest(), Duration.ofSeconds(40));
        for (PartitionEvent event : events) {
            System.out.println("Event: " + event.getData().getBodyAsString());
        }
    }
}
