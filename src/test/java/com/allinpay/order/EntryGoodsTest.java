package com.allinpay.order;

import java.util.HashMap;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class EntryGoodsTest extends JuintTest{

	/**
	 * 商品录入
	 */
	@Test
	public void entryGoods() {
		final BizParameter param = new BizParameter();
		
		final HashMap<String, Object> goodsParams = new HashMap<>();
		goodsParams.put("eshopEntCode", "1010");
		goodsParams.put("eshopEntName", "跨境电商");
		goodsParams.put("customsCode", "HG001");

		param.put("bizUserId", "toplp001");
		param.put("goodsType", 5);
		param.put("bizGoodsNo", "lpgoods004");
		param.put("goodsName", "虚拟商品");
		param.put("goodsDetail", "虚拟商品录入");
		param.put("goodsParams", goodsParams);
		param.put("showUrl", "http://ceshi.allinpay.com");
		

		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.entryGoods", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
