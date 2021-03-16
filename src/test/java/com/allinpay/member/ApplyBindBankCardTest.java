package com.allinpay.member;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class ApplyBindBankCardTest extends JuintTest{

	/**
	 * 请求绑定银行卡
	 */
	@Test
	public void applyBindBankCard() {
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "toplp001");
		param.put("phone", "18916507392");
		param.put("cardCheck", 1L);
		param.put("cardNo", client.encrypt("6228481234567890123"));
		param.put("name", "李平");
		param.put("identityNo", client.encrypt("411423198708175560"));
		param.put("identityType", 1L);
//		param.put("validate", client.encrypt("205012"));
//		param.put("cvv2", client.encrypt("321"));
		param.put("isSafeCard", false);
		param.put("unionBank", "");
		try {
			final OpenResponse response = client.execute("allinpay.yunst.memberService.applyBindBankCard", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
