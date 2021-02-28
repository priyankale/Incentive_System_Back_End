package com.isfc.view.exceptions;

/**
 * DetailNotFoundException
 * 
 * This is customized exception it is thrown when there are no details 
 * 
 * @author Priyanka Jawade
 *
 */
@SuppressWarnings("serial")
public class DetailNotFoundException extends RuntimeException {
	public DetailNotFoundException() {
	}

	/**
	 * @param message takes parameter as message
	 */
	public DetailNotFoundException(String message) {
		super(message);
	}

}
