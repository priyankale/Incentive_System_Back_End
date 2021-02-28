/**
 * 
 */
package com.isfc.view.service;

/**
 * @author Priyanka Jawade
 *
 */
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.isfc.view.model.CarCompany;
import com.isfc.view.model.CarDealer;
import com.isfc.view.model.CarDetails;
import com.isfc.view.model.CustomerDetails;
import com.isfc.view.repository.CarCompanyRepository;
import com.isfc.view.repository.CarDealerRepository;
import com.isfc.view.repository.CarDetailsRepository;
import com.isfc.view.repository.CustomerRepository;
import com.isfc.view.repository.IncentiveRepository;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
class CarDealerServiceTest {
	@Autowired
	CarDealerService service;
	@MockBean
	CarDealerRepository repo;
	@MockBean
	CustomerRepository crepo;
	@MockBean
	CarCompanyRepository companyrepo;
	@MockBean
	CarDetailsRepository carrepo;
	@MockBean
	IncentiveRepository irepo;
	/*
	 * @Before public void init() { MockitoAnnotations.initMocks(this); }
	 */

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.isfc.view.service.CarDealerService#addDealerDetails(com.isfc.view.model.CarDealer)}.
	 */
	@Test
	void testAddDealerDetails() {
		CarDealer dealer = new CarDealer();
		dealer.setCity("Chandrapur");
		dealer.setfName("Ram");
		dealer.setId(1);
		dealer.setlName("Sharma");
		dealer.setMail("sharma@gmail.com");
		dealer.setNo(8007477060L);
		Mockito.when(repo.save(Mockito.any(CarDealer.class))).thenReturn(dealer);
		CarDealer i = service.addDealerDetails(dealer);
		assertNotNull(service.addDealerDetails(i), "SUCCESS");
	}

	/**
	 * Test method for
	 * {@link com.isfc.view.service.CarDealerService#addCustomerDetails(com.isfc.view.model.CustomerDetails)}.
	 */
	@Test
	void testAddCustomerDetails() {
		CustomerDetails customer = new CustomerDetails();
		customer.setCity("Nagpur");
		customer.setfName("Sansruti");
		customer.setId(1);
		customer.setlName("Deshmukh");
		customer.setMail("deshmukh@gmail.com");
		customer.setNo(8006574412L);

		Mockito.when(crepo.save(Mockito.any(CustomerDetails.class))).thenReturn(customer);
		CustomerDetails i = service.addCustomerDetails(customer);
		assertNotNull(service.addCustomerDetails(i), "SUCCESS");

	}

	/**
	 * Test method for
	 * {@link com.isfc.view.service.CarDealerService#addCompanyDetails(com.isfc.view.model.CarCompany)}.
	 */
//	@Test
//	void testAddCompanyDetails() {
//		CarCompany company = new CarCompany();
//		company.setcMail("Hyundai@gmail.com");
//		company.setcName("Hyundai");
//		company.setId(1);
//
//		Mockito.when(companyrepo.save(Mockito.any(CarCompany.class))).thenReturn(company);
//		CarCompany i = cservice.addCompanyDetails(company);
//		assertNotNull(cservice.addCompanyDetails(i), "SUCCESS");
//	}

	/**
	 * Test method for
	 * {@link com.isfc.view.service.CarDealerService#addCarDetails(com.isfc.view.model.CarDetails)}.
	 * 
	 * @param carDetails
	 * @throws ParseException
	 */
	@Test
	void testAddCarDetails() throws ParseException {
		CarDetails cardetails = new CarDetails();

		cardetails.setbName("Hyundai");
		cardetails.setBookingDate("12-01-21");
		cardetails.setColor("Black");
		cardetails.setId(1);
		cardetails.setIncentives(null);
		cardetails.setmName("i10");
		cardetails.setPrice(8000000);
		Mockito.when(carrepo.save(Mockito.any(CarDetails.class))).thenReturn(cardetails);
		CarDetails i = service.addCarDetails(cardetails);
		assertNotNull(service.addCarDetails(i), "SUCCESS");
		assertNotNull(irepo);
	}

	/**
	 * Test method for {@link com.isfc.view.service.CarDealerService#getCar(int)}.
	 */
	@Test
	void testGetCar() {
		CarDetails cardetails = new CarDetails();

		cardetails.setbName("Hyundai");
		cardetails.setBookingDate("12-01-21");
		cardetails.setColor("Black");
		cardetails.setId(1);
		cardetails.setIncentives(null);
		cardetails.setmName("i10");
		cardetails.setPrice(8000000);
		Mockito.when(carrepo.findById(Mockito.anyInt())).thenReturn(Optional.of(cardetails));
		CarDetails d = service.getCar(1);
		Assert.assertEquals(d.getbName(), cardetails.getbName());
	}

	/**
	 * Test method for
	 * {@link com.isfc.view.service.CarDealerService#getDealer(int)}.
	 */
	@Test
	void testGetDealer() {
		CarDealer carDealer = new CarDealer();
		carDealer.setId(1);
		carDealer.setCity("hhh");
		carDealer.setfName("sanskruti");
		carDealer.setlName("deshmukh");
		carDealer.setMail("vgd");
		carDealer.setNo(895669L);

		Mockito.when(repo.findById(Mockito.anyInt())).thenReturn(Optional.of(carDealer));
		CarDealer d = service.getDealer(1);
		Assert.assertEquals(d.getfName(), carDealer.getfName());
	}

	/**
	 * Test method for
	 * {@link com.isfc.view.service.CarDealerService#getCustomer(int)}.
	 */
	@Test
	void testGetCustomer() {
		CustomerDetails customer = new CustomerDetails();
		customer.setId(1);
		customer.setCity("hhh");
		customer.setfName("sanskruti");
		customer.setlName("deshmukh");
		customer.setMail("vgd");
		customer.setNo(88596966L);

		Mockito.when(crepo.findById(Mockito.anyInt())).thenReturn(Optional.of(customer));
		CustomerDetails c = service.getCustomer(1);
		Assert.assertEquals(c.getfName(), customer.getfName());
	}

	/**
	 * Test method for
	 * {@link com.isfc.view.service.CarDealerService#updateCarDetails(com.isfc.view.model.CarDetails)}.
	 */
	@Test
	void testUpdateCarDetails() {
		CarDetails cardetails = new CarDetails();
		cardetails.setbName("Hyundai");
		cardetails.setBookingDate("12-01-21");
		cardetails.setColor("Black");
		cardetails.setId(1);
		cardetails.setIncentives(null);
		cardetails.setmName("i10");
		cardetails.setPrice(8000000);
		Mockito.when(carrepo.save(Mockito.any(CarDetails.class))).thenReturn(cardetails);
		CarDetails d = service.updateCarDetails(cardetails);
		assertNotNull(d);

	}

	/**
	 * Test method for
	 * {@link com.isfc.view.service.CarDealerService#deleteCar(int)}.
	 */
	@Test
	void testDeleteCar() {
		CarDetails cardetails = new CarDetails();
		cardetails.setId(2);
		Mockito.when(carrepo.existsById(2)).thenReturn(true);
		List<CarDetails> c = service.deleteCar(2);
		assertNull(c);

	}

}