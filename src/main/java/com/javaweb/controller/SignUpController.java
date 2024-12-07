package com.javaweb.controller;

import com.javaweb.repository.itface.AccountRepository;
import com.javaweb.repository.itface.EmployeeRepository;
import com.javaweb.repository.itface.LesseeRepository;
import com.javaweb.repository.itface.LessorRepository;
import com.javaweb.service.implement.RegistrationSerImplement;
import com.javaweb.service.itface.RegistrationService;
import com.javaweb.service.model.RegistrationDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SignUpController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LesseeRepository lesseeRepository;

    @Autowired
    private LessorRepository lessorRepository;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "/signup")
    public ResponseEntity<Map<String, Object>> signUp(@RequestBody RegistrationDTO registrationDTO) {

        try {
            // 1. Lưu vào cơ sở dữ liệu
            // Kiểm tra username đã tồn tại hay chưa
            if (accountRepository.findByUsername(registrationDTO.getUsername()) != null) {
                Map<String, Object> response = new HashMap<>();
                response.put("notification", "Username already exists!");
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            }

            if(employeeRepository.findByEmail(registrationDTO.getEmail()) != null ||
                    lesseeRepository.findByEmail(registrationDTO.getEmail()) != null ||
                    lessorRepository.findByEmail(registrationDTO.getEmail()) != null) {
                Map<String, Object> response = new HashMap<>();
                response.put("notification", "Email already exists!");
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            }

            registrationService.saveUser(registrationDTO);

            // 2. Chuẩn bị phản hồi
            Map<String, Object> response = new HashMap<>();
            response.put("notification", "Sign up successfully!");

            // Tự động đăng nhập
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    registrationDTO.getUsername(),
                    registrationDTO.getPassword()
            );

            Authentication authResult = authenticationManager.authenticate(authentication);
            SecurityContextHolder.getContext().setAuthentication(authResult);
//            UsernamePasswordAuthenticationToken authToken =
//                    new UsernamePasswordAuthenticationToken(registrationDTO.getUsername(), registrationDTO.getPassword());
//            Authentication authentication = authenticationManager.authenticate(authToken);
//            SecurityContextHolder.getContext().setAuthentication(authentication);

            // 3. Trả về phản hồi với HTTP status 201
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            // 4. Xử lý lỗi
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to Sign up!");
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
