package com.elewei.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.Properties;
////这是一个工具类，用于得到连接和关闭连接
public class DatabaseUtil 
{
	private static Connection ct=null;//连接
	private static ResultSet rs=null;//结果
	private static PreparedStatement ps=null;
	//连接数据库参数
	private static String url = "";	
	private static String drivername = "";
	private static String username = "";
	private static String password = "" ;
	//加载驱动，一次
static{
		try 
			{				
				Properties properties=new Properties();
				InputStream is=DatabaseUtil.class.getClassLoader().getResourceAsStream("com/elewei/utils/dbinfo.properties");
				properties.load(is);
				//属性文件读取信息
				drivername=properties.getProperty("driver");
				username=properties.getProperty("username");
				password=properties.getProperty("password");
				url=properties.getProperty("url");
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}

//得到连接
public static  Connection getCon()
{
	try {
		Class.forName(drivername);
		ct= DriverManager.getConnection(url,username,password);//注意配置文件
	} catch (Exception e) {
		e.printStackTrace();
	}
	return ct;//谁调用谁拿到Connection
}
public static void main(String args [])
{
	
	System.out.println(drivername);
	System.out.println(username);
	System.out.println(password);
	System.out.println(url);
}
//关闭资源函数
public static void close(ResultSet rs,Statement ps,Connection ct)
{
	if(rs!=null)
	{	
			try
		{
				rs.close();
		}catch(Exception e)
		{
			
		}
		rs=null;//使用垃圾回收
	}
	if(ps!=null)
	{
		try
		{
				ps.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		ps=null;
	}
	
	if(ct!=null)
	{
		try
		{
				ct.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		ct=null;
	}
		
}

}	
