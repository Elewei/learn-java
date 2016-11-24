#目标：   

- HttpServletRequest对象使用
- HttpServletResponse对象使用
- 解决中文乱码问题
- 请求转发与重定向

![](http://i.imgur.com/8Uct6hk.png)


HttpServeletResponse接口继承ServletResponse，封装HTTP响应消息


##HttpServletResponse 常见应用

1. 向客户端输出数据(以OutputStream 和 PrintWriter 输出)
2. SendRedirect() 实现请求重定向（可以带数据给下一个页面）
3. 发送http头，控制浏览器禁止缓存当前文档内容
4. 文件下载
5. 生成随机验证码


通过HttpServletRespnose回送http头控制浏览器的行为
通过HttpServletResponse提供的函数完成相应的功能


##HttpServletRequest对象
HttpServletRequest对象代表客户端的请求，当客户端通过http协议访问服务器时，HTTP请求头中的所有信息都封装在这个对象中。

获得客户机信息：

1. getRequestURL方法返回客户端发出请求时的完整URL
2. getRequestURI方法返回请求中的资源名部分
3. getQueryString方法返回请求行中的参数部分（参数名+值）
4. getRemoteAddr方法返回发出请求的客户机的IP地址
5. getRemoteHost方法返回发出请求的客户机的完整主机名
6. getRemotePort方法返回客户机所使用的网络端口号
7. getLocalPort方法返回WEB服务器所使用的网络端口号
8. getLocalAddr方法返回WEB服务器的IP地址
9. getLocalName方法返回WEB服务器的主机名

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//得到URL
		String url = request.getRequestURL().toString();
		out.println("URL	:" + url);
		out.println("<br>");
		
		//得到URI
		String uri = request.getRequestURI();
		out.println("URI	:" + uri);
		out.println("<br>");
		
		//得到QueryString,获取
		String qs = request.getQueryString();
		out.println("得到URL？后信息：" + qs);
		out.println("<br>");
		
		//获取请求方的IP地址
		String clientaddr = request.getRemoteAddr();
		out.println("请求端IP地址：" + clientaddr);
		out.println("<br>");
		
		//获取请求方的主机名
		String clienthost = request.getRemoteHost();
		out.println("请求端的主机名：" + clienthost);
		out.println("<br>");
		
		//获取请求方的端口号
		int clientport = request.getRemotePort();
		out.println("客户端端口号：" + clientport);
		out.println("<br>");
		
		//获取WEB服务器地址
		String serveraddr = request.getLocalAddr();
		out.println("服务器端端口号：" + serveraddr);
		out.println("<br>");
		
		//获取WEB服务器端口号
		int serverport = request.getLocalPort();
		out.println("服务器端端口号：" + serverport);
		out.println("<br>");
		
		//获取WEB服务器主机名
		String serverhost = request.getLocalName();
		out.println("服务器端主机名：" + serverhost);
		out.println("<br>");

HttpServletRequest常用方法

1. 获得客户机请求头(getHeader方法 && getHeaderNames方法)
2. 获得客户机请求参数（客户端提交的参数）(getParameter方法 && getParameterValues(String name) && getParameterNames方法
3. 实现请求转发：一个WEB资源收到客户端请求后，通知服务器去调用另外一个WEB资源进行处理 getRequestDispatcher方法，该方法返回一个RequestDispatcher对象，调用这个对象的forward方法可以实现请求转发










