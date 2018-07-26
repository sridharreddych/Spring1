package com.stock.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Stock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	//private int userPhone;
	private Integer userPhone;
	private String stockName;
	private double stockPrice;
	private int volumePurchased;
	private double totalPrice;
	private double fees;
	private double totalFees;
	//private LocalDateTime timestamp;
	private Timestamp timestamp;
	
	public Stock() {
		super();
	}
	
	
	public Stock(String userName, Integer userPhone, String stockName, double stockPrice, int volumePurchased,
			double totalPrice, double fees, double totalFees) {
		super();
		this.userName = userName;
		this.userPhone = userPhone;
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.volumePurchased = volumePurchased;
		this.totalPrice = totalPrice;
		this.fees = fees;
		this.totalFees = totalFees;
	}


	public Stock(String userName, Integer userPhone, String stockName, double stockPrice, int volumePurchased,
			double totalPrice, double fees, double totalFees, Timestamp timestamp) {
		super();
		this.userName = userName;
		this.userPhone = userPhone;
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.volumePurchased = volumePurchased;
		this.totalPrice = totalPrice;
		this.fees = fees;
		this.totalFees = totalFees;
		this.timestamp = timestamp;
	}



	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(Integer userPhone) {
		this.userPhone = userPhone;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	public int getVolumePurchased() {
		return volumePurchased;
	}
	public void setVolumePurchased(int volumePurchased) {
		this.volumePurchased = volumePurchased;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public double getTotalFees() {
		return totalFees;
	}
	public void setTotalFees(double totalFees) {
		this.totalFees = totalFees;
	}


	public Timestamp getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	
}
