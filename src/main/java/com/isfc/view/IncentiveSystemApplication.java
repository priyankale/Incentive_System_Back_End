package com.isfc.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main class for the application.
 * 
 * @author Priyanka Jawade
 *
 */
@SpringBootApplication
public class IncentiveSystemApplication {
	Logger logger = LoggerFactory.getLogger(IncentiveSystemApplication.class);

	/**
	 * This is the main method to launch the application
	 * @param args takes String 
	 */
	public static void main(String[] args) {
		SpringApplication.run(IncentiveSystemApplication.class, args);
	}

}
