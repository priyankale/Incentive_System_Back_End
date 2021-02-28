package com.isfc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isfc.view.model.CarDealer;

/**
 * Repository for car dealer 
 * @author Priyanka Jawade
 *
 */
@Repository
public interface CarDealerRepository extends JpaRepository<CarDealer, Integer> {

}
