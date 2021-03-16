package com.allinpay.member;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class GetMemberInfoTest extends JuintTest{

	/**
	 * 查询(个人、企业)会员信息
	 */
	@Test
	public void getMemberInfo() {
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "topep001");
		try {
			final OpenResponse response = client.execute("allinpay.yunst.memberService.getMemberInfo", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
				final JSONObject data = JSON.parseObject(response.getData());
				System.out.println(client.decrypt(data.getJSONObject("memberInfo").getString("accountNo")));// test
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
