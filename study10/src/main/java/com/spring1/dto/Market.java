package com.spring1.dto;

import java.util.List;

public class Market {
	private String marketName;
	private List<Goods> goodsList;
	public String getMarketName() {
		return marketName;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	@Override
	public String toString() {
		return "Market [marketName=" + marketName + ", goodsList=" + goodsList + "]";
	}
}
