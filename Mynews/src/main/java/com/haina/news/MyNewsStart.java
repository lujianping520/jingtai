package com.haina.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MyNewsStart extends SpringBootServletInitializer{
	public static void main(String[] args) {		
		//入口运行类
		SpringApplication.run(MyNewsStart.class, args);
	}
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(MyNewsStart.class);
	    }

}
