package com.stock.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetaData {
	@JsonProperty(value = "1. Information")
	private String information;
	@JsonProperty(value = "2. Notes")
	private String notes;
	@JsonProperty(value = "3. Time Zone")
	private String timeZone;

	public MetaData() {
		super();
	}

	public MetaData(String information, String notes, String timeZone) {
		super();
		this.information = information;
		this.notes = notes;
		this.timeZone = timeZone;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
}