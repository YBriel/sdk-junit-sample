package com.allinpay.assist;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class QueryReserveFundBalanceTest extends JuintTest {

	/**
	 * 通联通头寸查询
	 */
	@Test
	public void queryReserveFundBalance() {
		final BizParameter param = new BizParameter();
		param.put("sysid", "2004201037104559530");
		try {
			final OpenResponse response = client.execute("allinpay.yunst.merchantService.queryReserveFundBalance", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
