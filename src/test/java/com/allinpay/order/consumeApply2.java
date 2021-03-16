/**
 * create this file at 下午4:35:35 by renhd.
 */
package com.allinpay.order;

import java.util.HashMap;
import java.util.Random;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

/**
 * 通联开放平台行业分账产品 会员类接口测试demo 详细参考通商云开放平台接口规范
 *
 * @author 任海东 2020年1月10日
 *
 */
public class consumeApply2 extends JuintTest {

	/**
	 * 创建会员
	 */
	@Test
	public void depositApply() {
		
//		// 支付方式
//		//微信扫码支付(正扫) _集团
//		HashMap<String, Object> SCAN_ALIPAY = new HashMap<>();
//		SCAN_ALIPAY.put("vspCusid", "55058404816VQLX");
//		SCAN_ALIPAY.put("amount", 2);
//		SCAN_ALIPAY.put("limitPay", "no_credit");
		
		// 支付方式
		//微信扫码支付(正扫) _集团
		JSONArray balancePay = new JSONArray();
		JSONObject balance = new JSONObject();
		balance.put("accountSetNo", "400221");
		balance.put("amount", 2);
		balance.put("limitPay", "no_credit");
		balancePay.add(balance);
		
		
		HashMap<String, Object> H5_CASHIER_VSP = new HashMap<>();
		H5_CASHIER_VSP.put("amount", 1);
		H5_CASHIER_VSP.put("limitPay", "no_credit");
		
		HashMap<String, Object> payMethod = new HashMap<>();
		//payMethod.put("BALANCE", balancePay);
		payMethod.put("H5_CASHIER_VSP", H5_CASHIER_VSP);
		
		final BizParameter param = new BizParameter();
		param.put("recieverId", "toplp002");
		param.put("payerId", "toplp001"); //zhuyqgr0220b//#yunBizUserId_B2C#
//		param.put("receiverId", "zhuyqg1111r11330616121"); //zhuyqgr0220b//#yunBizUserId_B2C#
		param.put("bizOrderNo", getBizOrderNo());
		//request.put("accountSetNo", "2000000");  //2.0生产账户集
		//request.put("accountSetNo", "100002");
		//request.put("accountSetNo", "200002");//验收环境100000000003应用
		//param.put("accountSetNo", "400221"); //1909041340379149566:400111 //200126
		param.put("amount", 1L);
		param.put("fee", 1);
		param.put("validateType", 0L);
		param.put("frontUrl", "http://mallplus.mschn.cn/index.html#/pages/order/paySuccess?bizOrderNo=2020090310535636930816xf");
		param.put("backUrl", "http://test.allinpay.com/yst-notify/zfb/yibu");
		//param.put("ordErexpireDatetime", ordErexpireDatetime);
		param.put("payMethod", JSONObject.toJSON(payMethod));
		param.put("goodsName", "computer");
		param.put("industryCode", "1010");
		param.put("industryName", "保险代理");
		param.put("name", "诸燕青");
		param.put("source", 2L);
		param.put("summary", "deposit");
		param.put("extendInfo", "this is extend111Inf11XXXo");			
		try {
			final OpenResponse response = client.execute("allinpay.yunst.orderService.consumeApply", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private  String getBizOrderNo() {
		return System.currentTimeMillis() +new Random().nextInt(99999) + "at";
	}
}
