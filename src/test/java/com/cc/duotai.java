package com.cc;

/**
 * Created by changc on 2019/3/2.
 *
 *1.多态是方法的多态，不是属性的多态（多态与属性无关）

 2.多态存在要有3个必要条件：继承、方法重写、父类引用指向子类对象。

 3.父类引用指向子类对象后，用该父类引用调用子类重写的方法，此时多态就出现了。
 *
 *
 */
public class duotai {

    //多态的关键，通过父类的引用调用子类重写的方法。
    static void animalCry(Animal a) {
        a.shout();
    }

    public static void main(String[] args) {
        Animal a = new Animal();
        animalCry(a);

        dog d = new dog();
        animalCry(d);

        cat t = new cat();
        animalCry(t);
    }

    }

