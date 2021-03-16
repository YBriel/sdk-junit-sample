package com.allinpay.sdk.test.tea.acct;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class SignAcctAgreementTest extends JuintTest {

	/**
	 * 签订开户协议H5
	 */
	@Test
	public void openAcct() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "signAcctAgreement");
		paramMap.put("custId", "200604597378856" );
		paramMap.put("serviceUrl", "http://192.168.13.26:8001/yst-notify/zfb/yibu" );
		paramMap.put("version", "1.0" );
		paramMap.put("jumpUrl", "C001" );

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.mcht.signAcctAgreement", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
