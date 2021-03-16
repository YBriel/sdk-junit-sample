package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class OrderRefundQueryTest extends JuintTest {

	/**
	 * 退款订单查询
	 * 支付订单退款和收单余额支付退款订单查询
	 */
	@Test
	public void orderRefundQuery() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "B9990_0002_01");
		paramMap.put("custId", "200604597378856");
		paramMap.put("mchtRefundOrderNo", "lps1591846397373");//退款订单号
		//paramMap.put("orderNo", "lps1591339752627");//原始商户订单号
		paramMap.put("benginTime", "20200611");
		paramMap.put("endTime", "20200611");

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.orderRefundQuery", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
