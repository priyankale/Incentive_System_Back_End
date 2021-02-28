package com.isfc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isfc.view.model.CarDetails;
import com.isfc.view.model.IncentivesDetails;

/**
 * Repository for Incentive
 * @author Priyanka Jawade
 *
 */
@Repository
public interface IncentiveRepository extends JpaRepository<IncentivesDetails, Integer> {

	//IncentivesDetails findByBookingDate(CarDetails bookingDate);

	//IncentivesDetails findByBookingDate(int id);

	//IncentivesDetails findByBookingDate(CarDetails bookingDate);

}
