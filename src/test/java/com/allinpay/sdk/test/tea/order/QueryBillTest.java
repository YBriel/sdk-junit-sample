package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class QueryBillTest extends JuintTest {

	/**
	 * 对账单下载
	 */
	@Test
	public void queryBill() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "queryBill");
		paramMap.put("date", "20200605");
		paramMap.put("billType", "1");//1：应用方账单   2：收单机构账单
		paramMap.put("acquirerId", "1001");//对账单类型为2: 收单机构账单时必传     收银宝的收单机构号：1001

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.queryBill", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
