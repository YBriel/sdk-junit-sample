package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class UnsignAuthAgreementTest extends JuintTest {

	/**
	 * 扣款授权协议解约
	 */
	@Test
	public void unsignAuthAgreement() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "unsignAuthAgreement");
		paramMap.put("custId", "200604597378856");
		paramMap.put("cusid", "082006041001691");
		paramMap.put("acquirerId", "1001");//收单机构/清算平台对接电子账户系统，此字段必填；（1）收银宝收单机构号：1001
		paramMap.put("agreementStatus", "1");//1.生效  2.失效  3.签订中，不填则查询所有
		paramMap.put("agreementNo", "DK202006051228433");
		paramMap.put("serviceUrl", "http://192.168.13.26:8001/yst-notify/zfb/yibu");

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.unsignAuthAgreement", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
