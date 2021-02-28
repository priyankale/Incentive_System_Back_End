package com.isfc.view.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * CAR COMPANY POJO CLASS
 * 
 * @author Priyanka Jawade
 *
 */
@Entity
@Table(name = "car_company")
public class CarCompany {
	@Id
	@GeneratedValue

	@Column(name = " company_id")
	private int id;
	@NotEmpty(message = "Company name should not empty")
	@Size(min = 4, message = "min 4 chars required")
	@Column(name = "company_name")
	private String cName;
	
	@NotEmpty(message = "Company email should not empty")
	@Size(min = 4, message = "min 4 chars required")
	@Column(name = "company_email")
	private String cMail;
	
	private String password;


	public CarCompany() {
	}


	public CarCompany(int id,
			@NotEmpty(message = "Company name should not empty") @Size(min = 4, message = "min 4 chars required") String cName,
			@NotEmpty(message = "Company email should not empty") @Size(min = 4, message = "min 4 chars required") String cMail,
			String password) {
		super();
		this.id = id;
		this.cName = cName;
		this.cMail = cMail;
		this.password = password;
	}


	public CarCompany(
			@NotEmpty(message = "Company name should not empty") @Size(min = 4, message = "min 4 chars required") String cName,
			@NotEmpty(message = "Company email should not empty") @Size(min = 4, message = "min 4 chars required") String cMail,
			String password) {
		super();
		this.cName = cName;
		this.cMail = cMail;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
	}


	public String getcMail() {
		return cMail;
	}


	public void setcMail(String cMail) {
		this.cMail = cMail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "CarCompany [id=" + id + ", cName=" + cName + ", cMail=" + cMail + ", password=" + password + "]";
	}

	/**
	 * @param id company id
	 * @param cName company name
	 * @param cMail company email
	 */
	

}