/**
 * create this file at 下午4:35:35 by renhd.
 */
package com.allinpay.sdk.test;


import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;

/**
 * 通联开放平台行业分账产品 辅助类测试demo 详细参考通商云开放平台接口规范
 *
 *
 */
public class AssistApiTest extends JuintTest {

	/**
	 * 通联通头寸查询
	 */
	@Test
	public void queryReserveFundBalance() {
		final BizParameter param = new BizParameter();
		param.put("sysid", "100000000002");
		try {
			final OpenResponse response = client.execute("allinpay.yunst.merchantService.queryReserveFundBalance", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	

}
