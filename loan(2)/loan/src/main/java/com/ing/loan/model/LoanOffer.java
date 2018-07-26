package com.ing.loan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loan_offers")
public class LoanOffer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="offer_id")
	private Integer loanOfferId;
	
	@Column(name="roi")
	private Double rateOfInterest;
	
	@Column(name="loan_amt")
	private Double loanAmount;
	
	@Column(name="emi")
	private Double emi;
	
	@Column(name="tenure")
	private Integer tenure;
	
	@Column(name="min_sal_eligibility")
	private Double minimumSalaryEligibity;
	
	
	
	public Integer getLoanOfferId() {
		return loanOfferId;
	}
	public void setLoanOfferId(Integer loanOfferId) {
		this.loanOfferId = loanOfferId;
	}
	public Double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Double getEmi() {
		return emi;
	}
	public void setEmi(Double emi) {
		this.emi = emi;
	}
	public Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	public Double getMinimumSalaryEligibity() {
		return minimumSalaryEligibity;
	}
	public void setMinimumSalaryEligibity(Double minimumSalaryEligibity) {
		this.minimumSalaryEligibity = minimumSalaryEligibity;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanOffer [loanOfferId=");
		builder.append(loanOfferId);
		builder.append(", rateOfInterest=");
		builder.append(rateOfInterest);
		builder.append(", loanAmount=");
		builder.append(loanAmount);
		builder.append(", emi=");
		builder.append(emi);
		builder.append(", tenure=");
		builder.append(tenure);
		builder.append(", minimumSalaryEligibity=");
		builder.append(minimumSalaryEligibity);
		builder.append("]");
		return builder.toString();
	}
}
