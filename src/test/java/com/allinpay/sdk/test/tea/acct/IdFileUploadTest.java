package com.allinpay.sdk.test.tea.acct;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

import com.allinpay.sdk.test.tea.BusinessUtil;

public class IdFileUploadTest extends JuintTest {

	/**
	 * 影印件上传
	 */
	@Test
	public void idFileUpload() {
		String corpbuspic = BusinessUtil.JPGToBase64("./pic/WechatIMG1734Corp.jpg");
		String certFront = BusinessUtil.JPGToBase64("./pic/WechatIMG1734F.jpg");
		String certBack = BusinessUtil.JPGToBase64("./pic/WechatIMG1734B.jpg");
		
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "idcardUpload");
		paramMap.put("custType", "M" );
		paramMap.put("custId", "082005271000057" );
		paramMap.put("picType", "1" );
		paramMap.put("certFront", certFront);
		paramMap.put("certBack", certBack);
//		paramMap.put("template", "2" );
//		paramMap.put("corpbuspic", corpbuspic);
//		paramMap.put("icppic", "202004021000100004" );
//		paramMap.put("licensepic", "" );

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.idFileUpload", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
