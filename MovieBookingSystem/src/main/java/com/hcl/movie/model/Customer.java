package com.hcl.movie.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="mobile_number")
	private Long mobile;
	
	@Column(name="employement_type")
	private String empType;
	
	@Column(name="total_monthly_income")
	private Long totalMonthlyIncome;
	
	@Column(name="total_monthly_expenditure")
	private Long totalMonthlyExpendeture;
	
	@Column(name="monthly_saving")
	private Double monthlySaving;
	
	@Column(name="mail_id")
	private String mailId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public Long getTotalMonthlyIncome() {
		return totalMonthlyIncome;
	}

	public void setTotalMonthlyIncome(Long totalMonthlyIncome) {
		this.totalMonthlyIncome = totalMonthlyIncome;
	}

	public Long getTotalMonthlyExpendeture() {
		return totalMonthlyExpendeture;
	}

	public void setTotalMonthlyExpendeture(Long totalMonthlyExpendeture) {
		this.totalMonthlyExpendeture = totalMonthlyExpendeture;
	}

	public Double getMonthlySaving() {
		return monthlySaving;
	}

	public void setMonthlySaving(Double monthlySaving) {
		this.monthlySaving = monthlySaving;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((empType == null) ? 0 : empType.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mailId == null) ? 0 : mailId.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((monthlySaving == null) ? 0 : monthlySaving.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((totalMonthlyExpendeture == null) ? 0 : totalMonthlyExpendeture.hashCode());
		result = prime * result + ((totalMonthlyIncome == null) ? 0 : totalMonthlyIncome.hashCode());
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
		Customer other = (Customer) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (empType == null) {
			if (other.empType != null)
				return false;
		} else if (!empType.equals(other.empType))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mailId == null) {
			if (other.mailId != null)
				return false;
		} else if (!mailId.equals(other.mailId))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (monthlySaving == null) {
			if (other.monthlySaving != null)
				return false;
		} else if (!monthlySaving.equals(other.monthlySaving))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (totalMonthlyExpendeture == null) {
			if (other.totalMonthlyExpendeture != null)
				return false;
		} else if (!totalMonthlyExpendeture.equals(other.totalMonthlyExpendeture))
			return false;
		if (totalMonthlyIncome == null) {
			if (other.totalMonthlyIncome != null)
				return false;
		} else if (!totalMonthlyIncome.equals(other.totalMonthlyIncome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", mobile=" + mobile
				+ ", empType=" + empType + ", totalMonthlyIncome=" + totalMonthlyIncome + ", totalMonthlyExpendeture="
				+ totalMonthlyExpendeture + ", monthlySaving=" + monthlySaving + ", mailId=" + mailId + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getGender()=" + getGender() + ", getDob()=" + getDob()
				+ ", getMobile()=" + getMobile() + ", getEmpType()=" + getEmpType() + ", getTotalMonthlyIncome()="
				+ getTotalMonthlyIncome() + ", getTotalMonthlyExpendeture()=" + getTotalMonthlyExpendeture()
				+ ", getMonthlySaving()=" + getMonthlySaving() + ", getMailId()=" + getMailId() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	public Customer(Integer id, String name, String gender, Date dob, Long mobile, String empType,
			Long totalMonthlyIncome, Long totalMonthlyExpendeture, Double monthlySaving, String mailId) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.mobile = mobile;
		this.empType = empType;
		this.totalMonthlyIncome = totalMonthlyIncome;
		this.totalMonthlyExpendeture = totalMonthlyExpendeture;
		this.monthlySaving = monthlySaving;
		this.mailId = mailId;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}


