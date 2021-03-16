package com.allinpay.sdk.test.tea.addition;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class GenerateRandomKeyTest extends JuintTest {
    /**
     * 生成随机密码
     * 
     */
	@Test
	public void generateRandomKey() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("custId", "200224550949700");
		paramMap.put("serviceCode", "setPassWord");

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.generateRandomKey", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
