package com.hvdomingues.DinnerApp.entities;

import java.io.Serializable;
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
	@JoinColumn(name = "BillID", nullable = false)
	private Bill bill;
	
	@OneToMany(mappedBy = "indBill")
	private List<Order> orders;
	
	@Column(name = "StatusBill")
	private Integer statusBill;
	
	@Column(name = "TotalPaid")
	private Double totalPaid;
	
	@Column(name = "TipPaid")
	private Double tipPaid;
	
	public IndividualBill() {
		this.statusBill = 0;
	}
	
	public IndividualBill(Bill bill, String observation, int tabPosition) {
		this.bill = bill;
		this.observation = observation;
		this.tabPosition = tabPosition;
		this.statusBill = 0;
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
	

	public List<Order> getOrders() {
		return orders;
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}
	
	

	public Integer getStatusBill() {
		return statusBill;
	}

	public void setStatusBill(Integer statusBill) {
		this.statusBill = statusBill;
	}

	public Double getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(Double totalPaid) {
		this.totalPaid = totalPaid;
	}

	public Double getTipPaid() {
		return tipPaid;
	}

	//Recebe o valor total da conta individual, recebido no Service e calcula com base no valor total pago da conta individual a gorjeta paga.
	public void setTipPaid(Double totalValue) {
		this.tipPaid = this.totalPaid - totalValue;
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
