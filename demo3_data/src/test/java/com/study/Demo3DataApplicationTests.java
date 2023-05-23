package com.study;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@SpringBootTest
class Demo3DataApplicationTests {

	@Resource
	DataSource dataSource;

	@Test
	void contextLoads() throws SQLException{
		//查看默认数据源
		System.out.println(dataSource.getClass());

		//获取数据库连接
		Connection connection = dataSource.getConnection();
		System.out.println(connection);

		connection.close();


	}

}
