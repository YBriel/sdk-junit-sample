package com.allinpay.sdk.test.tea;

public class YourParams {

	 /*测试*/
  public static final String Allinpay_Cer_Path = "classpath:\\pfx\\TLCert.cer";//电子账户通联公钥，转账加密
    public static final String Your_Cer_Path = "classpath:\\pfx\\1265270846692298753.pfx";//商户私钥，回盘下载解密
   public static final String Your_Cer_Pwd = "123456";


	// //生产
 //   public static final String Allinpay_Cer_Path = "C:\\workSpace\\eclipseWorkSpace\\sdk-junit-sample-new\\pfx1\\TLCertdzts.cer";
 //    public static final String Your_Cer_Path = "C:\\workSpace\\eclipseWorkSpace\\sdk-junit-sample-new\\pfx\\1252162491785977857.pfx";
 //    public static final String Your_Cer_Pwd = "123456";

    //生产-批量转账加解密验证
  /*  public static final String Allinpay_Cer_Path = "C:\\workSpace\\eclipseWorkSpace\\sdk-junit-sample-new\\pfx1\\TLCertdzts.cer";
    public static final String Your_Cer_Path = "C:\\workSpace\\eclipseWorkSpace\\sdk-junit-sample-new\\pfx1\\1288296868232126466.pfx";
    public static final String Your_Cer_Pwd = "123456";*/
}