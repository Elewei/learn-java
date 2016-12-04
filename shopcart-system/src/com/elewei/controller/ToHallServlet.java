package com.elewei.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elewei.domain.Users;
import com.elewei.services.BooksService;
import com.elewei.services.MyCart;
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
		
		if(request.getSession().getAttribute("loginUser") != null) {
			//说明是合法用户，给下一个页面hall.jsp提供数据
			BooksService booksService = new BooksService();
			ArrayList al = booksService.getAllBook();
			//把要显示的数据放入request中，request生命周期最短
			request.setAttribute("books", al);
			
			//合法用户，跳转到购物大厅
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
			return;
		}
		
		//得到从登录页面传递的用户名与密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Users loginUser = new Users(username,password);
		
		//使用业务逻辑完成验证
		UsersService usersService = new UsersService();
		
		if(usersService.checkUser(loginUser)) {
			
			request.getSession().setAttribute("loginUser", loginUser);
			
			//创建一个购物车
			MyCart cart = new MyCart();
			request.getSession().setAttribute("cart", cart);
			
			//说明是合法用户，给下一个页面hall.jsp提供数据
			BooksService booksService = new BooksService();
			ArrayList al = booksService.getAllBook();
			//把要显示的数据放入request中，request生命周期最短
			request.setAttribute("books", al);
			
			//合法用户，跳转到购物大厅
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
		} else {
			//不合法
			System.out.println("该用户不合法");
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
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
