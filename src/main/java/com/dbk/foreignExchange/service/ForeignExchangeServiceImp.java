package com.dbk.foreignExchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbk.foreignExchange.dao.ForeignExchangeDao;
import com.dbk.foreignExchange.entity.ResultInfo;

@Service("foreignExchangeService")
public class ForeignExchangeServiceImp implements ForeignExchangeService {
	@Autowired
	private ForeignExchangeDao foreignExchangeDao;
	
	/* (non-Javadoc)
	 * @see com.dbk.foreignExchange.service.ForeignExchangeService#convert(double, java.lang.String, java.lang.String)
	 */
	public ResultInfo convert(double amount,String from, String to) {
		ResultInfo info = new ResultInfo();
		try {
			double rateFrom = foreignExchangeDao.getRate(from);
			double rateTo = foreignExchangeDao.getRate(to);
			//���ڻ��ʶ����������Ҷ��Եģ�Ϊ��չʾ׼ȷ�������ʼ���Ϊ��ת�����������ּ�Ļ���
			double rate = rateFrom/rateTo;
			info.setAmount(String.format("%.2f", amount*rate));
			info.setRate(String.format("%.6f", rate));
		} catch (Exception e) {
			e.printStackTrace();
			info.setAmount(amount+"");
			info.setRate("���ʲ�����");
		}
		info.setFrom(from);
		info.setTo(to);
		return info;
	}
}
