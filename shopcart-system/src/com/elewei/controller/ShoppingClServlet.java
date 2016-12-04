package com.elewei.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elewei.services.BooksService;
import com.elewei.services.MyCart;;

/**
 * Servlet implementation class ShoppingClServlet
 */
@WebServlet("/ShoppingClServlet")
public class ShoppingClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//接收type值，区分用户想要做什么del, add, update..
		String type = request.getParameter("type");
		
		if(type.equals("del")) {
			
			//删除商品
			String id = (String) request.getParameter("id");
			//得到购物车(从session中获取购物车)
			MyCart cart = (MyCart) request.getSession().getAttribute("cart");
			cart.delBook(id);
			request.setAttribute("totalPrice", MyCart.getTotalPrice());
			request.setAttribute("bookList", MyCart.showMyCart() );
			request.getRequestDispatcher("/WEB-INF/showMyCart.jsp").forward(request, response);
			
		} else if(type.equals("add")) {
			//接收书籍ID号
			String id = (String) request.getParameter("id");
			
			//当用户登录成功后，创建购物车
			MyCart cart = (MyCart) request.getSession().getAttribute("cart");
			cart.addBook(id);
			
			//把要显示的数据放入request中，准备显示
			request.setAttribute("bookList", MyCart.showMyCart() );
			request.setAttribute("totalPrice", MyCart.getTotalPrice());
			
			//跳转显示我的购物车
			request.getRequestDispatcher("/WEB-INF/showMyCart.jsp").forward(request, response);
		} else if(type.equals("update")) {
			//更新,得到用户希望更新的书号与数量
			String bookIds[] = request.getParameterValues("id");
			String nums[] = request.getParameterValues("bookNum");
			MyCart cart = (MyCart) request.getSession().getAttribute("cart");
			for(int i=0; i<bookIds.length; i++) {
				//更新购物车
				MyCart.updateBook(bookIds[i], nums[i]);
			}
			
			//跳转到我的购物车
			//把要显示的数据放入request中，准备显示
			request.setAttribute("bookList", MyCart.showMyCart() );
			request.setAttribute("totalPrice", MyCart.getTotalPrice());
			
			//跳转显示我的购物车
			request.getRequestDispatcher("/WEB-INF/showMyCart.jsp").forward(request, response);
			
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
