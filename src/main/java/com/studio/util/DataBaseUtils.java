package com.studio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DataBaseUtils {

	private static final Logger logger = LogManager.getLogger(DataBaseUtils.class);
	public static Connection getConection(){
		Connection con = null;
		try {
			logger.info("Start to connect mysql database : my_info!");
			// 加载Mysql驱动程序  ，oracle的： Class.forName("oracle.jdbc.driver.OracleDriver");
			//不知道可以打出Driver看导入包的提示
			Class.forName("com.mysql.jdbc.Driver");		
			//localhost 为本级地址，my_info为数据库名
			String url = "jdbc:mysql://localhost:3306/my_info?characterEncoding=utf8";
			String username ="root";
			String password ="";
			con = DriverManager.getConnection(url, username, password);
			logger.info("Database connect succesfully!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
