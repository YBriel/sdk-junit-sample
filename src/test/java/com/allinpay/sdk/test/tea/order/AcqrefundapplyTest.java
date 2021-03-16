package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class AcqrefundapplyTest extends JuintTest {

	/**
	 * 收单余额支付申请
	 */

	@Test
	public void acqrefundapply() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "acqrefundapply");
		paramMap.put("custId", "200527551032693" );
		paramMap.put("mchtRefundOrderNo", "lpaf" + System.currentTimeMillis() );//退款申请订单号
		paramMap.put("tlOrderNo", "20200601171539100001" );//原始通联订单号
		//paramMap.put("orderNo", "20200527160655100001" );
		//paramMap.put("orderDatetime", "202004021212" );
		paramMap.put("orderAmount", "4" );
		paramMap.put("refundAmount", "4" );
		paramMap.put("refundAddFee", "1" );
		paramMap.put("remark", "202004021000100004" );
		paramMap.put("serviceUrl", "http://192.168.13.26:8001/yst-notify/zfb/yibu" );
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.acqrefundapply", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
