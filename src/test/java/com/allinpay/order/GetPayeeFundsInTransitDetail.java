package com.allinpay.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class GetPayeeFundsInTransitDetail extends JuintTest{

	/**
	 * 收款方在途资金明细查询
	 */
	@Test
	public void getPayeeFundsInTransit() {
		final BizParameter param = new BizParameter();
		param.put("bizOrderNo", "1587885436506lpac");
		param.put("bizUserId", "toplp002");
		param.put("accountSetNo", "400221");
		param.put("dateStart", "2020-04-22");
		param.put("dateEnd", "2020-04-26");
		
		param.put("queryNum", 10L);
		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.getPayeeFundsInTransitDetail", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
