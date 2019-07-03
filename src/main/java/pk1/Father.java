package pk1;

/**
 * Created by admin on 2019/6/28.
 *
 * 访问控制权限（yes代表可以访问）
 *         private 	default      protected 	public
 同一类 	yes 	yes 	     yes 	   yes
 同一包中的类 	  	yes 	     yes 	   yes
 子类 	  	  	                 yes 	   yes
 其他包中的类 	  	  	  	               yes
 ---------------------
 *
 *如果一个属性是 private，那么外部不可以直接对这个属性进行读取与修改，而是通过这个类提供的 get、set 方法去访问
 *
 *
 *
 *
 */
public class Father {
    private String param1 ="这是private";
    protected String param2 ="这是protected";
    public String param3 = "这是public";
    String param4 ="这是default";
    public static void main(String[] args) {
        Father father = new Father();
        System.out.println("father 实例访问："+father.param1);
        System.out.println("father 实例访问："+father.param2);
        System.out.println("father 实例访问："+father.param3);
        System.out.println("father 实例访问："+father.param4);
    }

}