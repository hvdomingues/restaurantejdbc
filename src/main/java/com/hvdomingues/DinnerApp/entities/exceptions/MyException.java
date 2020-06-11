package com.hvdomingues.DinnerApp.entities.exceptions;

//Descobrir como organizar as exceções.
public class MyException extends Exception{
	private static final long serialVersionUID = 1302158997535306808L;

	private String eMessage;
	
	
	
	public MyException(String eMessage) {
		super();
		this.eMessage = eMessage;
	}



	public String getMessage() {
		return eMessage;
	}
	

}
