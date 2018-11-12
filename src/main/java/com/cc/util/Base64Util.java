package com.cc.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Util {
    /**
     * base64 编码
     *
     * @param str
     * @return
     */
    public static String encoder(String str){
        final Base64.Encoder encoder = Base64.getEncoder();
        String strEncoder = null;
        try {
            strEncoder = encoder.encodeToString(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strEncoder;
    }
    /**
     * base64 解码
     *
     * @param str
     * @return
     */
    public static String decoder(String str){
        final Base64.Decoder decoder = Base64.getDecoder();
        String strEncoder = null;
        try {
            strEncoder = new String(decoder.decode(str), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strEncoder;
    }

    /**
     * test
     *
     * @param args
     */
    public static void main(String[] args){
        String testStr = "qwerqwfavavaegfgbsd#*#-asdfasd-asdf-fasdf-asd";
        String encoderStr = encoder(testStr);
        System.out.println(encoderStr);
        String decoderStr = decoder(encoderStr);
        System.out.println(decoderStr);
    }
}