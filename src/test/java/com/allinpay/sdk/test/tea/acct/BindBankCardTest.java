package com.allinpay.sdk.test.tea.acct;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class BindBankCardTest extends JuintTest {

	/**
	 * 请求绑定银行卡
	 */
	@Test
	public void bindBankCard() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "B1002_0100_03");
		paramMap.put("custTypecardType", "U");
		paramMap.put("custId", "200604597378856" );
		paramMap.put("signSeqNo", "202006041506100391");
		paramMap.put("smsCode", "490953" );
		paramMap.put("operType", "01");

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.bindBankCard", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
