package com.cc.exception;

/**
 * Created by admin on 2019/6/1.
 * try catch是直接处理，处理完成之后程序继续往下执行，throw则是将异常抛给它的上一级处理，程序便不往下执行了。
 本题的catch语句块里面，打印完1之后，又抛出了一个RuntimeException，程序并没有处理它，而是直接抛出，
 因此执行完finally语句块之后，程序终止了

 首先执行try，遇到算术异常，抛出，执行catch，打印1，然后抛出RuntimeException，缓存异常，执行finally，打印2，然后抛出RuntimeException。
 则执行结果为12.
 如果catch中没有抛出RuntimeException，则执行结果为123。
 *
 *
 *
 *
 *那我们就不得不说一下throws，其实throws并不是抛出一个实际的Exception而是一个异常声明，它声明这个方法可能会抛出一个异常，注意是可能，所以在没有异常的情况下也是可以用throws的，而throws本身的作用也是用来提高程序的健壮性，反过来，如果这个方法的的确确的有一个异常，那么编译器会强制让你加上throws这个异常声明。

 通常throws是写在参数列表的后面，这样就表明这个方法有可能会抛出一个异常

 class A{
 public void func() throws Exception{
 throw new Exception();
 }

 public void g() throws Exception{

 }
 }
 *
 *
 *
 */
public class ZeroTest {
    public static void main(String[] args) {
        try{
            int i = 100/ 0;
            System.out.print(i);
        }catch(Exception e){
            System.out.print(1);
            //throw new RuntimeException();
        }finally{
            System.out.print(2);
        }
        System.out.print(3);
    }
}
