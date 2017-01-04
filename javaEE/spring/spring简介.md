
spring是什么？  
struts 是web框架（jsp/action/actionform）  
hibernate是orm框架，处于持久层  
spring是容器框架，用于配置bean,并维护bean之间关系的框架，主要目标是Spring简化开发  

bean是java中任何一种对象。javabean/service/action/数据源/dao  

IOC(控制反转 inverse of control): 所谓控制反转，把创建对象（bean）和维护对象的关系权利从程序中转移到spring容器文件中（applicationContext.xml）

DI(dependncy injection, 依赖注入): di和ioc是同一个概念，spring设计者认为di更准确表示spring核心技术。

spring框架，它可以管理web层，业务层，dao层，持久层



Spring 项目开发步骤：(最小配置)
第一步：在web根目录下建立lib目录
引入spring.jar包，常用jar包都已经包括  
引入日志包commons-logging.jar包  


第二步：创建spring核心文件 applicationContext.xml

	<!DOCTYPE beans PUBLIC “-//SPRING/DTD BEAN/EN”
	    “http://www.springframework.org/dtd/spring-beans.dtd”>



传统方法与现有方法的区别：  
使用spring，没有new对象，把创建对象的任务交给容器，体现控制反转的思想


深入理解spring框架运行原理：

* spring框架什么时候被加载？
* spring配置bean怎样被创建？
* bean与bean之间的关系是怎样被维护的？

`ClassPathXmlApplicationContext()`会导致spring容器加载，同时applicationContext中配置的bean对象被创建到内存。

	内存中大体结构：
	userService(0x00001  UserService[name, byteService(0x234)])
	byService(0x234)			ByService[name]

	Uservice us 指向内存userService(0x00001)

spring深入反射机制(dom4j + java反射机制),底层代码

	userService = Class.forName(“com.elewei.service.UserService”);
	userService.setName(“启卫”);
	
	byService=Class.forName(“com.elewei.service.ByService”);
	byService.setName(“启卫”);
	userService.setByeService(byService);
	applicationContext = new HashMap();
	applicationContext.put(“userService”, userService);
	applicationContext.put(“byService”, byService);

 
 
把ApplicationContext做成单例：
	
	< !-- src/applicationContext.xml -->
	<?xml version=“1.0” encoding=“UTF-8”?>
	
	<!DOCTYPE beans PUBLIC “-//SPRING/DTD BEAN/EN”
	    “http://www.springframework.org/dtd/spring-beans.dtd”>
	
	<beans>
		<bean id=“userService” class=“com.elewei.service.UserService”>
			<property name=“name”>
				<value>启卫</value>
			</property>
			<property name=“byService” ref=“byService”></property>
		</bean>
		
		<bean id=“byService” class=“com.elewei.service.ByService”>
			<property name=“name” value=“启卫”></property>
		</bean>
	</beans>

-------

	/* src/com.elewei.service/UserService.java */
	package com.elewei.service;
	
	public class UserService {
		private String name;
		
		private ByService byService;
		
		public ByService getByService() {
			return byService;
		}
	
		public void setByService(ByService byService) {
			this.byService = byService;
		}
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
		
		public void sayHello() {
			System.out.println(“Hello “ + name);
			byService.sayBye();
		}
		
	}

------
	
	/* src/com.elewei.service/UserService.java */
	package com.elewei.service;
	
	public class ByService {
		private String name;
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
		
		public void sayBye() {
			System.out.println(“bye + “ + name);
		}
	}

------
	
	/* com.elewei.util.ApplicationContextUtil.java */
	package com.elewei.util;
	
	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;
	
	final public class ApplicationContextUtil {
		private static ApplicationContext ac = null;
		
		private ApplicationContextUtil() {
			
		}
		
		static {
			ac = new ClassPathXmlApplicationContext(“applicationContext.xml”);
		}
		
		public static ApplicationContext getApplicationContextUtil() {
			return ac;
		}
	}


-------

	/* src/com.elewei.test/Test.java */
	package com.elewei.test;
	import com.elewei.service.UserService;
	import com.elewei.util.ApplicationContextUtil;
	
	public class Test {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
	//		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(“applicationContext.xml”);
	//		UserService userService = (UserService) ac.getBean(“userService”);
	//		userService.sayHello();
			
	//		ByService byService = (ByService) ac.getBean(“byService”);
	//		byService.sayBye();
			
			((UserService)ApplicationContextUtil.getApplicationContextUtil().getBean(“userService”)).sayHello();;
	
		}
	
	}





