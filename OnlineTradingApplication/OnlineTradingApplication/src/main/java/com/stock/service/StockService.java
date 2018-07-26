package com.stock.service;

import java.util.List;

import com.stock.model.Stock;

public interface StockService {
	
	public boolean executeStock(Stock stock);
	public List<Stock> getOrderSummery(String userName);

}
