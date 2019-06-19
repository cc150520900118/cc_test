package com.cc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cc.bean.UserBean;
import com.cc.bean.UserBean1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by changc on 2019/3/6.
 */
@Controller
@RequestMapping("/mvc")
public class FromDemo {
    /**
     *
     * @Description: ajax访问的方法,使用实体类接收表单序列化的参数
     * @author QSNP242
     * @param user
     * @return  String
     * @throws
     * @date 2018年3月29日
     */
    @RequestMapping("/m1")
    @ResponseBody
    public UserBean test(UserBean user){
        System.out.println("ok");
        System.out.println(user.toString());
        return user;
    }

    @RequestMapping("/m2")
    @ResponseBody
    public UserBean test1(@RequestBody UserBean user){
        System.out.println("ok");
        System.out.println(user.toString());
        return user;
    }
    @RequestMapping("/m3")
    @ResponseBody
    public UserBean1 test3(UserBean1 user){
        System.out.println("ok");
        System.out.println(user.toString());
        return user;
    }

    /**
     *
     * @Description: 访问表单的jsp
     * @author QSNP242
     * @return  String
     * @throws
     * @date 2018年3月29日
     */
    @RequestMapping("/enter")
    public String enter(){
        return "index";
    }


@RequestMapping(value={"/poiQueryLwsj"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
@ResponseBody
public Map<String, Object> poiQueryLwsj(String aliyun) {
        Map result = new HashMap();
        StringBuffer sb = new StringBuffer("");
        try
        {
        String reqString = "[";
        String[] reqStr = aliyun.split(";");
        for (int i = 0; i < reqStr.length; i++) {
        String[] req = reqStr[i].split(",");

        String ecgj = "";
        if (i == reqStr.length - 1)
        reqString = reqString + "{\"datetime\":\"" + req[2] + "\",\"ecgi\":\"" + ecgj + "\",\"latitude\":\"" + req[1] + "\",\"longitude\":\"" + req[0] + "\"}";
        else {
        reqString = reqString + "{\"datetime\":\"" + req[2] + "\",\"ecgi\":\"" + ecgj + "\",\"latitude\":\"" + req[1] + "\",\"longitude\":\"" + req[0] + "\"},";
        }
        }
        reqString = reqString + "]";

        //JSONArray json = JSONArray.fromObject(reqString);
            JSONArray json = JSON.parseArray(reqString);
        reqString = json.toString();

        System.out.println("传入接口参数：" + reqString);
        URL url = new URL("http://77.1.24.80:9090/mapmatching/compute?type=station&maxLoopNum=7&minRoadLen=300");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);

        connection.setRequestProperty("UserName", "OFN2ifO9u");
        connection.setRequestProperty("Password", "NzzauPPdYvxvOTUsJ8n");
        connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        connection.connect();
        DataOutputStream out = new DataOutputStream(
        connection.getOutputStream());
        out.write(reqString.getBytes("UTF-8"));
        out.flush();
        out.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        String lines;
        while ((lines = reader.readLine()) != null)     {
        sb.append(lines);
        }
        reader.close();

        connection.disconnect();
        } catch (Exception e) {
        e.printStackTrace();
        }
        if (((sb.toString().length() == 0 ? 1 : 0) | (sb.toString().trim().length() == 0 ? 1 : 0)) != 0) {
        return result;
        }
        System.out.println("输出接口参数：" + sb.toString());
        result.put("data", sb.toString());
        result.put("status", "success");
        return result;
        }
}