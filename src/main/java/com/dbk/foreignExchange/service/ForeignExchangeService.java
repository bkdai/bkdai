package com.dbk.foreignExchange.service;

import com.dbk.foreignExchange.entity.ResultInfo;

public interface ForeignExchangeService {

	public abstract ResultInfo convert(double amount, String from, String to);

}