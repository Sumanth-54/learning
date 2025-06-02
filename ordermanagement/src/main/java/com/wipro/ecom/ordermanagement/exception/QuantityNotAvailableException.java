package com.wipro.ecom.ordermanagement.exception;

public class QuantityNotAvailableException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuantityNotAvailableException(String message) {
        super(message);
    }
}
