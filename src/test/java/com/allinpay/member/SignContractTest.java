package com.allinpay.member;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class SignContractTest extends JuintTest{

	/**
	 * 电子会员签约
	 */
	@Test
	public void signContract() {
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "toplp002");
		param.put("jumpUrl", "http://ceshi.allinpay.com");
		param.put("backUrl", "https://www.baidu.com");
		param.put("source", 2L);
		try {
			//非小程序跳转
		   final String url = client.concatUrlParams("allinpay.yunst.memberService.signContract", param);
		   System.out.println(url);
		   browser(url);// 打开浏览器
		   
		   //小程序跳转
//		   String contractUrl = "https://protocol6.allinpay.com/yuncallback/member/signContract.html?";
//		   final OpenResponse response = client.execute("allinpay.yunst.memberService.signContract", param);
//		   String params = JSON.parseObject(response.getData()).getString("param");
//		   browser(contractUrl+params);
//		  } catch (final Exception e) {
//		   e.printStackTrace();
//		  }
//		System.out.println(url);
//		browser(url);// 打开浏览器
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
