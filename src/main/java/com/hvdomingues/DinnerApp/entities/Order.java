package com.hvdomingues.DinnerApp.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderID")
	private Integer id;
	
	@Column(name = "Moment")
	private Instant moment;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "IndividualBillID")
	IndividualBill indBill;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItem;
	
	
	public Order() {
	}
	
	public Order(Instant moment, IndividualBill indBill) {
		this.moment = moment;
		this.indBill = indBill;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public IndividualBill getIndBill() {
		return indBill;
	}

	public void setIndBill(IndividualBill indBill) {
		this.indBill = indBill;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", moment=" + moment + ", indBill=" + indBill + "]";
	}
	
	
}
