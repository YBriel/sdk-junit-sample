package com.allinpay.member;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class SetRealNameTest extends JuintTest{
	
	
	/**
	 * 个人会员实名认证
	 */
	@Test
	public void setRealName() {
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "toplp001");
		param.put("isAuth", "true");
		param.put("name", "李平");
		param.put("identityType", "1");
		param.put("identityNo", client.encrypt("411423198708175560"));// 敏感数据加密
		try {
			final OpenResponse response = client.execute("allinpay.yunst.memberService.setRealName", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
