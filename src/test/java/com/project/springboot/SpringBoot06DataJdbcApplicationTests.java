//package com.project.springboot;
//
//import com.baomidou.mybatisplus.enums.IdType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.rules.DbType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SpringBoot06DataJdbcApplicationTests {
//
//
//	@Autowired
//	DataSource dataSource;
//
//	@Test
//	public void contextLoads() throws SQLException {
//		//org.apache.tomcat.jdbc.pool.DataSource
//		System.out.println(dataSource.getClass());
//
//		Connection connection = dataSource.getConnection();
//		System.out.println(connection);
//		connection.close();
//
//	}
//
//}
