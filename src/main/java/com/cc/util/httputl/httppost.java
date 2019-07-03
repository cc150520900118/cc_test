/*
package com.cc.util.httputl;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import java.net.URI;

*/
/**
 * Created by admin on 2019/6/25.
 *//*

public class httppost {
    public static void main(String[] agrs) {
        String result = null;
        */
/*HttpClient client = HttpClients.createDefault();
        URIBuilder builder = new URIBuilder();
        URI uri = null;
        try {
            uri = builder.setScheme("http")
                    .setHost("192.168.1.116:8050")
                    .setPath("selectCityByPhoneNo")
                    .build();

            HttpPost post = new HttpPost(uri);
            //设置请求头
            post.setHeader("Content-Type", "application/json");
            String body = "{\"phoneNo\": \"1300184\"}";
            //设置请求体
            post.setEntity(new StringEntity(body));
            //获取返回信息
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            System.out.println("接口请求失败"+e.getStackTrace());
        }*//*

        System.out.println("结果========"+result);

    }
    }
}
*/
