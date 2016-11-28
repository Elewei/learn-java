#ServletContext


为什么需要ServletContext?

在访问某个网站的时候，网站首页页面上显示您是第几位浏览者（网站计数器），这是怎么实现的？


访问某个BBS网站的时候，往往会显示有多少人在线。这是怎么实现的？


如果涉及到不同用户共享数据，而这些数据量不大，同时又不希望写入数据库中，我们就可以考虑使用ServletContext

实现思路：使用文件或数据库保存信息，定义visitNum初始值为0，来一个人visitNum增加一
缺点：对数据库或文件访问过于频繁

什么是ServletContext?


可以把它想像成是一个共用的空间，可以被所有客户访问。

![](/Users/David/Documents/java/learn-java/javaEE/servlet/servletContext.tiff)

Web容器在启动时，它会为每个WEB应用程序都创建一个对应的ServletContext对象，它代表当前web应用

ServletContext对象可以通过`ServletConfig.getServletContext`方法获得对ServletContext对象的引用，也可以通过`this.getServletContext()`来获得其对象的引用。

由于一个WEB应用中的所有Servlet共享同一个ServletContext对象，因此Servlet对象之间可以通过ServletContext对象来实现通讯。ServletContext对象通常也被称之为Context域对象。公共聊天室就会用到它。

创建ServletContext的两种方法实例：

	//servletCreate.java	
	//1. 获取ServletContext对象引用 
	this.getServletContext().setAttribute("uname", "启卫");;
	
	//2. 通过ServletConfig获取
	this.getServletConfig().getServletContext().setAttribute("sex", "男");;

 读取servletContext中的信息
	
	ServletRead.java
	//取出ServletContext某个属性
	String uname = (String) this.getServletContext().getAttribute("uname");
	String sex = (String) this.getServletContext().getAttribute("sex");
	out.println(uname);
	out.println(sex);

	//删除sex属性
	this.getServletContext().removeAttribute("sex");
	out.print("删除servletContext sex: " +sex+"<br />");


ServletContext应用


* 多个Servlet通过ServletContext对象实现数据共享  
* 获取Web应用的初始化参数  
* 实现Servlet的转发  
* 利用ServletContext对象读取资源文件（.properties文件）  
* 读取资源文件（读web目录下和WEB-INF目录下的文件）  
* 得到文件路径  

**获取web应用的初始化参数**
	
	//web.xml
 	<!--如果希望所有的servlet都可以访问该配置-->
  	<context-param>
  		<param-name>name</param-name>
  		<param-value>scotte</param-value>
  	</context-param>
  	

	
	//ServletContextRead.java
	//取出ServletContext某个属性
	String val = this.getServletContext().getInitParameter("name");
	out.println(val);


**使用servletContext实现servlet转发**

		//目前我们跳转到下一个页面有以下几种方法
		//1. response.sendRedirect("/web应用名/资源名");
		//2. request.getRequestDispatcher("/资源名").forward(request, response);
		/*
		 * 区别1: getRequestDispacher 一个跳转发生在web服务器， sendRedirect发生在浏览器 
		 * 区别2：如果request.setAttribute("name","qiwei") 如果希望下一个页面使用属性值，则使用getRequestDispacher
		 * 区别3：如果session.setAttribute("name","qiwei") 如果希望下一个页面使用属性值，两个方法都可以使用，建议使用getRequestDispacher
		 * 区别4：如果希望跳转到本WEB应用以外的URL，则只能使用sendRedirect
		 */
		//这个本质和request.getRequestDispacher一样
		this.getServletContext().getRequestDispatcher("/web/url").forward(request, response);


**读取webContent目录下的资源文件**

**第一步**：在webContent目录下新建dbinfo.properties文本文件
	
	//dbinfo.properties
	username=scott
	password=12345

**第二步**：创建ServletContextRead.java文件
	
	//ervletContextRead.java
	//读取到文件
	InputStream inputstream = this.getServletContext().getResourceAsStream("dbinfo.properties");
		
	//创建properties
	Properties pp = new Properties();
	pp.load(inputstream);
		
	//打印
	out.println("name = " + pp.getProperty("username"));
	out.println("password= " + pp.getProperty("password"));


**获取webContent目录下图片的绝对路径**


**第一步**：在webContent目录下新建一个文件夹，拷贝图片到该目录下

**第二步**：创建ServletContextRead.java文件
	
	//ServletContextRead.java
	//如何读取一个文件的全路径
	String path = this.getServletContext().getRealPath("/img/servletContext.tiff");
	out.println(path);


**实际案例：网站计数器**

怎样才是一次有效的点击？ 各个网站有不同的标准  
1. 只要访问过该网页，就算是一次，刷新一次也算。  
2. 不同的ip访问该网页，算一次有效点击； 如果是同一ip在一定时间（比如1天），不管浏览该网页多少次都处一次。  
3. 用户退出网站，再次访问也算一次。


实现第3种：


