package com.allinpay.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class GetOrderSplitRuleListDetailTest extends JuintTest {

	/**
	 * 订单分账明细查询
	 */
	@Test
	public void getPayeeFundsInTransit() {
		final BizParameter param = new BizParameter();
		
		param.put("bizOrderNo", "1587913280387lpcs");
		
		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.getOrderSplitRuleListDetail", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
