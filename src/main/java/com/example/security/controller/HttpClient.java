package com.example.security.controller;

import com.example.security.utils.PushMsgUtil;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 * @since 1.0.0
 */
public class HttpClient {
    public static void main(String[] args) {
        String s = PushMsgUtil.pushMsg("push", "推送给小米信息测试22", "小米测试推送22", "chinapost", "哈哈哈哈222", ".portalba4371cee65fa1bf", null);
        System.out.println(s);
    }

    //多线程,回调接口,将json传出
    static class OnDispatchProcedure implements Runnable {
        private String json;

        public void setJson(String json) {
            this.json = json;
        }

        //2):在A类中覆盖Runnable接口中的run方法.
        @Override
        public void run() {
            // run方法具体重写
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://localhost:8080/default/trustedrequest/message");
            //httpPost.addHeader("AUTH-CHANNEL", "APP");
            //StringEntity stringEntity = new StringEntity(json, "utf-8");
            //httpPost.setEntity(stringEntity);
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("action", "pushAll"));
            nvps.add(new BasicNameValuePair("title", "测试"));
            nvps.add(new BasicNameValuePair("summary", "副标题"));
            nvps.add(new BasicNameValuePair("type", "IOS"));
            nvps.add(new BasicNameValuePair("msgContent", "消息内容"));
            //nvps.add(new BasicNameValuePair("deviceToken", "eyJhbGciOiJIUzI1NiJ9.eyJVU0VSX0NIQU5ORUwiOiJBTElQQVkiLCJJU1NVRVJfQVQiOjE1NDc4MDQwMzIxMzcsIk9QRU5fSUQiOiJhcHBUZXN0ZXIiLCJJU1NVRVIiOiJuZXctZ2VuZXJhdGlvbi1hcGkiLCJuYmYiOjE1NDc4MDQwMzIsIlBIT05FX0lEIjpudWxsLCJQSE9ORSI6IiIsIlVTRVJfSUQiOiJkYmZhN2QyYzk2MzI0MWZjYmJkNzYyMTc1YzE3YTcxNiIsImV4cCI6MTU0OTExODAzMn0.uic1aDWW3et600SE98eYfOiJ06uBuCbtgxorJSmBgPM"));
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
                httpClient.execute(httpPost);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}