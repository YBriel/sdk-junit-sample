package com.allinpay.order;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class DepositApplyTest extends JuintTest{

	/**
	 * 充值申请
	 */
	@Test
	public void depositApply() {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 15);
		final Date date = calendar.getTime();
		final String orderExpireDatetime = sdf.format(date);

		final BizParameter param = new BizParameter();
		// 实名付（单笔）
		final HashMap<String, Object> realnamePay = new HashMap<>();
		realnamePay.put("bankCardNo", client.encrypt("6228480402637874321"));
		realnamePay.put("amount", 100); // 分

		// 收银宝网关
		final Map<String, Object> gatewayVsp = new HashMap<>();
		gatewayVsp.put("amount", 3L);
		gatewayVsp.put("paytype", "B2C");
		gatewayVsp.put("limitPay", "no_credit");
		
		//通用虚拟入金
		HashMap<String, Object> VIRTUAL_IN = new HashMap<>();
		VIRTUAL_IN.put("amount", 30000L);
		VIRTUAL_IN.put("extChannelNo", "");
		VIRTUAL_IN.put("extAccount", "");
		VIRTUAL_IN.put("paysummary", "");

		// 组装支付方式
		final HashMap<String, Object> payMethod = new HashMap<>();
//		payMethod.put("REALNAMEPAY", realnamePay);
		payMethod.put("GATEWAY_VSP", gatewayVsp);
	//	payMethod.put("VIRTUAL_IN", VIRTUAL_IN);

		param.put("bizUserId", "toplp001");
		param.put("bizOrderNo", System.currentTimeMillis() + "lpdp");
		param.put("accountSetNo", "400193");
		param.put("amount", 3L);
		param.put("fee", 0L);
		param.put("validateType", 0L);
		param.put("frontUrl", "http://ceshi.allinpay.com");
		param.put("backUrl", "http://test.allinpay.com/yst-notify/zfb/yibu");
		param.put("orderExpireDatetime", orderExpireDatetime);
		param.put("payMethod", JSONObject.toJSON(payMethod));
		param.put("goodsName", "computer");
		param.put("industryCode", "1010");
		param.put("industryName", "保险代理");
		param.put("source", 2L);
		param.put("summary", "deposit");
		param.put("extendInfo", "this is extendInfo");

		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.depositApply", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}


}
