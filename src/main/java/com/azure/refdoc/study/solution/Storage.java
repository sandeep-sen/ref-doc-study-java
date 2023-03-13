package com.azure.refdoc.study.solution;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.blob.specialized.BlockBlobClient;

public class Storage {

    BlobServiceClient storageClient;
    BlobContainerClient blobContainerClient;
    private static final Logger logger = LoggerFactory.getLogger(Storage.class);

    public Storage(String azureStorageConnectionString, String storageContainerName) {
        logger.info("Creating Blob Service Client");

        this.storageClient = new BlobServiceClientBuilder()
                .connectionString(azureStorageConnectionString)
                .httpLogOptions(new HttpLogOptions()
                        .setLogLevel(HttpLogDetailLevel.HEADERS))
                .buildClient();

        logger.info("Creating Blob Container Client");
        this.blobContainerClient = storageClient.getBlobContainerClient(storageContainerName);
    }

    public void getBlobContent(String blobName) throws IOException {
        logger.info("Getting content for file : ", blobName);

        BlockBlobClient blobClient = this.blobContainerClient.getBlobClient(blobName)
                .getBlockBlobClient();
        int dataSize = (int) blobClient.getProperties().getBlobSize();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(dataSize);
        blobClient.downloadStream(outputStream);
        String content = new String(outputStream.toByteArray());
        outputStream.close();
        System.out.println("Blob content for " + blobName);
        System.out.println(content);
    }

    public void getBlobList() throws IOException {
        logger.info("Getting list of Blobs from container: ", this.blobContainerClient.getBlobContainerName());

        for (BlobItem blobItem : this.blobContainerClient.listBlobs()) {
            System.out.println("List of blobs:");
            System.out.println(blobItem.getName());
        }
    }
}