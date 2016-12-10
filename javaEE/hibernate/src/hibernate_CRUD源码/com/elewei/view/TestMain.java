package com.elewei.view;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.elewei.domain.Employee;
import com.elewei.util.MySessionFactory;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//使用hibernate完成crud操作，不使用service，直接测试
		
		//查询一个用户
		
		
	}

	public static void delEmployee() {
		//删除一个用户
		//获取一个会话
		Session session = MySessionFactory.getSessionFactory().openSession();
		
		//4. 使用事物提交
		Transaction transaction = session.beginTransaction();
		
		//获取要删除的用户,load方法通过主键获取该对象实例
		Employee employee = (Employee) session.load(Employee.class, 5);

		
		//删除用户
		session.delete(employee);
		
		//保存
		//session.save(employee);
		//提交
		transaction.commit();
		//关闭
		session.close();
	}

	public static void updateEmployee() {
		//修改用户
		//获取一个会话
		Session session = MySessionFactory.getSessionFactory().openSession();
		
		//4. 使用事物提交
		Transaction transaction = session.beginTransaction();
		//获取要修改的用户,load方法通过主键获取该对象实例
		Employee employee = (Employee) session.load(Employee.class, 1);
		
		
		
		//修改
		employee.setName("小红");
		

		//保存
		//session.save(employee);
		//提交
		transaction.commit();
		//关闭
		session.close();
	}
	
	//增加用户
	public static void addEmployee() {
		//1. 创建Configuration,该对象读取hibernate.cfg.xml，并完成初始化
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		//2. SessionFactory 【这是一个会话工厂，是一个重量级的对象】
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//3. 创建Session，相当于一次连接
		Session session = sessionFactory.openSession();
		//添加一个雇员
		Employee employee = new Employee();
		employee.setName("启卫");
		employee.setEmail("qiwei@elewei.com");
		employee.setHiredate(new Date());
		employee.setSalary(1000.56f);
		//4. 使用事物提交
		Transaction transaction = session.beginTransaction();
		//保存
		//session.save(employee);
		//提交
		transaction.commit();
		//关闭
		session.close();
	}

}
