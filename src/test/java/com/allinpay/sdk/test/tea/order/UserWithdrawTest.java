package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class UserWithdrawTest extends JuintTest {

	/**
	 * 账户提现订单申请
	 */
	@Test
	public void userWithdraw() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "userwithdraw");
		paramMap.put("custType", "U" );
		paramMap.put("custId", "200527551032693" );
		paramMap.put("orderNo", "lpwd" + System.currentTimeMillis());
		paramMap.put("orderAmount", "1" );
		paramMap.put("addFee", "0" );
		paramMap.put("agreementId", "XY200213658811");
		paramMap.put("authWay", "1" );
		paramMap.put("jumpUrl", "http://www.baidu.com" );
		paramMap.put("serviceUrl", "http://192.168.13.26:8001/yst-notify/zfb/yibu" );
//		paramMap.put("acctType", "00" );
//		paramMap.put("acctName", "" );
//		paramMap.put("acctNo", "1" );
//		paramMap.put("acctProp", "XY200213658811");
//		paramMap.put("currency", "01" );
//		paramMap.put("bankCode", "100" );
//		paramMap.put("cnapsno", "1" );
//		paramMap.put("bankName", "XY200213658811");
//		paramMap.put("province", "01" );
//		paramMap.put("city", "100" );
//		paramMap.put("remark", "XY200213658811");
		

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.userwithdraw", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
