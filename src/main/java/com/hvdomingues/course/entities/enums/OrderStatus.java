package com.hvdomingues.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1, "Waiting Payment"),
	PAID(2, "Paid"),
	SHIPPED(3, "Shipped"),
	DELIVERED(4, "Delivered"),
	CANCELED(5, "Canceled");
	
	private int code;
	
	private String descripton;
	
	public String getDescripton() {
		return descripton;
	}

	private OrderStatus(int code, String descriptionParam) {
		this.code = code;
		this.descripton = descriptionParam;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		} 
		
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
}
