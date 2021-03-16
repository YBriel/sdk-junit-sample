/**
 * create this file at 下午4:35:35 by renhd.
 */
package com.allinpay.sdk.test.tea;

import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;
import org.junit.Test;

/**
 * 通联开放平台电子账户产品 接口测试demo
 *
 * @author 罗剑 2020年5月26日
 *
 */
public class elecApiTest extends JuintTest {

	/**
	 * 发送短信验证码
	 */
	@Test
	public void sendMsg() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "B1013_0000_01");
		paramMap.put("phone", "13611853096");
		paramMap.put("smsTemplateType", "dz01");
		paramMap.put("smsType", "0");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.sendSms", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void CustRegister() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "custRegister");
		paramMap.put("custType", "U");
		paramMap.put("mobile", "13611853096");
		paramMap.put("smsCode", "111111");
		paramMap.put("smsSeqNo", "2005261429243625");
		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.custRegister", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void accountTransfer() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "B1006_0004_92");
		paramMap.put("targetCustId", "200224550949700");
		paramMap.put("sourceCustId", "200224550949700");
		paramMap.put("orderNo", "22222222222");
		paramMap.put("transferType", "B2C");
		paramMap.put("custName", "诸燕青");
		paramMap.put("amtType", "1");
		paramMap.put("bizType", "0101");
		paramMap.put("transferAmt", "1");
		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.accountTransfer", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void acqpayapply() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "acqpayapply");
		paramMap.put("custId", "200224550949700" );
		paramMap.put("orderAmount", "1" );
		paramMap.put("orderNo", "202004021000100004" );
		paramMap.put("orderAmount", "1" );
		paramMap.put("bizType", "12" );
		paramMap.put("subBizType", "1201" );
		paramMap.put("orderDatetime", "202004021212" );
		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.acqpayapply", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void acqrefundapply() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "acqrefundapply");
		paramMap.put("custId", "200224550949700" );
		paramMap.put("orderAmount", "1" );
		paramMap.put("mchtRefundOrderNo", "202004021000100004" );
		paramMap.put("orderNo", "202004021000100004" );
		paramMap.put("orderAmount", "1" );
		paramMap.put("refundAmount", "1" );
		paramMap.put("orderDatetime", "202004021212" );
		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.acqrefundapply", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void applyBankCardBind() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "B1002_0100_01");
		paramMap.put("custTypecardType", "U");
		paramMap.put("custId", "200224550949700" );
		paramMap.put("cardNo", "6214850212623075");
		paramMap.put("mobile", "13611853095" );
		paramMap.put("operType", "01");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.applyBankCardBind", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void bankagreementQuery() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "B1002_0200_02");
		paramMap.put("custId", "200224550949700" );
		paramMap.put("agreementType", "02" );

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.bankagreementQuery", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void bankAgreementQuery() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "B1002_0200_02");
		paramMap.put("custId", "200224550949700" );
		paramMap.put("agreementType", "02" );

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.bankAgreementModify", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void batchAccountTransfer() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "batchDf");
		paramMap.put("batchNo", "200224550949700");
		paramMap.put("custId", "200224550949700");
		paramMap.put("content", "200224550949700");
		paramMap.put("randomKey", "200224550949700");
		paramMap.put("orderNo", "22222222222");
		paramMap.put("transferType", "B2C");
		paramMap.put("custName", "诸燕青");
		paramMap.put("fileType", "01");
		paramMap.put("bizType", "0101");
		paramMap.put("transferSumAmt", "1");
		paramMap.put("transferSumCnt", "1");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.bussservice.batchAccountTransfer", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void bindBankCard() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "B1002_0100_03");
		paramMap.put("custTypecardType", "U");
		paramMap.put("custId", "200224550949700" );
		paramMap.put("signSeqNo", "202004021000100004");
		paramMap.put("smsCode", "111111" );
		paramMap.put("operType", "01");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.bindBankCard", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changePassword() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "changePassword");
		paramMap.put("password", "123456");
		paramMap.put("custId", "200224550949700");
		paramMap.put("oldPassword", "123456");
		paramMap.put("newPassword", "123457");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.changePassword", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createConsumeOrder() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "changePassword");
		paramMap.put("password", "123456");
		paramMap.put("custId", "200224550949700");
		paramMap.put("oldPassword", "123456");
		paramMap.put("newPassword", "123457");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.createOrder", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void custInfoQuery() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "custInfoQuery");
		paramMap.put("custType", "M");
		paramMap.put("custId", "082004011000099" );

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.custInfoQuery", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void custInfoModify() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode","custInfoModify");
		//paramMap.put("custType","M");
		paramMap.put("custId","082004151000013");//082002191000011
		paramMap.put("idType","01");
		paramMap.put("idNo","110108195601082211");
		paramMap.put("custName","万建华");
		paramMap.put("idExpDate","2025-10-08");

		paramMap.put("mobile","13601956907");
		paramMap.put("corpbusname","通联支付网络服务股份有限公司");
		paramMap.put("shortname","通联支付网络服务股份有限公司");
		paramMap.put("mccid","");
		//paramMap.put("comproperty","");
		paramMap.put("thrcertflag","1");
		paramMap.put("creditcode","91310000680985471T");
		/*paramMap.put("creditcodeexpire","20201012");
		paramMap.put("regnumber","");
		paramMap.put("regnumberexpire","");
		paramMap.put("organcode","");
		paramMap.put("organexpire","");
		paramMap.put("taxnumer","");
		*/
		paramMap.put("acctid","2900000010120100060018");
		paramMap.put("acctname","通联支付网络服务股份有限公司");
		paramMap.put("accttype","1");
		paramMap.put("accttp","00");
		paramMap.put("cnapsno","316290000019");
		paramMap.put("cnapsname","浙江银行股份有限公司上海分行");
		paramMap.put("address","上海");
		paramMap.put("province","上海");
		paramMap.put("city","上海");
		paramMap.put("email","2287681961@qq.com");
		paramMap.put("contactperson","");
		paramMap.put("contactphone","");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.custInfoModify", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void custRealNameAuth() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "custRealNameAuth");
		paramMap.put("custType", "U");
		paramMap.put("custId", "171011549145558");
		paramMap.put("verifyType", "YYS");//YHK，GSZ，SFZ
		paramMap.put("idType", "01");
		paramMap.put("idNo", "310225198707083434");
		paramMap.put("acctNo", "6214850212623075");
		paramMap.put("mobile", "13611853095");
		paramMap.put("custName", "诸燕青");
		paramMap.put("thrcertflag", "1");
		paramMap.put("corpbusName", "上海叫来河网络科技有限公司");
		paramMap.put("creditcode", "91310115MA1H9AJ015");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.custRealNameAuth", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void custRegisterNoSms() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "custRegisterNoSms");
		paramMap.put("custType", "M");
		paramMap.put("mobile", "13611853095");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.custRegisterNoSms", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void downloadBatchAccountTransferDetail() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "C301316");
		paramMap.put("batchNo", "200224550949700");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.downloadBatchAccountTransferDetail", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void generateRandomKey() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("custId", "200224550949700");
		paramMap.put("serviceCode", "setPassWord");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.generateRandomKey", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void generateVoucher() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "generateVoucher");
		paramMap.put("terminalType", "pc");
		paramMap.put("custId", "200224550949700");
		paramMap.put("orderNo", "200224550949700");
		paramMap.put("batchNo", "200224550949700");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.generateVoucher", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getBatchAccountTransferDetail() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "C301311");
		paramMap.put("batchNo", "200224550949700");
		paramMap.put("custId", "200224550949700");
		paramMap.put("fileStatus", "0");
		paramMap.put("benginDate", "20200401");
		paramMap.put("endDate", "20200402");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.appservice.getBatchAccountTransferDetail", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getMchtBankList() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "getMchtBankList");
		paramMap.put("mchtId", "*");
		paramMap.put("cardType", "00" );

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.getMchtBankList", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void idFileUpload() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "idcardUpload");
		paramMap.put("custId", "200224550949700" );
		paramMap.put("picType", "1" );
		paramMap.put("certFront", "202004021000100004" );
		paramMap.put("certBack", "202004021000100004" );

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.idFileUpload", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void openAcct() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "idcardUpload");
		paramMap.put("custId", "200224550949700" );
		paramMap.put("picType", "1" );
		paramMap.put("certFront", "202004021000100004" );
		paramMap.put("certBack", "202004021000100004" );

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.openAcct", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void queryAcctHisAmt() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "queryaccthisamt");
		paramMap.put("custId", "082004151000013111" );
		paramMap.put("periodDay", "20200514" );

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.elecaccount.appservice.queryAcctHisAmt", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void orderConfirm() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "orderconfirm");
		paramMap.put("orderAmount", "1" );
		paramMap.put("authWay", "1" );
		paramMap.put("tlOrderNo", "211111111222222222221" );

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.orderConfirm", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void orderPayApply() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "B1006_0005_03");
		paramMap.put("orderAmount", "1" );
		paramMap.put("recievercustId", "082004011000099" );
		paramMap.put("payercustId", "200224550949700" );
		paramMap.put("tlOrderNo", "21111111122222222222orderConfirm1" );

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.orderPayApply", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void orderQuery() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "B9990_0003_02");
		paramMap.put("custId", "200224550949700");
		paramMap.put("orderNo", "dz01");
		paramMap.put("tlOrderNo", "0");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.orderQuery", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void orderRefundQuery() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "B9990_0002_01");
		paramMap.put("custId", "200224550949700");
		paramMap.put("mchtRefundOrderNo", "dz01");
		paramMap.put("orderNo", "22222222222");
		paramMap.put("benginTime", "202004021231");
		paramMap.put("endTime", "202004021231");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.orderRefundQuery", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void queryAcctDetail() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "queryacctdetail");
		paramMap.put("acctType", "C001");
		paramMap.put("custId", "200224550949700" );
		paramMap.put("beginDate", "20200402");
		paramMap.put("endDate", "20200402" );
		paramMap.put("pageIndex", "1");
		paramMap.put("pageSize", "1" );

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.queryacctdetail", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void queryAcctInfo() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "queryacctinfo");
		paramMap.put("acctType", "C001");
		paramMap.put("custId", "200224550949700" );

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.queryacctinfo", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void queryAgreeInfo() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "queryagreeinfo");
		paramMap.put("agreementType", "02");
		paramMap.put("custId", "171011549145558" );

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.mcht.queryagreeinfo", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void queryAuthAgreement() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "queryAuthAgreement");
		paramMap.put("pageIndex", "1");
		paramMap.put("pageSize", "10");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.queryAuthAgreement", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void queryBill() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "queryBill");
		paramMap.put("date", "20200402");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.queryBill", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void refundApply() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "refundapply");
		paramMap.put("mchtRefundOrderNo", "21111111122222222222" );
		paramMap.put("refundAmount", "1" );
		paramMap.put("orderDatetime", "21111111122222222222" );
		paramMap.put("orderNo", "21111111122222222222" );
		paramMap.put("custId", "200224550949700" );

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.refundapply", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void releaseMargin() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "releaseMargin");
		paramMap.put("custId", "20200402");
		paramMap.put("custId", "200224550949700");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.releaseMargin", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void resetPayPassword() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "resetPayPassword");
		paramMap.put("password", "123456");
		paramMap.put("custId", "200224550949700");
		paramMap.put("verifyType", "1");
		paramMap.put("smsCode", "123457");
		paramMap.put("smsSeqNo", "123457");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.resetPayPassword", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void setNotifyUrl() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "setnotifyurl");
		paramMap.put("custId", "200224550949700");
		paramMap.put("type", "1");
		paramMap.put("notifyType", "1");
		paramMap.put("serviceUrl", "www.baidu.com");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.setnotifyurl", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void setPassword() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "setPassword");
		paramMap.put("password", "123456");
		paramMap.put("custId", "200224550949700");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.setPassword", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void settlementOnAccount() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "settlementOnAccount");
		paramMap.put("orderAmount", "1");
		paramMap.put("custId", "200224550949700");
		paramMap.put("orderNo", "200224550949700");
		paramMap.put("outSourceType", "02");
		paramMap.put("custName", "诸燕青");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.settlementOnAccount", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void signAuthAgreement() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "signAuthAgreement");
		paramMap.put("orderAmount", "1");
		paramMap.put("custId", "200224550949700");
		paramMap.put("orderNo", "200224550949700");
		paramMap.put("outSourceType", "02");
		paramMap.put("cusid", "1001");
		paramMap.put("validTime", "20200510140811");
		paramMap.put("serviceInfo", "202004021212");
		paramMap.put("jumpUrl", "www.baidu.com");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.signAuthAgreement", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void syncAgreeInfo() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "syncagreeinfo");
		paramMap.put("agreementType", "02");
		paramMap.put("custId", "200224550949700" );

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.mcht.syncagreeinfo", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void unbindBankCard() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "B1002_0100_04");
		paramMap.put("custTypecardType", "U");
		paramMap.put("custId", "200224550949700" );
		paramMap.put("agreementId", "17010210009160");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.unbindBankCard", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void unsignAuthAgreement() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "unsignAuthAgreement");
		paramMap.put("custId", "200224550949700");
		paramMap.put("cusid", "1001");
		paramMap.put("agreementNo", "202004021000100004");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.accountcenter.trans.unsignAuthAgreement", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void userAcctAmtFreeze() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "useracctamtfreeze");
		paramMap.put("custTypecardType", "U");
		paramMap.put("custId", "200224550949700" );
		paramMap.put("orderId", "20200402");
		paramMap.put("amount", "1" );
		paramMap.put("operType", "01");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.useracctamtfreeze", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void userAcctfreeze() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "useracctamtfreeze");
		paramMap.put("custType", "U");
		paramMap.put("custId", "200224550949700" );
		paramMap.put("operType", "02");

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.useracctfreeze", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void userChargeApply() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "idcardUpload");
		paramMap.put("custId", "200224550949700" );
		paramMap.put("orderAmount", "1" );
		paramMap.put("orderNo", "202004021000100004" );
		paramMap.put("orderAmount", "1" );
		paramMap.put("agreementId", "202004021000100004" );
		paramMap.put("outSourceType", "01" );

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.userchargeapply", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void userWithdraw() {
		final BizParameter paramMap = new BizParameter();
		paramMap.put("transCode", "userwithdraw");
		paramMap.put("custId", "200224550949700" );
		paramMap.put("orderAmount", "1" );
		paramMap.put("orderNo", "202004021000100004" );
		paramMap.put("orderAmount", "1" );
		paramMap.put("agreementId", "202004021000100004" );
		paramMap.put("outSourceType", "01" );

		paramMap.put("mchtId","080803000053305");
		paramMap.put("jrlNo","1234566");
		try {
			final OpenResponse response = client.execute("allinpay.elecaccount.paycenter.orderservice.userwithdraw", paramMap);
			if ("000000".equals(response.getSubCode())) {
				System.out.println(response.getData());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
