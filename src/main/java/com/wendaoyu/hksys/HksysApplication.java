package com.wendaoyu.hksys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	@Bean
	public Converter<String, Date> addNewConvert(){
		return new Converter<String, Date>() {
			@Override
			public Date convert(String source) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = null;
				try {
					date = sdf.parse( source);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return date;
			}
		};
	}
}
