package com.stock.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.model.Stock;
import com.stock.repository.StockDao;

@Service
public class StockServiceImpl implements StockService{
	
	private static Logger log = LoggerFactory.getLogger(StockServiceImpl.class);
	
	@Autowired
	StockDao stockDao;
	boolean createFlag = false;
	double totalStockPrice;
	double taxFees;
	double totalIncudeFees;
	int stockMaximum;
	int stockMinimum;

	@Override
	public boolean executeStock(Stock stock) {
	 if(stock.getVolumePurchased() != 0 && stock.getVolumePurchased() < 500) {
		 totalStockPrice = (stock.getVolumePurchased() * stock.getStockPrice()) * 0.10;
		 log.info("If purchesed stocke is laess than 500: totalStockPrice -->"+totalStockPrice);
		 taxFees = stock.getVolumePurchased() * 0.10;
		 log.info("taxFees---> "+taxFees);
		 totalIncudeFees = totalStockPrice + taxFees;
		 log.info("totalIncudeFees---> "+totalIncudeFees);
		 stock.setTotalPrice(totalStockPrice);
		 stock.setFees(taxFees);
		 stock.setTotalFees(totalIncudeFees);
		 createFlag = stockDao.createStock(stock);
	 }else if(stock.getVolumePurchased() != 0 && stock.getVolumePurchased() >= 500) {
		 stockMinimum = stock.getVolumePurchased() % 100;
		 log.info("stockMinimum---> "+stockMinimum);
		 stockMaximum = stock.getVolumePurchased() - stockMinimum;
		 log.info("stockMaximum--> "+stockMaximum);
		 totalStockPrice = ((stockMaximum * stock.getStockPrice()) * 0.10) + ((stockMinimum * stock.getStockPrice()) * 0.15);
		 log.info("If purchesed stocke is greater than 500: totalStockPrice -->"+totalStockPrice);
		 taxFees = (stockMinimum * 0.15) + (stockMaximum * 0.10);
		 log.info("taxFees---> "+taxFees);
		 totalIncudeFees = totalStockPrice + taxFees;
		 log.info("totalIncudeFees---> "+totalIncudeFees);
		 stock.setTotalPrice(totalStockPrice);
		 stock.setFees(taxFees);
		 stock.setTotalFees(totalIncudeFees);
		 createFlag = stockDao.createStock(stock);
	 }		
		return createFlag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> getOrderSummery(String userName) {
		@SuppressWarnings("rawtypes")
		List orderList = new ArrayList();
		orderList = stockDao.getOrderDetails(userName);
		return orderList;
	}

	
}
