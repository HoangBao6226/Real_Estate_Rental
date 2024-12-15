package com.javaweb.config;

import com.javaweb.service.implement.CustomOAuth2UserService;
import com.javaweb.service.implement.CustomUserDetailsSerImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsSerImplement customUserDetailsService;

    public SecurityConfig(CustomUserDetailsSerImplement customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/lessee/assets/**", "/lessee/vendor/**").permitAll()
                        .requestMatchers( "/", "/index", "/properties", "/propertiesSearch").permitAll()
                        .requestMatchers("/login**", "/signup").permitAll()
                        .requestMatchers("/properties/**").hasRole("LESSEE")
                        .requestMatchers("/manager**").hasRole("MANAGER")
                        .requestMatchers("/sales/**").hasRole("SALES")
                        .requestMatchers("/lessor/**").hasRole("LESSOR")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login")  // Trang đăng nhập
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(customOAuth2UserService()) // Tùy chỉnh ánh xạ người dùng
                        )
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(provider);
    }

    @Bean
    public CustomOAuth2UserService customOAuth2UserService() {
        return new CustomOAuth2UserService();
    }

}

