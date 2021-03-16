package com.allinpay.sdk.test.tea;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Enumeration;

/**
 *  提供加密、解密、签名、验签功能
 */
public class CryptoUtil {
    /**
     * SHA1withRSA 签名
     * 
     * @param source 签名源串
     * @param pkcs8_rsa_private_key  PEM编码，pkcs8形式的RSA私钥
     * @return 签名
     */
    public static String doSignBySHA1withRSA(String source, String pkcs8_rsa_private_key) {
        PrivateKey privateKey = getRSAPrivateKey(pkcs8_rsa_private_key);
        byte[] sourceData = source.getBytes();
        String result = null;

        try {
            Signature sign = Signature.getInstance("SHA1withRSA");
            sign.initSign(privateKey);
            sign.update(sourceData);
    
            byte[] resultData = sign.sign();
            result = Base64.getEncoder().encodeToString(resultData);

        } catch (Exception e) {
            e.printStackTrace();
        } 

        return result;
    }

    /**
     * SHA1withRSA 签名验签
     * 
     * @param sign 签名串
     * @param source 签名源串
     * @param pkcs8_rsa_public_key PEM编码，pkcs8形式的RSA公钥
     * @return 验签是否通过
     */
    public static boolean doVerifyBySHA1withRSA(String sign, String source, String pkcs8_rsa_public_key) {
        PublicKey publicKey = getRSAPublicKey(pkcs8_rsa_public_key);
        byte[] sourceData = source.getBytes();
        boolean result = false;

        try {
            Signature verify = Signature.getInstance("SHA1withRSA");
            verify.initVerify(publicKey);
            verify.update(sourceData);
    
            byte[] decoded = Base64.getDecoder().decode(sign);
            result = verify.verify(decoded);

        } catch (Exception e) {
            e.printStackTrace();
        } 

        return result;
    }

    /**
     * RSA 公钥加密
     * 
     * @param plainText 明文
     * @param pkcs8_rsa_public_key PEM编码，pkcs8形式的RSA公钥
     * @return 加密后的密文
     */
    public static String doEncryptByRSA(String plainText, String pkcs8_rsa_public_key) {
        PublicKey publicKey = getRSAPublicKey(pkcs8_rsa_public_key);
        byte[] sourceData = plainText.getBytes();
        String result = null;

        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] resultData = cipher.doFinal(sourceData);
            result = Base64.getEncoder().encodeToString(resultData);

        } catch (Exception e) {
            e.printStackTrace();
        } 

        return result;
    }

    /**
     * RSA 私钥解密
     * 
     * @param encryptedText 密文
     * @param pkcs8_rsa_private_key PEM编码，pkcs8形式的RSA私钥
     * @return 解密后的明文
     */
    public static String doDecryptByRSA(String encryptedText, String pkcs8_rsa_private_key) {
        PrivateKey privateKey = getRSAPrivateKey(pkcs8_rsa_private_key);
        byte[] sourceData = Base64.getDecoder().decode(encryptedText);
        String result = null;

        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] resultData = cipher.doFinal(sourceData);
            result = new String(resultData);

        } catch (Exception e) {
            e.printStackTrace();
        } 

        return result;
    }

    /**
     * AES 加密
     * 
     * @param plainText 明文
     * @param AESKey AES密钥
     * @return 加密后的密文
     */
    public static String doEncryptByAES(String plainText, String AESKey) {
        Key key = new SecretKeySpec(AESKey.getBytes(), "AES");
        byte[] resultData = null;

        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
    
            resultData = cipher.doFinal(plainText.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } 

        if (resultData != null) {
            return bytesToHexStr(resultData);

        } else {
            return null;
        }
    }

    /**
     * AES 解密
     * 
     * @param encryptedText 密文
     * @param AESKey AES密钥
     * @return 解密后的明文
     */
    public static String doDecryptByAES(String encryptedText, String AESKey) {
        Key key = new SecretKeySpec(AESKey.getBytes(), "AES");
        byte[] resultData = null;

        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
    
            resultData = cipher.doFinal(hexStrToBytes(encryptedText));

        } catch (Exception e) {
            e.printStackTrace();
        } 

        if (resultData != null) {
            return new String(resultData);

        } else {
            return null;
        }
    }

    /**
     * sha1
     * 
     * @param str 源串
     * @return 摘要
     */
    public static String getSha1(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }
    
    private static PublicKey getRSAPublicKey(String pkcs8_rsa_public_key) {
        byte[] keyBytes = pkcs8_rsa_public_key.getBytes();

        String pem = new String(keyBytes);
        pem = pem.replace("-----BEGIN PUBLIC KEY-----", "");
        pem = pem.replace("-----END PUBLIC KEY-----", "");
        pem = pem.replace("\n", "");

        byte[] decoded = Base64.getDecoder().decode(pem);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);

        PublicKey publicKey = null;

        try {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            publicKey = kf.generatePublic(spec);

        } catch (Exception e) {
            e.printStackTrace();
        } 

        return publicKey;
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


    private static String bytesToHexStr(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);

        for (byte b : bytes) {
            buf.append(String.format("%02x", Integer.valueOf(b & 0xff)));
        }

        return buf.toString();
    }

    private static byte[] hexStrToBytes(String str) {
        if(str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for(int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }


    /**
     * RSA 公钥加密
     *
     * @param plainText 明文
     * @param pkcs8_rsa_public_key PEM编码，pkcs8形式的RSA公钥
     * @return 加密后的密文
     */
    public static String doEncryptByRSA1(String plainText, PublicKey publicKey) {
        //    PublicKey publicKey = getRSAPublicKey(pkcs8_rsa_public_key);
        byte[] sourceData = plainText.getBytes();
        String result = null;

        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] resultData = cipher.doFinal(sourceData);
            result = Base64.getEncoder().encodeToString(resultData);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static KeyStore loadKeyStore(String pfxkeyfile,String password){
        System.out.println("加载签名证书==>" + pfxkeyfile);
        FileInputStream fis = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            fis = new FileInputStream(pfxkeyfile);
            char[] nPassword = password.toCharArray();
            if (null != keyStore) {
                keyStore.load(fis, nPassword);
            }
            return keyStore;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null!=fis)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }
    public static PrivateKey getPriKey(KeyStore keyStore,String password){
        try {
            Enumeration<String> aliasenum  = keyStore.aliases();
            if (aliasenum.hasMoreElements()) {
                String keyAlias = aliasenum.nextElement();
                if (keyStore.isKeyEntry(keyAlias)) {
                    PrivateKey privateKey = (PrivateKey) keyStore.getKey(keyAlias,password.toCharArray());
                    return privateKey;
                }
            }
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
 }

