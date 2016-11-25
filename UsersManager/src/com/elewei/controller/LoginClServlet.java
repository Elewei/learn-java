package com.elewei.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		
		//这时看看有没有接到
		System.out.println(id);
		System.out.println(password);
		
		//驱动程序名称
		String driver = "com.mysql.jdbc.Driver";
		
        // URL指向要访问的数据库名UMS        
		String url = "jdbc:mysql://127.0.0.1:3306/UMS";
		
        // MySQL配置时的用户名           
		String user = "root";           
		
		// MySQL配置时的密码          
		String passworddb = "weiwei"; 
		
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		
		//到数据库中验证
		try {
			//第一步：加载驱动
			Class.forName(driver);
			
			//第二步：得到连接
			conn = DriverManager.getConnection(url, user, passworddb); 
			  
			// statement用来执行SQL语句             
            ps = conn.prepareStatement("SELECT * FROM users where id=? and password=?");
			
            //给？赋值
            ps.setObject(1, id);
            ps.setObject(2, password);
            
            // 要执行的SQL语句           
            rs = ps.executeQuery();
            
            if(rs.next()) {
            	//说明该用户合法
            	request.getRequestDispatcher("/MainFrame").forward(request, response);;
            } else {
            	//不合法
            	request.setAttribute("err", "用户ID或密码有误！");
            	request.getRequestDispatcher("/LoginServlet").forward(request, response);;
            }
            
			//第三步：创建PrepareStatement
			
			//第四步：执行操作
			//第五步：根据结构做处理
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs=null;
			}
			
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ps = null;
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = null;
			}
			
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
