package com.study;
import com.study.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;


@SpringBootTest
class WebApplicationTests {

	@Resource
	UserMapper userMapper;


	@Test
	void contextLoads() {

	}

}
