package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class GenerateVoucher extends JuintTest {

	/**
	 * 转账电子回单
	 */
	@Test
	public void generateVoucher() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "generateVoucher");
		paramMap.put("terminalType", "pc");
		paramMap.put("type", "2");//1:单笔转账  2:批量转账
		//paramMap.put("custId", "080803000053305");//单子回单获取必填
		//paramMap.put("orderId", "20200605160501907793");//单笔转账、担保转账转出、担保转账转入必填
		paramMap.put("batchNo", "lpbatchNo1592295106184");//批量转账单子回单获取必填

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.generateVoucher", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
