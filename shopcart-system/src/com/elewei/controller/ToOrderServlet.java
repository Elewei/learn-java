package com.elewei.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elewei.services.MyCart;

/**
 * Servlet implementation class ToOrderServlet
 */
@WebServlet("/ToOrderServlet")
public class ToOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//处理用户查看订单的请求
		//得到购物车
		MyCart cart = (MyCart) request.getSession().getAttribute("cart");
		ArrayList al = cart.showMyCart();
		float totalPrice = cart.getTotalPrice();
		request.setAttribute("orderinfo", al);
		request.setAttribute("totalPrice", totalPrice);
		//跳转到显示我的订单
		request.getRequestDispatcher("/WEB-INF/showMyOrder.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
