package com.allinpay.sdk.test.tea.member;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class SendMsgTest extends JuintTest {

	/**
	 * 发送短信验证码
	 */
	@Test
	public void sendMsg() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "B1013_0000_01");
		paramMap.put("phone", "18916507392");
		paramMap.put("smsTemplateType", "dz01");
		paramMap.put("smsType", "0");
		
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.sendSms", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
