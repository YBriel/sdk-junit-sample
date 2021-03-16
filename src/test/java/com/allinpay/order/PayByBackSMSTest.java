package com.allinpay.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class PayByBackSMSTest extends JuintTest{

	/**
	 * 确认支付（后台+短信验证码）
	 */
	@Test
	public void payByBackSMS() {
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "toplp001");
		param.put("bizOrderNo", "1587885436506lpac");
		param.put("tradeNo", "");
		param.put("verificationCode", "11111"); // 测试环境 验证码 11111
		param.put("consumerIp", "192.168.11.11");

		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.payByBackSMS", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
