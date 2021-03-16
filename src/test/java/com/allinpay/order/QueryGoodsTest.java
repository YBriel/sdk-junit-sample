package com.allinpay.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class QueryGoodsTest extends JuintTest{

	/**
	 * 查询商品
	 */
	@Test
	public void queryGoods() {
		final BizParameter param = new BizParameter();

		param.put("bizUserId", "toplp001");
		param.put("bizGoodsNo", "lpgoods004");		

		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.queryGoods", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
