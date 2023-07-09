/*******************************************************************************
 * Unpublished Work. Copyright 2009-2022 Transverse, LLC. All Rights Reserved.
 * This software contains confidential and trade secret information of:
 * Transverse, LLC.
 * 600 Congress Ave.
 * Suite 2800
 * Austin, TX 78701
 * USA
 * Use, duplication or disclosure of this software is prohibited
 * without prior written permission of Transverse, LLC.
 ******************************************************************************/

package com.saten.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import cloud.localstack.awssdkv2.TestUtils;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.transfer.s3.S3TransferManager;


@TestConfiguration
public class S3TestConfiguration {

    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Bean
    AwsBasicCredentials awsCredentials() {
        return AwsBasicCredentials.create("123", "123");
    }


    @Bean
    S3Client awsS3Client() {
        S3Client s3Client = TestUtils.getClientS3V2();
        CreateBucketRequest request = CreateBucketRequest.builder().bucket(bucketName).build();
        s3Client.createBucket(request);
        return s3Client;
    }

    @Bean
    S3TransferManager s3TransferManager() {
        return S3TransferManager.builder().s3Client(TestUtils.getClientS3AsyncV2()).build();
    }
}
