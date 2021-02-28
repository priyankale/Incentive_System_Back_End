package com.isfc.view.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.isfc.view.model.CarDealer;
import com.isfc.view.model.CarDetails;
import com.isfc.view.model.CustomerDetails;
import com.isfc.view.model.IncentivesDetails;
import com.isfc.view.repository.CarCompanyRepository;
import com.isfc.view.repository.CarDealerRepository;
import com.isfc.view.repository.CarDetailsRepository;
import com.isfc.view.repository.CustomerRepository;
import com.isfc.view.repository.IncentiveRepository;

/**
 * CAR DEALER SERVICE CLASS
 * 
 * This class provides logic to add,view,update,delete details
 * 
 * @author Priyanka Jawade
 *
 */
@Service
@Transactional
public class CarDealerService implements CarDealerServiceInterface {
	Logger logger = LoggerFactory.getLogger(CarDealerService.class);

	@Autowired
	CarDealerRepository dealerRepository;
	@Autowired
	CarDetailsRepository carRepository;
	@Autowired
	CarCompanyRepository companyRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	IncentiveRepository incentiveRepository;

	@Override
	public CarDealer addDealerDetails(CarDealer cardealer) {

		logger.info(null);
		return dealerRepository.save(cardealer);
	}

	@Override
	public CustomerDetails addCustomerDetails(CustomerDetails customerdetails) {
		return customerRepository.save(customerdetails);
	}

	

	/**
	 * Method to add car details and adding incentives which are applicable for
	 * particular booking date and adding deal details
	 */
	@Override
	public CarDetails addCarDetails(CarDetails cardetails) throws ParseException {
		IncentivesDetails incentivesDetails = new IncentivesDetails();
		String bookingDate = cardetails.getBookingDate();
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		Date bDate = formatter1.parse(bookingDate);
		String date = "2020-12-31";
		incentivesDetails.setBookingDate(cardetails);

		try {
			Date newDate = formatter1.parse(date);
			if (bDate.before(newDate)) {
				incentivesDetails.setAccessories("Accessories will be provided");
				incentivesDetails.setInsurance("Insurance will be provided");
				incentivesDetails.setWarranty(2);
				incentivesDetails.setPrice(10);
			} else {
				incentivesDetails.setAccessories("Accessories won't be provided");
				incentivesDetails.setInsurance("Insurance won't be provided");
				incentivesDetails.setWarranty(1);
				incentivesDetails.setPrice(5);

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		incentiveRepository.save(incentivesDetails);

		return carRepository.save(cardetails);
	}

	/**
	 * Method to get car details for particular id
	 */
	@Override
	public CarDetails getCar(int id) {
		return carRepository.findById(id).orElse(null);
	}

	/**
	 * Method to view dealer details for particular id
	 */
	@Override
	public CarDealer getDealer(int id) {
		return dealerRepository.findById(id).orElse(null);
	}

	/**
	 * Method to view customer details for particular id
	 */
	@Override
	public CustomerDetails getCustomer(int id) {
		return customerRepository.findById(id).orElse(null);
	}

	/**
	 * Method to update car details
	 */
	@Override
	public CarDetails updateCarDetails(CarDetails cardetails) {
		return carRepository.save(cardetails);
	}

	/**
	 * Method to delete car details of particular car id
	 */
	@Override
	public List<CarDetails> deleteCar(int id) {
		carRepository.deleteById(id);
		return carRepository.findAll();
	}

	/**
	 * Method to get all the customer details
	 */
	@Override
	public List<CustomerDetails> getAllCustomerDetails() {
		return customerRepository.findAll();
	}

	@Override
	public List<CarDetails> getAllCars() {

		return carRepository.findAll();
	}

	@Override
	public List<CarDealer> getAllDealers() {

		return dealerRepository.findAll();
	}

	@Override
	public CarDealer updateDealerDetails(CarDealer dealerDetails) {
		return dealerRepository.save(dealerDetails);
	}

	@Override
	public CustomerDetails updateCustomerDetails(CustomerDetails customerDetails) {
		return customerRepository.save(customerDetails);
	}

	@Override
	public IncentivesDetails getIncentive(int id) {
		//int id=carDetails.getId();
		return incentiveRepository.findById(id).orElse(null);
	}


	
}