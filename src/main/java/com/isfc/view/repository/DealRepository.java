package com.isfc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isfc.view.model.DealDetails;
/**
 * Repository for deal 
 * @author Priyanka Jawade
 *
 */
@Repository
public interface DealRepository extends JpaRepository<DealDetails, Integer>{

}
