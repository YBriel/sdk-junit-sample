package com.allinpay.order;

import java.util.HashMap;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class SignalAgentPayTest extends JuintTest{

	/**
	 * 单笔托管代付（标准版）
	 */
	@Test
	public void signalAgentPay() {
	final BizParameter param = new BizParameter();
	// 源托管代收订单付款信息
	final JSONArray collectPayList = new JSONArray();
	final HashMap<String, Object> collect1 = new HashMap<>();
	collect1.put("bizOrderNo", "1587885436506lpac");
	collect1.put("amount", 1L);
	collectPayList.add(new JSONObject(collect1));

	param.put("bizUserId", "toplp003");
	param.put("accountSetNo", "400221");
	param.put("bizOrderNo", System.currentTimeMillis() + "lpsa");
	param.put("collectPayList", collectPayList);
	param.put("tradeCode", "2003");
	param.put("amount", 1L);
	param.put("fee", 0L);
	param.put("backUrl", "http://test.allinpay.com/yst-notify/zfb/yibu");
	param.put("summary", "consume");
	param.put("extendInfo", "this is extendInfo");
	try {
		final OpenResponse response = client.execute("allinpay.yunst.orderService.signalAgentPay", param);
		if ("OK".equals(response.getSubCode())) {
			System.out.println(response.getData());
		}
	} catch (final Exception e) {
		e.printStackTrace();
	}
}

}
