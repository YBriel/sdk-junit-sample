package com.allinpay.order;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class WithdrawApplyTest extends JuintTest{

	/**
	 * 提现申请
	 */
	@Test
	public void withdrawApply() {
		
		//电子账户代付
		HashMap<String, Object> WITHDRAW_TEA = new HashMap<>();
		WITHDRAW_TEA.put("amount", "1");
//		WITHDRAW_TEA.put("unionBank", "308290003159");
//		WITHDRAW_TEA.put("bankName", "招商银行股份有限公司上海大连路支行");
//		WITHDRAW_TEA.put("province", "");//
//		WITHDRAW_TEA.put("city", "");
		
		// 组装支付方式
		HashMap<String, Object> payMethod = new HashMap<>();
		//payMethod.put("WITHDRAW_TLT", WITHDRAW_TLT);
		//payMethod.put("WITHDRAW_SD", WITHDRAW_SD);
		//payMethod.put("VIRTUAL_OUT", VIRTUAL_OUT);
		//payMethod.put("WITHDRAW_JFB", WITHDRAW_JFB);
		//payMethod.put("WITHDRAW_HTBANK", WITHDRAW_HTBANK);
		payMethod.put("WITHDRAW_TEA", WITHDRAW_TEA);
					
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 15);
		final Date date = calendar.getTime();
		final String orderExpireDatetime = sdf.format(date);
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "dashabi");
		param.put("bizOrderNo", System.currentTimeMillis() + "lpwd");
		param.put("accountSetNo", "400193");
		param.put("amount", 1L);
		param.put("fee", 0L);
		param.put("validateType", 0L);
		//param.put("payMethod", JSONObject.toJSON(payMethod));
		param.put("backUrl", "http://test.allinpay.com/yst-notify/zfb/yibu");
		param.put("orderExpireDatetime", orderExpireDatetime);
		param.put("bankCardNo", client.encrypt("6217582000020319455"));
		param.put("bankCardPro", 0L);
		param.put("withdrawType", "D0");
		param.put("industryCode", "1010");
		param.put("industryName", "保险代理");
		param.put("source", 2L);
		param.put("summary", "withdraw");
		param.put("extendInfo", "扩展参数");

		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.withdrawApply", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
