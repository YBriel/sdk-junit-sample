package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class UserChargeApply extends JuintTest {

	/**
	 * 订单充值申请
	 */
	@Test
	public void userChargeApply() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "userchargeapply");
		paramMap.put("custType", "U");
		paramMap.put("custId", "200604597378856");
		paramMap.put("outSourceType", "01" );
		paramMap.put("orderNo", "lpuc" + System.currentTimeMillis());
		paramMap.put("orderAmount", "2" );
		paramMap.put("addFee", "0" );
		paramMap.put("agreementId", "16020110519787" );
		paramMap.put("remark", "202004021000100004" );
		paramMap.put("jumpUrl", "http://www.baidu.com" );
		paramMap.put("serviceUrl", "http://192.168.13.26:8001/yst-notify/zfb/yibu" );

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.userchargeapply", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
