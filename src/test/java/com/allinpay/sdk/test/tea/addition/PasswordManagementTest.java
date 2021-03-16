package com.allinpay.sdk.test.tea.addition;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class PasswordManagementTest extends JuintTest {

	/**
	 * 支付密码管理
	 */
	@Test
	public void custRealNameAuth() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "passwordManagement");
		paramMap.put("custType", "M");
		paramMap.put("custId", "082006041001691");
		paramMap.put("managementType", "1");//
		paramMap.put("jumpUrl", "http://www.baidu.com" );

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.passwordManagement", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
