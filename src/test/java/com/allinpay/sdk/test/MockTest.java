package com.allinpay.sdk.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.util.SecretUtils;

public class MockTest extends JuintTest {

	@Test
	public void mock() {
		final BizParameter param = new BizParameter();
		param.put("aaaa", "fdsfdsafdsadf");
		param.put("bbb", 2L);
		param.put("ccc", 1L);
		try {
			final OpenResponse response = client.execute("allinpay.top.mock.api", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
			assertTrue("10000".equals(response.getCode()));
		} catch (final Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	@Test
	public void mockJump() {
		final BizParameter param = new BizParameter();
		param.put("aaaa", "fdsfdsafdsadf");
		param.put("bbb", 2L);
		param.put("ccc", 1L);
		try {
//			final String url = client.concatUrlForServer("allinpay.top.common.jump", param, "https://www.baidu.com",
//					"661520093552836608");
//			browser(url);
		} catch (final Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	@Test
	public void getCompanyInfo() {
		final BizParameter param = new BizParameter();
		param.put("companyId", "082003121000034");
		try {
			final OpenResponse response = client.execute("allinpay.top.info.getCompanyInfo", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOther() {
		System.out.println(SecretUtils.decryptAES("03770E9003CEF303C4B7B3EEA174D3AA4EAAEABA4B66C591EDEFC3D675AC45B9",
				"CmeIjpnKJuAtZQhJyYtdQSmZjstsaXId"));
	}
}
