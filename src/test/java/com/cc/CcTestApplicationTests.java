package com.cc;

import com.cc.bean.Person;
import com.cc.bean.Person1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CcTestApplicationTests {
	@Autowired
	Person person;
	@Autowired
	Person1 person1;
	@Autowired
	Person1 person2;
	@Autowired
	ApplicationContext ioc;
	@Test
	public void contextLoads() throws FileNotFoundException {
		//读取项目路径
		System.getProperty("user.dir");
		System.out.println("1111111111111"+System.getProperty("user.dir"));
		String path = System.getProperty("user.dir") + "/src/main/resource/";
		System.out.println("我的"+path);
		System.out.println("开心");
		//读取项目路径
		File file = ResourceUtils.getFile("classpath:version.txt");
		if(file.exists()){
			System.out.println("222222222"+file.getName());
			/*File[] files = file.listFiles();
			if(files != null){
				for(File childFile:files){
					System.out.println(childFile.getName());
				}
			}*/
		}
	}

	//如果说，我们只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@Value；
 	//如果说，我们专门编写了一个javaBean来和配置文件进行映射，我们就直接使用@ConfigurationProperties；默认从全局配置文件中获取
	//ConfigurationProperties
	@Test
	public void contextLoads1() {
		//@ConfigurationProperties(prefix = "person1")
		// -----可以从yml 也可以从properties
		System.out.println("ConfigurationProperties=="+person);
		//@Value
		// -----可以从yml 也可以从properties
		System.out.println("Value=="+person1);
		//@PropertySource(value = {"classpath:person.properties"})
		//创建非默认的配置文件
		System.out.println("PropertySource=="+person2);
	}
	@Test
	public void contextLoads3() {

		System.out.println(person2);
	}


	@Test
	public void testHelloService(){
		boolean b = ioc.containsBean("helloService02");
		System.out.println("b==========="+b);
	}
}
