package com.isfc.view.service;

import java.text.ParseException;
import java.util.List;

import com.isfc.view.model.CarCompany;
import com.isfc.view.model.CarDetails;

/**
 * CarCompanyService INTERFACE
 * 
 * This interface have abstract methods which are implemented in
 * CarCompanyService class
 * 
 * @author Priyanka Jawade
 *
 */
public interface CarCompanyServiceInterface {

	CarCompany addCompanyDetail(CarCompany companyDetails);

	CarDetails addCarDetails(CarDetails cardetails) throws ParseException;

	

	CarCompany getCompanys(int id);

	CarCompany updateCompanyDetails(CarCompany companyDetails);

	List<CarCompany> getAllCompanys();

	List<CarDetails> getAllCars();

	

	
	CarDetails viewCar(int id);

	CarDetails updateCar(CarDetails carDetails);


	

}
