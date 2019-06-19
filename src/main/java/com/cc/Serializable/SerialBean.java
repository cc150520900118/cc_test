package com.cc.Serializable;

import java.io.Serializable;

/**
 * Created by admin on 2019/6/19.
 */
public class SerialBean implements Serializable {
    private static final long serialVersionUID=1L;
    private String name;
    //为了安全起见，不希望在网络操作中被传输
    private transient int id;
    private  int age;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SerialBean{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
    public SerialBean(String name,int age){
        super();
        this.name=name;
        this.age=age;
    }
}
