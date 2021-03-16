package com.allinpay.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class UnfreezeMoneyTest extends JuintTest{

	/**
	 * 解冻金额
	 */
	@Test
	public void unfreezeMoney() {
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "toplp001");
		param.put("bizFreezenNo", "1587889027877lpfm");
		param.put("accountSetNo", "400221");
		param.put("amount", 1);

		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.unfreezeMoney", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
