package com.elewei.view;

import java.io.*;
import java.sql.*;
import java.util.*;
import com.elewei.domain.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.elewei.service.UsersService;

/**
 * Servlet implementation class ManagerUsers
 */
@WebServlet("/ManagerUsers")
public class ManagerUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerUsers() {
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
		
		out.println("<script type='text/javascript' language='javascript'>");
		out.println("function gotoPageNow() { var pageNow=document.getElementById('pageNow'); "
				+ "window.open('/UsersManager/ManagerUsers?pageNow=' + pageNow.value, '_self');}"
				+ "function confirmOper() {window.confirm('真的要删除该用户吗？');}"
				);
		out.println("</script>");
		
		
		out.println("<h1>管理用户<h1>");
		
		
		//定义分页需要的变量
		int pageNow = 1; //当前页
		int pageSize = 3;  //指定每页显示3条记录
		int pageCount = 0;
		
		//接收用户用户的pageNow
		String spagenow = request.getParameter("pageNow");
		if(spagenow != null) { 
			pageNow = Integer.parseInt(spagenow);
		}
		
		
		try {
			
			UsersService usersService = new UsersService();
			ArrayList<Users> al = usersService.getUsersByPage(pageNow, pageSize);
			pageCount = usersService.getPageCount(pageSize);
			
			out.println("<table border=1 >");
			out.print("<tr><th>id</th><th>用户名</th><th>email</th><th>级别</th><th>删除用户</th><th>修改用户</th></tr>");
			
			for(Users u:al) {
				out.println("<tr>"
				+ "<td>"+u.getId()+"</td>"
				+ "<td>"+u.getName()+"</td>"
				+ "<td>"+u.getEmail()+"</td>"
				+ "<td>"+u.getGrade()+"</td>"
				+ "<td><a onClick='return confirmOper()' href='/UsersManager/UserClServlet?type=del&id="+u.getId()+"'>删除用户</a></td>"
				+ "<td><a href='/UsersManager/UserClServlet?type=gotoUpdateView&id="+u.getId()+"'>修改用户</a></td>"
				+ "</tr>");
			}
			
			out.println("</table>");
			
			
			//显示上一页
			if(pageNow > 1)
				out.println("<a href='/UsersManager/ManagerUsers?pageNow="+(pageNow-1)+"'>上一页</a>");
			
			//显示分页
			for(int i=1; i<=pageCount; i++) {
				out.println("<a href='/UsersManager/ManagerUsers?pageNow="+i+"'><"+i+"></a>");
			}
			
			//显示下一页
			if(pageNow < pageCount)
				out.println("<a href='/UsersManager/ManagerUsers?pageNow="+(pageNow+1)+"'>下一页</a>");
			
			//显示分页信息
			out.println("&nbsp;&nbsp;&nbsp;当前页" +pageNow+ "/总页数" + pageCount + "<br />");
			
			//跳转到第几页
			out.println("跳转到: <input type='text' id='pageNow' name='pageNow' /> <input type='button' onClick='gotoPageNow()' value='跳' />");
			
		} catch (Exception e) {
			e.printStackTrace();
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
