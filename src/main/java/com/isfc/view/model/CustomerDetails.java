package com.isfc.view.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CUSTOMER DETAILS POJO CLASS
 * 
 * @author Priyanka Jawade
 *
 */
@Entity
@Table(name = "customer_details")

public class CustomerDetails {
	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private int id;
	@Column(name = "cust_first_name")
	private String fName;
	@Column(name = "cust_last_name")
	private String lName;
	@Column(name = "cust_email")
	private String mail;
	@Column(name = "cust_contact")
	private long no;
	@Column(name = "cust_city")
	private String city;
	


	public CustomerDetails() {
	}

	/**
	 * @param id customer id
	 * @param fName customer first name
	 * @param lName customer last name
	 * @param mail customer email
	 * @param no customer contact number
	 * @param city customer city
	 */
	public CustomerDetails(int id, String fName, String lName, String mail, long no, String city) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.mail = mail;
		this.no = no;
		this.city = city;
	}

	public CustomerDetails(String fname, String lname, String mail, long no, String city) {
		super();
		this.fName = fname;
		this.lName = lname;
		this.mail = mail;
		this.no = no;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	


	@Override
	public String toString() {
		return "CustomerDetails [id=" + id + ", fName=" + fName + ", lName=" + lName + ", mail=" + mail + ", no=" + no
				+ ", city=" + city + "]";
	}

}
