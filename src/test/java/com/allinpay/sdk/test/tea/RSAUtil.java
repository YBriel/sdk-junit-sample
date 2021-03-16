package com.allinpay.sdk.test.tea;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

//import org.apache.log4j.Logger;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class RSAUtil {
//	private static Provider provider = new BouncyCastleProvider();
	public static RSAPublicKey publicKey;
	public static RSAPublicKey tlPublicKey;
	public static RSAPrivateKey privateKey;

	/*private static Logger logger = Logger.getLogger(RSAUtil.class);

	static {
		YunPropertiesLoader.load();
	}*/

	private RSAUtil() {
		//
	}

	public static void initPubKey(final RSAPublicKey pubKey) {
		tlPublicKey = pubKey;
	}

	/**
	 * 替代encrypt方法，通过通联公钥加密数据
	 *
	 * @param data
	 * @return
	 * @throws Exception

	public static String encrypt(final String data) throws Exception {
		return byte2hex(encrypt(tlPublicKey, data.getBytes()));
	} */

	/**	public static String decrypt(final String data) throws Exception {
		final Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", new BouncyCastleProvider());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		final byte[] bytes = cipher.doFinal(hex2byte(data));
		return new String(bytes);
	}

	public static String sign(final String text) throws Exception {
		return sign(privateKey, md5(text));
	}

	public static boolean verify(final String text, final String sign) throws Exception {
		return verify(tlPublicKey, text, sign);
	}
	 */
	/**public static String sign(final PrivateKey privateKey, final String text) throws Exception {
		final Signature signature = Signature.getInstance("SHA1WithRSA", provider);

		signature.initSign(privateKey);
		signature.update(text.getBytes("utf8"));
		final byte[] data = signature.sign();
		return Base64.encode(data);
	}

	public static boolean verify(final PublicKey publicKey, String text, final String sign) throws Exception {
		final Signature signature = Signature.getInstance("SHA1WithRSA", provider);
		signature.initVerify(publicKey);
		text = md5(text);
		signature.update(text.getBytes("UTF-8"));
		final byte[] signed = Base64.decode(sign);
		return signature.verify(signed);
	}

	public static String md5(final String src) {
		String result = "";
		try {
			final MessageDigest md = MessageDigest.getInstance("MD5");
			result = Base64.encode(md.digest(src.getBytes("utf-8")));
		} catch (final Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}
*/
	public static PrivateKey loadPrivateKey(String alias, final String path, final String password) throws Exception {
		FileInputStream ksfis = null;
		try {
			final KeyStore ks = KeyStore.getInstance("pkcs12");
			ksfis = new FileInputStream(path);
			final char[] storePwd = password.toCharArray();
			final char[] keyPwd = password.toCharArray();

			ks.load(ksfis, storePwd);
		/*	if (YunUtil.trimStrIsEmpty(alias)) {
				final Enumeration<String> aliases = ks.aliases();
				if (aliases.hasMoreElements()) {
					alias = aliases.nextElement();
				}
			}*/
			return (PrivateKey) ks.getKey(alias, keyPwd);
		} finally {
			if (ksfis != null) {
				ksfis.close();
			}
		}
	}

	public static PublicKey loadPublicKey(final String alias, final String path, final String password)
			throws Exception {
		FileInputStream ksfis = null;
		try {
			final KeyStore ks = KeyStore.getInstance("pkcs12");

			ksfis = new FileInputStream(path);
			final char[] storePwd = password.toCharArray();

			ks.load(ksfis, storePwd);

			return ks.getCertificate(alias).getPublicKey();
		} finally {
			if (ksfis != null) {
				ksfis.close();
			}
		}
	}

	/**
	 * 根据路径加载通联云商通公钥证书
	 *
	 * @param certPath
	 * @return
	 * @throws Exception
	 */
	public static PublicKey loadTLPublicKey(final String certPath) throws Exception {
		FileInputStream certInputStream = null;
		PublicKey pubKey = null;
		final CertificateFactory certificatefactory = CertificateFactory.getInstance("X.509");
		try {
			certInputStream = new FileInputStream(certPath);
			final X509Certificate cert = (X509Certificate) certificatefactory.generateCertificate(certInputStream);
			pubKey = cert.getPublicKey();
		} finally {
			if (certInputStream != null) {
				certInputStream.close();
			}
		}
		return pubKey;
	}

/*	public static RSAPublicKey generateRSAPublicKey(final byte[] modulus, final byte[] publicExponent)
			throws Exception {
		final KeyFactory keyFac = KeyFactory.getInstance("RSA", provider);
		final RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(new BigInteger(modulus),
				new BigInteger(publicExponent));
		return (RSAPublicKey) keyFac.generatePublic(pubKeySpec);
	}

	public static RSAPrivateKey generateRSAPrivateKey(final byte[] modulus, final byte[] privateExponent)
			throws Exception {
		final KeyFactory keyFac = KeyFactory.getInstance("RSA", provider);
		final RSAPrivateKeySpec priKeySpec = new RSAPrivateKeySpec(new BigInteger(modulus),
				new BigInteger(privateExponent));
		return (RSAPrivateKey) keyFac.generatePrivate(priKeySpec);
	}

	public static byte[] encrypt(final Key key, final byte[] data) throws Exception {
		final Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", provider);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(data);
	}

	public static byte[] decrypt(final Key key, final byte[] raw) throws Exception {
		final Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", provider);
		cipher.init(Cipher.DECRYPT_MODE, key);
		return cipher.doFinal(raw);
	}*/

	public static String getPublicKeyString(final RSAPublicKey key) throws Exception {
		final String exponent = byte2hex(key.getPublicExponent().toByteArray());
		final String modulus = byte2hex(key.getModulus().toByteArray());
		final StringBuilder sb = new StringBuilder();
		sb.append(modulus).append(" ").append(exponent);
		return sb.toString();
	}

	public static String getPrivateKeyString(final RSAPrivateKey key) throws Exception {
		final String exponent = byte2hex(key.getPrivateExponent().toByteArray());
		final String modulus = byte2hex(key.getModulus().toByteArray());
		final StringBuilder sb = new StringBuilder();
		sb.append(modulus).append(" ").append(exponent);
		return sb.toString();
	}

	public static String byte2hex(final byte[] bytes) {
		final StringBuilder retString = new StringBuilder();
		for (final byte b : bytes) {
			String hex = Integer.toHexString(b & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			retString.append(hex.toUpperCase());
		}
		return retString.toString();
	}

	public static byte[] hex2byte(String src) {
		if (src.length() % 2 != 0) {
			src = src + "0";
		}
		final byte[] ret = new byte[src.length() / 2];
		final byte[] tmp = src.getBytes();
		for (int i = 0; i < src.length() / 2; i++) {
			ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
		}
		return ret;
	}

	/**
	 * 将两个ASCII字符合成一个字节； 如："EF"--> 0xEF
	 *
	 * @param src0 byte
	 * @param src1 byte
	 * @return byte
	 */
	public static byte uniteBytes(final byte src0, final byte src1) {
		byte b0 = Byte.decode("0x" + new String(new byte[] { src0 })).byteValue();
		b0 = (byte) (b0 << 4);// 左移4bit，变成8位里的高4位
		final byte b1 = Byte.decode("0x" + new String(new byte[] { src1 })).byteValue();// 不左移，保持在低4位
		return (byte) (b0 ^ b1);// 按位异或即可
	}

	/**
	 * 生成三位随机数
	 *
	 * @return
	 */
	public static String getRandomNum() {
		final SecureRandom sr = new SecureRandom();
		return "" + sr.nextInt(10) + sr.nextInt(10) + sr.nextInt(10);
	}

	/**
	 * 验证ip是否合法
	 *
	 * @param ip ip地址
	 * @return ip合法返回true，否则返回false
	 */
	public static boolean ipCheck(final String ip) {
		if (ip != null && !ip.isEmpty()) {
			final String regex = "^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|[1-9])\\."
					+ "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\." + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\."
					+ "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|[1-9])$";
			return ip.matches(regex);
		}
		return false;
	}

	/**
	 * 得到ip的数字，不足三位的在后面补0，调用ipCheck方法之后再调用此方法
	 *
	 * @param ip
	 * @return
	 */
	public static String getIpNum(final String ip) {
		final StringBuilder sb = new StringBuilder();
		final String[] len = ip.split("\\.");
		for (final String s : len) {
			if (s.length() == 3) {
				sb.append(s);
			} else if (s.length() == 2) {
				sb.append(s).append("0");
			} else if (s.length() == 1) {
				sb.append(s).append("00");
			}
		}
		return sb.toString();
	}

	/*public static String base64EncodeData(final RSAPublicKey pubKey, final String data) throws Exception {
		return Base64.encode(encrypt(pubKey, data.getBytes()));
	}
*/
}
