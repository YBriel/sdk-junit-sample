package com.allinpay.sdk.test.tea.member;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class CustInfoModifyTest extends JuintTest {

	/**
	 * 修改企业信息
	 */
	@Test
	public void custInfoModify() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode","custInfoModify");
		//paramMap.put("custType","M");
		paramMap.put("custId","082008261000038");//082002191000011
		paramMap.put("idType","01");
		paramMap.put("idNo","110108195601082211");
		paramMap.put("custName","万建华");
		paramMap.put("idExpDate","2025-10-08");

		paramMap.put("mobile","13601956907");
		paramMap.put("corpbusName","通联支付网络服务股份有限公司");
		paramMap.put("shortname","通联支付网络服务股份有限公司");
		paramMap.put("mccid","");
		paramMap.put("comproperty","");
		paramMap.put("thrcertflag","1");
		paramMap.put("creditcode","91310000680985471T");
		paramMap.put("creditcodeexpire","20201012");
		paramMap.put("regnumber","");
		paramMap.put("regnumberexpire","");
		paramMap.put("organcode","");
		paramMap.put("organexpire","");
		paramMap.put("taxnumer","");
		
		paramMap.put("acctid","6225220113999387");
		paramMap.put("acctname","通联支付");
		paramMap.put("accttype","1");
		paramMap.put("accttp","00");
		paramMap.put("cnapsno","316290000019");
		paramMap.put("cnapsname","浦发银行上海分行");
		paramMap.put("address","上海");
		paramMap.put("province","上海");
		paramMap.put("city","上海");
		paramMap.put("bankcode","03080000");
		paramMap.put("email","2287681961@qq.com");
		paramMap.put("contactperson","");
		paramMap.put("contactphone","");

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.custInfoModify", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
