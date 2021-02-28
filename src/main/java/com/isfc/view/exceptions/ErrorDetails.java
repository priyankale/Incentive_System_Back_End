package com.isfc.view.exceptions;

import java.time.LocalDate;

/**
 * ErrorDetail POJO class 
 * @author Priyanka Jawade
 *
 */
public class ErrorDetails {

	private String message;
	private LocalDate date;
	private String details;

	
	public ErrorDetails() {
	}

	/**
	 * @param message takes message as parameter 
	 * @param date takes local date as parameter
	 * @param details takes details as parameter
	 */
	public ErrorDetails(String message, LocalDate date, String details) {
		super();
		this.message = message;
		this.date = date;
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
