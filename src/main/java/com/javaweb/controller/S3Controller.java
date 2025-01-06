package com.javaweb.controller;

import com.javaweb.service.implement.S3Service;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;

@RestController
public class S3Controller {

    @Autowired
    private S3Service s3Service;

    @Autowired
    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @GetMapping("/s3/image/{key}")
    public void getImageUrl(@PathVariable String key, HttpServletResponse res) throws IOException {

        res.sendRedirect(s3Service.generatePresignedUrl(key));
    }
//    public String getImageUrl(@PathVariable String key) {
//        return s3Service.generatePresignedUrl(key);
//    }
//    public ResponseEntity<Void> getImageUrl(@PathVariable String key) {
//        String preSignedUrl = s3Service.generatePresignedUrl(key);
//        return ResponseEntity.status(HttpStatus.FOUND)
//                .location(URI.create(preSignedUrl))
//                .build();
//    }
}

