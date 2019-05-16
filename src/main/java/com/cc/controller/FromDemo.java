package com.cc.controller;

import com.cc.bean.UserBean;
import com.cc.bean.UserBean1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
