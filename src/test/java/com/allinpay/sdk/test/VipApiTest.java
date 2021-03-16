/**
 * create this file at 下午4:35:35 by renhd.
 */
package com.allinpay.sdk.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;

/**
 * 通联开放平台行业分账产品 特权类接口测试demo 详细参考通商云开放平台接口规范
 *
 * @author 任海东 2020年1月10日
 *
 */
public class VipApiTest extends JuintTest {

	/**
	 * 特权会员订单查询
	 */
	@Test
	public void vipGetOrderPaymentDetail() {
		final BizParameter param = new BizParameter();
		param.put("privBizUserId", "32ec6cdb-eb26-4021-bb69-810ac5513e34");
		param.put("sysid", "1902271423530473681");//特权会员可查询的应用
		param.put("bizOrderNo", "473193726871356439");//商户订单号
		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.vipGetOrderPaymentDetail", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	

}
