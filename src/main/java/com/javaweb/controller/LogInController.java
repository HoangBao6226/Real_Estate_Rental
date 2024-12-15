package com.javaweb.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class LogInController {

    @GetMapping("/login")
    public String login() {

        return "login/index_login";
    }

}
