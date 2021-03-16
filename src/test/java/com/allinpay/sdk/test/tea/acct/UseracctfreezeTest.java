package com.allinpay.sdk.test.tea.acct;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class UseracctfreezeTest extends JuintTest {

	/**
	 * 账户解冻
	 */
	@Test
	public void userAcctfreeze() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "useracctfreeze");
		paramMap.put("custType", "M");
		paramMap.put("custId", "082006041001691" );
		paramMap.put("operType", "02");

		
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.useracctfreeze", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
