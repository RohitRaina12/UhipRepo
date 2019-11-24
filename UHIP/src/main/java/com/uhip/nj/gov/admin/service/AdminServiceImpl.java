package com.uhip.nj.gov.admin.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.uhip.nj.gov.admin.model.AppAccountsModel;
import com.uhip.nj.gov.admin.repository.AppAccountsRepository;

public class AdminServiceImpl implements AdminService{
	@Autowired
	private AppAccountsRepository repo;

	@Override
	public String registerAccount(AppAccountsModel model) {
		
		return null;
	}
	 

}
