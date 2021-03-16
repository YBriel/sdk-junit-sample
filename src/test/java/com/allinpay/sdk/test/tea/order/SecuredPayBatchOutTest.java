package com.allinpay.sdk.test.tea.order;

import java.util.HashMap;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class SecuredPayBatchOutTest extends JuintTest {

	/**
	 * 担保转账转出申请
	 */
	@Test
	public void orderRefundQuery() {
		JSONArray receiveList = new JSONArray();
		HashMap<String, Object> receiver1 = new HashMap<String, Object>();
		receiver1.put("receiveAmt", "4");
		receiver1.put("targetCustId", "200604597378856");//191216542808913  
		receiver1.put("custName", "李平");
		receiveList.add(receiver1);
		
		HashMap<String, Object> receiver2 = new HashMap<String, Object>();
		receiver2.put("receiveAmt", "200");
		receiver2.put("targetCustId", "191225546617166");//191225546617166  
		receiver2.put("custName", "李平");
		//receiveList.add(receiver2);
		
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "securedPayBatchOut");
		paramMap.put("orderNo","lpspb" + System.currentTimeMillis());
		paramMap.put("sourceCustId","082006041001691"); //转出客户号191118550850207    080803000053305  081912131000080
		paramMap.put("transferAmt","4"); //转出金额
		paramMap.put("addFee","0");//
		paramMap.put("jumpUrl","https://www.baidu.com/");
		paramMap.put("serviceUrl","http://192.168.13.26:8001/yst-notify/zfb/yibu");
		paramMap.put("receiveList",receiveList);
		
		

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.securedPayBatchOut", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}


}
