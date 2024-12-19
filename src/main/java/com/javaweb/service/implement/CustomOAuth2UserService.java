//package com.javaweb.service.implement;
//
//import com.javaweb.entity.AccountEntity;
//import com.javaweb.repository.itface.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomOAuth2UserService extends DefaultOAuth2UserService {
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    private LesseeRepository lesseeRepository;
//
//    @Autowired
//    private LessorRepository lessorRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
//        OAuth2User oAuth2User = super.loadUser(userRequest);
//
//        // Lấy thông tin người dùng từ Google
//        String email = oAuth2User.getAttribute("email");
//        String name = oAuth2User.getAttribute("name");
//
//        // Thực hiện các thao tác kiểm tra hoặc lưu thông tin người dùng trong hệ thống
//        System.out.println("Email: " + email);
//        System.out.println("Name: " + name);
//
//        // Lưu Account
////        AccountEntity account = accountRepository.findByUsername(email);
////        if (account == null) {
////            account = new AccountEntity();
////            account.setUsername(email);
////            account.setPassword(passwordEncoder.encode("OAuth2_Google_Login"));
////            account.setRoleID(roleRepository.findById(4).get());
////            accountRepository.save(account);
////        }
//        // Trả về đối tượng OAuth2User
//        // Trả về một OAuth2User với email là nameAttributeKey
//        return new DefaultOAuth2User(
//                oAuth2User.getAuthorities(),
//                oAuth2User.getAttributes(),
//                "email" // Cấu hình nameAttributeKey
//        );
//    }
//}
//
