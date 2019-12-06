package com.uhip.nj.gov.admin.service;

import org.springframework.stereotype.Service;

import com.uhip.nj.gov.admin.model.AppAccountsModel;

public interface AdminService {
	public String registerAccount(AppAccountsModel model);
	public boolean validateEmail(String email);
}
