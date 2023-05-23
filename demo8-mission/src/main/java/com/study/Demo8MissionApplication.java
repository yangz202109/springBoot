package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yangz
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class Demo8MissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo8MissionApplication.class, args);
	}

}
