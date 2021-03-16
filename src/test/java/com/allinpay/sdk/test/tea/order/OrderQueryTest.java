package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class OrderQueryTest extends JuintTest {

	/**
	 * 查询订单状态
	 */
	@Test
	public void orderQuery() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "B9990_0003_02");
//		paramMap.put("custId", "200224550949700");
//		paramMap.put("orderNo", "dz01");//商户订单号
		paramMap.put("tlOrderNo", "20200605144639100001");//通联订单号

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.orderQuery", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
