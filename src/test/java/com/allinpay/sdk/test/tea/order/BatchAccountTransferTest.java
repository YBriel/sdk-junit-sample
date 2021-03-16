package com.allinpay.sdk.test.tea.order;
import com.allinpay.sdk.bean.BizParameter;
import com.allinpay.sdk.bean.OpenResponse;
import com.allinpay.sdk.test.JuintTest;
import com.allinpay.sdk.test.tea.YourParams;
import com.allinpay.sdk.test.tea.AESUtil;
import com.allinpay.sdk.test.tea.CryptoUtil;
import com.allinpay.sdk.test.tea.RSAUtil;
import org.junit.Test;

import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Map;
import java.util.TreeMap;

public class BatchAccountTransferTest  extends JuintTest {
    /**
     * bytes转换成十六进制字符串
     *
     * @param byte[] b byte数组
     * @return String 每个Byte值之间空格分隔
     */
    public static String byte2HexStr(byte[] b) {
        String stmp = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            sb.append((stmp.length() == 1) ? "0" + stmp : stmp);
//            sb.append(" ");
        }
        return sb.toString().toUpperCase().trim();
    }

    public static byte[] toByteArray(String hexString) {
        if (hexString == null)
            return null;
        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() >> 1];
        int index = 0;
        for (int i = 0; i < hexString.length(); i++) {
            if (index > hexString.length() - 1)
                return byteArray;
            byte highDit = (byte) (Character.digit(hexString.charAt(index), 16) & 0xFF);
            byte lowDit = (byte) (Character.digit(hexString.charAt(index + 1), 16) & 0xFF);
            byteArray[i] = (byte) (highDit << 4 | lowDit);
            index += 2;
        }
        return byteArray;
    }

    public static byte[] getBaseFromRandKey(String randKey) {
        byte neiKey[] = {0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x1A, 0x2A, 0x2B, 0x2C, 0x2D, 0x2E, 0x2F, 0x3A, 0x3B, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x1A, 0x2A, 0x2B, 0x2C, 0x2D, 0x2E, 0x2F, 0x3A, 0x3B};

        char[] sKey = randKey.toCharArray();
        byte[] fkey = new byte[16];
        for (int i = 0; i < sKey.length; i++) {
            fkey[i] = (byte) (sKey[i] ^ neiKey[i]);
            if (i == 15) {
                break;
            }
        }

        String baseKey = Base64.getEncoder().encodeToString(fkey);
        System.out.println("baseKey:" + baseKey);
//		fkey=fkey.substr(0,fkey.length-16);
        return fkey;
    }

    private String loadContentFromFile(String filePath) throws Exception {

        String retStr = "X,081911281000024,3,300,6002,6\r\n" +
                "通联支付网络服务股份有限公司,13564610082,91310000680985471T,082004091000090,100,无中间客户,1\r\n" +
                "小猫,13488880090,110101201003073458,191204550875149,100,手续费测试,2\r\n" +
                "任曦,13488880091,140423198906211220,200306550955957,100,手续费,3";
        if (filePath == null || "".equals(filePath)) {
            return retStr;
        }
        try {
            StringBuilder sb = new StringBuilder();

            long start = System.currentTimeMillis();// 开始时间
            int bufSize = 1024;// 1K缓冲区
            File fin = new File(filePath);
            /*
             * 通道就是为操作文件而建立的一个连接。（读写文件、内存映射等） 此处的getChannel()可以获取通道；
             * 用FileChannel.open(filename)也可以创建一个通道。 "r"表示只读。
             *
             * RandomAccessFile是独立与I/O流家族的类，其父类是Object。 该类因为有个指针可以挪动，所以，可以从任意位置开始读取文件数据。
             **/
            FileChannel fcin = new RandomAccessFile(fin, "r").getChannel();
            // 给字节缓冲区分配大小
            ByteBuffer rBuffer = ByteBuffer.allocate(bufSize);
//	        String enterStr = "\n";


            String tempString = null;
            while (fcin.read(rBuffer) != -1) {// 每次读1k到缓冲区
                int rSize = rBuffer.position();// 记录缓冲区当前位置
                rBuffer.rewind();// 位置归零，标记取消，方便下次循环重新读入缓冲区。
                byte[] bs = new byte[rSize];
                rBuffer.get(bs);// 将缓冲区数据读到字节数组中
                rBuffer.clear();// 清除缓冲
                sb.append(new String(bs));

            }
            long end = System.currentTimeMillis();// 结束时间
            System.out.println("传统IO读取数据,指定缓冲区大小，总共耗时：" + (end - start) + "ms");
            retStr = new String(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return retStr;
    }

    private BizParameter prepareData(String mchtId, String pwd, String filePath) throws Exception {


//		String pwdRsaEnced = CryptoUtil.doEncryptByRSA(pwd, YourParams.Allinpay_PKCS8_RSA_Public_Key);
//		System.out.println("pwdRsaEnced:" + pwdRsaEnced);
//
//		String pwdAesEnced = Base64.getEncoder()
//				.encodeToString(AESUtil.encryptForH5KeyBord(pwdRsaEnced, queryPwdRandAesKey(appId, mchtId, "batchDf")));

   //     String pwdAesEnced = simulateH5Board(pwd, queryPwdRandAesKey(appId, mchtId, "batchDf"));
   //     System.out.println("pwdAesEnced:" + pwdAesEnced);

        String aesKey = generateFileRandAesKey();
        System.out.println("aesKey:" + aesKey);
     /*   String aesKeyEnced = byte2HexStr(
     //           Base64.getDecoder().decode(CryptoUtil.doEncryptByRSA(aesKey, YourParams.Allinpay_PKCS8_RSA_Public_Key)));
        */
        PublicKey pubkey = RSAUtil.loadTLPublicKey(YourParams.Allinpay_Cer_Path);
        String aesKeyEnced =  byte2HexStr(
                Base64.getDecoder().decode(CryptoUtil.doEncryptByRSA1(aesKey, pubkey) ) );
        System.out.println("aesKeyEnced:" + aesKeyEnced);
        String fileCont = loadContentFromFile(filePath);

        System.out.println("fileCont:" + fileCont);

        String fileContEned = byte2HexStr(AESUtil.encrypt(fileCont, new SecretKeySpec(getBaseFromRandKey(aesKey), AESUtil.KEY_ALGORITHM)));

        System.out.println("fileContEned:" + fileContEned);

        String fileCont2 = AESUtil.decrypt(toByteArray(fileContEned), new SecretKeySpec(getBaseFromRandKey(aesKey), AESUtil.KEY_ALGORITHM));

        System.out.println("fileCont2:" + fileCont2);

        BizParameter dataMap = new BizParameter();
        dataMap.put("batchNo", System.currentTimeMillis() + "");
        dataMap.put("custId", mchtId);
//        dataMap.put("transCustId", "082005271000057");//中间客户号
//        dataMap.put("transCustName", "通联支付网络股份服务有限公司");//中间客户名称
        dataMap.put("transCode", "batchDf");
        dataMap.put("fileType", "01");
        dataMap.put("fileName", System.currentTimeMillis() + "");
        dataMap.put("transferSumCnt", "1");
        dataMap.put("transferSumAmt", "1");
        dataMap.put("totalAddFee", "1");

        dataMap.put("randomKey", aesKeyEnced);
        dataMap.put("content", fileContEned);
        //	dataMap.put("payPwd", pwdAesEnced);
        dataMap.put("remark", "tstRemark");
        dataMap.put("serviceUrl", "http://test.allinpay.com/yst-notify/zfb/yibu");
        dataMap.put("version", "2.0");
        dataMap.put("businessCode", "6002");
       // dataMap.put("transSignType", "");
//
//        dataMap.put("transCustId", "082002101000191");
//        dataMap.put("transCustName", "上海卡梅拉信息技术有限公司");

	/*	dataMap.put("transCustId", "080803000053305");
		dataMap.put("transCustName", "电子账户商户入网1234");*/

        String source = getSourceString(dataMap);
        System.out.println("accountTransfer_API source : " + source);

        return dataMap;

    }

    /**
     * 模拟密码控件   --返回加密后的密文
     *
     * @param pwd         支付密码
     * @param appId
     * @param custId      客户号
     * @param serviceCode 使用支付密码的接口名
     * @return
     */
    public String simulateH5Board(String pwd, String randKey) {
        try {
            PublicKey pubkey = RSAUtil.loadTLPublicKey(YourParams.Allinpay_Cer_Path);
            String pwdRsaEnced = CryptoUtil.doEncryptByRSA1(pwd, pubkey);
            System.out.println("pwdRsaEnced:" + pwdRsaEnced);

            String pwdAesEnced = Base64.getEncoder()
                    .encodeToString(AESUtil.encryptForH5KeyBord(pwdRsaEnced, randKey ));

            return pwdAesEnced;
        }catch(Exception e)
        {
            return null;
        }
    }

    /**
     * 生成文件内容AES随机密钥(模拟密码控件)
     *
     * @param pwd
     * @return
     */
    public String queryPwdRandAesKey(String appId, String mchtId, String transCode) {

        BizParameter bizMap = new BizParameter();
        bizMap.put("custId", mchtId);
        bizMap.put("serviceCode", transCode);
//        String retStr = doSendData("appwallet", "appservice/generateRandomKey", bizMap);
//        Map retMap = JSONObject.parseObject(retStr, HashMap.class);
//        Map dataMap = (Map) JSONObject.parseObject((String) retMap.get("data"));
//        return (String) dataMap.get("randomKey");
        try {
            final OpenResponse response = client.execute("allinpay.elecaccount.appwallet.appservice.generateRandomKey", bizMap);
            if ("000000".equals(response.getSubCode())) {
                System.out.println(response.getData());
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 生成文件内容AES随机密钥
     *
     * @param pwd
     * @return
     */
    public String generateFileRandAesKey() {
        String randPool = "0123456789";
        StringBuilder sb = new StringBuilder();
        int randInt = 0;
        int poolLen = randPool.length();
        for (int i = 0; i < 32; i++) {
            randInt = (int) (Math.random() * poolLen);
            sb.append(randPool.charAt(randInt));
        }

        String randomKey = new String(sb);
        return randomKey;
    }

    /**
     * 通联公钥 加密数据
     *
     * @param fileCont
     * @return
     */
    public String rsaPublicKeyEnc(String fileCont) {
        return null;
    }

    /**
     * 文件内容 加密随机密钥---使用通联公钥
     *
     * @param randKey
     * @return
     */
    public String encRandKey(String randKey) {
        return null;
    }

    private String getSourceString(Map<String, Object> postData) {
        if (null == postData) {
            return "";
        }

        Map<String, Object> sortedData = new TreeMap<String, Object>();
        sortedData.putAll(postData);

        StringBuilder source = new StringBuilder();

        for (String key : sortedData.keySet()) {
            if (key.equals("sign")) {
                continue;
            }

            Object value = sortedData.get(key);

            if (value != null && value != "" && value instanceof String) {
                source.append(key + "=" + value + "&");
            }
        }

        if (source.length() > 0) {
            source.deleteCharAt(source.length() - 1);
        }

        return source.toString();
    }


    /**
     * 批量代发
     *
     * @param mchtId
     * @param pwd
     * @param filePath
     */

    public void doRequest(String mchtId,
                          String pwd, String filePath) {

        BizParameter paramMap = new BizParameter();
        Map<String, Object> bizMap = null;
        try {
            paramMap = prepareData(mchtId, pwd, filePath);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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
    public void testMain() {
        this.doRequest("082006041001691", "", "./batchfile/XJFF_082006041001691_20200604_1.req");
    }

}