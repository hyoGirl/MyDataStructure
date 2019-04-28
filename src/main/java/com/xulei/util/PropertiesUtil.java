package com.xulei.util;

import java.io.*;
import java.util.PropertyResourceBundle;

/**
 * @author ashura1110
 * @ClassName PropertiesUtil
 * @description TODO
 * @Date 2019/4/28 19:47
 * @Version 1.0
 */
public class PropertiesUtil {


    public static void main(String[] args) {


        String proFilePath="./conf/sdk.properties";
        try {
            File file = new File(proFilePath);
            BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(file));
            PropertyResourceBundle resourceBundle=new PropertyResourceBundle(bufferedInputStream);
            String priKey = resourceBundle.getString("priKey");
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
