package com.cc.bean;

import lombok.Data;

/**
 * Created by changc on 2019/3/6.
 */
//lombok  @Data  数据set、get
@Data
public class MessagePojo {
    //当前页
    private String delay;
    //页大小
    private String className;
}
