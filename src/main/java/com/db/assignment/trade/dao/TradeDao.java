package com.db.assignment.trade.dao;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.db.assignment.trade.model.Trade;

public interface TradeDao {

	public static Map<String, Trade> tradeMap = new ConcurrentHashMap<>();

	public void save(Trade trade);

	List<Trade> findAll();

	Trade findTrade(String tradeId);
}
