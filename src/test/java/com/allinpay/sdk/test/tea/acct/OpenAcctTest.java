package com.allinpay.sdk.test.tea.acct;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class OpenAcctTest extends JuintTest {

	/**
	 * 开户申请
	 */
	@Test
	public void openAcct() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "openAcct");
		paramMap.put("custType", "U" );
		paramMap.put("custId", "200604597378856" );
		paramMap.put("acctType", "C001" );

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.openAcct", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
