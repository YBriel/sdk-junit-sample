package com.allinpay.sdk.test.tea;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * 实现AES加解密
 *
 * @author: xuzongxin
 * @date: 2018/8/21 15:12
 * @description:
 */
public class AESUtil {
//    private static final Logger LOGGER = LoggerFactory.getLogger(AESUtil.class);
 
    private final static byte neiKey[]= {0x11,0x22,0x33,0x44,0x55,0x66,0x77,0x1A,0x2A,0x2B,0x2C,0x2D,0x2E,0x2F,0x3A,0x3B,0x11,0x22,0x33,0x44,0x55,0x66,0x77,0x1A,0x2A,0x2B,0x2C,0x2D,0x2E,0x2F,0x3A,0x3B};
    
    public static final String KEY_ALGORITHM = "AES";
    private static final String CHAR_SET = "UTF-8";
    /**
     * AES的密钥长度
     */
    private static final Integer SECRET_KEY_LENGTH = 128;
    /**
     * 加解密算法/工作模式/填充方式
     */
//    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    
 
    /**
     * AES加密操作
     *
     * @param content  待加密内容
     * @param password 加密密码
     * @return 返回Base64转码后的加密数据
     */
    public static byte[] encrypt(String content, byte[] password) {
        if (content == null || password  == null) {
            return null;
        }
        try {
            //创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            byte[] byteContent = content.getBytes(CHAR_SET);
            //初始化为加密密码器
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));
            byte[] encryptByte = cipher.doFinal(byteContent);
            return encryptByte;
        } catch (Exception e) {
        	e.printStackTrace();
//            LOGGER.error("AES encryption operation has exception,content:{},password:{}", content, password, e);
        }
        return null;
    }
    
    /**
     * AES加密操作
     *
     * @param content  待加密内容
     * @param password 加密密码
     * @return 返回Base64转码后的加密数据
     */
    public static byte[] encrypt(String content, Key password) {
        if (content == null || password  == null) {

//            LOGGER.error("AES encryption params is null");
            return null;
        }
        try {
            //创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            byte[] byteContent = content.getBytes(CHAR_SET);
            //初始化为加密密码器
            cipher.init(Cipher.ENCRYPT_MODE, password);
            byte[] encryptByte = cipher.doFinal(byteContent);
            return encryptByte;
        } catch (Exception e) {
        	e.printStackTrace();
//            LOGGER.error("AES encryption operation has exception,content:{},password:{}", content, password, e);
        }
        return null;
    }
 
    
    /**
     * AES解密操作
     *
     * @param encryptContent 加密的密文
     * @param password       解密的密钥
     * @return
     */
    public static String decrypt(byte[] encryptByte, byte[] password) {
//    	System.out.println("decrypt encryptByte:" + Hex.encodeHexString(encryptByte));
//    	System.out.println("decrypt password:" + Hex.encodeHexString(password));
        if (encryptByte == null || password == null) {
//            LOGGER.error("AES decryption params is null");
            return null;
        }
        try {
        	return decrypt(encryptByte, getSecretKey(password));
        } catch (Exception e) {
        	e.printStackTrace();
//            LOGGER.error("AES decryption operation has exception,content:{},password:{}", encryptByte, password, e);
        }
        return null;
        
    }
    
    /**
     * AES解密操作
     *
     * @param encryptContent 加密的密文
     * @param password       解密的密钥
     * @return
     */
    public static String decrypt(String encryptContent, byte[] password) {
        if ( encryptContent == null || password == null) {
//            LOGGER.error("AES decryption params is null");
            return null;
        }
        return decrypt(Base64.getDecoder().decode(encryptContent), password);
    }
    
    /**
     * AES解密操作
     *
     * @param encryptContent 加密的密文
     * @param password       解密的密钥
     * @return
     */
    public static String decrypt(byte[] encryptByte, Key password) {
        if (encryptByte == null || password == null) {
//            LOGGER.error("AES decryption params is null");
            return null;
        }
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, password);
            //执行解密操作
            byte[] result = cipher.doFinal(encryptByte);
            return new String(result, CHAR_SET);
        } catch (Exception e) {
        	e.printStackTrace();
//            LOGGER.error("AES decryption operation has exception,content:{},password:{}", encryptByte, password, e);
        }
        return null;
    }
    
    /**
     * 仅用于密码控件AES解密操作
     *
     * @param encryptContent 加密的密文
     * @param randKey       解密的随机数
     * @return
     */
    public static String decryptForH5KeyBord(String encryptContent, String randKey) {
        if ( encryptContent == null ||randKey == null ) {
//            LOGGER.error("AES decryption params is null");
            return null;
        }
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(getBaseFromRandKey(randKey), KEY_ALGORITHM));
            //执行解密操作
            byte[] result = cipher.doFinal(Base64.getDecoder().decode(encryptContent));
            return new String(result, CHAR_SET);
        } catch (Exception e) {
//            LOGGER.error("AES decryption operation has exception,content:{},password:{}", encryptContent, randKey, e);
        }
        return null;
    }
    
    /**
     * 仅用于密码控件AES解密操作
     *
     * @param encryptContent 加密的密文
     * @param randKey       解密的随机数
     * @return
     */
    public static byte[] encryptForH5KeyBord(String encryptContent, String randKey) {
        if ( encryptContent == null || randKey == null ) {
//            LOGGER.error("AES encryptForH5KeyBord params is null");
            return null;
        }
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //设置为解密模式
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(getBaseFromRandKey(randKey), KEY_ALGORITHM));
            //执行解密操作
            byte[] result = cipher.doFinal(encryptContent.getBytes());
            return result;
        } catch (Exception e) {
        	e.printStackTrace();
//            LOGGER.error("AES encryptForH5KeyBord operation has exception,content:{},password:{}", encryptContent, randKey, e);
        }
        return null;
    }
 
    private static SecretKeySpec getSecretKey(final byte[] password) throws NoSuchAlgorithmException {
        //生成指定算法密钥的生成器
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        keyGenerator.init(SECRET_KEY_LENGTH, new SecureRandom(password));
        //生成密钥
        SecretKey secretKey = keyGenerator.generateKey();
        //转换成AES的密钥
        return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
    }
    
    public static byte[]  getBaseFromRandKey(String randKey) {
			char[] sKey = randKey.toCharArray();
			byte[] fkey= new byte[16];
			for(int i=0;i<sKey.length;i++){
				fkey[i] = (byte) (sKey[i]^neiKey[i]);
				if( i == 15) {
					break;
				}
			}
			
			String baseKey = Base64.getEncoder().encodeToString(fkey);
//			System.out.println("baseKey:" +baseKey);
//			fkey=fkey.substr(0,fkey.length-16);
			return fkey;
    }
 
    public static void main(String[] args) throws Exception {
        String str = "Hello World";
        System.out.println("str:" + str);
 
        String encryptStr = Base64.getEncoder().encodeToString(encrypt(str, "aa7889d3-435b-4ed2-99f9-08035661eda9".getBytes()));
        System.out.println("encrypt:" + encryptStr);
 
        String decryptStr = decrypt(encryptStr, "aa7889d3-435b-4ed2-99f9-08035661eda9".getBytes());
        
        System.out.println("decryptStr:" + decryptStr);
        
        str = "aaaaaa";
        
        String randKey = "S7oCTtakDLimbxVdCCgF2v9tRt6w5jd2";
        String baseKey = "QhVcBwESFnFuZ0VATFdsXw==";
        encryptStr = Base64.getEncoder().encodeToString(encrypt(str, getBaseFromRandKey(randKey)));
        System.out.println("encrypt:" + encryptStr);
        randKey= "rzOURJNghyoFdCQCnDHNzcLHatedfKu4";
        encryptStr="sUJ0nz5A9pXklUsy8c/1UQqYtFxaT6GYUfN4WzRQ9busxoFETtO/Fkm4bTeplpEFJZRdueI0IZ2kaSwZrC3ADKH+n3lOgEyhRwNMgmCeU+CUsbmE3DOH95FmRP+1dzlMifCg8njGYtth5lbT+kQFx+A1r3U65RbOfKU4LQVDzKBnpVXwKnNooznKnkpICkloGD2iPyyiZ2Axb13ry+4hLO8nrN4ft5ZNOo+SMyaowrg=";
        decryptStr = decryptForH5KeyBord(encryptStr, randKey);
        System.out.println("decryptStr:" + decryptStr);
    }
 
}
//版权声明：本文为CSDN博主「Martiny66」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/xzx4959/article/details/81951037