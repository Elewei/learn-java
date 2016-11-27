package com.elewei.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elewei.domain.Users;

/**
 * Servlet implementation class MainFrame
 */
@WebServlet("/MainFrame")
public class MainFrame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainFrame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//取出login的session, 封装成函数，或者过滤器
		Users u = (Users) request.getSession().getAttribute("login");
		
		if(u == null) {
			//非法用户
			request.setAttribute("err", "请输入用户名与密码登录");
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
			return;
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>欢迎登录</h1>");
		out.println("<a href='LoginServlet'>重新返回登录界面</a>");
		
		out.println("<h3>请选择操作</h3>");
		out.println("<a href='/UsersManager/ManagerUsers'>管理用户</a><br />");
		out.println("<a href='/UsersManager/UserClServlet?type=gotoAddView'>添加用户</a><br />");
		out.println("<a href=''>查找用户</a><br />");
		out.println("<a href=''>退出系统</a><br />");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
