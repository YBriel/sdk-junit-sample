package com.allinpay.assist;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class QueryBankBalanceTest extends JuintTest {

	/**
	 * 平台账户集余额查询
	 */
	@Test
	public void queryReserveFundBalance() {
		final BizParameter param = new BizParameter();
		
		param.put("acctOrgType", 1L);//1-华通银行  3-上海银行（金服宝）  4-招商银行（金服宝）
		param.put("acctNo", "1010012198010000039");
		param.put("acctName", "通联支付网络服务股份有限公司辽宁分公司");
		param.put("date", "20200427");


		
		try {
			final OpenResponse response = client.execute("allinpay.yunst.merchantService.queryBankBalance", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
