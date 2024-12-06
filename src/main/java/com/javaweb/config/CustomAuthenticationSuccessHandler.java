//package com.javaweb.config;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.RedirectStrategy;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
//import org.springframework.security.web.savedrequest.SavedRequest;
//
//import java.io.IOException;
//
//public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//    private final HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
//    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//
//        // Lấy URL trước khi bị chuyển đến trang login
//
//        SavedRequest savedRequest = requestCache.getRequest(request, response);
//
//        // Nếu không có URL trước đó, chuyển hướng đến trang mặc định
//
//        if (savedRequest == null) {
//            redirectStrategy.sendRedirect(request, response, "/"); // URL mặc định nếu không có URL trước đó
//            return;
//        }
//
//        // URL trước đó người dùng truy cập
//        String targetUrl = savedRequest.getRedirectUrl();
//        redirectStrategy.sendRedirect(request, response, targetUrl); // Chuyển hướng về URL trước đó
//    }
//}
