package com.cc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
//@ImportResource(locations = {"classpath:beans.xml"})  导入配置文件
//为了让@Async注解能够生效，还需要在Spring Boot的主程序中配置@EnableAsync
@EnableAsync
@SpringBootApplication
public class CcTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcTestApplication.class, args);
	}
}
