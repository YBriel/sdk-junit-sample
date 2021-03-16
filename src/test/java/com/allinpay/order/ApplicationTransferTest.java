package com.allinpay.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class ApplicationTransferTest extends JuintTest{

	/**
	 * 平台转账
	 */
	@Test
	public void applicationTransfer() {
		final BizParameter param = new BizParameter();
		
		param.put("bizTransferNo", System.currentTimeMillis() + "lpat");
		param.put("sourceAccountSetNo", "100001");
		param.put("targetBizUserId", "toplp001");
		param.put("targetAccountSetNo", "400221");
		param.put("amount", 2L);
		param.put("extendInfo", "平台转账");

		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.applicationTransfer", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
