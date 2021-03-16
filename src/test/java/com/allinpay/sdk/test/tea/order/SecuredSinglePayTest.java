package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class SecuredSinglePayTest extends JuintTest {

	/**
	 * 单笔担保转账转入
	 */
	@Test
	public void orderRefundQuery() {		
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "securedSinglePay");
		paramMap.put("orderNo","lpssp" + System.currentTimeMillis());
		paramMap.put("tlOrderNo","20200611112941100001"); //源担保转出订单号
		paramMap.put("receiveAmt","3"); //转出金额
		paramMap.put("targetCustId","200604597378856");//
		paramMap.put("custName","李平");
		paramMap.put("remark","单笔担保转账转入");
		paramMap.put("serviceUrl","http://192.168.13.26:8001/yst-notify/zfb/yibu");

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.securedSinglePay", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
