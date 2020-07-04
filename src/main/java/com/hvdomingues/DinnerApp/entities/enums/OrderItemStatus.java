package com.hvdomingues.DinnerApp.entities.enums;

public enum OrderItemStatus {
	
	NULO(0,"Não foi settado"),
	SENT(1, "Enviado a cozinha"),
	PREPARING(2, "Sendo preparado"),
	DELIVERED(3, "Item entregue"),
	DEVOLVIDO(4, "Item devolvido");
	
	private int code;
	
	private String descripton;
	
	public String getDescripton() {
		return descripton;
	}

	private OrderItemStatus(int code, String descriptionParam) {
		this.code = code;
		this.descripton = descriptionParam;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderItemStatus valueOf(int code) {
		for(OrderItemStatus value : OrderItemStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		} 
		
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
}
