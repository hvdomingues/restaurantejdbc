package com.hvdomingues.DinnerApp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "individualbills")
public class IndividualBill implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IndividualBillID", unique = true)
	private Integer id;
	
	@Column(name = "Observation", nullable = true)
	private String observation;
	
	@Column(name = "TabPosition", nullable = false)
	private Integer tabPosition;
	
	
	@ManyToOne
	@JoinColumn(name = "BillID")
	private Bill bill;
	
	
	
	public IndividualBill() {}
	
	public IndividualBill(Bill bill, String observation, int tabPosition) {
		this.bill = bill;
		this.observation = observation;
		this.tabPosition = tabPosition;
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

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	
	public Integer getTabPosition() {
		return tabPosition;
	}

	public void setTabPosition(Integer tabPosition) {
		this.tabPosition = tabPosition;
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bill == null) ? 0 : bill.hashCode());
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
		IndividualBill other = (IndividualBill) obj;
		if (bill == null) {
			if (other.bill != null)
				return false;
		} else if (!bill.equals(other.bill))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IndividualBill [id=" + id + ", observation=" + observation + ", tabPosition=" + tabPosition + ", bill="
				+ bill.getId() + "]";
	}

	
	
	
	
	
	

	
	
}
