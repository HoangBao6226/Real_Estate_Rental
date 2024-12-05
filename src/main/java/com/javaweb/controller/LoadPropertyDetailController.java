package com.javaweb.controller;

import com.javaweb.service.itface.AccomService;
import com.javaweb.service.itface.AccomTypeService;
import com.javaweb.service.model.AccomDTO;
import com.javaweb.service.model.AccomTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class LoadPropertyDetailController {

	@Autowired
	private AccomTypeService accomTypeSer;

	@Autowired
	private AccomService accomSer;

	@GetMapping(value = "/properties/{id}")
	public String loadProperty(Model model, @PathVariable int id) {

		AccomDTO ac = accomSer.findAccomById(id);
//		"accommodation" giống như key để gửi qua bên FE
		model.addAttribute("accommodation", ac);

		return "property-details";
	}

}