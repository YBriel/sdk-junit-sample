package com.allinpay.member;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class CreateBankSubAcctNoTest extends JuintTest{
	
	/**
	 * 会员子账户开通
	 */
	@Test
	public void getSubAcctNoInfoForHT() {
		
		final BizParameter param = new BizParameter();
		param.put("accountSetNo", "100001");
		param.put("bizUserId", "#yunBizUserId_B2C#");
		param.put("acctOrgType", 0L);//0-通联   1-华通银行

		
		try {
			final OpenResponse response = client.execute("allinpay.yunst.memberService.createBankSubAcctNo", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
