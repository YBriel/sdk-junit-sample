package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class QueryAuthAgreementTest extends JuintTest {

	/**
	 * 扣款授权协议查询
	 */
	@Test
	public void queryAuthAgreement() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "queryAuthAgreement");
		paramMap.put("custId", "200604597378856");
		paramMap.put("cusid", "082006041001691");//收款方收单商户号
		paramMap.put("acquirerId", "1001");
		paramMap.put("agreementNo", "DK202006051228433");//协议编号
	//	paramMap.put("agreementStatus", "1");//1.生效  2.失效  3.签订中，不填则查询所有
		paramMap.put("pageIndex", "1");
		paramMap.put("pageSize", "10");

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.queryAuthAgreement", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
