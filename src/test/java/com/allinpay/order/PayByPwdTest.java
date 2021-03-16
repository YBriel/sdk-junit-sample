package com.allinpay.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.test.JuintTest;

public class PayByPwdTest extends JuintTest {

	/**
	 * 确认支付（前台+支付密码）
	 */
	@Test
	public void payByPwd() {
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "toplp001");
		param.put("bizOrderNo", "1587884081271lpcs");
		param.put("tradeNo", "");
		param.put("jumpUrl", "http://ceshi.allinpay.com");
		param.put("consumerIp", "192.168.11.11");
		try {
			final String url = client.concatUrlParams("allinpay.yunst.orderService.payByPwd", param);
			System.out.println(url);
			browser(url);// 打开浏览器
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
