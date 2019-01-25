package com.example.security.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 推送消息工具类
 *
 * @author DELL
 * @since 1.0.0
 */
public class PushMsgUtil {
    /**
     * 调用服务地址,可以放入配置文件中
     */
    private static final String URL = "http://211.156.195.52:443/chinapost/trustedrequest/message";
    /**
     * 推送消息
     * @param action 推送的设备类型,pushAll全部设备/push指定设备/pushIOS IOS设备/pushAndroid安卓设备/pushByGroup 分组平台
     * @param title 标题
     * @param summary 摘要即副标题（仅Android可见）
     * @param type 消息类型
     * @param msgContent 消息内容，（仅Android可见）
     * @param deviceToken 设备toenId
     * @param groupId 群组id
     * @return success：是否成功 errCode：错误编码 errMsg：错误信息 operation：操作步骤 data：其他信息
     */
    public static String pushMsg(String action,
                                 String title,
                                 String summary,
                                 String type,
                                 String msgContent,
                                 String deviceToken,
                                 String groupId) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(URL);
        List<NameValuePair> nvps = addParameter(action, title, summary, type, msgContent, deviceToken, groupId);
        return getResponse(httpClient, httpPost, nvps);
    }

    /**
     * 将设备添加进群组或者从移除群组中
     * @param action    请求类型 joinGroup加入/removeFormGroup移除
     * @param groupId   群组ID
     * @param deviceToken   设备tokenId
     * @return  请求响应返回值
     */
    public static String addOrRemoveAdvicefromGroup(String action,
                                                    String groupId,
                                                    String deviceToken) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(URL);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("action", action));
        nvps.add(new BasicNameValuePair("groupId", groupId));
        nvps.add(new BasicNameValuePair("deviceToken", deviceToken));
        return getResponse(httpClient, httpPost, nvps);
    }
    /**
     * 获取调用接口的返回值
     * @param httpClient httpClient客户端
     * @param httpPost httpPost
     * @param nvps 参数
     * @return 响应返回值
     */
    private static String getResponse(CloseableHttpClient httpClient, HttpPost httpPost, List<NameValuePair> nvps) {
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity resEntity = httpResponse.getEntity();
            if (resEntity != null) {
                return EntityUtils.toString(resEntity, "utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "调用接口失败";
    }

    /**
     * 推送消息
     * @param action 推送的设备类型, pushAll 全部设备/push 指定设备/pushIOS IOS设备/ pushAndroid 安卓设备/ pushByGroup 分组平台
     * @param title 标题
     * @param summary 摘要即副标题（仅Android可见）
     * @param type 消息类型
     * @param msgContent 消息内容，（仅Android可见）
     * @param deviceToken 设备toenId
     * @param groupId 群组id
     * @return 添加的参数
     */
    private static List<NameValuePair> addParameter(String action,
                                                    String title,
                                                    String summary,
                                                    String type,
                                                    String msgContent,
                                                    String deviceToken,
                                                    String groupId) {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("action", action));
        nvps.add(new BasicNameValuePair("title", title));
        nvps.add(new BasicNameValuePair("summary", summary));
        nvps.add(new BasicNameValuePair("type", type));
        nvps.add(new BasicNameValuePair("msgContent", msgContent));
        if (!"".equals(deviceToken) && deviceToken != null) {
            nvps.add(new BasicNameValuePair("deviceToken", deviceToken));
        }
        if (!"".equals(groupId) && groupId != null) {
            nvps.add(new BasicNameValuePair("groupId", groupId));
        }
        return nvps;
    }

}
