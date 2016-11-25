package com.elewei.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//解决中文乱码
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//返回一个界面（html技术）
		PrintWriter out = response.getWriter(); 
		out.println("<h1>用户登录</h1>");
		//action写法 /web应用名/Servlet的url
		out.println("<form action='/UsersManager/LoginClServlet' method='post'>");
		out.println("用户id：<input type='text' name='id' /><br/>");
		out.println("密　码：<input type='password' name='password' /><br/>");
		out.println("<input type='submit' value='登录' /><br/>");
		out.println("</form>");
		String errinfo = (String) request.getAttribute("err"); 
		if(errinfo != null) {
			out.println("<font color='red'>" + errinfo + "</font>");
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
