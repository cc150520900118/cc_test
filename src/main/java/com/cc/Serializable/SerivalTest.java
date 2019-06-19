package com.cc.Serializable;

import java.io.*;

/**
 * Created by admin on 2019/6/19.
 */
public class SerivalTest {
    //序列化
    public static void outStream() throws IOException {
        SerialBean sn =new SerialBean("changchao",19);
        File flie =new File("D:\\test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(flie));
        oos.writeObject(sn);
        oos.close();
    }
    //反序列化
    public static void inStream() throws IOException, ClassNotFoundException {
        File flie =new File("D:\\test.txt");
        ObjectInputStream sis=new ObjectInputStream(new FileInputStream(flie));
        SerialBean readObject = (SerialBean)sis.readObject();
        System.out.println("output:"+readObject.toString());
    }

    public static void main(String[] args) throws Exception{
        outStream();
        inStream();
    }

}
