package com.allinpay.sdk.test.tea.member;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class CustRealNameAuthTest extends JuintTest {

	/**
	 * 实名认证
	 */
	@Test
	public void custRealNameAuth() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "custRealNameAuth");
		paramMap.put("custType", "U");
		paramMap.put("custId", "200604597378856");
		paramMap.put("verifyType", "YHK");//YHK，GSZ，SFZ
		paramMap.put("idType", "01");
		paramMap.put("idNo", "411423198708175560");
		paramMap.put("acctNo", "6225220113999387");
		paramMap.put("mobile", "18916507392");
		paramMap.put("custName", "李平");
		paramMap.put("thrcertflag", "1");
		paramMap.put("corpbusName", "上海验证河网络科技有限公司");
		paramMap.put("creditcode", "91310115MA1H9AJ015");

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.custRealNameAuth", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
