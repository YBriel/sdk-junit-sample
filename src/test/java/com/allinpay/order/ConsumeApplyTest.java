/**
 * 
 */
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

/**
 * @author Julie
 *
 */
public class ConsumeApplyTest extends JuintTest{

	/**
	 * 消费申请
	 */
	@Test
	public void consumeApply() {
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
		realnamePay.put("amount", 200L);
		
		//账户余额
		JSONArray BALANCE = new JSONArray();
		HashMap<String, Object> balancePay = new HashMap<>();
		balancePay.put("accountSetNo", "400221");
		balancePay.put("amount", 10L);
		BALANCE.add(balancePay);
		//收银宝H5
		HashMap<String, Object> H5_CASHIER_VSP = new HashMap<>();
		H5_CASHIER_VSP.put("amount", 1);
		H5_CASHIER_VSP.put("limitPay", "no_credit");

		// 组装支付方式
		final HashMap<String, Object> payMethod = new HashMap<>();
		//payMethod.put("REALNAMEPAY", realnamePay);
		//payMethod.put("BALANCE", BALANCE);
		payMethod.put("H5_CASHIER_VSP", H5_CASHIER_VSP);
		
		// *** split rule
		final JSONArray splitRule = new JSONArray();

		final HashMap<String, Object> splitRule1 = new HashMap<>();
		splitRule1.put("bizUserId", "toplp003");
		splitRule1.put("accountSetNo", "400221");
		splitRule1.put("amount", 2L);
		splitRule1.put("fee", 0L);
		splitRule1.put("remark", " 消费一级分账");

		final JSONArray splitRule2List1 = new JSONArray();
		final HashMap<String, Object> splitRule2List = new HashMap<>();
		splitRule2List.put("bizUserId", "renhd001");
		splitRule2List.put("accountSetNo", "200001");
		splitRule2List.put("amount", 20L);
		splitRule2List.put("fee", 0L);
		splitRule2List.put("remark", "消费二级分账");

		splitRule2List1.add(new JSONObject(splitRule2List));

		//splitRule1.put("splitRuleList", splitRule2List1);
		splitRule.add(new JSONObject(splitRule1));

//		request.put("splitRule", splitRule);
		
		param.put("payerId", "toplp001");
		param.put("recieverId", "toplp002");
		param.put("bizOrderNo", System.currentTimeMillis() + "lpcs");
		param.put("amount", 1L);
		param.put("fee", 0L);
		param.put("validateType", 0L);
		param.put("splitRule",splitRule);
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
		param.put("extendInfo", "商户上送扩展信息");

		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.consumeApply", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
