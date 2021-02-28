package com.isfc.view.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isfc.view.exceptions.DetailNotFoundException;
import com.isfc.view.model.CarCompany;
import com.isfc.view.model.CarDealer;
import com.isfc.view.model.CarDetails;
import com.isfc.view.model.CustomerDetails;
import com.isfc.view.service.CarCompanyServiceInterface;
import com.isfc.view.service.CarDealerServiceInterface;

/**
 * CAR COMPANY CONTROLLER CLASS
 * 
 * This class allows car company to add car details,add company details ,and
 * view car details
 * 
 * @author Priyanka Jawade
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class CarCompanyController {
	Logger logger = LoggerFactory.getLogger(CarCompanyController.class);
	@Autowired
	CarCompanyServiceInterface cservice;
	@Autowired
	CarDealerServiceInterface service;

	/**
	 * This method adds the company details
	 * 
	 * @param companyDetails takes parameter as company details
	 * @return id for entered company details
	 */
	@PostMapping("/addCompanyDetail")
	public ResponseEntity<Integer> addCompanyDetail(@RequestBody @Valid CarCompany companyDetails) {
		CarCompany company = cservice.addCompanyDetail(companyDetails);
		logger.info(" Company details added successfully");
		return new ResponseEntity<>(company.getId(), HttpStatus.OK);
	}

	/**
	 * This method add the car detail
	 * 
	 * @param cardetails takes parameter as car detail
	 * @return the id for the entered car details
	 * @throws ParseException if the
	 */
	@PostMapping("/addCarDetail")
	public ResponseEntity<Integer> addCarDetails(@RequestBody CarDetails cardetails) throws ParseException {
		CarDetails cardetailsInfo = cservice.addCarDetails(cardetails);
		logger.info(" Car details added successfully");
		return new ResponseEntity<>(cardetailsInfo.getId(), HttpStatus.OK);
	}

	/**
	 * This method is used to get the car details
	 * 
	 * @param id take car id
	 * @return return the car details for the given id
	 */
	@GetMapping("/viewCar/{id}")
	public ResponseEntity<CarDetails> viewCar(@PathVariable("id") int id) {

		CarDetails carDetails = cservice.viewCar(id);
		if (carDetails == null) {
			logger.error("No car Present with given id");
			throw new DetailNotFoundException("No Car present with the given id: " + id);
		}
		return new ResponseEntity<>(carDetails, HttpStatus.OK);
	}
	@GetMapping("/getCompany/{id}")
	public ResponseEntity<CarCompany> getCompany(@PathVariable("id") int id) {

		CarCompany companyDetails = cservice.getCompanys(id);
		if (companyDetails == null) {
			logger.error("No company Present with given id");
			throw new DetailNotFoundException("No Company present with the given id: " + id);
		}
		return new ResponseEntity<>(companyDetails, HttpStatus.OK);
	}
	@GetMapping("/getAllCompanys")
	public ResponseEntity<List<CarCompany>> getAllCompanys() {
		List<CarCompany> companyDetails = cservice.getAllCompanys();
		return new ResponseEntity<>(companyDetails, HttpStatus.OK);
	}
	@GetMapping("/getAllCarDetail")
	public ResponseEntity<List<CarDetails>> getAllCars() {
		List<CarDetails> cars = cservice.getAllCars();
		return new ResponseEntity<List<CarDetails>>(cars, HttpStatus.OK);
	}

	@PutMapping("/updateCompanyDetails")
	public ResponseEntity<CarCompany> updateCompanyDetails(@RequestBody CarCompany companyDetails) {
		CarCompany companyInfo = cservice.updateCompanyDetails(companyDetails);
		return new ResponseEntity<>(companyInfo, HttpStatus.OK);
	}
	@PutMapping("/updateCar")
	public ResponseEntity<CarDetails> updateCar(@RequestBody CarDetails carDetails) {
		CarDetails carInfo = cservice.updateCar(carDetails);
		return new ResponseEntity<>(carInfo, HttpStatus.OK);
	}

}