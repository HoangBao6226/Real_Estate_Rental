package com.javaweb.controller;

import com.javaweb.service.itface.AccomService;
import com.javaweb.service.itface.AccomTypeService;
import com.javaweb.service.model.AccomDTO;
import com.javaweb.service.model.AccomTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class LoadIndexController {

	@Autowired
	private AccomTypeService accomTypeSer;

	@Autowired
	private AccomService accomSer;

	@GetMapping(value = "/")
	public String loadIndex(Model model) {

		List<AccomTypeDTO> acDTO = accomTypeSer.findAllAccomType();
//		"____" giống như key để gửi qua bên FE
		model.addAttribute("accomType", acDTO);

		List<AccomDTO> ac = accomSer.findRandomAccomAvailable();
//		"accommodation" giống như key để gửi qua bên FE
		model.addAttribute("accommodation", ac);

		return "index";
	}

}