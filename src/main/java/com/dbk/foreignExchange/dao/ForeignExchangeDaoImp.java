package com.dbk.foreignExchange.dao;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;
@Repository("foreignExchangeDao")
public class ForeignExchangeDaoImp implements ForeignExchangeDao {
	//用map模拟redis
	private static ConcurrentHashMap<String, Double> rateMap = new ConcurrentHashMap<String, Double>();
	private ForeignExchangeDaoImp(){
		//模拟redis的实时更新操作
		ForeignExchangeDaoImp.rateMap.clear();
		ForeignExchangeDaoImp.rateMap.put("CNY", 1d);//人民币
		ForeignExchangeDaoImp.rateMap.put("USD", 6d);//美元
		ForeignExchangeDaoImp.rateMap.put("AUD", 5d);//澳元
		ForeignExchangeDaoImp.rateMap.put("HKD", 0.8d);//港元
		ForeignExchangeDaoImp.rateMap.put("EUR", 7.9d);//欧元
		ForeignExchangeDaoImp.rateMap.put("GBP", 8.8d);//英镑
	}
	/* (non-Javadoc)
	 * @see com.dbk.foreignExchange.dao.ForeignExchangeDao#getRate(java.lang.String)
	 */
	public double getRate(String currencyCode){
		System.out.println(rateMap.get(currencyCode));
		return ForeignExchangeDaoImp.rateMap.get(currencyCode);
		
	}

}
