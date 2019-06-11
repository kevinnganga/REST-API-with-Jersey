package com.myRootPackage.ExceptionsHandling;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	// highlight on the class name and select "add generated serial version ID"
	private static final long serialVersionUID = 3427426592695164409L;
	
	//create a constructor that takes message as an argument
	
	public DataNotFoundException(String message) {
		
		super(message);
		
	}

}
