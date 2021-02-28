package com.isfc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isfc.view.model.CarCompany;

/**
 * Repository for Car Company
 * @author Priyanka Jawade
 *
 */
@Repository
public interface CarCompanyRepository extends JpaRepository<CarCompany, Integer> {

}
