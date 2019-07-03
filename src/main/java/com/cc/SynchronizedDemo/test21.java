package com.cc.SynchronizedDemo;

/**
 * Created by admin on 2019/6/26.
 *
 * 在给value1赋初始值之后，我们无法再对value1的值进行修改，final关键字起到了常量的作用。从value2我们可以看到，
 * final修饰的变量可以不在声明时赋值，即可以先声明，后赋值。value3时一个引用变量，这里我们可以看到final修饰引用变量时，
 * 只是限定了引用变量的引用不可改变，
 * 即不能将value3再次引用另一个Value对象，
 * 但是引用的对象的值是可以改变的，从内存模型中我们看的更加清晰：
 *
 *
 */
public class test21 {
    public static void main(String[] args)
    {
        ThreadDomain21 td = new ThreadDomain21();
        MyThread21_0 mt0 = new MyThread21_0(td);
        MyThread21_1 mt1 = new MyThread21_1(td);
        mt0.start();
        mt1.start();


        final int value1 = 1;
       // value1=2;//final 定义常量不能改变  String 就是一个字符串常量
        final double value2;
        value2 = 2.0;

        final Value value3 = new Value(1);
        value3.v = 4;//可以改变引用对象的值
    }
    static class Value {
        int v;

        public Value(int v) {
            this.v = v;
        }
    }
}
