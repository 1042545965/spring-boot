package com.project.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.project.springboot.dao")
@SpringBootApplication
@EnableCaching //加入缓存的话的必要的操作
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
