#JSP 技术

**为什么出现JSP（Java Server Page）？**  
在开发WEB的时候，使用servlet做界面非常麻烦，于是又有一个新技术JSP。

JSP运行在服务器端
JSP的基础是servlet(相当于对servlet进行了包装)
JSP是一个综合技术 

JSP = HTML + CSS + JS + JAVA片段 + JSP标签

**使用JSP输出当前时间**
	
	<% --ShowTime.jsp-->
	<%@ page language=“java” contentType=“text/html; charset=UTF-8”
	    pageEncoding=“UTF-8”%>
	<!DOCTYPE html PUBLIC “-//W3C//DTD HTML 4.01 Transitional//EN” “http://www.w3.org/TR/html4/loose.dtd”>
	<html>
	<head>
	<meta http-equiv=“Content-Type” content=“text/html; charset=UTF-8”>
	<title>Insert title here</title>
	</head>
	<body>
		<%
			out.println(“hello,world!” + “当前日期” + new java.util.Date());
		%>
	</body>
	</html>


**JSP工作原理**


第一步：浏览器输入http://localhost:8080/ServeletProject/ShowTime.jsp请求资源  
第二步：web服务器接收请求，如果是第一次访问，把ShowTime.jsp翻译成一个servlet(ShowTime_jsp.java)文件，再将其编译成一个class(ShowTime_jsp.class)文件，将class文件装载入内存，如果是第二次以后访问，直接访问内存中的实例。


**JSP元素：**


**指令元素**：用于从JSP发送一个信息到容器，比如设置全局变量，文字编码，引入包等。  

**1. page指令**  

`<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>`

language=“”  
import=“包.*”  
session=[ “true” | ”false”], 默认为true
buffer=[none|**8k**|指定大小]给out对象使用的缓冲区是大小，默认8k  
autoFlash=[**true**|false] 当buffer满后，是否自动刷新到浏览器  
isThreadSafe=[**true**|false] 默认true表示该jsp的线程安全由程序员控制，false则对应的servlet将实现线程安全接口。  
errorPage=“相对jsp页面” 当jsp出现错误时，自动跳转到指定jsp页面。绝对路径  
isErrorPage  
contentType=“text/html; charset=utf-8” 指定网页以什么方式显示页面  
pageEncoding=“utf-8” 指定servlet引擎以什么方法翻译jsp->servlet 并 指定网页以什么方式显示页面

**2. include指令**


`<%@ include file=“/abc.jsp” %>`


**3. taglib指令**
<mytag:xx 属性 />

abc.jsp 保留page指令与内容信息，其他可以清除



**脚本元素**: java片段


1. scriptlet <% java代码 %>
2. 表达式： <%=表达式 %>
3. declaration声明

	<%! int i=0; %>  //成员变量
	<%! 定义函数 %> 



**动作元素**


1. `<jsp:forward> `转发
2. `<jsp:include file=“”>` 引入

动态引入：
`<%@ include file=“” %>` 静态引入  
`<jsp:include file=“”></jsp:include>` 动态引入  


区别：静态引入把两个jsp翻译成一个servlet, 动态引入把2个jsp分别编译

**JSP注释**


	<% -- 注释的内容 -->	//JSP专用注释  
	<!--注释的内容-->		//源码可以看到


**JSP九大内置对象**

1. out //向客户端输出数据，字节流
2. request //接收客户端的http请求 --HttpServletRequest
	getParameter(String name);	//name表示表单中的参数名
	getParameterValues(String name); //使用得到是String[]
	getAttribute(String name, Object obj); //设置名字为name的obj, 值为obj
	getAttribute(String name); //返回由name指定的属性值，如果不存在就返回null;
	getCookie();
3. response //封装jsp的产生回应 --HttpServletResponse
	addCookie(Cookie cookie);
	sendRedirect(“./welcome.jsp”);
4. session //用于保存用户的信息，跟踪用户的行为 --HttpSession
	getAttribute(String name, Object obj);
	getAttribute(String name);
5. application // 多个用户共享该对象，可以做计数器 --ServletContext
6. pageContext //代表JSP页面上下文，也是一个域对象，可以setAttribute(), 作用范围只是本页面
7. exception //代表运行时的一个异常
	getMessage();
8. page //代表jsp这个实例本身（使用比较少）
9. config //代表jsp对应的servlet的配置，可以得到web.xml的参数  -- ServletConfig


pageContext(域对象，存放的数据只能在当前页面使用)
request(域对象，存放的数据在一次request请求有效)
session(域对象，存放的数据在一次会话有效)
application(域对象，存放的数据在整个web应用运行期间有效)


