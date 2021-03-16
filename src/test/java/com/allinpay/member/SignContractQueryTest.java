package com.allinpay.member;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.test.JuintTest;

public class SignContractQueryTest extends JuintTest{

	/**
	 * 电子会员签约查询
	 */
	@Test
	public void signContract() {
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "toplp001");
		param.put("jumpUrl", "http://ceshi.allinpay.com");
		param.put("backUrl", "https://www.baidu.com");
		param.put("source", 2L);
		try {
			final String url = client.concatUrlParams("allinpay.yunst.memberService.signContractQuery", param);
			System.out.println(url);
			browser(url);// 打开浏览器
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
