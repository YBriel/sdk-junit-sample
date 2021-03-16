package com.allinpay.assist;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class QueryMerchantBalanceTest extends JuintTest {

	/**
	 * 平台账户集余额查询
	 */
	@Test
	public void queryReserveFundBalance() {
		final BizParameter param = new BizParameter();
		
		param.put("accountSetNo", "100004");

		
		try {
			final OpenResponse response = client.execute("allinpay.yunst.merchantService.queryMerchantBalance", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
