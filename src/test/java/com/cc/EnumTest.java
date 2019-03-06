package com.cc;

/**
 * Created by changc on 2019/3/2.
 */
enum ActionTypeEnum{
    //通过括号赋值,而且必须带有一个参构造器和一个属性跟方法，否则编译出错
    //赋值必须都赋值或都不赋值，不能一部分赋值一部分不赋值；如果不赋值则不能写构造器，赋值编译也出错
    下载(1,"xiazai"),
    访问(2,"fangwen"),
    ss(3,"sssss"),
    shangchuan(2,"上传");
    int index;
    String name;

    private ActionTypeEnum(int index,String name){
        this.index = index;
        this.name = name;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


}

public class EnumTest
{
    public static void main(String[] args)
    {
        ActionTypeEnum[] actionTypeEnums = ActionTypeEnum.values();
        for(ActionTypeEnum actionTypeEnum : actionTypeEnums){
            System.out.println("name=" + actionTypeEnum.getName());
            System.out.println("index= " + actionTypeEnum.getIndex());
            System.out.println("oridary=" + actionTypeEnum.ordinal());
            System.out.println("this = " + actionTypeEnum);
            System.out.println("下载值："  + actionTypeEnum.valueOf("下载"));
            System.out.println("name()方法= " + actionTypeEnum.name());
            System.out.println("--------------叫我分割线------------------");
        }
    }
}
