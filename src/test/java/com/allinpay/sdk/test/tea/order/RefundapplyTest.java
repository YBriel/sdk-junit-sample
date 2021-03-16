package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class RefundapplyTest extends JuintTest {

	/**
	 * 订单退款申请
	 * 请求【担保转账转出申请】、【订单确认】接口完成支付的转出订单
	 */
	@Test
	public void acqrefundapply() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "refundapply");
		paramMap.put("mchtRefundOrderNo", "lps" + System.currentTimeMillis());
		paramMap.put("tlOrderNo", "20200611112941100001" );//原始通联订单号(优先使用此订单号) 担保转账转出的订单，上送转出的通联订单号
		paramMap.put("custId", "200604597378856" );
		//paramMap.put("orderNo", "1" );//原始商户订单号		
		//paramMap.put("orderDatetime", "1" );//
		paramMap.put("refundAmount", "1" );
		paramMap.put("refundAddFee", "0" );
		paramMap.put("serviceUrl", "http://192.168.13.26:8001/yst-notify/zfb/yibu");
		
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.refundapply", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
