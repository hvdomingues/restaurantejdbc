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

@Entity
@Table(name = "orderitem")
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderItemID")
	private Integer id;
	
	@Column(name = "Quantity")
	private Integer quantity;
	
	@Column(name = "ItemPrice")
	private Double itemPrice;
	
	@ManyToOne
	@JoinColumn(name = "OrderID")
	private Order order;
	
	@OneToOne
	@JoinColumn(name = "ProductID")
	private Product product;

	
	public OrderItem() {	
	}
	
	public OrderItem(Integer id, Integer quantity, Order order, Product product) {
		this.id = id;
		this.quantity = quantity;
		this.order = order;
		this.product = product;
		this.itemPrice = product.getPrice();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice() {
		this.itemPrice = this.product.getPrice();
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
	
	public Double totalPrice() {
		return itemPrice * quantity;
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
		return "OrderItem [id=" + id + ", quantity=" + quantity + ", itemPrice=" + itemPrice + ", order=" + order
				+ ", product=" + product + "]";
	}
	
	
	
	

}
