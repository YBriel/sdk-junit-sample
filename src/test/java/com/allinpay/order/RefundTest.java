package com.allinpay.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class RefundTest extends JuintTest{

	/**
	 * 退款申请
	 */
	@Test
	public void refund() {
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "lyz003");
		param.put("bizOrderNo", System.currentTimeMillis() + "lprf");
		param.put("oriBizOrderNo", "1587879108538lpdp");
		param.put("backUrl", "http://test.allinpay.com/yst-notify/zfb/yibu");
		param.put("amount", 5);
		param.put("refundType", "D0");

		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.refund", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
