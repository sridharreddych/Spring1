package com.stock.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockWrapper {

	@JsonProperty(value = "Meta Data")
	private MetaData metaData;
	@JsonProperty(value = "Stock Quotes")
	private List<StockDetails> stockList;

	public StockWrapper(MetaData metaData, List<StockDetails> stockList) {
		super();
		this.metaData = metaData;
		this.stockList = stockList;
	}

	public StockWrapper() {
		super();
	}

	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

	public List<StockDetails> getStockList() {
		return stockList;
	}

	public void setStockList(List<StockDetails> stockList) {
		this.stockList = stockList;
	}

}
