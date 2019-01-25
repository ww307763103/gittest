package com.example.security.controller;

import com.example.security.utils.Base64Util;
import com.example.security.utils.HttpUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 * @since 1.0.0
 */
@Controller
public class TestController {
    public static void main(String[] args) throws IOException {
        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";

        //http://211.156.193.146/youzheng/baidu/character

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/default/trustedrequest/message");
        httpClient.execute(httpPost);

    }
}