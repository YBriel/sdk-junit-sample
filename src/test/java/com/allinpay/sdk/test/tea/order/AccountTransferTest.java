package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class AccountTransferTest extends JuintTest {

	/**
	 * 单笔资金转账
	 */
	@Test
	public void accountTransfer() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "B1006_0004_92");
		paramMap.put("orderNo", "lpat" + System.currentTimeMillis());
		paramMap.put("sourceCustId", "082006041001691");
		paramMap.put("targetCustId", "200604597378856");//200604597378856
		paramMap.put("transferType", "B2C");
		paramMap.put("custName", "李平");
		paramMap.put("transferAmt", "1");
		paramMap.put("addFee", "0");
		paramMap.put("amtType", "1");//现金发放
		paramMap.put("bizType", "6002");
		paramMap.put("jumpUrl", "http://www.baidu.com" );
		paramMap.put("serviceUrl", "http://192.168.13.26:8001/yst-notify/zfb/yibu" );
		
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.accountTransfer", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
