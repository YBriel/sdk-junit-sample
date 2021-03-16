package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class SignAuthAgreementTest extends JuintTest {

	/**
	 * 签订扣款协议申请
	 */
	@Test
	public void signAuthAgreement() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "signAuthAgreement");
		paramMap.put("custType", "U");
		paramMap.put("custId", "200604597378856");
		paramMap.put("cusid", "082006041001691");//收款方收单商户号
		paramMap.put("acquirerId", "1001");//收单机构/清算平台对接电子账户系统，此字段必填；（1）收银宝收单机构号：1001
		paramMap.put("validTime", "20210510140811");
		paramMap.put("agreementType", "03");//03：扣款授权协议
		paramMap.put("serviceInfo", "200224550949700");
		paramMap.put("jumpUrl", "www.baidu.com");//
		paramMap.put("serviceUrl", "http://192.168.13.26:8001/yst-notify/zfb/yibu");
		
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.signAuthAgreement", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
