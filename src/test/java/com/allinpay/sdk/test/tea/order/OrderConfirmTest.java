package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class OrderConfirmTest extends JuintTest {

	/**
	 * 订单确认
	 */
	@Test
	public void orderConfirm() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "orderconfirm");
		paramMap.put("orderAmount", "1" );
		paramMap.put("authWay", "0" );
		paramMap.put("tlOrderNo", "20200825172729100001" );
		paramMap.put("smsCode", "111111" );
		
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.orderConfirm", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
