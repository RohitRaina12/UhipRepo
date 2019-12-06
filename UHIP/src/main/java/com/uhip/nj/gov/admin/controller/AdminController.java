package com.uhip.nj.gov.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uhip.nj.gov.admin.model.AppAccountsModel;
import com.uhip.nj.gov.admin.service.AdminService;
import com.uhip.nj.gov.exceptions.UhipAdminWebException;
import com.uhip.nj.gov.util.AppConstants;

@Controller
public class AdminController {
	@Autowired
	AdminService service;
	
	private  static final Logger logger=LoggerFactory.getLogger(AdminController.class);
    
	/**
	 * This method is used to display Account Registration form
	 * @param model
	 * @return String
	 * 
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String displayAccountRegForm(Model model) {
		try {
			logger.debug("**displayAccountRegForm(-) method execution started**");
			AppAccountsModel accModel = new AppAccountsModel();
			model.addAttribute(AppConstants.MODEL_OBJ_LN, accModel);
			initializeAccRegForm(model);
		}
		catch (Exception e) {
			logger.error("**Exception occured in displayAccountRegForm(-)**");
			throw new UhipAdminWebException(e.getMessage());
		}
		logger.debug("**displayAccountRegForm(-) method execution completed**");
		logger.info("**displayAccountRegForm(-) method execution completed successfully**");
		return AppConstants.ACC_REG_FORM_LVN;
	}
    /**
     * This method is used to add values to Registration form
     * @param model
     */
	private void initializeAccRegForm(Model model) {
		try {
			logger.debug("**initializeAccRegForm() execution started**");
			List<String> genderList = new ArrayList<String>();
			List<String> role = new ArrayList<String>();
			genderList.add("Male");
			genderList.add("Female");
			model.addAttribute("genderList", genderList);
			role.add("Admin");
			role.add("Case Worker");
			model.addAttribute("role", role);
		}
		catch (Exception e) {
			logger.debug("**Exception occured in initializeAccRegForm()**");
			throw new UhipAdminWebException(e.getMessage());
		}
		logger.debug("**initializeAccRegForm() execution completed**");
		logger.info("**initializeAccRegForm() execution completed successfully**");
	}
    /**
     * This method is used to register the user
     * @param accModel
     * @param model
     * @return String
     */
	@RequestMapping(value = { "regForm" }, method = RequestMethod.POST)
	public String processAccountRegForm(@ModelAttribute("modelObj") AppAccountsModel accModel,RedirectAttributes attr, Model model) {
        try {
        	logger.debug("**processAccountRegForm(-,-) execution started**");
        	String registerMsg=null;
            //calling service class method
    		registerMsg=service.registerAccount(accModel);
    		attr.addFlashAttribute("regMsg",registerMsg);
    		initializeAccRegForm(model);
        	
        }
        catch (Exception e) {
        	logger.debug("**Exception occured in processAccountRegForm(-,-)**");
			throw new UhipAdminWebException(e.getMessage());
		}
        logger.debug("**processAccountRegForm(-,-) execution completed**");
        logger.info("**processAccountRegForm(-,-) execution completed successfully**");
		return "redirect:/regSuccess";
	}
	@RequestMapping(value= {"regSuccess"},method=RequestMethod.GET)
	private String displayAccRegFormAfterSuccess(Model model) {
		AppAccountsModel accModel = new AppAccountsModel();
		model.addAttribute(AppConstants.MODEL_OBJ_LN, accModel);
		initializeAccRegForm(model);
		return AppConstants.ACC_REG_FORM_LVN;
	}
	@RequestMapping(value="/regForm/checkEmail",method=RequestMethod.GET)
	public @ResponseBody String checkEmail(HttpServletRequest request) {
		String email=request.getParameter("email");
		System.out.println("checkemail called");
		boolean flag=service.validateEmail(email);
		if(flag=true) {
			return "duplicate";
		}
		else
			return "unique";
	}

}
