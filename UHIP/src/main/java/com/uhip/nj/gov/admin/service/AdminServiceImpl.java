package com.uhip.nj.gov.admin.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhip.nj.gov.admin.entity.AppAccountsEntity;
import com.uhip.nj.gov.admin.model.AppAccountsModel;
import com.uhip.nj.gov.admin.repository.AppAccountsRepository;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AppAccountsRepository repo;
    /**
     * this method is used to register the user
     */
	@Override
	public String registerAccount(AppAccountsModel model) {
		AppAccountsEntity entity=null;
		entity=new AppAccountsEntity();
		//converting AppAccountModel to AppAccountEntity
		BeanUtils.copyProperties(model, entity);
		//setting activeSwich=y
		entity.setActiveSw("Y");
		//calling method to save data
		entity=repo.save(entity);
		if(entity.getAccId()!=null) {
			return "Account Registered with Account id:" +entity.getAccId();
		}
		else
		{
			return"Account not Registered";
		}
		
	}
	@Override
	public boolean validateEmail(String email) {
		boolean flag=false;
		int count=repo.getEmailCount(email);
		if(count>0) {
			flag=true;
		}
		return flag;
	}
	 

}
