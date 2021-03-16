package com.allinpay.sdk.test.tea.addition;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class SetNotifyUrlTest extends JuintTest {

	/**
	 * 通知地址维护
	 */
	@Test
	public void setNotifyUrl() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "setnotifyurl");
		paramMap.put("custId", "082006031003925");
		paramMap.put("type", "set");
		paramMap.put("notifyType", "1");//1-企业线下划款入账
		paramMap.put("serviceUrl", "http://192.168.13.26:8001/yst-notify/zfb/yibu");

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.setnotifyurl", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
