package com.dbk.foreignExchange;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dbk.foreignExchange.dao.ForeignExchangeDao;
import com.dbk.foreignExchange.entity.ResultInfo;
import com.dbk.foreignExchange.service.ForeignExchangeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ForeignExchangeApplicationTests {
	@Mock
    private ForeignExchangeDao foreignExchangeDao;
	@InjectMocks
    private ForeignExchangeService foreignExchangeService;
 
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testConvert() throws Exception {
		ResultInfo info = new ResultInfo();
        double amount = 2;
        String from = "USD";
        String to = "CNY";
        info = foreignExchangeService.convert(amount, from, to);
        System.out.println("{\"amount\":\""+info.getAmount()+"\",\"rate\":\""+info.getRate()+"\",\"from\":\""+info.getFrom()+"\",\"to\":\""+info.getTo()+"\"}");
    }
	@Test
	public void contextLoads() {
	}

}
