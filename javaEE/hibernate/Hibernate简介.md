Hibernete简介

hibernate是什么？
hibernate是一个对JDBC轻量极封装的框架,处于持久层
hibernate基础是反射机制

为什么需要Hibernate?
切换数据库时可能需要重写业务层数据库代码


界面 -> 业务逻辑层 -> 持久层 -> 数据库

持久层将 对象模型 <-> 关系模型 进行转换


使用手动配置方式开发一个hibernate项目，完成对数据库的CRUD操作。

Hibernate 开发的三种方式：  
1. domain object -> mapping -> DB  
2. 由DB开始，用工具生成mapping 和 Domain object  
3. 由mapping 开始  


创建employee表
create table employee (
id number primary key,
name varchar2(64) not null,
email varchar2(64) not null,
hiredate date not null,
salary float not null
);


开发domain对象和对象关系映射文件
src/com.elewei.domain/Employee.java

对象关系映射文件：作用是用于指定domain对象和表的映射关系,domain

手动配置hibernate.cfg.xml文件，该文件用于配置， 连接数据库的类型。

	//hibernate.cfg.xml
	<?xml version=“1.0” encoding=“utf-8”?>
	<!DOCTYPE hibernate-configuration PUBLIC
	        “-//Hibernate/Hibernate Configuration DTD 3.0//EN”
	        “http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd”>
	        
	<hibernate-configuration>
		<session-factory>
			<property name=“connection.driver_class”>com.mysql.jdbc.Driver</property>
			<property name=“connection.url”>jdbc:mysql://127.0.0.1:3306/ems?useUnicode=true&amp;characterEncoding=utf-8</property>
			<property name=“connection.username”>root</property>
			<property name=“connection.password”>weiwei</property>
			<property name=“dialect”>org.hibernate.dialect.MySQLDialect</property>		
			<property name=“show_sql”>true</property>
			<mapping resource=“com/elewei/domain/Employee.hbm.xml”/>
		</session-factory>
		
	</hibernate-configuration>


-----

	//TestMain.java 测试文件
	package com.elewei.view;
	
	import java.util.Date;
	
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;
	
	import com.elewei.domain.Employee;
	
	public class TestMain {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			//使用hibernate完成crud操作，不使用service，直接测试
			//1. 创建Configuration,该对象读取hibernate.cfg.xml，并完成初始化
			Configuration configuration = new Configuration().configure(“hibernate.cfg.xml”);
			//2. SessionFactory 【这是一个会话工厂，是一个重量级的对象】
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			//3. 创建Session，相当于一次连接
			Session session = sessionFactory.openSession();
			//添加一个雇员
			Employee employee = new Employee();
			employee.setName(“启卫”);
			employee.setEmail(“qiwei@elewei.com”);
			employee.setHiredate(new Date());
			employee.setSalary(1000.56f);
			//4. 使用事物提交
			Transaction transaction = session.beginTransaction();
			//保存
			session.save(employee);
			//提交
			transaction.commit();
			//关闭
			session.close();
		}
	
	}






------

domain -> 数据库 自动映射









