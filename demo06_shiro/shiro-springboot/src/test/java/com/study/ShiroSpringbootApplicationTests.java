package com.study;

import com.study.pojo.User;
import com.study.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class ShiroSpringbootApplicationTests {
	@Autowired
	UserService userService;

	@Test
	void contextLoads() {
		User user = userService.queryUserByName("admin");
		System.out.println(user);

	}
	@Test
	void t() {

		//String str= DigestUtils.md5Hex(DigestUtils.md5Hex("yz090807"+"*v1#")+"0971");


	}

}
