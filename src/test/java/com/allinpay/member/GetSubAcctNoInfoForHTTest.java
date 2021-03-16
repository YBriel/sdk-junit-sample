package com.allinpay.member;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class GetSubAcctNoInfoForHTTest extends JuintTest{
	

	/**
	 * 华通子账号合规信息维护
	 */
	@Test
	public void getSubAcctNoInfoForHT() {
		
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "toplp001");
		param.put("subAcctNo", "12321322243434324");
		param.put("jumpUrl", "https://www.baid.com");
		param.put("backUrl", "http://test.allinpay.com/yst-notify/zfb/yibu");
		
		try {
			final OpenResponse response = client.execute("allinpay.yunst.memberService.getSubAcctNoInfoForHT", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
