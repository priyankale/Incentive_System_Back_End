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
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.isfc.view.model.IncentivesDetails;
import com.isfc.view.service.CarDealerServiceInterface;

/**
 * CAR DEALER CONTROLLER CLASS
 * 
 * This class allows car dealer to add,view,update,and delete details
 * 
 * @author Priyanka Jawade
 * @param <DealerDetails>
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class CarDealerController<DealerDetails> {
	Logger logger = LoggerFactory.getLogger(CarDealerController.class);

	@Autowired
	CarDealerServiceInterface service;

	/**
	 * @param carDealer takes car dealer as parameter
	 * @return id for entered dealer details
	 */
	@PostMapping("/addDealerDetails")
	public ResponseEntity<Integer> addDealerDetails(@RequestBody @Valid CarDealer carDealer) {
		CarDealer dealerInfo = service.addDealerDetails(carDealer);
		logger.info(" Dealer Details added successfully");
		return new ResponseEntity<>(dealerInfo.getId(), HttpStatus.OK);
	}

	/**
	 * @param customerDetails takes customer details as parameter
	 * @return id for entered customer details
	 */
	@PostMapping("/addCustomerDetails")
	public String addCustomerDetails(@RequestBody CustomerDetails customerDetails) {
		String str = "Customer details not added";
		CustomerDetails customerInfo = service.addCustomerDetails(customerDetails);
		if (customerInfo != null) {
			str = " Customer details added successfully";
		}
		logger.info(str);
		return str;

	}

	/**
	 * @param companyDetails takes company details as parameter
	 * @return id for entered company details
	 */


	/**
	 * @param carDetails takes car details as parameter
	 * @return id for entered car details
	 * @throws ParseException throws parse exception
	 */
	@PostMapping("/addCarDetails")
	public ResponseEntity<Integer> addCarDetails(@RequestBody CarDetails carDetails) throws ParseException {
		CarDetails cardetailsInfo = service.addCarDetails(carDetails);
		logger.info("Details added successfully");
		return new ResponseEntity<>(cardetailsInfo.getId(), HttpStatus.OK);
	}

	/**
	 * @param id takes Car id as parameter
	 * @return car details for entered id
	 */
	@GetMapping("/getCar/{id}")
	public ResponseEntity<CarDetails> getCar(@PathVariable("id") int id) {

		CarDetails carDetails = service.getCar(id);
		if (carDetails == null) {
			logger.error("No car Present with given id");
			throw new DetailNotFoundException("No Car present with the given id: " + id);
		}

		return new ResponseEntity<>(carDetails, HttpStatus.OK);
	}
	
	@GetMapping("/getIncentive/{id}")
	public ResponseEntity<IncentivesDetails> getIncentive(@PathVariable("id") int id) {
		CarDetails carDetails = service.getCar(id+1);

	IncentivesDetails incentive = service.getIncentive(id);
		return new ResponseEntity<>(incentive, HttpStatus.OK);
	}


	/**
	 * @param id takes dealer id as parameter
	 * @return dealer details for entered parameter
	 */
	@GetMapping("/getDealer/{id}")
	public ResponseEntity<CarDealer> getDealer(@PathVariable("id") int id) {

		CarDealer dealerDetails = service.getDealer(id);
		if (dealerDetails == null) {
			logger.error("No dealer Present with given id");
			throw new DetailNotFoundException("No Dealer present with the given id: " + id);
		}
		return new ResponseEntity<>(dealerDetails, HttpStatus.OK);
	}

	/**
	 * @param id takes customer id as parameter
	 * @return customer details for entered parameter
	 */
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<CustomerDetails> getCustomer(@PathVariable("id") int id) {

		CustomerDetails customerDetails = service.getCustomer(id);
		if (customerDetails == null) {
			logger.error("No customer Present with given id");
			throw new DetailNotFoundException("No Customer present with the given id: " + id);
		}
		return new ResponseEntity<>(customerDetails, HttpStatus.OK);
	}

	/**
	 * @return shows all the customer details
	 */
	@GetMapping("/getAllCustomerDetails")
	public ResponseEntity<List<CustomerDetails>> getAllCustomerDetails() {
		List<CustomerDetails> customerDetails = service.getAllCustomerDetails();
		return new ResponseEntity<>(customerDetails, HttpStatus.OK);
	}

	/**
	 * @param carDetails takes car details as parameter to update the car details
	 * @return updated car details
	 */
	@PutMapping("/updateCarDetails/{id}")
	public ResponseEntity<CarDetails> updateCarDetails(@PathVariable int id, @RequestBody CarDetails carDetails) {
		carDetails.setId(id);
		System.out.println(carDetails);
		CarDetails carInfo = service.updateCarDetails(carDetails);
		return new ResponseEntity<>(carInfo, HttpStatus.OK);
	}
	@PutMapping("/updateDealerDetails")
	public ResponseEntity<CarDealer> updateDealerDetails(@RequestBody CarDealer dealerDetails) {
		CarDealer dealerInfo = service.updateDealerDetails(dealerDetails);
		return new ResponseEntity<>(dealerInfo, HttpStatus.OK);
	}
	@PutMapping("/updateCustomerDetails")
	public ResponseEntity<CustomerDetails> updateCustomerDetails(@RequestBody CustomerDetails customerDetails) {
		CustomerDetails customerInfo = service.updateCustomerDetails(customerDetails);
		return new ResponseEntity<>(customerInfo, HttpStatus.OK);
	}


	/**
	 * @param id takes car id as parameter which is to be deleted
	 * @return deleted car details
	 */
	@DeleteMapping("/deleteCar/{id}")
	public ResponseEntity<List<CarDetails>> deleteCar(@PathVariable int id) {
		List<CarDetails> car = service.deleteCar(id);
		return new ResponseEntity<>(car, HttpStatus.OK);
	}
	@GetMapping("/getAllCars")
	public ResponseEntity<List<CarDetails>> getCars() {
		List<CarDetails> cars = service.getAllCars();
		return new ResponseEntity<List<CarDetails>>(cars, HttpStatus.OK);
	}
	@GetMapping("/getAllDealers")
	public ResponseEntity<List<CarDealer>> getDealers() {
		List<CarDealer> cars = service.getAllDealers();
		return new ResponseEntity<List<CarDealer>>(cars, HttpStatus.OK);
	}
	

}
