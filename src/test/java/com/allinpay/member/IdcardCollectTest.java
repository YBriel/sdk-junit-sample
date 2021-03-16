package com.allinpay.member;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;
import com.allinpay.sdk.test.tea.BusinessUtil;

public class IdcardCollectTest extends JuintTest{
	
	/**
	 * 影印件采集
	 */
	@Test
	public void idcardCollect() {
		
		String picture = BusinessUtil.JPGToBase64("D:\\workspace\\yunst-sdk-junit-2.0\\pic\\certFront.jpg");
		
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "topep001");
		param.put("picType", 1L);
		param.put("picture", picture);
		
		try {
			final OpenResponse response = client.execute("allinpay.yunst.memberService.idcardCollect", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
