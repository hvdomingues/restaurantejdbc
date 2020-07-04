package com.hvdomingues.DinnerApp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hvdomingues.DinnerApp.entities.enums.OrderItemStatus;

@Entity
@Table(name = "orderitem")
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderItemID")
	private Integer id;
	
	
	@Column(name = "Observation")
	private String observation;
	
	@Column(name = "ItemPrice")
	private Double itemPrice;
	
	@Column(name = "Status")
	private Integer status;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "OrderID")
	private Order order;
	
	@OneToOne
	@JoinColumn(name = "ProductID")
	private Product product;

	
	public OrderItem() {	
	}
	
	public OrderItem(Order order, Product product, String observation) {
		this.order = order;
		this.product = product;
		this.itemPrice = product.getPrice();
		this.observation = observation;
		setStatus(OrderItemStatus.SENT);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice() {
		this.itemPrice = this.product.getPrice();
	}

	public String getStatus() {
		return OrderItemStatus.valueOf(status).getDescripton();
	}

	public void setStatus(OrderItemStatus orderItemStatus) {
		if(orderItemStatus != null) {
			this.status = orderItemStatus.getCode();
		}
		
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", observation=" + observation + ", itemPrice=" + itemPrice + ", order=" + order
				+ ", product=" + product + "]";
	}
	
	
	
	

}
