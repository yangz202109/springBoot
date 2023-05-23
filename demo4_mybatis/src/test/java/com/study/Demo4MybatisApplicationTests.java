package com.study;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest
class Demo4MybatisApplicationTests {

	@Resource
	DataSource dataSource;

	@Test
	void contextLoads() {
		System.out.println(dataSource.getClass());
	}

}
