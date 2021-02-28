/**
 * 
 */
package com.isfc.view.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isfc.view.IncentiveSystemApplication;
import com.isfc.view.model.CustomerDetails;

import junit.framework.Assert;

/**
 * @author Priyanka Jawade
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = IncentiveSystemApplication.class)
@SuppressWarnings("deprecation")
class CustomerRepositoryTest {
	CustomerDetails c = new CustomerDetails();
	@Autowired
	private CustomerRepository crepo;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before Execution ");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After Execution");
	}

	@Test
	void testGetCustByName() {
		CustomerDetails c = crepo.getCustByName("RAM");
		Assert.assertEquals("deshmukh", c.getlName());

	}

	@Test
	void testGetCustByFName() {
		CustomerDetails c = crepo.getCustByName("RAM");
		Assert.assertEquals("SHARMA", c.getlName());

	}

}
