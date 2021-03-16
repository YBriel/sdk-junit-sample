package com.allinpay.member;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class SetCompanyInfoTest extends JuintTest{

	/**
	 * 设置企业信息
	 */
	@Test
	public void setCompanyInfo() {
		final BizParameter param = new BizParameter();
		param.put("bizUserId", "blk0021");
		param.put("backUrl", "http://test.allinpay.com/yst-notify/zfb/yibu");
		param.put("isAuth", false);
		final Map<String, Object> companyBasicInfo = new LinkedHashMap<>();
		companyBasicInfo.put("companyName", "跨境商户企业会员");
		companyBasicInfo.put("companyAddress", "上海浦东新区金沪路");
		companyBasicInfo.put("authType", 1L);
		companyBasicInfo.put("uniCredit", "111111");
		companyBasicInfo.put("businessLicense", "222222");
		companyBasicInfo.put("organizationCode", "333333");
		companyBasicInfo.put("taxRegister", "444444");
		companyBasicInfo.put("expLicense", "2099-1-1");
		companyBasicInfo.put("telephone", "555555");
		companyBasicInfo.put("legalName", "张三");
		companyBasicInfo.put("identityType", 1L);
		companyBasicInfo.put("legalIds", client.encrypt("666666"));
		companyBasicInfo.put("legalPhone", "777777");
		companyBasicInfo.put("accountNo", client.encrypt("6228480402637874215"));
		companyBasicInfo.put("parentBankName", "农业银行");
		companyBasicInfo.put("bankCityNo", "777777");
		companyBasicInfo.put("bankName", "农业银行");
		companyBasicInfo.put("unionBank", "103611001012");
		companyBasicInfo.put("bankCityNo", "");
		companyBasicInfo.put("province", "");
		companyBasicInfo.put("city", "");

		param.put("companyBasicInfo", companyBasicInfo);

		try {
			final OpenResponse response = client.execute("allinpay.yunst.memberService.setCompanyInfo", param);
			if ("OK".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
