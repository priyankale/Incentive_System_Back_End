package com.isfc.view.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * CAR DEALER POJO CLASS
 * 
 * @author Priyanka Jawade
 *
 */
@Entity
@Table(name = "car_dealer")
public class CarDealer {
	@Id
	@GeneratedValue
	@Column(name = "dealer_id")
	private int id;
	@NotEmpty(message = "first name should not empty")
	@Size(min = 3, message = "min 3 chars required")
	@Column(name = "first_name")
	private String fName;
	@NotEmpty(message = "Last name should not empty")
	@Size(min = 3, message = "min 3 chars required")
	@Column(name = "last_name")
	private String lName;
	@NotEmpty(message = "Email should not empty")
	@Size(min = 4, message = "min 4 chars required")
	@Column(name = "Email")
	private String mail;
	private String password;

	@Column(name = "dealer_contact")
	private long no;
	@NotEmpty(message = "City should not empty")
	@Size(min = 4, message = "min 4 chars required")
	@Column(name = "dealer_city")
	private String city;
	

	public CarDealer() {

	}

	/**
	 * @param id dealer id
	 * @param fName first name of dealer
	 * @param lName last name of dealer
	 * @param mail email of dealer
	 * @param no mobile no of dealer
	 * @param city city of the dealer
	 */
	public CarDealer(int id, String fName, String lName, String mail,String password, long no, String city) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.mail = mail;
		this.password=password;
		this.no = no;
		this.city = city;
	}

	public CarDealer(String fName, String lName, String mail,String password, long no, String city) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.mail = mail;
		this.password=password;
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
	
	


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CarDealer [id=" + id + ", fName=" + fName + ", lName=" + lName + ", mail=" + mail + ", password="
				+ password + ", no=" + no + ", city=" + city + "]";
	}


}
