package com.elewei.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elewei.domain.Users;
import com.elewei.services.UsersService;

/**
 * Servlet implementation class toHallServlet
 */
@WebServlet("/ToHallServlet")
public class ToHallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToHallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//得到从登录页面传递的用户名与密码
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");

		System.out.println("username + password");
		
//		Users loginUser = new Users("username","password");
//		//使用业务逻辑完成验证
//		UsersService usersService = new UsersService();
//		if(usersService.checkUser(loginUser)) {
//			//合法用户，跳转到购物大厅
//			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);;
//		} else {
//			//不合法
//			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
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
