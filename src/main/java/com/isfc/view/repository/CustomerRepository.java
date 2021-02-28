package com.isfc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isfc.view.model.CustomerDetails;


/**
 * Repository for customer 
 * @author Priyanka Jawade
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Integer>{
	@Query("SELECT c FROM CustomerDetails c where c.fName=:fName")
	CustomerDetails getCustByName(String fName);

}
