package com.allinpay.order;

import java.util.HashMap;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class BatchAgentPayTest extends JuintTest{

	/**
	 * 批量托管代付（标准版）
	 */
	@Test
	public void batchAgentPay() {
		final BizParameter param = new BizParameter();
		
		final HashMap<String, Object> pay1 = new HashMap<>();
		pay1.put("bizOrderNo", System.currentTimeMillis() + "lpbsa1");
		
		final JSONArray collectPayList1 = new JSONArray();
		final HashMap<String, Object> collect1 = new HashMap<>();
		collect1.put("bizOrderNo", "1587885436506lpac");
		collect1.put("amount", 2L);
		collectPayList1.add(new JSONObject(collect1));
		
		pay1.put("collectPayList", collectPayList1);
		pay1.put("bizUserId", "toplp002");
		pay1.put("accountSetNo", "400221");
		pay1.put("backUrl", "http://test.allinpay.com/yst-notify/zfb/yibu");
		pay1.put("amount", 2L);
		pay1.put("fee", 0L);
		//pay1.put("splitRuleList", splitRuleList);
		//pay1.put("summary", "");
		//pay1.put("extendInfo", "");
		
		final HashMap<String, Object> pay2 = new HashMap<>();
		pay2.put("bizOrderNo", System.currentTimeMillis() + "lpbsa2");
		
		final JSONArray collectPayList2 = new JSONArray();
		final HashMap<String, Object> collect2 = new HashMap<>();
		collect2.put("bizOrderNo", "1587885436506lpac");
		collect2.put("amount", 1L);
		collectPayList2.add(new JSONObject(collect2));
		
		pay2.put("collectPayList", collectPayList2);
		pay2.put("bizUserId", "toplp003");
		pay2.put("accountSetNo", "400221");
		pay2.put("backUrl", "http://test.allinpay.com/yst-notify/zfb/yibu");
		pay2.put("amount", 1L);
		pay2.put("fee", 0L);
		
		final JSONArray batchPayList = new JSONArray();
		batchPayList.add(pay1);
		batchPayList.add(pay2);

		param.put("bizBatchNo", System.currentTimeMillis() + "bap");
		param.put("batchPayList", batchPayList);
		param.put("tradeCode", "2003");

		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.batchAgentPay", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
