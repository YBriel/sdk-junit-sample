package com.allinpay.sdk.test.tea.acct;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class ApplyBankCardBindTest extends JuintTest {

	/**
	 * 请求绑定银行卡
	 */

	@Test
	public void applyBankCardBind() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "B1002_0100_01");
		paramMap.put("custType", "U");
		paramMap.put("custId", "200604597378856" );
		paramMap.put("cardNo", "6225220113999387");
		paramMap.put("custName", "李平");
		paramMap.put("idType", "01");
		paramMap.put("idNo", "411423198708175560");
		paramMap.put("mobile", "18916507392" );
		paramMap.put("isDelete", "1");
//		paramMap.put("expireDate", "2503" );
//		paramMap.put("cvv2", "234");

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.applyBankCardBind", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
