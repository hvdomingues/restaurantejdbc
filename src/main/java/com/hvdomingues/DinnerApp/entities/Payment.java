package com.hvdomingues.DinnerApp.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PaymentID", unique = true)
	private Integer id;
	
	@Column(name = "PaymentMoment")
	private Instant payMoment;
	//criar getters e setters
	@Column(name = "PaymentValue", nullable = true)
	private Double payValue;
	
	public Payment() {	
	}

	public Payment(Integer id, Instant payMoment, Double payValue) {
		this.id = id;
		this.payMoment = payMoment;
		this.payValue = payValue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getPayMoment() {
		return payMoment;
	}

	public void setPayMoment(Instant payMoment) {
		this.payMoment = payMoment;
	}

	
	
	public Double getPayValue() {
		return payValue;
	}

	public void setPayValue(Double payValue) {
		this.payValue = payValue;
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
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", payMoment=" + payMoment + ", payValue=" + payValue + "]";
	}
	
	
	
	
}
