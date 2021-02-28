package com.isfc.view.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isfc.view.model.CarCompany;
import com.isfc.view.model.CarDealer;
import com.isfc.view.model.CarDetails;
import com.isfc.view.model.DealDetails;
import com.isfc.view.model.IncentivesDetails;
import com.isfc.view.repository.CarCompanyRepository;
import com.isfc.view.repository.CarDetailsRepository;
import com.isfc.view.repository.DealRepository;
import com.isfc.view.repository.IncentiveRepository;

/**
 * CAR COMPANY SERVICE CLASS
 * 
 * This class provide the logic to add the incentive details applicable for the
 * car based on particular booking date ,also to get the details of the car
 * 
 * @author Priyanka Jawade
 *
 */
@Service
@Transactional

public class CarCompanyService implements CarCompanyServiceInterface {

	@Autowired
	CarDetailsRepository carRepository;
	@Autowired
	IncentiveRepository incentiveRepository;
	@Autowired
	CarCompanyRepository companyRepository;
	@Autowired
	DealRepository dealRepository;

	/**
	 * This method allows to insert company details entered by admin
	 */
	@Override
	public CarCompany addCompanyDetail(CarCompany companyDetails) {
		return companyRepository.save(companyDetails);
	}

	/**
	 * This method allows to insert car details,incentive details,and deal details
	 */
	@Override
	public CarDetails addCarDetails(CarDetails cardetails) throws ParseException {
		IncentivesDetails incentivesDetails = new IncentivesDetails();
		DealDetails dealDetails = new DealDetails();
		String bookingDate = cardetails.getBookingDate();
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		Date bDate = formatter1.parse(bookingDate);
		String date = "2020-12-31";
		incentivesDetails.setBookingDate(cardetails);
		String status;
		try {
			Date newDate = formatter1.parse(date);
			if (bDate.before(newDate)) {
				status = "approved";
				incentivesDetails.setAccessories("Accessories will be provided");
				incentivesDetails.setInsurance("Insurance will be provided");
				incentivesDetails.setWarranty(2);
				incentivesDetails.setPrice(10);
				dealDetails.setApproved(status);
				dealDetails.setIncentivesDetails(incentivesDetails);
			} else {
				status = "reject";
				incentivesDetails.setAccessories("Accessories won't be provided");
				incentivesDetails.setInsurance("Insurance won't be provided");
				incentivesDetails.setWarranty(1);
				incentivesDetails.setPrice(5);
				dealDetails.setApproved(status);
				dealDetails.setIncentivesDetails(incentivesDetails);

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		incentiveRepository.save(incentivesDetails);
		dealRepository.save(dealDetails);

		return carRepository.save(cardetails);
	}

	/**
	 * This method allows to view the car details based on given id
	 */


	@Override

	public CarDetails viewCar(int id) {
		return carRepository.findById(id).orElse(null);
	}

	@Override
	public CarCompany getCompanys(int id) {

		return companyRepository.findById(id).orElse(null);
	}

	@Override
	public List<CarCompany> getAllCompanys() {

		return companyRepository.findAll();
	}

	@Override
	public CarCompany updateCompanyDetails(CarCompany companyDetails) {
		
		return companyRepository.save(companyDetails);
}

	@Override
	public List<CarDetails> getAllCars() {

		return carRepository.findAll();
	}
	
	@Override
	public CarDetails updateCar(CarDetails cardetails) {
		return carRepository.save(cardetails);
	}

}