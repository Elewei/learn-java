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
 * Servlet implementation class UpdateUserView
 */
@WebServlet("/UpdateUserView")
public class UpdateUserView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserView() {
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
		
		//获取从控制器传递的users对象
		Users user = (Users) request.getAttribute("userinfo");
		//显示
		out.println("<h1>修改用户</h1>");
		out.println("<form action='/UsersManager/UserClServlet?type=update' method='post' />");
		out.println("<table border=1px bordercolor=green cellspacing=0 width=200px >");
		out.println("<tr><td>ID号</td><td><input type='text' name='id' readonly value='"+user.getId()+"' /></td></tr>");
		out.println("<tr><td>用户名</td><td><input type='text' name='username' value='"+user.getName()+"' /></td></tr>");
		out.println("<tr><td>密码</td><td><input type='text' name='password' value='"+user.getPassword()+"' /></td></tr>");
		out.println("<tr><td>邮箱</td><td><input type='text' name='email' value='"+user.getEmail()+"' /></td></tr>");
		out.println("<tr><td>级别</td><td><input type='text' name='grade' value='"+user.getGrade()+"' /></td></tr>");
		out.println("<tr><td><input type='submit' value='修改用户' /></td><td><input type='reset' value='重新填写' /></td></tr>");
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
