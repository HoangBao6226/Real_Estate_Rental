package com.javaweb.service.implement;

import com.javaweb.entity.LesseeEntity;
import com.javaweb.repository.itface.LesseeRepository;
import com.javaweb.service.itface.LesseeService;
import com.javaweb.service.model.LesseeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LesseeSerImplement implements LesseeService {

    @Autowired
    private LesseeRepository lesseeRepository;

    @Override
    public LesseeEntity saveLessee(LesseeDTO lesseeDTO) {

        String fullName = lesseeDTO.getName().trim();
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

        LesseeEntity lesseeEntity = new LesseeEntity();
        lesseeEntity.setFirstName(firstName);
        lesseeEntity.setLastName(lastName);
        lesseeEntity.setAddress(lesseeDTO.getAddress());
        lesseeEntity.setEmail(lesseeDTO.getEmail());
        lesseeEntity.setPhoneNumber(lesseeDTO.getPhone());

        return lesseeRepository.save(lesseeEntity);
    }

}
