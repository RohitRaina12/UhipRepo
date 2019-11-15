package com.uhip.nj.gov.ar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArController {
	@RequestMapping(value= {"/"}, method=RequestMethod.GET)
	public String displayRegForm() {
		
		return "form";
	}
	

}
