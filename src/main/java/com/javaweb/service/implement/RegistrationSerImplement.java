package com.javaweb.service.implement;

import com.javaweb.entity.AccountEntity;
import com.javaweb.entity.LesseeEntity;
import com.javaweb.entity.LessorEntity;
import com.javaweb.repository.itface.AccountRepository;
import com.javaweb.repository.itface.LesseeRepository;
import com.javaweb.repository.itface.LessorRepository;
import com.javaweb.repository.itface.RoleRepository;
import com.javaweb.service.itface.RegistrationService;
import com.javaweb.service.model.RegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationSerImplement implements RegistrationService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private LesseeRepository lesseeRepository;

    @Autowired
    private LessorRepository lessorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(RegistrationDTO form) {

        // Lưu Account
        AccountEntity account = new AccountEntity();
        account.setUsername(form.getUsername());
        account.setPassword(passwordEncoder.encode(form.getPassword()));

        // Lưu Lessee
        String fullName = form.getName().trim();
        String firstName = "";
        String lastName = "";

        if (fullName.contains(" ")) {
            // Tách tên dựa trên khoảng trắng
            int lastSpaceIndex = fullName.lastIndexOf(" ");
            lastName = fullName.substring(0, lastSpaceIndex).trim();
            firstName = fullName.substring(lastSpaceIndex + 1).trim();
        } else {
            // Nếu chỉ có một từ, xem đó là firstName
            firstName = fullName;
        }

        String selectedRole = form.getRole();

        if ("lessee".equalsIgnoreCase(selectedRole)) {
            LesseeEntity lessee = new LesseeEntity();
            lessee.setFirstName(firstName);
            lessee.setLastName(lastName);
            lessee.setAddress(form.getAddress());
            lessee.setPhoneNumber(form.getPhone());
            lessee.setEmail(form.getEmail());
            lesseeRepository.save(lessee);
            // Lưu Account
            account.setRoleID(roleRepository.findById(4).get());
            account.setLesseeID(lesseeRepository.findById(lessee.getLesseeID()).get());
            accountRepository.save(account);
        } else if ("lessor".equalsIgnoreCase(selectedRole)) {
            LessorEntity lessor = new LessorEntity();
            lessor.setFirstName(firstName);
            lessor.setLastName(lastName);
            lessor.setAddress(form.getAddress());
            lessor.setPhoneNumber(form.getPhone());
            lessor.setEmail(form.getEmail());
            lessorRepository.save(lessor);
            // Lưu Account
            account.setRoleID(roleRepository.findById(3).get());
            account.setLessorID(lessorRepository.findById(lessor.getLessorID()).get());
            accountRepository.save(account);
        }

    }
}
