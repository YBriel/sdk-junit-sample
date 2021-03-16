package com.allinpay.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class QueryInExpDetailTest extends JuintTest{

	/**
	 * 查询账户收支明细
	 */
	@Test
	public void queryInExpDetail() {
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "toplp001");
		param.put("accountSetNo", "400221");
		param.put("dateStart", "2020-04-01");
		param.put("dateEnd", "2020-05-01");
		param.put("startPosition", 1L);
		param.put("queryNum", 10L);
		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.queryInExpDetail", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
