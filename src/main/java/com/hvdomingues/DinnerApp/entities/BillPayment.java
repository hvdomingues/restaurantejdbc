package com.hvdomingues.DinnerApp.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.hvdomingues.DinnerApp.entities.pk.BillPaymentPK;

@Entity
@Table(name = "billpayment")
public class BillPayment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private BillPaymentPK id = new BillPaymentPK();
	
	public BillPayment() {
	}
	
	public BillPayment(Payment payment, IndividualBill indBill) {
		id.setIndividualBill(indBill);
		id.setPayment(payment);	
	}

	public Payment getPayment() {
		return id.getPayment();
	}
	
	public void setPayment(Payment payment) {
		id.setPayment(payment);
	}
	
	public IndividualBill getIndBill() {
		return id.getIndividualBill();
	}
	
	public void setIndBill(IndividualBill indBill) {
		id.setIndividualBill(indBill);
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
		BillPayment other = (BillPayment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
