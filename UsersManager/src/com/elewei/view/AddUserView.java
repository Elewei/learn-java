package com.elewei.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUserView
 */
@WebServlet("/AddUserView")
public class AddUserView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserView() {
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
		
		//显示
		out.println("<h1>添加用户</h1>");
		out.println("<form action='/UsersManager/UserClServlet?type=add' method='post' />");
		out.println("<table border=1px bordercolor=green cellspacing=0 width=200px >");
		out.println("<tr><td>ID号</td><td><input type='text' name='id' /></td></tr>");
		out.println("<tr><td>用户名</td><td><input type='text' name='username' /></td></tr>");
		out.println("<tr><td>密码</td><td><input type='text' name='password'  /></td></tr>");
		out.println("<tr><td>邮箱</td><td><input type='text' name='email'  /></td></tr>");
		out.println("<tr><td>级别</td><td><input type='text' name='grade'  /></td></tr>");
		out.println("<tr><td><input type='submit' value='添加用户' /></td><td><input type='reset' value='重新填写' /></td></tr>");
		out.println("</table>");
		out.println("</form>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
