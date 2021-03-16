package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class QuerySecuredListTest extends JuintTest {

	/**
	 * 担保转账资金明细查询
	 */
	@Test
	public void orderRefundQuery() {		
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "querySecuredList");
		paramMap.put("tlOrderNo","20200605144639100001"); //担保转出通联订单号
		paramMap.put("targetCustId","200604597378856");//指定转入客户号，则仅返回该客户相关信息
		paramMap.put("benginTime","20200528");
		paramMap.put("endTime","20200605");

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.querySecuredList", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
