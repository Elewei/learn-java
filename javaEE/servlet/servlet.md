#Servlet介绍
**为什么会出现servlet?**  

需求：使用现有的java技术，开发一个动态网页，比如可以让用户留言，其他人可以回复。


**Servlet容器是如何工作的？** 
 
一个servlet容器要为一个servlet请求提供服务，有**三件事情**要做：

- **创建一个request对象**并填充那些有可能被引用的servlet使用的信息，如参数、头部、cookies、查询字符串、URI等。  
- **创建一个response对象**，所引用的servlet使用它来给客户端发送响应。
- **调用servlet的service方法**，并传入request和response对象，这里servlet会从request对象取值，给response写值。


**什么是servlet（Java 服务器小程序）**  

- servlet是用java编写的服务器程序，它的特点：
- 他是由服务器端（Tomcat）调用和执行的
- 他是用java编写的
- 他是按照servlet规范开发的
- 功能强大，可以完成几乎所有网站功能
- 是学习JSP的基础

Servlet技术是在java EE 出现之前就存在了，在开发动态网页中，得到广泛的应用，直到现在的java EE项目中也是非常重要的，同时JSP也是在servlet的基础上发展起来的。


![](http://i.imgur.com/bLctHcf.png)


开发servlet有三种方法
1. 实现servlet接口
2. 继承GenericServlet
3. 继承HttpServlet

需求：请使用实现servlet接口的方式来开发一个servlet，要求该servlet能够返回一句话, hello,world， 同时显示当前时间。

步骤：
第一步：在tomcat发布目录中先建立一个web应用，
第二步：建立WEB-INF目录，拷贝创建web.xml文件
第三步：创建classes 与 lib 目录
第四步：在classes目录下创建MyFirstServlet.java文件
第五步：编辑MyFirstServlet.java文件
	package com.web;

	import javax.servlet.*;
	import java.io.*;
	import java.servlt.http.*;

	class MyFirstServlet implements Servlet {
	//该函数用于初始化servlet， 就是把该servlet装载到内存中，只运行一次
	public void init(ServltConfig config) throws ServletException {
		
	}
	
	//得到servletcofnig对象
	public ServletConfig getServletConfig() {
		return null;
	}
	
	//该函数是服务函数，我们的业务逻辑代码写在这里
	//该函数每次请求都会被调用
	public void service(ServletRequest req, ServletResponse res) throws ServletException, java.io.IOException {
		
	}
	
	//得到servlet的配置信息
	public java.lang.String getServletInfo() {
		return null;
	}
	
	//销毁该servlet，从内存中清除，在整个过程中被调用一次
	public void destroy() {
		
	}

	}

第六步：编译javac -d . MyFristServlet.java
第七步：部署Servlet到web.xml文件




















