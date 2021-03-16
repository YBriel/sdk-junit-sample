package com.allinpay.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class ResendPaySMSTest extends JuintTest{

	/**
	 * 重发支付短信验证码
	 */
	@Test
	public void resendPaySMS() {
		final BizParameter param = new BizParameter();
		param.put("bizOrderNo", "1587913686806lpcs");
		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.resendPaySMS", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
