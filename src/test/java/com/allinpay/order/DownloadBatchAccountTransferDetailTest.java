package com.allinpay.order;
import com.alibaba.fastjson.JSONObject;
import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;
import com.allinpay.sdk.test.tea.YourParams;
import com.allinpay.sdk.test.tea.AESUtil;
import com.allinpay.sdk.test.tea.CryptoUtil;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Map;

public class DownloadBatchAccountTransferDetailTest extends JuintTest {

	public static byte[] toByteArray(String hexString) {
        if (hexString == null)
            return null;
        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() >> 1];
        int index = 0;
        for (int i = 0; i < hexString.length(); i++) {
            if (index  > hexString.length() - 1)
                return byteArray;
            byte highDit = (byte) (Character.digit(hexString.charAt(index), 16) & 0xFF);
            byte lowDit = (byte) (Character.digit(hexString.charAt(index + 1), 16) & 0xFF);
            byteArray[i] = (byte) (highDit << 4 | lowDit);
            index += 2;
        }
        return byteArray;
    }
	private static PrivateKey getRSAPrivateKey(String pkcs8_rsa_private_key) {
        byte[] keyBytes = pkcs8_rsa_private_key.getBytes();

        String pem = new String(keyBytes);
        pem = pem.replace("-----BEGIN PRIVATE KEY-----", "");
        pem = pem.replace("-----END PRIVATE KEY-----", "");
        pem = pem.replace("\n", "");

        byte [] decoded = Base64.getDecoder().decode(pem);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);

        PrivateKey privateKey = null;

        try {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            privateKey = kf.generatePrivate(spec);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return privateKey;
    }
    /**
     * 批量资金转账回盘下载（C301311）
     */

    public String doRequest(String batchNo)  {

        final BizParameter bizContent = new BizParameter();
//        bizContent.put("fileName", fileName);
        bizContent.put("batchNo", batchNo );
        OpenResponse response=null;
        try {
            response = client.execute("allinpay.elecaccount.appwallet.appservice.downloadBatchAccountTransferDetail", bizContent);
            if ("000000".equals(response.getSubCode())) {
                System.out.println(response.getData());
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }

		Map dataMap = (Map) JSONObject.parseObject(response.getData());
		String randKey = (String)dataMap.get("randKey");
		String contentEnced = (String) dataMap.get("content");
		String content = "";
        try {
//        	String appidPrivKeyStr = "308204bf020100300d06092a864886f70d0101010500048204a9308204a50201000282010100b21fd22ffaeec66ffd998833233506a062079b0224addd1a142cf43071de888984beaf7ae2d2c2a163a84af76f8115cd2ba164e4497276a346a805c58d1eff0af27bf8862a11634753adf4e7d6a985d6818c21a4caf65864fdb250db991c78d109efcf45e7e662564383c71806b8e6cff3f606bef6d32ab435d843dfc867ba87eb9f01241c60700cb2f18b91d0ed417225faff216e874333ccc099348ab1cfbf69330ea86303fcd5461b06667ce642a78adb1dc23588a4635ba61b2bd9ca6f5e522ee3da66309eabc7810731dcd07b82ed7c8231fe8ce55ff0594df846b4e53312f78f2bd3b8d19ba9f3a9bbfc173bf8ae4d2673053ee8338a8226496c19005f020301000102820101009f9c1df6ba6edd479ac1c9a6b104a1d4732307860b21f43e9b1791141be4e10a00f5f13e3723ce1d59b482c0679d0ed1132882c480ffdd48ff562e1dd00f974fd2eabd4e5341d36925957a1f885dcd3ce246941b1b7754cbe1fcb7b19ee8416666f6091045f54de6a886db8f2eeede7c36ca1d4f5ed2e7b025938d76681872ae3bc0ee93c713ad812b74cc9075bca951d098ab1faa8dbd4b558d380aedc545e3f8b641e88c980d1938233f4568a6a406edc27cb7008b78fe9b00a6f68628642ea1a3cc3ecaa647111be8c52fd4a8b4ece14ec979a0d49fcd1378b3f49fd136142db26a36170c66f6fba5283dafb9841472c76b902c5d6f359acbb09be307534902818100dda0bc230c19f2f70810bec51ca8a3eeb90dc3b98dfe6f5b4051d97caef34febe701cea58dcf8d46fcd0dfd027495deaea5e68b6012b15cbe7fdf67a5d1c9d87acac95478e8a89ef40542e3d815ba97912d2bf17179878d3ba22cd3aa486fbe4d33a63cf98f5a89e159fa8a3c1537fe9efd140e81a3f8bfd39a7507abc936f2302818100cdbfde7a9fcc8c352d3c05ccfc787a47888dc8313c11bfdf0a4cf98c4d1152bb8681d0e2744057a4d3c3e423d0df356739893abb74c12fbdd81b69822baefb6d151af2c932efc47bff54c61ea5c33cc6002792911a721cee43ace650bf73e8bb9ed7ded9142d0f823d307f8de799ef219ed722a614c1c855f4a4279a5086fb9502818072c68f28475818efbe098e025eb9274cb6215ebf75bdd2c59b25c8503dfa5be57b98ffffd4d52c011b64c0c3f7d49302d9a552ed0ee5d53fe84129a86d1828acdecbf1f340ea964c853013525eefad70ba42d21b8f68b30a53573a99a8230fc88d6babcd131605e0f8a9da9813c2be77d46eb6027db573360ce98d5042e0c7a9028181009c1090c234da23f3e616e45383a223268576fe461249685fd76161dcc14c8593c6c84b58aa536fe78fd5c40442d83c9acaf2c3c11323c281df1d93df70212f87a37da8716318a9d2606fbe43dafa87ebac8c57c986e4cdfb110c623b17ade4f803d9bca8ae7c2b8a5fbd9cd357bcd4bd8ccda4f39345161fd50c7b19bb41582d02818100915933e52bb037ea6e45654f4cffe99fcfe5022af9c3934371d27bdc9c870fde5db02a04203d78e3596137f2066ec93a23b019881a0ae8b7ca5792c6ff6246023adc0826e1c06b4eec4a7af336b922d88cd130bd9a8e5fb6c311b13d0b874c4c519a0597de3f5e135e539b0872d0671aca2b8fbf458cb4ff030ed9cc6e204acc";
//        	KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        	EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(toByteArray(appidPrivKeyStr));
//		
//			RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(privateKeySpec);
        	//PrivateKey privateKey =  getRSAPrivateKey(YourParams.Your_PKCS8_RSA_Private_Key);

            String Your_Cer_Path = YourParams.Your_Cer_Path;
            String Your_Cer_Pwd = YourParams.Your_Cer_Pwd;
            KeyStore keyStore = CryptoUtil.loadKeyStore(Your_Cer_Path,Your_Cer_Pwd);
            PrivateKey privateKey = CryptoUtil.getPriKey(keyStore,Your_Cer_Pwd);

			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			String pwd = new String( cipher.doFinal(toByteArray(randKey)) );
			
			System.out.println("pwd:" + pwd);
			content = AESUtil.decrypt(toByteArray(contentEnced), new SecretKeySpec(AESUtil.getBaseFromRandKey(pwd), AESUtil.KEY_ALGORITHM));
			System.out.println("content:" + content);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        return  content;
    }
    
    @Test
    public void testMain() {
    	this.doRequest("1591263374241"); //1591263374241
    }
}