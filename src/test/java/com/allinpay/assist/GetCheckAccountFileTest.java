package com.allinpay.assist;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class GetCheckAccountFileTest extends JuintTest {

	/**
	 * 商户集合对账文件下载
	 */
	@Test
	public void queryReserveFundBalance() {
		final BizParameter param = new BizParameter();
		
		param.put("date", "20200424");
		param.put("fileType", 2L);//1-明细    2-汇总

		
		try {
			final OpenResponse response = client.execute("allinpay.yunst.merchantService.getCheckAccountFile", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
