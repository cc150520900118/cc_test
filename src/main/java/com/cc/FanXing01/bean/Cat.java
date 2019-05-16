package com.cc.FanXing01.bean;

public class Cat extends Animal{
	/*父类只有有参构造器，那么会覆盖父类本身的无参构造器，就会没有无参构造器；
	如果子类没有显示的构造器，默认创建无参构造器，子类的这个无参构造器回去调用父类的无参构造器；
	解决方式：
	①在父类加一个无参构造器
	② 通过使用super关键字调用父类传递有参构造器
	*/
	
	
	//子类报错的第②种解决方法
	/*public Cat(Object t) {
		super(t);
	}*/

	

}
