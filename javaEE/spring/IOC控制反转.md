一、理解IOC控制反转  
依赖注入（di）：比IOC更好的名字，获得依赖对象的方式反转了。  

spring开发提倡接口编程，配合di技术可以解决层与层之间解耦

使用spring接口编程，实现一个大小写字母大小写转换的案例：

思路：
第1步：创建一个接口 ChangeLetter
第2步：两类类实现接口
第3步：把对象配置到spring
第4步：使用


di配合接口编程，可以减少（WEB）层与层(业务层)之间的耦合度。


二、装配Bean
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



Bean的生命周期 

![](bean生命周期.png)

第一步：实例化，当我们加载beans.xml（scope=singleton）文件时，就开始实例化到内存中。（构造函数被调用）
第二步：







