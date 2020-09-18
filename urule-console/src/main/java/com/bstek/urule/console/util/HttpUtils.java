package com.bstek.urule.console.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

import static com.bstek.urule.console.config.UruleContants.KM_SERVER;

/**
 * @author libo
 * @Title: HttpUtils
 * @Description:
 * @date 2020/8/21 11:42
 * @Version 1.0
 */
@Slf4j
public class HttpUtils {

    public static String doPostForm(String url, Map paramMap) {
        String result = null;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Post请求
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        // 响应模型
        try {
            NameValuePair[] nvp = null;
            // 判断参数map集合paramMap是否为空
            if (null != paramMap && paramMap.size() > 0) {// 不为空
                // 创建键值参数对象数组，大小为参数的个数
                nvp = new NameValuePair[paramMap.size()];
                // 循环遍历参数集合map
                Set<Map.Entry<String, Object>> entrySet = paramMap.entrySet();
                // 获取迭代器
                Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();

                int index = 0;
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> mapEntry = iterator.next();
                    // 从mapEntry中获取key和value创建键值对象存放到数组中
                    try {
                        if (mapEntry.getValue() instanceof String[] || mapEntry.getValue() instanceof Collection) {
                            ObjectMapper mapper= new ObjectMapper();
                            // 设置输出时包含属性的风格
                            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
                            // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
                            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                            nvp[index] = new BasicNameValuePair(mapEntry.getKey(), mapper.writeValueAsString(mapEntry.getValue()));
                        } else {
                            nvp[index] = new BasicNameValuePair(mapEntry.getKey(),
                                    new String(mapEntry.getValue().toString().getBytes("UTF-8"), "UTF-8"));
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    index++;
                }
            }
            // 判断nvp数组是否为空
            if (null != nvp && nvp.length > 0) {
                // 将参数存放到requestBody对象中
                httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(nvp), "UTF-8"));
            }
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            result = EntityUtils.toString(responseEntity, "utf-8");
//            System.out.println("响应状态为:" + response.getStatusLine());
//            if (responseEntity != null) {
//                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
//                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
//            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            result = "";
        } catch (IOException e) {
            e.printStackTrace();
            result = "";
        } finally {
            try {
                // 释放资源
                if (httpPost != null) {
                    httpPost.releaseConnection();
                }
                if (httpClient != null) {
                    try {
                        httpClient.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public static String findKmServerByName(String name) {
        String[] nameList = name.split("/");
        if (nameList.length < 2) {
            return null;
        }

        return KM_SERVER.get(nameList[1]);
    }
}
