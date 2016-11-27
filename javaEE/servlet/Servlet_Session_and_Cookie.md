#Servlet 会话技术

什么是会话？
会话可简单的理解为：用户开一个浏览器访问某个网站，点击多个超链接，访问服务器多个web资源，然后关闭浏览器，整个过程称之为一个会话。

会话过程中要解决的一些问题？
每个用户在使用浏览器与服务器进行会话的过程中，不可避免各自会产生一些数据，服务器要想办法为每个用户保存这些数据。

##Cookie技术
为什么需要cookie？
如何保存用户上次登录时间？
如何显示用户曾经浏览历史？
如何把登录的用户名或密码保存到电脑？
网站的个性化

cookie是客户端技术，服务器把每个用户的数据以cookie的形式写给用户各自的浏览器。当用户使用浏览器再去访问该服务器中的web资源时，就会带着各自的数据去。这样，WEB资源处理的就是用户各自的数据了。


cookie原理：(服务器向浏览器推送cookie)
第一步：浏览器向web服务器发出请求
第二步：web服务器找到servlet
第三步：servlet创建cookie
第四步: web服务器将数据推送到浏览器的缓存中

当服务器向浏览器读取cookie信息时
浏览器会在请求头中增加cookie信息

Servlet创建cookie步骤：

	Cookie cookie = new Cookie("name","qiwei"); //创建cookie
	cookie.setMaxAge(3600);	//设置cookie生命周期（秒）
	response.addCookie(cookie);   //把cookie信息回写给浏览器

Servlet读取cookie步骤

		//读取所有cookie信息，再选择
		Cookie [] cookies = request.getCookies();
		
		//循环遍历所有cookie信息
		for(int i=0; i<cookies.length; i++) {
			Cookie cookie = cookies[i];
			out.println("name="+cookie.getName()+"value="+cookie.getValue());
		}
		
cookie小结：
1. cookie在服务器端创建
2. cookie是保存在浏览器这端
3. cookie的生命周期可以通过cookie.setMaxAge()来设置，如果不设置生命周期，则浏览器关闭时，则消失(cookie运行在内存中)
4. cookie可以被多个浏览器共享
5. cookie可以理解为一张2列的表，第一列表示String类型的name, 第二列是String类型的value
6. 如果cookie重名，则会替换存在的cookie值
7. 一个web站点可以保存不超过20个cookie, 一个浏览器最多放300个cookie，每个cookie限制在4k
8. cookie以明文方式存放，安全性较低，可以通过加密后在保存


实际用例：使用cookie显示上次最后访问时间
	
	CreateCookie.java
	package com.elewei.session;
	
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.text.SimpleDateFormat;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.Cookie;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	/**
	 * Servlet implementation class CreateCookie
	 */
	@WebServlet("/CreateCookie")
	public class CreateCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		
		//第一步：获取cookie, 假设我们上次登录时间的cookie存储格式为："lastlogintime" "2011-11-11 12:12:12";
		//读取所有cookie信息，再选择
		Cookie [] cookies = request.getCookies();
		
		//如果是第一次登录：则显示欢迎您登录系统
		boolean b = false;	//假设没有这个cookie
		
		//循环遍历所有cookie信息
		if(cookies != null) {
			
			for(Cookie cookie:cookies) {
				//取出名字：
				String name = cookie.getName();
				if("lastlogintime".equals(name)) {
					out.println("你最后一次登录时间为：" + cookie.getValue());
					//把当前日期保存到cookie中
					SimpleDateFormat simpledateformat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
					String nowTime = simpledateformat.format(new java.util.Date());
					Cookie updatecookie = new Cookie("lastlogintime",nowTime); //创建cookie
					updatecookie.setMaxAge(7*3600*24);
					response.addCookie(updatecookie);   //把cookie信息回写给浏览器
					b = true;
					break;
				}
				
			}
		}
		if(b == false) {
			//没有找到lastlogintime这个cookie
			out.println("欢迎您登录本系统");
			//把当前日期保存到cookie中
			SimpleDateFormat simpledateformat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			String nowTime = simpledateformat.format(new java.util.Date());
			Cookie cookie = new Cookie("lastlogintime",nowTime); //创建cookie
			cookie.setMaxAge(7*3600*24);
			response.addCookie(cookie);   //把cookie信息回写给浏览器
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	}
	
cookie相关函数
public Cookie(Stirng name, String value)
setValue 与 getValue 方法
setMaxAge 与 getMaxAge 方法
getName 方法



##Session技术
如何实现在不同页面，可以去查看信息（比如说购物车），同时还要实现不同的用户看到的信息是自己的

session是服务器端技术，利用这个技术，服务器在运行时可以为每一个用户的浏览器创建一个其共享的session对象，由于session为用户浏览独享，所以用户在访问服务器的web资源时，可以把各自的数据放在各自的session中，当用户再去访问服务器中的其它web资源时，其它web资源再从用户各自的session中取出数据为用户服务。

当用户打开浏览器，访问某个网站时操作session时，服务器就会在服务器内存为该浏览器分配一个session对象，该session对象被**这个浏览器独占**。

session对象也可看做是一个容器，session对象默认存在时间为**30min**。


Session可以用来做什么？
1. 网上商城中的购物车
2. 保存登录用户的信息
3. 将某些数据放入到session中，供同一用户的各个页面使用
4. 防止用户非法登录到某个页面


session创建步骤：
		
		//获取session
		HttpSession session = request.getSession();
		
		//给该sesssion放入属性
		session.setAttribute("uname", "宋江");
		session.setAttribute("age", "100");
		
		//创建对象实例
		User user = new User();
		user.setName("启卫");
		user.setColor("蓝色");
		
		session.setAttribute("people", user);

session 读取步骤：
		
		//获取session
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("uname");
		System.out.println("Session是"+uname);
		
		User user = (User) session.getAttribute("people");
		if(user != null) {
			out.println("人的名字" + user.getName() + "颜色" + user.getColor());
		}

session删除：
	session.removeAttribute("age");
	

session小结：
session存在服务器内存中
默认生命周期30min，可通过web.xml文件修改
一个用户浏览器独享一个session域对象
session中可以存放多个属性
session可以存放对象
如果sessionsetAttribute("name","obj"),如果名字重复，则会替换

www.sourceforge.net[开源]

服务器是如何实现一个session为一个用户浏览器服务的？
当用户的一个浏览器访问一个WEB资源时，假设这个web资源创建了一个session,且id号为100， web服务器还会在浏览器A上创建一个cookie, id号也为100， 当浏览器A去访问第二个web资源时，会把cookie信息一起传送过去，服务器发现有100的id，则会调用session 号为100的这个session。

验证码：
第一步:生成验证码
第二步：在登录界面中增加验证码
第三步：在验证登录servlet中使用session判断验证码是否正确












