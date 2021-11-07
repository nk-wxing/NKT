package com.nkt.news.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "123456";

		try {
			Class.forName(driver);
			System.out.println("打开数据库连接！");
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return null;
	}

	public void close(Connection connection) {
		try {
			connection.close();
			System.out.println("已关闭数据库连接！");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
