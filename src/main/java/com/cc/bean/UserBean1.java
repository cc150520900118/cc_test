package com.cc.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by changc on 2019/3/6.
 */
//serialVersionUID作用：
//序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。
    @Data
public class UserBean1 implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Integer age;
    //private List<Integer> sport;
}