package com.cc;

/**
 * Created by changc on 2019/3/2.
 */


public class EnumDemo {

    public void change(Day day) {
        switch (day) {
            case MONDAY:
                System.out.println("周一");
                break;
            case TUESDAY:
                System.out.println("周二");
                break;
            case WEDNESDAY:
                System.out.println("周三");
                break;
        }
    }
    public void cc(Day day){
        this.change(day);
    }

    public static void main(String[] args){
        //直接引用
        Day day =Day.MONDAY;
        EnumDemo enumDemo =new EnumDemo();
        enumDemo.cc(day);
        System.out.print(day);
    }
}
// /定义枚举类型
enum Day {
    MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY, SUNDAY
}



