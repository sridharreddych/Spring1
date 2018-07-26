package com.hcl.movie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="offer")
public class Offer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="offer_id")
	private Integer offerId;
	
	@Column(name="monthly_saving")
	private Double monthlySaving;
	
	@Column(name="loan_amount")
	private Integer loanAmount;
	
	@Column(name="rate_of_interest")
	private Integer rateOfInterest;
	
	@Column(name="tenure")
	private Integer tenure;
	
	@Column(name="monthly_emi")
	private Integer monthlyEMI;

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public Double getMonthlySaving() {
		return monthlySaving;
	}

	public void setMonthlySaving(Double monthlySaving) {
		this.monthlySaving = monthlySaving;
	}

	public Integer getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Integer rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public Integer getMonthlyEMI() {
		return monthlyEMI;
	}

	public void setMonthlyEMI(Integer monthlyEMI) {
		this.monthlyEMI = monthlyEMI;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loanAmount == null) ? 0 : loanAmount.hashCode());
		result = prime * result + ((monthlyEMI == null) ? 0 : monthlyEMI.hashCode());
		result = prime * result + ((monthlySaving == null) ? 0 : monthlySaving.hashCode());
		result = prime * result + ((offerId == null) ? 0 : offerId.hashCode());
		result = prime * result + ((rateOfInterest == null) ? 0 : rateOfInterest.hashCode());
		result = prime * result + ((tenure == null) ? 0 : tenure.hashCode());
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
		Offer other = (Offer) obj;
		if (loanAmount == null) {
			if (other.loanAmount != null)
				return false;
		} else if (!loanAmount.equals(other.loanAmount))
			return false;
		if (monthlyEMI == null) {
			if (other.monthlyEMI != null)
				return false;
		} else if (!monthlyEMI.equals(other.monthlyEMI))
			return false;
		if (monthlySaving == null) {
			if (other.monthlySaving != null)
				return false;
		} else if (!monthlySaving.equals(other.monthlySaving))
			return false;
		if (offerId == null) {
			if (other.offerId != null)
				return false;
		} else if (!offerId.equals(other.offerId))
			return false;
		if (rateOfInterest == null) {
			if (other.rateOfInterest != null)
				return false;
		} else if (!rateOfInterest.equals(other.rateOfInterest))
			return false;
		if (tenure == null) {
			if (other.tenure != null)
				return false;
		} else if (!tenure.equals(other.tenure))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", monthlySaving=" + monthlySaving + ", loanAmount=" + loanAmount
				+ ", rateOfInterest=" + rateOfInterest + ", tenure=" + tenure + ", monthlyEMI=" + monthlyEMI
				+ ", getOfferId()=" + getOfferId() + ", getMonthlySaving()=" + getMonthlySaving() + ", getLoanAmount()="
				+ getLoanAmount() + ", getRateOfInterest()=" + getRateOfInterest() + ", getTenure()=" + getTenure()
				+ ", getMonthlyEMI()=" + getMonthlyEMI() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}

	public Offer(Integer offerId, Double monthlySaving, Integer loanAmount, Integer rateOfInterest, Integer tenure,
			Integer monthlyEMI) {
		super();
		this.offerId = offerId;
		this.monthlySaving = monthlySaving;
		this.loanAmount = loanAmount;
		this.rateOfInterest = rateOfInterest;
		this.tenure = tenure;
		this.monthlyEMI = monthlyEMI;
	}

	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
