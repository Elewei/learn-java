package com.elewei.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elewei.domain.Users;
import com.elewei.service.UsersService;

import java.sql.*;

/**
 * Servlet implementation class LoginClServlet
 */
@WebServlet("/LoginClServlet")
public class LoginClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//接收用户名与密码
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		//创建UsersService对象，完成用户登录验证
		UsersService usersService = new UsersService();
		Users user = new Users();
		user.setId(Integer.parseInt(id));
		user.setPassword(password);
		
        if(usersService.checkUser(user)) {
           //说明该用户合法
           request.getRequestDispatcher("/MainFrame").forward(request, response);;
        } else {
           //不合法
           request.setAttribute("err", "用户ID或密码有误！");
           request.getRequestDispatcher("/LoginServlet").forward(request, response);;
        }
            
		
		
//		//简单判断
//		if("qiwei".equals(username) && "123".equals(password)) {
//			//跳转到下一个页面 sendRedirect URL 写法 /web应用名称/servlet URL
//			response.sendRedirect("/UsersManager/MainFrame");
//		} else {
//			//跳回
//			response.sendRedirect("/UsersManager/LoginServlet");
//			out.println("用户名或密码错误");
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
