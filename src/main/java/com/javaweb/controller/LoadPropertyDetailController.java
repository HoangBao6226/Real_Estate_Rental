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
public class LoadPropertyDetailController {

	@Autowired
	private AccomTypeService accomTypeSer;

	@Autowired
	private AccomService accomSer;

	@GetMapping(value = "/property-details.html")
	public String loadProperty(Model model, Model model2) {

		List<AccomTypeDTO> acDTO = accomTypeSer.findAllAccomType();
//		"____" giống như key để gửi qua bên FE
		model.addAttribute("accomType", acDTO);

		List<AccomDTO> ac = accomSer.findAllAccomAvailable();
//		"accommodation" giống như key để gửi qua bên FE
		model.addAttribute("accommodation", ac);

		return "property-details";
	}

}