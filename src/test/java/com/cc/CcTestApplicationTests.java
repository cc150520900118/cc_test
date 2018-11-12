package com.cc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CcTestApplicationTests {

	@Test
	public void contextLoads() throws FileNotFoundException {
		//读取项目路径
		System.getProperty("user.dir");
		System.out.println("1111111111111"+System.getProperty("user.dir"));
		String path = System.getProperty("user.dir") + "/src/main/resource/";
		System.out.println("1111111111111"+path);
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

}
