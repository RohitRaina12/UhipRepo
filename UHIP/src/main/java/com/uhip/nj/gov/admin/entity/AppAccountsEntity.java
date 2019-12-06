package com.uhip.nj.gov.admin.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="APP_ACCOUNTS")
@Data
public class AppAccountsEntity {
	@Id
	@SequenceGenerator(name="accId_gen", 
	                  sequenceName="ACC_ID_GEN_SEQ",allocationSize=1)                
			
	@GeneratedValue(generator="accId_gen",strategy=GenerationType.SEQUENCE)
	@Column(name="ACCOUNT_ID")
	private Integer accId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String pwd;
	
	@Column(name="Date_Of_Birth")
    private String dob;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="SSN")
	private Long ssn;
	
	@Column(name="PHONE")
	private Long phNumber;
	
	@Column(name="ROLE")
	private String role;
	
	@Column(name="ACTIVE_SW")
	private String activeSw;
	
	
	@CreationTimestamp
	@Column(name="CREATION_DATE")
	private Timestamp creationDt;
	
	
	@UpdateTimestamp
	@Column(name="UPDATION_DATE")
	private Timestamp updateDt;

}
