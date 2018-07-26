package com.stock.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockDetails {

	@JsonProperty(value = "1. symbol")
	private String symbol;
	@JsonProperty(value = "2. price")
	private String price;
	@JsonProperty(value = "3. volume")
	private String volume;
	@JsonProperty(value = "4. timestamp")
	private String currentTime;

	public StockDetails() {
		super();
	}

	public StockDetails(String symbol, String price, String volume, String currentTime) {
		super();
		this.symbol = symbol;
		this.price = price;
		this.volume = volume;
		this.currentTime = currentTime;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
}
