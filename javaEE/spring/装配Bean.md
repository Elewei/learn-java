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











