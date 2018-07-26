package com.stock.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stock.model.MetaData;
import com.stock.model.Stock;
import com.stock.model.StockWrapper;
import com.stock.service.StockService;

@CrossOrigin
@RestController
@RequestMapping(value = "/onlinetrading")
public class StockController {

	private static final Logger log = LoggerFactory.getLogger(StockController.class);

	@Autowired
	StockService stockService;
	String message = null;
	boolean createStock = false;

	@RequestMapping(value = "/purchaseStock", method = RequestMethod.POST)
	public String purchaseStock(@RequestBody Stock stock) {
		createStock = stockService.executeStock(stock);
		if (createStock)
			message = "Stock purchased successfully!! ";
		else
			message = "DB Error:::";

		return message;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getStocketHistory/{userName}", method = RequestMethod.GET)
	public List<Stock> getOrderDetails(@PathVariable("userName") String userName) {
		@SuppressWarnings("rawtypes")
		List orderList = new ArrayList();
		orderList = stockService.getOrderSummery(userName);
		return orderList;
	}

	@RequestMapping(value="/getMarketDetails", method=RequestMethod.GET)
	public StockWrapper getMarketDetails() {
		final String uri = "https://www.alphavantage.co/query?function=BATCH_STOCK_QUOTES&symbols=MSFT,FB,AAPL&apikey=ZDTPC2AH48QQ836J";

		RestTemplate restTemplate = new RestTemplate();
		log.info(uri);
		StockWrapper result = restTemplate.getForObject(uri, StockWrapper.class);

		log.info(result.getMetaData().getInformation());
		return result;

	}

}
