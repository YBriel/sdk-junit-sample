package com.allinpay.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class GetOrderDetailTest extends JuintTest{

	/**
	 * 查询订单状态
	 */
	@Test
	public void getOrderDetail() {
		final BizParameter param = new BizParameter();
		param.put("bizOrderNo", "1587884757127lpwd");
		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.getOrderDetail", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
