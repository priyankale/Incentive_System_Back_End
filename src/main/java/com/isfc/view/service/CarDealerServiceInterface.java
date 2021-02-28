package com.isfc.view.service;

import java.text.ParseException;
import java.util.List;

import com.isfc.view.model.CarCompany;
import com.isfc.view.model.CarDealer;
import com.isfc.view.model.CarDetails;
import com.isfc.view.model.CustomerDetails;
import com.isfc.view.model.IncentivesDetails;

/**
 * CarDealerService INTERFACE 
 * 
 * This interface has abstract method which is implemented in CarDealerService class
 * @author Priyanka Jawade
 *
 */
public interface CarDealerServiceInterface {

	CarDealer addDealerDetails(CarDealer cardealer);

	CustomerDetails addCustomerDetails(CustomerDetails customerdetails);

	

	CarDetails addCarDetails(CarDetails cardetails) throws ParseException;

	CarDetails getCar(int id);

	CarDealer getDealer(int id);

	CustomerDetails getCustomer(int id);

	CarDetails updateCarDetails(CarDetails carDetails);

	List<CarDetails> deleteCar(int id);

	List<CustomerDetails> getAllCustomerDetails();
	List<CarDetails> getAllCars();

	List<CarDealer> getAllDealers();

	CarDealer updateDealerDetails(CarDealer dealerDetails);

	CustomerDetails updateCustomerDetails(CustomerDetails customerDetails);

	IncentivesDetails getIncentive(int id);

	//IncentivesDetails getIncentive(int id);







}
