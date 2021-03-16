package com.allinpay.sdk.test.tea.order;

import org.junit.Test;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;

public class GetBatchAccountTransferDetail extends JuintTest {

	/**
	 * 批量资金转账查询
	 */
	@Test
	public void getBatchAccountTransferDetail() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "C301311");
		//paramMap.put("batchNo", "1591842525838");
		paramMap.put("custId", "082006041001691");
		//paramMap.put("fileStatus", "0");
		paramMap.put("beginDate", "20200611");
		paramMap.put("endDate", "20200611");

		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.appservice.getBatchAccountTransferDetail", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
