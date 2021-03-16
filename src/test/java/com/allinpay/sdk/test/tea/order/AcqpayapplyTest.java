package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class AcqpayapplyTest extends JuintTest {

	/**
	 * 收单余额消费申请
	 */
	@Test
	public void acqpayapply() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "acqpayapply");
		paramMap.put("custId", "200527551032693" );
		paramMap.put("orderAmount", "4" );
		paramMap.put("addFee", "1" );
		paramMap.put("orderNo", "lpacp" + System.currentTimeMillis());
		paramMap.put("orderDatetime", "202005171212" );
		paramMap.put("bizType", "12" );
		paramMap.put("subBizType", "1201" );//1201-余额消费（按人行风控返回鉴权方式）  1202-余额代扣（需先签订扣款扣授权协议）
		paramMap.put("cusid", "082004161002567" );//收款方收单商户号
		paramMap.put("acquirerId", "1001" );//收单机构号
		paramMap.put("agreementNo", "DK202005291600494" );//代扣协议号
		paramMap.put("remark", "1201" );
		paramMap.put("jumpUrl", "http://www.baidu.com" );
		paramMap.put("serviceUrl", "http://192.168.13.26:8001/yst-notify/zfb/yibu" );
		
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.acqpayapply", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
