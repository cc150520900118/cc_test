package com.cc.paixu;

/**
 * Created by admin on 2019/6/27.
 */
class User1 {

    private String name; //姓名

    private int age; // 年龄


    public User1(String name, int age) {
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
}