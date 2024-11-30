package com.javaweb.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.javaweb.service.itface.AccomService;
import com.javaweb.service.model.AccomDTO;


@Controller
@RequestMapping("/accommodation2")
public class SearchController {

	@Autowired
	private AccomService accomSer;
	
	@GetMapping(value = "/list-accom")
	public String listAccomDTO(Model model) {
		List<AccomDTO> acDTO = accomSer.findAllAccom();

//		"accommodation" giống như key để gửi qua bên FE
		model.addAttribute("accommodation", acDTO);

		return "list-accom";
	}
	
	@PostMapping(value = "/search")
	public List<AccomDTO> searchAccom(@RequestParam Map<String, Object> params, 
										@RequestParam (name = "amenityName", required = false) List<String> amenityName,
										@RequestParam (name = "rentTypeName", required = false) List<String> rentTypeName) {
		return accomSer.findAll(params, amenityName, rentTypeName);		
	}
}