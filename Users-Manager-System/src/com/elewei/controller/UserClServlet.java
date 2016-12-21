package com.elewei.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elewei.domain.Users;
import com.elewei.service.*;

/**
 * Servlet implementation class DelClServlet
 */
@WebServlet("/UserClServlet")
public class UserClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserClServlet() {
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
		
		String type = request.getParameter("type");
		UsersService us = new UsersService();
		
		if("del".equals(type)) {
			String id = request.getParameter("id");		//接收id
			
			if(us.delUser(id)) {
				//成功，则跳转跳Ok界面
				request.getRequestDispatcher("/Ok").forward(request, response);
				
			} else {
				//失败，则跳转跳Error界面
				request.getRequestDispatcher("/Error").forward(request, response);
			}
		} else if("gotoUpdateView".equals(type)) {
			//要去修改界面
			//得到ID号
			String id = request.getParameter("id");		//接收id
			//通过ID获取userBean
			Users users = us.getUserById(id);
			//为了让下一个servlet接收到使用users对象，可以把该users对象放入到request对象中
			request.setAttribute("userinfo", users);
			//请求转发
			request.getRequestDispatcher("/UpdateUserView").forward(request, response);
			
		} else if("update".equals(type)) {
			//接收用户的新的信息
			String id = request.getParameter("id");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String grade = request.getParameter("grade");
			
			Users user = new Users(Integer.parseInt(id), username, password, email, Integer.parseInt(grade));
			//修改用户
			if(us.updateUser(user)) {
				//成功，则跳转跳Ok界面
				request.getRequestDispatcher("/Ok").forward(request, response);
			} else {
				//失败，则跳转跳Error界面
				request.getRequestDispatcher("/Error").forward(request, response);
			}
			
		} else if("gotoAddView".equals(type)) {
			//跳转
			request.getRequestDispatcher("/AddUserView").forward(request, response);
		} else if("add".equals(type)) {
			//接收用户信息
			String id = request.getParameter("id");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String grade = request.getParameter("grade");
			
			Users user = new Users(Integer.parseInt(id), username, password, email, Integer.parseInt(grade));
			
			if(us.addUser(user)) {
				//成功，则跳转跳Ok界面
				request.getRequestDispatcher("/Ok").forward(request, response);
			} else {
				//失败，则跳转跳Error界面
				request.getRequestDispatcher("/Error").forward(request, response);
			}
			
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
