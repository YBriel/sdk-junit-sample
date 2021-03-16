package com.allinpay.order;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class CrossBorderWithdrawApplyTest extends JuintTest{

	/**
	 * 提现申请
	 */
	@Test
	public void withdrawApply() {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 15);
		final Date date = calendar.getTime();
		final String orderExpireDatetime = sdf.format(date);
		
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "toplp001");
		param.put("bizOrderNo", System.currentTimeMillis() + "lpwd");
		param.put("accountSetNo", "400221");
		param.put("amount", 5L);
		param.put("fee", 0L);
		param.put("validateType", 0L);
		param.put("backUrl", "http://test.allinpay.com/yst-notify/zfb/yibu");
		param.put("orderExpireDatetime", orderExpireDatetime);
		param.put("crossBorderbizUserId", "topep001");
		param.put("bankCardNo", client.encrypt("6228480402637874215"));
		param.put("bankCardPro", 1L);
		param.put("withdrawType", "D0");
		param.put("industryCode", "1010");
		param.put("industryName", "保险代理");
		param.put("source", 2L);
		param.put("summary", "withdraw");
		param.put("extendInfo", "this is extendInfo");

		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.crossBorderWithdrawApply", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
