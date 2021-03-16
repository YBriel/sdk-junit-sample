package com.allinpay.sdk.test.tea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

/**
 *  提供和项目业务相关的功能
 */
public class BusinessUtil {
    public static String getCurrentTimestamp() {
        Date date = new Date();
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(date);

        return timeStamp;
    }

    public static String readFile(String filePath) {
        StringBuffer s = new StringBuffer();

        try {
            String encoding = "UTF-8";
            File file = new File(filePath);

            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null) {
                    s.append(lineTxt + "\n");
                }
                read.close();

            } else {
                System.out.println("找不到指定文件！");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容错误");
            e.printStackTrace();
        }

        return s.toString();
    }

    // 字符串有最大长度限制65534字节
    public static String JPGToBase64(String imgPath) {
        byte[] data = null;
 
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return Base64.getEncoder().encodeToString(data);
    }
}