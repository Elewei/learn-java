package com.elewei.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		

		
		//接收用户名与密码与验证码
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String checkcode = request.getParameter("checkcode");
		
		//取出session中验证码
		String sessioncheckcode = (String) request.getSession().getAttribute("checkcode");
		
		//比较
		if(checkcode.equals(sessioncheckcode)) {
			//验证码成功
			//到数据认证
		}
		
		//查看用户是否保存用户名与密码
        String value = request.getParameter("iskeepinfo");
        if(value != null && value.equals("keep")) {
        	//创建cookie， 并保存用户名
        	Cookie cookie = new Cookie("id",id);
        	cookie.setMaxAge(7*2*3600*24);
        	response.addCookie(cookie);
        	System.out.println("cooke创建成功");
        }
		
		//创建UsersService对象，完成用户登录验证
		UsersService usersService = new UsersService();
		Users user = new Users();
		user.setId(Integer.parseInt(id));
		user.setPassword(password);
		
        if(usersService.checkUser(user)) {
           
        	//把user对象保存到session中
        	HttpSession session = request.getSession();
        	session.setAttribute("login", user);
        	
        	
        	//说明该用户合法
           request.getRequestDispatcher("/MainFrame").forward(request, response);
           
           
        } else {
           //不合法
           request.setAttribute("err", "用户ID或密码有误！");
           request.getRequestDispatcher("/LoginServlet").forward(request, response);
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
