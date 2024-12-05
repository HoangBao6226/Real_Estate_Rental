package com.javaweb.controller;

import com.javaweb.service.model.AccomDTO;
import com.javaweb.service.model.AccomTypeDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LogInController {

    @GetMapping(value = "/login")
    public String loadIndex() {

//        List<AccomTypeDTO> acDTO = accomTypeSer.findAllAccomType();
////		"____" giống như key để gửi qua bên FE
//        model.addAttribute("accomType", acDTO);
//
//        List<AccomDTO> ac = accomSer.findRandomAccomAvailable();
////		"accommodation" giống như key để gửi qua bên FE
//        model.addAttribute("accommodation", ac);

        return "login/index_login";
    }
}
