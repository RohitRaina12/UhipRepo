package com.uhip.nj.gov.admin.model;

import lombok.Data;

@Data
public class AppAccountsModel {
	private String firstName;
	private String lastName;
	private String email;
	private String pwd;
	private String dob;
	private String gender;
	private Long ssn;
	private Long phNumber;
	private String role;

}
