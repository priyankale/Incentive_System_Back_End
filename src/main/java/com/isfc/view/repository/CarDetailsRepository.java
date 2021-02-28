package com.isfc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isfc.view.model.CarDetails;
/**
 * Repository for Car Details
 * @author Priyanka Jawade
 *
 */
@Repository
public interface CarDetailsRepository extends JpaRepository<CarDetails, Integer> {


}
