/**
 * create this file at 下午2:12:44 by renhd.
 */
package com.allinpay.sdk.test;

import java.lang.reflect.Method;

import org.junit.Before;

import com.allinpay.sdk.OpenClient;
import com.allinpay.sdk.bean.OpenConfig;

/**
 * junit 测试demo示例
 *
 * @author 任海东 2020年1月10日
 *
 */
public class JuintTest {

	protected OpenClient client;

	@Before
	public void configClient() {
		//平台账户测试环境
//		final String url = "http://test.allinpay.com/op/gateway";
//		//final String url = "http://192.168.13.80:8888/gateway";//内网浏览器ip换成：192.168.14.165:8080
//		final String appId = "1250978269474349057";
//		final String secretKey = "4Ue2o3YxIHfUZSgHMVR2FNpx76dR2g1F";
//		final String privateKeyPath = "D:\\workspace\\sdk-junit-sample\\pfx\\1250978269474349057.pfx";
//		final String pwd = "123456";
//		final String tlPublicKey = "D:\\workspace\\sdk-junit-sample\\pfx\\云开放平台测试证书.cer";
		
		//平台账户商户测试应用-测试环境
		/*final String url = "http://test.allinpay.com/op/gateway";
		final String appId = "1581648210684";
		final String secretKey = "WaHVZNHZYX3v4si1bBTVseIwEMPMcKzL";
		final String privateKeyPath = "D:\\workspace\\sdk-junit-sample\\pfx\\1581648210684.pfx";
		final String pwd = "123456";
		final String tlPublicKey = "D:\\workspace\\sdk-junit-sample\\pfx\\云开放平台测试证书.cer";
		*/
		//电子账户测试环境
		final String url = "https://test.allinpay.com/op/gateway";
		final String appId = "1902271423530473681";
		final String secretKey = "123456";

		final String privateKeyPath = "D:\\项目\\通联\\eleaccountTOP_java_demo_20201010\\eleaccount_java_demo_TOP_20201010\\px3\\1902271423530473681.pfx";
		final String pwd = "123456";
		final String tlPublicKey = "D:\\项目\\通联\\eleaccountTOP_java_demo_20201010\\eleaccount_java_demo_TOP_20201010\\px3\\1902271423530473681.cer";
		
		
//		//生产环境
		// final String url = "https://cloud.allinpay.com/gateway";
  //    	final String appId = "1252162491785977857";
		// final String secretKey = "8L0MJSfssqU12f5zIHCcGNYxJlexYsyF";
		// final String privateKeyPath = "C:\\workSpace\\eclipseWorkSpace\\sdk-junit-sample-new\\pfx\\1252162491785977857.pfx";
  //   	final String pwd = "123456";
		// final String tlPublicKey = "C:\\workSpace\\eclipseWorkSpace\\sdk-junit-sample-new\\pfx1\\topTLCert.cer";
		
//		//生产环境-测批量转账加解密
		/*final String url = "https://cloud.allinpay.com/gateway";
		final String appId = "1288296868232126466";
		final String secretKey = "mnTQ92e0h3U5GuhdmdIYFOjlqIGSlffT";
		final String privateKeyPath = "C:\\workSpace\\eclipseWorkSpace\\sdk-junit-sample-new\\pfx1\\1288296868232126466.pfx";
		final String pwd = "123456";
		final String tlPublicKey = "C:\\workSpace\\eclipseWorkSpace\\sdk-junit-sample-new\\pfx1\\TLCert.cer";*/
		
		//生产环境--迁移
//		final String url = "https://cloud.allinpay.com/gateway";
//		final String appId = "1902141108045931770";
//		final String secretKey = "oeDtSWRL2hPbCI38x8S9XCMvfjXogWNG";
//		final String privateKeyPath = "D:\\workspace\\sdk-junit-sample\\pfx\\1902141108045931770.pfx";
//		final String pwd = "123456";
//		final String tlPublicKey = "D:\\workspace\\sdk-junit-sample\\pfx\\TLCert.cer";
		
		final OpenConfig oc = new OpenConfig(url, appId, secretKey, privateKeyPath, pwd, tlPublicKey);
		//电子账户专用开始
		oc.setVersion("2.0");
		//电子账户专用结束
		try {
			client = new  OpenClient(oc);
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 打开默认浏览器，支持苹果和windows
	 *
	 * @param url
	 */
	protected void browser(final String url) {
		try {
			final String osName = System.getProperty("os.name");
			if (osName.startsWith("Windows")) {
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler  " + url);
			} else if (osName.startsWith("Mac OS")) {
				final Class<?> fileMgr = Class.forName("com.apple.eio.FileManager");
				final Method openURL = fileMgr.getDeclaredMethod("openURL", new Class[] { String.class });
				openURL.invoke(null, new Object[] { url });
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
