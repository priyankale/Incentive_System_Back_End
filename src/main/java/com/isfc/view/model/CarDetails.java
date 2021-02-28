package com.isfc.view.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * CAR DETAILS POJO CLASS
 * 
 * @author Priyanka Jawade
 *
 */
@Entity
@Table(name = "car_details")

public class CarDetails {
	@Id
	@GeneratedValue
	@Column(name = "car_id")
	private int id;
	@Column(name = "brand_name")
	private String bName;
	@Column(name = "model_name")
	private String mName;
	@Column(name = "car_color")
	private String color;
	@Column(name = "car_price")
	private double price;
	private String bookingDate;
		
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "bookingDate")
	private IncentivesDetails incentives;

	public CarDetails() {
	}

	/**
	 * @param id car id
	 * @param bName brand name of car
	 * @param mName model name of car
	 * @param color color of the car
	 * @param price value of the car
	 * @param bookingDate date of booking car
	 */
	public CarDetails(int id, String bName, String mName, String color, double price, String bookingDate) {
		super();
		this.id = id;
		this.bName = bName;
		this.mName = mName;
		this.color = color;
		this.price = price;
		this.bookingDate = bookingDate;
	}

	public CarDetails(String bName, String mName, String color, double price, String bookingDate) {
		super();
		this.bName = bName;
		this.bName = mName;
		this.color = color;
		this.price = price;
		this.bookingDate = bookingDate;
	}

	public IncentivesDetails getIncentives() {
		return incentives;
	}

	public void setIncentives(IncentivesDetails incentives) {
		this.incentives = incentives;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	@Override
	public String toString() {
		return "CarDetails [id=" + id + ", bName=" + bName + ", mName=" + mName + ", color=" + color + ", price="
				+ price + ", bookingDate=" + bookingDate + "]";
	}

}