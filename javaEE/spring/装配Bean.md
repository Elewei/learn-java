<<<<<<< HEAD
###一、理解IOC控制反转  
依赖注入（di）：比IOC更好的名字，获得依赖对象的方式反转了，本质是创建应用对象之间的协作关系

spring开发提倡接口编程，配合di技术可以解决层与层之间解耦

使用spring接口编程，实现一个大小写字母大小写转换的案例：

思路：
第1步：创建一个接口 ChangeLetter
第2步：两类类实现接口
第3步：把对象配置到spring
第4步：使用


di配合接口编程，可以减少（WEB）层与层(业务层)之间的耦合度。


###二、装配Bean

装配bean的三种装配机制：
在xml进行显式配置
在java中进行显式配置
隐式的bean发现机制和自动装配

bean工厂：最简单的容器，提供了基础的依赖注入支持。创建各种类型的Bean.
ApplicationContext(应用上下文)：建立在bean工厂基础之上，提供系统架构服务。
区别：
如果我们使用beanfactory去获取bean，当你只是实例化该容器，容器的bean不会被实例化，只有当你去使用getBean某个bean时，才会实时创建。
如果使用ApplicationContext则该配置在使用singleton的时候bean被实例化，如果scope配置成prototype的时候，则会不会创建

如果不是特别节约内存，使用ApplicationContext获取bean，直接创建实例。


<bean scope=“singleton | prototype | request | session” />
singleton: 单例 默认值(所创建的所有对象都一样)
prototype: 原型(每次都会创建一个新的实例)
request: 一次请求有效
session: session级有效
double session: web中和spring容器相关联 


三种获取ApplicationContext经常用到的实现：
ClassPathXmlApplicationContext: 从类路径中加载
FileSystemXmlApplicationContext: 从文件系统加载
XmlWebApplicationContext: 从web系统中加载
AnnotationConfigApplicationContext: 从java配置文件中加载应用上下文
AnnotationConfigWebApplicationContext

第一种：

		//从ApplicationContext中取bean
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/elewei/ioc/beans.xml");
		
		Student s1 = (Student) ac.getBean("student");
		Student s2 = (Student) ac.getBean("student");
		System.out.println(s1);
		System.out.println(s2);
		
第二种：

	ApplicationContext ac = new FileSystemXmlApplicationContext("beans.xml");
	Student s1 = (Student) ac.getBean("student");
	Student s2 = (Student) ac.getBean("student");
	System.out.println(s1);
	System.out.println(s2);

第三种：



从bean工厂获取bean

			//从bean工厂中取bean
	//		Resource res = new ClassPathResource(“com/elewei/ioc/beans.xml”); 
	//		DefaultListableBeanFactory factory= new DefaultListableBeanFactory (); 
	//		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory); 
	//		reader.loadBeanDefinitions(res);
	//		factory.getBean(“student”);


自动装配
组件扫描（component scanning）:spring会自动发现应用上下文所创建的bean
自动装配(自动装配):spring自动满足bean之间的依赖


应用上下文加载完毕后，可以调用上下文的getBean()方法从spring容器中获取bean

Spring Bean的生命周期 

![](bean生命周期.png)

第一步：实例化，当我们加载beans.xml（scope=singleton）文件时，就开始实例化到内存中。（构造函数被调用）
第二步： 填充属性
第三步：调用BeanNameAware的setBeanName方法
第四步：调用BeanFactoryAware的setBeanFactory方法
第五步：调用ApplicationContextAware的setApplicationContext()方法
第六步：调用BeanPostProcessor的预初始化方法
第七步：调用InitializingBean的afterPropertiesSet的方法
第八步：调用自定义的初始化方法
第九步：调用BeanPostProcessor的初始化后的方法
第10步：bean可以使用了


第11步：容器关闭
调用DispostableBean的destory()方法
调用自定义的销毁方法
=======
装配Bean

在spring容器内拼凑bean叫做装配。装配bean的时候，需要告诉容器哪些bean以及容器如何使用依赖注入将他们配合在一起。

对bean的最基本的配置包括bean的id与class

基本装配scope
prototype,singleton, request session, global-session


如何给集合注入类型注入值：
java中主要的集合类型：list, map, set, 数组

定义Department

	package com.elewei.beanlife;
	
	import java.util.List;
	import java.util.Map;
	import java.util.Set;
	
	public class Department {
	private String name;
	private String [] empName;
	private List<Employee> empList;
	private Set<Employee> empSets;
	private Map<String, Employee> empMaps;
		
	public Map<String, Employee> getEmpMaps() {
		return empMaps;
	}
	public void setEmpMaps(Map<String, Employee> empMaps) {
		this.empMaps = empMaps;
	}
	public Set<Employee> getEmpSets() {
		return empSets;
	}
	public void setEmpSets(Set<Employee> empSets) {
		this.empSets = empSets;
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getEmpName() {
		return empName;
	}
	public void setEmpName(String[] empName) {
		this.empName = empName;
	}
	
	
}

	
------
	
	package com.elewei.beanlife;
	
	public class Employee {
	private String name;
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	}
	
-------
	<?xml version=“1.0” encoding=“UTF-8”?>
	
	<!DOCTYPE beans PUBLIC “-//SPRING//DTD BEAN 2.0//EN”
	    “http://www.springframework.org/dtd/spring-beans-2.0.dtd”>
	
	<beans>
	
	<bean id="department" class="com.elewei.beanlife.Department"   >
		<property name="name">
			<value>财务部</value>
		</property>
		<property name="empName">
			<list>
				<value>小明</value>
				<value>小红</value>
				<value>小张</value>
			</list>
		</property>
		<property name="empList">
			<list>
				<ref bean="emp1"></ref>
				<ref bean="emp2"></ref>
			</list>
		</property>
		<property name="empSets">
			<set>
				<ref bean="emp1"></ref>
				<ref bean="emp2"></ref>
			</set>
		</property>
		<property name="empMaps">
			<map>
				<entry key="1" value-ref="emp1"></entry>
				<entry key="2" value-ref="emp2"></entry>
			</map>
		</property>
	</bean>
	
	<bean id="emp1"  class="com.elewei.beanlife.Employee">
		<property name="name">
			<value>北京</value>
		</property>
		<property name="id">
			<value>1</value>
		</property>
	</bean>
	
	<bean id="emp2"  class="com.elewei.beanlife.Employee">
		<property name="name">
			<value>天津</value>
		</property>
		<property name="id">
			<value>2</value>
		</property>
	</bean>

	
	
<!-- 	<bean id="personService2" class="com.elewei.beanlife.PersonService"   >
		<property name="name">
			<value>小红</value>
		</property>
		<property name="age">
			<value>23</value>
		</property>
	</bean> -->
	
	</beans>
	
-----

	package com.elewei.beanlife;
	
	import java.util.Iterator;
	import java.util.Map;
	import java.util.Map.Entry;
	
	import org.springframework.beans.factory.BeanFactory;
	import org.springframework.beans.factory.support.BeanDefinitionRegistry;
	import org.springframework.beans.factory.support.DefaultListableBeanFactory;
	import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
	import org.springframework.beans.factory.xml.XmlBeanFactory;
	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;
	import org.springframework.context.support.FileSystemXmlApplicationContext;
	import org.springframework.core.io.ClassPathResource;
	import org.springframework.core.io.Resource;
	
	public class App3 {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			//从ApplicationContext中取bean
			ApplicationContext ac = new ClassPathXmlApplicationContext(“com/elewei/beanlife/beans.xml”);
			Department department = (Department) ac.getBean(“department”);
			
			System.out.println(department.getName());
			for(String empName:department.getEmpName()) {
				System.out.println(empName);
			}
			
			System.out.println(“****通过list集合取出数据****”);
			for(Employee e: department.getEmpList()) {
				System.out.println(e.getName() + e.getId());
			}
			
			System.out.println(“****通过set集合取出数据****”);
			for(Employee e: department.getEmpSets()) {
				System.out.println(e.getName() + e.getId());
			}
			
	//		System.out.println(“****通过map集合取出数据****”);
	//		for(Entry<String, Employee> entry1:department.getEmpMaps().entrySet()) {
	//			System.out.println(entry1.getKey() + “ “ + entry1.getValue().getName());
	//		}
			
			//使用Iterator获取map
			Map<String,Employee> empmaps = department.getEmpMaps();
			Iterator it = empmaps.keySet().iterator();
			while(it.hasNext()) {
				String key = (String) it.next();
				Employee emp = empmaps.get(key);
				System.out.println(“key” + key + “ “ + emp.getName());
				
			}
			
			
			
		}
	
	}


set注入是一种方式，还有一种	通过构造函数注入值。
set注入的缺点无法清晰
	
	//beans.xml配置文件
	<bean id="employee" class="com.elewei.constructor.Employee">
		<constructor-arg index="0" type="java.lang.String" value="大明" />
		<constructor-arg index="1" type="int" value="23" />
	</bean>	
	

-------

	package com.elewei.constructor;
	
	public class Employee {
		private String name;
		private int age;
		
		public Employee() {
			super();
		}
		public Employee(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
		
	}



自动装配bean的属性值（autowire）的五种方式：
no
byName: 根据内存中对象的名字匹配
byType: 根据内存中对象的类型匹配
constructor: 通过构造函数来进行匹配
autodetect: 在byName 与 constructor 自动发现
default: 在beans中default-autowire=“*type*”

byName案例用法配置：

	<bean id=“master” class=“com.elewei.autowire.Master” autowire=“byName”>
		<property name=“name” value=“启卫” />
	</bean>
	
	<bean id="dog" class="com.elewei.autowire.Dog">
		<property name="name" value="大黄" />
		<property name="age" value="3" />
	</bean>	


该配置会启用注解
<context:annotation-config />


使用spring特殊的bean
通过配置后加工bean，涉及到Bean和Bean工厂生命周期。
改变依赖注入，将字符串转换成其他类型。
从属性文本装载信息，包括信息国际化。
监听并处理其他bean及spring发布的系统消息。
知道自己在spring中的唯一标识。



>>>>>>> 4d9022e13ec9e64d18ea884d2a033c21c98001ed










