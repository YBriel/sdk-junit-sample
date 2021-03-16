package com.allinpay.member;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.test.JuintTest;

public class SetPayPwdTest extends JuintTest{

	/**
	 * 设置支付密码
	 */
	@Test
	public void setPayPwd() {
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "toplp001");
		param.put("phone", "18916507392");
		param.put("name", "李平");
		param.put("identityType", "1");
		param.put("identityNo", client.encrypt("411423198708175560"));
		param.put("jumpUrl", "http://ceshi.allinpay.com");
		param.put("backUrl", "http://test.allinpay.com/yst-notify/zfb/yibu");
		
		try {
			final String url = client.concatUrlParams("allinpay.yunst.memberService.setPayPwd", param);
			System.out.println(url);
			browser(url);// 打开浏览器
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
