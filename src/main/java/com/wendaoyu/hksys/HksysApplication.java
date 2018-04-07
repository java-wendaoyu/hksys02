package com.wendaoyu.hksys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.wendaoyu.hksys.dao")
@ComponentScan
@EnableAutoConfiguration
public class HksysApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HksysApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HksysApplication.class);
	}
}
