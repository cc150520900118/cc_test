package com.cc.UuidDemo;

import java.util.UUID;

/**
 * Created by admin on 2019/6/29.
 */
public class UuidDemo {
    public static void main(String[] args) {

        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        System.out.println(UUID.randomUUID().version());

        System.out.println(randomUUID().substring(0,6));

        System.out.println(UUID.nameUUIDFromBytes("890110866094329856".getBytes()).toString().replace("-", ""));

        System.out.println(UUID.nameUUIDFromBytes("890110866094329856".getBytes()).version());

    }
    public static String randomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
