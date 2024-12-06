package com.javaweb.controller;

import com.javaweb.entity.AccountEntity;
import com.javaweb.repository.itface.AccountRepository;
import com.javaweb.service.implement.CustomUserDetailsSerImplement;
import com.javaweb.service.itface.AccountService;
import com.javaweb.service.model.AccountDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LogInController {

    @GetMapping("/login")
    public String login() {

        return "login/index_login";
    }

}
