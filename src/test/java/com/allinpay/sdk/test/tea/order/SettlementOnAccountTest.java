package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class SettlementOnAccountTest extends JuintTest {

	/**
	 * 结算至支付账户
	 */
	@Test
	public void settlementOnAccount() {		
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "settlementOnAccount");
		//paramMap.put("acquirerId", "1");//收单机构接入时必填
		paramMap.put("custType", "U");
		paramMap.put("custId", "200527551032693");
		paramMap.put("orderAmount", "1");
		paramMap.put("custName", "李平");//个人客户必填
		//paramMap.put("corpbusName", "082005271000057");//企业客户必填
		paramMap.put("outSourceType", "02");//02：通联电子银行-收银宝往来户
		paramMap.put("orderAmount", "1");
		paramMap.put("orderNo", "lpsoa" + System.currentTimeMillis());
		paramMap.put("remark","");
		paramMap.put("serviceUrl","http://192.168.13.26:8001/yst-notify/zfb/yibu");
		

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.settlementOnAccount", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
