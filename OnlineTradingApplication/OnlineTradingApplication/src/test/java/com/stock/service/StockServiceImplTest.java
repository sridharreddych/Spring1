package com.stock.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.stock.model.Stock;
import com.stock.repository.StockDaoImpl;


@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {
	
	@InjectMocks
	StockServiceImpl stockServiceImpl;
	@Mock
	StockDaoImpl stockDaoImpl;
	
	static Stock stock;;
	@SuppressWarnings("rawtypes")
	List orderList;
	
	@SuppressWarnings("rawtypes")
	@Before
	public void setUp() {
		stock = new Stock();
		orderList = new ArrayList();
		stock.setUserName("Chanchal");
		stock.setUserPhone(98861712);
		stock.setStockName("ICICI");
		stock.setStockPrice(100);
		stock.setVolumePurchased(50);
	}

	@Test
	public void testexecuteStock() {
		
		when(stockDaoImpl.createStock(stock)).thenReturn(true);
		
		stockServiceImpl.executeStock(stock);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testgetOrderSummery() {
		
		when(stockDaoImpl.getOrderDetails("Chanchal")).thenReturn(orderList);
		
		stockServiceImpl.getOrderSummery("Chanchal");
	}
}
