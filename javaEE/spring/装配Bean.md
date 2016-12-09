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










