package com.xinkao.xinkao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Create by 钱 on 2018/9/29 0029.
 */
public class HttpUtils {
    public static String sendGetMethod(String url) {
        HttpURLConnection conn = null;
        String result = "";
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(2000);
            conn.setReadTimeout(2000);
            conn.connect();

            if (conn.getResponseCode() == 200) {
                InputStream in = conn.getInputStream();
                result = StreamUtils.stream2String(in);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
