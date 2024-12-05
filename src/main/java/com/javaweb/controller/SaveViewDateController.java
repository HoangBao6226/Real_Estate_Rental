package com.javaweb.controller;

import com.javaweb.entity.DetailStatusEntity;
import com.javaweb.entity.ReservationEntity;
import com.javaweb.service.itface.DetailStatusService;
import com.javaweb.service.itface.ReservationService;
import com.javaweb.service.model.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SaveViewDateController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private DetailStatusService detailStatusService;

    @PostMapping(value = "/save-date")
    public ResponseEntity<Map<String, Object>> addReservation(@PathVariable int accommodationID,
                                                              @RequestParam (name = "lesseeID") String id2,
                                                              @RequestBody ReservationDTO reDTO) {

        try {
            // 1. Lưu vào cơ sở dữ liệu
            int lesseeID = Integer.parseInt(id2);
            ReservationEntity savedRe = reservationService.saveReservation(reDTO, accommodationID, lesseeID);
            DetailStatusEntity saveDS = detailStatusService.updateStatusID(accommodationID);

            // 2. Chuẩn bị phản hồi
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Reservation saved successfully!");

            // 3. Trả về phản hồi với HTTP status 201
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            // 4. Xử lý lỗi
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to save reservation.");
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
