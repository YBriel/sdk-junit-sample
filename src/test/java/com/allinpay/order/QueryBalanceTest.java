package com.allinpay.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class QueryBalanceTest extends JuintTest{

	/**
	 * 查询余额
	 */
	@Test
	public void queryBalance() {
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "toplp001");
		param.put("accountSetNo", "400221");

		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.queryBalance", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
