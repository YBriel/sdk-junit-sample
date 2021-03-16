package com.allinpay.member;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class BindPhoneTest extends JuintTest{

	/**
	 * 绑定手机
	 */
	@Test
	public void bindPhone() {
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "toplp001");
		param.put("phone", "18916507392");
		param.put("verificationCode", "11111");
		try {
			final OpenResponse response = client.execute("allinpay.yunst.memberService.bindPhone", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
