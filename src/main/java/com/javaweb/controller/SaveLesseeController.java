package com.javaweb.controller;

import com.javaweb.entity.LesseeEntity;
import com.javaweb.service.itface.LesseeService;
import com.javaweb.service.model.LesseeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class SaveLesseeController {

    @Autowired
    private LesseeService lesseeService;

    @PostMapping(value = "/save-lessee")
    public ResponseEntity<Map<String, Object>> saveLessee(@RequestBody LesseeDTO lesseeDTO) {

        try {
            // 1. Lưu vào cơ sở dữ liệu
            LesseeEntity savedLessee = lesseeService.saveLessee(lesseeDTO);

            // 2. Chuẩn bị phản hồi
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Lessee saved successfully!");
            response.put("lesseeID", savedLessee.getLesseeID());

            // 3. Trả về phản hồi với HTTP status 201
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            // 4. Xử lý lỗi
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to save lessee.");
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
