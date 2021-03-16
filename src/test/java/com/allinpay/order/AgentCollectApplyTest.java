package com.allinpay.order;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class AgentCollectApplyTest extends JuintTest{

	/**
	 * 托管代收申请（标准版）
	 */
	@Test
	public void agentCollectApply() {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 15);
		final Date date = calendar.getTime();
		final String orderExpireDatetime = sdf.format(date);
		final BizParameter param = new BizParameter();
		// 支付方式
		// 实名付（单笔）
		final Map<String, Object> realnamePay = new HashMap<>();
		realnamePay.put("bankCardNo", client.encrypt("6228480402637874321"));
		realnamePay.put("amount", 30L);
		
		//账户余额
		JSONArray BALANCE = new JSONArray();
		HashMap<String, Object> balancePay = new HashMap<>();
		balancePay.put("accountSetNo", "400221");
		balancePay.put("amount", 8L);
		BALANCE.add(balancePay);

		// 组装支付方式
		final HashMap<String, Object> payMethod = new HashMap<>();
		//payMethod.put("REALNAMEPAY", realnamePay);
		payMethod.put("BALANCE", BALANCE);

		// 收款列表
		final JSONArray receiverList = new JSONArray();
		final HashMap<String, Object> receiver1 = new HashMap<>();
		receiver1.put("bizUserId", "toplp002");
		receiver1.put("amount", 3L);
		receiverList.add(new JSONObject(receiver1));
		
		final HashMap<String, Object> receiver2 = new HashMap<>();
		receiver2.put("bizUserId", "toplp003");
		receiver2.put("amount", 5L);
		receiverList.add(new JSONObject(receiver2));
		

		param.put("payerId", "toplp001");
		param.put("bizOrderNo", System.currentTimeMillis() + "lpac");
		param.put("recieverList", receiverList);
		param.put("tradeCode", "1003");
		param.put("amount", 8L);
		param.put("fee", 0L);
		param.put("validateType", 1L); // 1 短信验证
		param.put("frontUrl", "http://ceshi.allinpay.com");
		param.put("backUrl", "http://test.allinpay.com/yst-notify/zfb/yibu");
		param.put("orderExpireDatetime", orderExpireDatetime);
		param.put("payMethod", payMethod);
		param.put("goodsName", "computer");
		param.put("goodsDesc", "computer made in china");
		param.put("industryCode", "1010");
		param.put("industryName", "保险代理");
		param.put("source", 2L);
		param.put("summary", "consume");
		param.put("extendInfo", "this is extendInfo");
		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.agentCollectApply", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
