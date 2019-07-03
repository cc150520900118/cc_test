package com.cc.paixu;

/**
 * Created by admin on 2019/6/27.
 */
class User implements Comparable<User>{

    private String name; //姓名

    private int age; // 年龄


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
     // getter && setter
     public String getName() {
       return name;
    }
   public void setName(String name) {
    this.name = name;
   }
   public int getAge() {
     return age;
   }
    public void setAge(int age) {
    this.age = age;
    }

    @Override
    public String toString() {
    return "User [name=" + name + ", age=" + age + "]";
}

    @Override
    public int compareTo(User user) {           //重写Comparable接口的compareTo方法，
     return this.age - user.getAge();// 根据年龄升序排列，降序修改相减顺序即可
   }
}