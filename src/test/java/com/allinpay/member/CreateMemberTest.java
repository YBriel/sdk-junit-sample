package com.allinpay.member;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class CreateMemberTest extends JuintTest{

	/**
	 * 创建会员
	 */
	@Test
	public void createMemberTest() {
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "toplp002");
		param.put("memberType", 3L);//2-企业会员，3-个人会员
		param.put("source", 1L);
		try {
			final OpenResponse response = client.execute("allinpay.yunst.memberService.createMember", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
