package com.isfc.view.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * DEAL DETAIL POJO CLASS
 * 
 * @author Priyanka Jawade
 *
 */
@Entity
@Table(name = "deal_table")
public class DealDetails {
	@Id
	@GeneratedValue
	@Column(name = "deal_id")
	private int id;
	@Column(name = "approved_status")
	private String approved;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "inc_id")
	private IncentivesDetails incentivesDetails;


	public DealDetails() {
	}


	/**
	 * @param id deal id
	 * @param approved incentive approval
	 * @param incentivesDetails details of the incentive applicable
	 */
	public DealDetails(int id, String approved, IncentivesDetails incentivesDetails) {
		super();
		this.id = id;
		this.approved = approved;
		this.incentivesDetails = incentivesDetails;
	}


	public DealDetails(String approved, IncentivesDetails incentivesDetails) {
		super();
		this.approved = approved;
		this.incentivesDetails = incentivesDetails;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getApproved() {
		return approved;
	}


	public void setApproved(String approved) {
		this.approved = approved;
	}


	public IncentivesDetails getIncentivesDetails() {
		return incentivesDetails;
	}


	public void setIncentivesDetails(IncentivesDetails incentivesDetails) {
		this.incentivesDetails = incentivesDetails;
	}


	@Override
	public String toString() {
		return "DealDetails [id=" + id + ", approved=" + approved + ", incentivesDetails=" + incentivesDetails + "]";
	}

	
}