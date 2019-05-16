package com.cc.util;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by admin on 2019/4/27.
 */
public class ListSort {
    public static class UserBean {
        private String id;
        private String birthday;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }
    }

    public static void main(String[] args) {
        List<UserBean> list = new ArrayList<UserBean>();
        UserListGenerate(list);
        for(UserBean user:list){
            System.out.println("排序前："+user.getBirthday());
        }
        ListSort(list);
        for(UserBean user:list){
            System.out.println("排序后："+user.getBirthday());
        }
    }

    private static void UserListGenerate(List<UserBean> list) {
        UserBean user1 = new UserBean();
        UserBean user2 = new UserBean();
        UserBean user3 = new UserBean();
        user1.setId("zhagnsan");
        user1.setBirthday("2016-1-29 19:40:00");

        user2.setId("lisi");
        user2.setBirthday("2017-1-29 19:40:00");

        user3.setId("wangwu");
        user3.setBirthday("2017-1-29 20:40:00");

        list.add(user1);
        list.add(user2);
        list.add(user3);
    }

    private static void ListSort(List<UserBean> list) {
        Collections.sort(list, new Comparator<UserBean>() {
            @Override
            public int compare(UserBean o1, UserBean o2) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    Date dt1 = format.parse(o1.getBirthday());
                    Date dt2 = format.parse(o2.getBirthday());
                    if (dt1.getTime() > dt2.getTime()) {
                        return 1;
                    } else if (dt1.getTime() < dt2.getTime()) {
                        return -1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }
}