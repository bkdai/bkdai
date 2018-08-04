package com.dbk.foreignExchange.dao;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;
@Repository("foreignExchangeDao")
public class ForeignExchangeDaoImp implements ForeignExchangeDao {
	//��mapģ��redis
	private static ConcurrentHashMap<String, Double> rateMap = new ConcurrentHashMap<String, Double>();
	private ForeignExchangeDaoImp(){
		//ģ��redis��ʵʱ���²���
		ForeignExchangeDaoImp.rateMap.clear();
		ForeignExchangeDaoImp.rateMap.put("CNY", 1d);//�����
		ForeignExchangeDaoImp.rateMap.put("USD", 6d);//��Ԫ
		ForeignExchangeDaoImp.rateMap.put("AUD", 5d);//��Ԫ
		ForeignExchangeDaoImp.rateMap.put("HKD", 0.8d);//��Ԫ
		ForeignExchangeDaoImp.rateMap.put("EUR", 7.9d);//ŷԪ
		ForeignExchangeDaoImp.rateMap.put("GBP", 8.8d);//Ӣ��
	}
	/* (non-Javadoc)
	 * @see com.dbk.foreignExchange.dao.ForeignExchangeDao#getRate(java.lang.String)
	 */
	public double getRate(String currencyCode){
		System.out.println(rateMap.get(currencyCode));
		return ForeignExchangeDaoImp.rateMap.get(currencyCode);
		
	}

}
