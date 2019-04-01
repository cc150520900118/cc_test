package com.cc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//@ImportResource(locations = {"classpath:beans.xml"})  导入配置文件
//为了让@Async注解能够生效，还需要在Spring Boot的主程序中配置@EnableAsync
// 启用异步任务
@EnableAsync
//进行定时任务
@EnableScheduling
@SpringBootApplication

//该注解会扫描相应的包
@ServletComponentScan("com.pandy.blog.filters")


public class CcTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcTestApplication.class, args);
	}
}
