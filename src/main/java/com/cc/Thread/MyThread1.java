package com.cc.Thread;

/**
 * Created by changc on 2019/3/18.
 *
 * 实现Runnable的，
 * 相当于是拿出一个卖票10张得任务给三个人去共同完成，
 * new MyThread相当于创建一个任务，然后实例化三个Thread，
 * 创建三个线程即安排三个窗口去执行。
 *
 * 首先，java只能单继承，因此如果是采用继承Thread的方法，那么在以后进行代码重构的时候可能会遇到问题，
 * 因为你无法继承别的类了。
 * 其次，如果一个类继承Thread，则不适合资源共享。
 * 但是如果实现了Runable接口的话，则很容易的实现资源共享。
 * 通过下面的实例可以清晰的看出两种方式的区别所在。
 *
 */
class MyThread1 implements Runnable{
    private int ticket =10;
    private String name;
    public void run(){
        for(int i =0;i<500;i++){
            if(this.ticket>0){
                System.out.println(Thread.currentThread().getName()+"卖票---->"+(this.ticket--));
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //设计三个线程
        MyThread1 mt = new MyThread1();
        for (int i=0 ;i<4;i++){
            //MyThread1 mt = new MyThread1();
            Thread t1 = new Thread(mt,i+"号窗口");
            t1.start();
        }
        //Thread t1 = new Thread(mt,"一号窗口");
        //Thread t2 = new Thread(mt,"二号窗口");
        //Thread t3 = new Thread(mt,"三号窗口");
        //t1.start();
        //t2.start();
        //t3.start();
    }
}
