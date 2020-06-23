package com.hvdomingues.DinnerApp.services.exceptions;

public class MyException2 extends RuntimeException{
	private static final long serialVersionUID = 1302158997535306808L;

	private String eMessage;
	
	
	
	public MyException2(String eMessage) {
		super();
		this.eMessage = eMessage;
	}



	public String getMessage() {
		return eMessage;
	}
	

}
