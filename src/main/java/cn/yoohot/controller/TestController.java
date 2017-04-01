package cn.yoohot.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.DriverConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yoohot.mapper.UserInfoMapper;
import cn.yoohot.model.UserInfo;

@Controller
public class TestController {
//	@Autowired
//	private UserInfoMapper userInfoMapper;
//
//	@RequestMapping("/hello")
//	public String hello(){
//		System.out.println("hello");
//		UserInfo userInfo = userInfoMapper.selectByPrimaryKey(1);
//		System.out.println(userInfo);
//		return "hello";
//	}
//	
//	
//	
//	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yoohot", "root", "1230.");
//		System.out.println(connection);
//	}
}
