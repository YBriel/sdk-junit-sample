package com.allinpay.member;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class SendVerificationCodeTest extends JuintTest {

	/**
	 * 发送短信验证码
	 */
	@Test
	public void sendVerificationCode() {
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "toplp001");
		param.put("phone", "18916507392");
		param.put("verificationCodeType", 6L);
		try {
			final OpenResponse response = client.execute("allinpay.yunst.memberService.sendVerificationCode", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
