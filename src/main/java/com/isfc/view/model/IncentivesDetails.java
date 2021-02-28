package com.isfc.view.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * INCENTIVE DETAIL POJO CLASS
 * 
 * @author Priyanka Jawade
 *
 */
@Entity
@Table(name = "car_incentives")
public class IncentivesDetails {

	@Id
	@GeneratedValue
	@Column(name = "incentive_id")
	private int id;
	@Column(name = "car_free_insurance")
	private String insurance;
	@Column(name = "discount_price")
	private double price;
	@Column(name = "car_warranty")
	private int warranty;
	@Column(name = "free_cccessories")
	private String accessories;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carid")
	private CarDetails bookingDate;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,mappedBy  = "incentivesDetails")
	private DealDetails dealDetails;


	public IncentivesDetails() {
	}

	/**
	 * @param id incentive id
	 * @param insurance insurance as incentive
	 * @param price price discount as incentive
	 * @param warranty warranty as incentive
	 * @param accessories accessories as incentive
	 * @param bookingDate booking date for which incentive applicable 
	 */
	public IncentivesDetails(int id, String insurance, double price, int warranty, String accessories,
			CarDetails bookingDate) {
		super();
		this.id = id;
		this.insurance = insurance;
		this.price = price;
		this.warranty = warranty;
		this.accessories = accessories;
		this.bookingDate = bookingDate;
	}

	public IncentivesDetails(String insurance, double price, int warranty, String accessories,
			CarDetails bookingDate) {
		super();
		this.insurance = insurance;
		this.price = price;
		this.warranty = warranty;
		this.accessories = accessories;
		this.bookingDate = bookingDate;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public String getAccessories() {
		return accessories;
	}

	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}

	public CarDetails getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(CarDetails bookingDate) {
		this.bookingDate = bookingDate;
	}

	public DealDetails getDealDetails() {
		return dealDetails;
	}

	public void setDealDetails(DealDetails dealDetails) {
		this.dealDetails = dealDetails;
	}

	@Override
	public String toString() {
		return "IncentivesDetails [id=" + id + ", insurance=" + insurance + ", price=" + price + ", warranty="
				+ warranty + ", accessories=" + accessories + ", bookingDate=" + bookingDate + "]";
	}

}
