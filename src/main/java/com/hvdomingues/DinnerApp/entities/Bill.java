package com.hvdomingues.DinnerApp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "bills")
public class Bill implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BillID", unique = true)
	private Integer id;
	
	@Column(name = "TableNumber", nullable = false)
	private Integer tableNumber;
	
	@Column(name = "StatusBill", nullable = false)
	private Integer statusBill;
	
	@JsonIgnore
	@OneToMany(mappedBy = "bill", fetch = FetchType.EAGER)
	private List<IndividualBill> individualBills;
	

	
	public Bill() {
		this.statusBill = 0;
	}
	
	
	public Bill(Integer tableNumber) {
		this.tableNumber = tableNumber;
		this.statusBill = 0;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(Integer tableNumber) {
		this.tableNumber = tableNumber;
	}

	public int getStatusBill() {
		return statusBill;
	}

	public void setStatusBill(int statusBill) {
		this.statusBill = statusBill;
	}
	
	
	

	public void setIndividualBills(List<IndividualBill> individualBills) {
		this.individualBills = individualBills;
	}




	public List<IndividualBill> getIndividualBills() {
		return individualBills;
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
		Bill other = (Bill) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Bill [id=" + id + ", tableNumber=" + tableNumber + ", statusBill=" + statusBill + ", individualBills="
				+ individualBills + "]";
	}

	





	
	

}
