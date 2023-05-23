package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ShiroSpringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ShiroSpringbootApplication.class, args);
//		Object o = context.getBean("GetShiroFilterFactory");
//		System.out.println(o);

	}

}
