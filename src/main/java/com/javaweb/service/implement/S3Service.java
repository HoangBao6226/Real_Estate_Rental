package com.javaweb.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import java.time.Duration;

@Service
public class S3Service {

    @Autowired
    private S3Presigner s3Presigner;

//    @Value("${aws.s3.bucket-name}")
    private String bucketName = "yoon-realestate";

//    public S3Service(S3Presigner s3Presigner) {
//        this.s3Presigner = s3Presigner;
//    }

//    @Async
//    public void generatePresignedUrl(String key, StringBuilder pre) {
//        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
//                .bucket(bucketName)
//                .key(key)
//                .build();
//
//        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
//                .signatureDuration(Duration.ofMinutes(30)) // URL valid for 10 minutes
//                .getObjectRequest(getObjectRequest)
//                .build();
//
//        pre.append(s3Presigner.presignGetObject(presignRequest).url().toString());
//    }
    public String generatePresignedUrl(String key) {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(30)) // URL valid for 10 minutes
                .getObjectRequest(getObjectRequest)
                .build();

        String pre = s3Presigner.presignGetObject(presignRequest).url().toString();
        return pre;
    }
}

