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
@Table(name="eligibilitydetails")
public class EligibilityDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="eligibility_id")
	private Integer eid;
	
	@Column(name="date_of_offer")
	private Date dateOfOffer;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Date getDateOfOffer() {
		return dateOfOffer;
	}

	public void setDateOfOffer(Date dateOfOffer) {
		this.dateOfOffer = dateOfOffer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfOffer == null) ? 0 : dateOfOffer.hashCode());
		result = prime * result + ((eid == null) ? 0 : eid.hashCode());
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
		EligibilityDetails other = (EligibilityDetails) obj;
		if (dateOfOffer == null) {
			if (other.dateOfOffer != null)
				return false;
		} else if (!dateOfOffer.equals(other.dateOfOffer))
			return false;
		if (eid == null) {
			if (other.eid != null)
				return false;
		} else if (!eid.equals(other.eid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EligibilityDetails [eid=" + eid + ", dateOfOffer=" + dateOfOffer + ", getEid()=" + getEid()
				+ ", getDateOfOffer()=" + getDateOfOffer() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}

	public EligibilityDetails(Integer eid, Date dateOfOffer) {
		super();
		this.eid = eid;
		this.dateOfOffer = dateOfOffer;
	}

	public EligibilityDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
