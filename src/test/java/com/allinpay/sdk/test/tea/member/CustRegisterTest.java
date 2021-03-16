package com.allinpay.sdk.test.tea.member;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class CustRegisterTest extends JuintTest {

	/**
	 * 创建会员
	 */
	@Test
	public void CustRegister() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "custRegister");
		paramMap.put("custType", "U");
		paramMap.put("mobile", "18916507392");
		paramMap.put("smsCode", "400764");
		paramMap.put("smsSeqNo", "2006041456055787");
		
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.custRegister", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
