//package com.javaweb;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                // Cấu hình CSRF
//                .csrf(csrf -> csrf.disable()) // Tắt CSRF nếu không cần
//
//                // Cấu hình CORS
//                .cors(cors -> {}) // Cấu hình CORS qua lambda (rỗng nếu mặc định)
//
//                // Phân quyền truy cập
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/properties.html").hasRole("admin") // Chỉ admin truy cập
//                        .anyRequest().authenticated() // Các request khác cần xác thực
//                )
//
//                // Form login
//                .formLogin(form -> form.defaultSuccessUrl("/index").permitAll()); // Redirect sau đăng nhập
//
//        return http.build();
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOrigin("*"); // Cho phép tất cả nguồn (cần tùy chỉnh nếu cần)
//        configuration.addAllowedMethod("*"); // Cho phép tất cả HTTP methods (GET, POST, ...)
//        configuration.addAllowedHeader("*"); // Cho phép tất cả headers
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//}
//
//
//
