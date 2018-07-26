package com.stock.repository;

import java.util.List;

import com.stock.model.Stock;

public interface StockDao {
	
	public boolean createStock(Stock stock);
	public List<Stock> getOrderDetails(String customerName);

}
