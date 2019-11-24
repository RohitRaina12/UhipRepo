package com.uhip.nj.gov.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uhip.nj.gov.admin.model.AppAccountsModel;

@Controller
public class AdminController {
	
	@RequestMapping(value= {"/"}, method=RequestMethod.GET)
	public String displayAccountRegForm(Model model) {
		initializeAccRegForm(model);
		return "accountRegForm";
	}
	private void initializeAccRegForm(Model model) {
		AppAccountsModel accModel=new AppAccountsModel();
		List<String> genderList=new ArrayList<String>();
		List<String> role=new ArrayList<String>();
		genderList.add("Male");
		genderList.add("Female");
		model.addAttribute("genderList",genderList);
		model.addAttribute("modelObj", accModel);
		role.add("Admin");
		role.add("Case Worker");
		model.addAttribute("role",role);
		
	}
	public String processAccountRegForm(@ModelAttribute("modelObj")AppAccountsModel accModel) {
		return "accountRegForm";
	}

}
