package com.hvdomingues.DinnerApp.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.entities.Payment;

@Embeddable
public class BillPaymentPK implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name  = "IndividualBillID")
	private IndividualBill individualBill;
	
	@ManyToOne
	@JoinColumn(name = "PaymentID")
	private Payment payment;


	public IndividualBill getIndividualBill() {
		return individualBill;
	}

	public void setIndividualBill(IndividualBill individualBill) {
		this.individualBill = individualBill;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((individualBill == null) ? 0 : individualBill.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
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
		BillPaymentPK other = (BillPaymentPK) obj;
		if (individualBill == null) {
			if (other.individualBill != null)
				return false;
		} else if (!individualBill.equals(other.individualBill))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		return true;
	}
	
	
}
