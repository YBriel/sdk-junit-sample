package com.allinpay.sdk.test.tea.order;

import java.util.HashMap;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class SecuredBatchPay extends JuintTest {

	/**
	 * 批量担保转账转入
	 */
	@Test
	public void orderRefundQuery() {	
		JSONArray receiveList = new JSONArray();
		HashMap<String, Object> receiver1 = new HashMap<String, Object>();
		receiver1.put("orderNo", "lpsbbs1" + System.currentTimeMillis());
		receiver1.put("receiveAmt", "1");
		receiver1.put("targetCustId", "200604597378856");
		receiver1.put("custName", "李平");
		receiver1.put("remark", "担保转账-批量转入1");
		receiveList.add(receiver1);
		
		HashMap<String, Object> receiver2 = new HashMap<String, Object>();
		receiver2.put("orderNo", "lpsbbs2" + System.currentTimeMillis());
		receiver2.put("receiveAmt", "1");
		receiver2.put("targetCustId", "191225546617166");
		receiver2.put("custName", "李平");
		receiver2.put("remark", "担保转账-批量转入2");
		//receiveList.add(receiver2);
		
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "securedBatchPay");
		paramMap.put("batchNo","lpsbb" + System.currentTimeMillis());
		paramMap.put("tlOrderNo","20200605143749100001"); //源担保转出通联订单号
		paramMap.put("totalreceiveAmt","1"); //总转入金额
		paramMap.put("serviceUrl","http://192.168.13.26:8001/yst-notify/zfb/yibu");
		paramMap.put("receiveList",receiveList);
		
		

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.securedBatchPay", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
