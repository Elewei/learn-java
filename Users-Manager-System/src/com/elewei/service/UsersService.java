package com.elewei.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.elewei.dao.SqlHelper;
import com.elewei.domain.*;


public class UsersService {
	
	//验证用户是否合法
	public boolean checkUser(Users user) {
		
		boolean b = false;
		
		String sql = "SELECT * FROM users where id=? and password=?";
		String [] parameters = {user.getId()+"", user.getPassword()};
		//SqlHelper完成查询任务
		ResultSet rs = SqlHelper.executeQuery(sql, parameters);
		
		//根据rs判断该用户是否存在
		try {
			if(rs.next()) {
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		
		return b;
	}
	
	//按照分页来获取用户
	public ArrayList getUsersByPage(int pageNow, int pageSize) {
		
		ArrayList<Users> al = new ArrayList<Users>();
		String sql = "SELECT * FROM users limit "+(pageSize * pageNow - pageSize)+","+pageSize+" ";
		ResultSet rs = SqlHelper.executeQuery(sql, null);
		//二次封装，把ResultSet -> User对象 -> ArrayList(集合)
		try {
			while(rs.next()) {
				
				Users u = new Users();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(4));
				u.setGrade(rs.getInt(5));
				
				al.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		
		return al;
	}
	
	/********获取一共可以分几页信息************/
	public int getPageCount(int pageSize) {
		String sql = "SELECT COUNT(*) FROM users";
		ResultSet rs = SqlHelper.executeQuery(sql, null);
		int rowCount = 0;
		
		try {
			rs.next();
			rowCount = rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		
		return (rowCount-1)/pageSize+1;
		
	}
	
	public boolean delUser(String id) {
		boolean b = true;
		
		
		String sql = "DELETE FROM users where id=?";
		String [] parameters = {id}; 
		
		try {
			SqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			b = false;
			e.printStackTrace();
		}
		
		return b;
	}
	
	//通过id获取用户信息
	public Users getUserById(String id) {
		Users u = new Users();
		String sql = "SELECT * FROM users where id=?";
		String [] parameters = {id};
		ResultSet rs = SqlHelper.executeQuery(sql, parameters);
		try {
			if(rs.next()) {
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setGrade(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		
		return u;
		
	}
	
	//修改用户
	public boolean updateUser(Users user) {
		boolean b = true;
		String sql = "update users set username=?, password=?, email=?, grade=? where id=?";
		String [] parameters = {user.getName(), user.getPassword(), user.getEmail(), user.getGrade()+"", user.getId()+""};
		
		try {
			SqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			b = false;
		}
		
		return b;
	}
	
	//增加用户
	public boolean addUser(Users user) {
		boolean b = true;
		String sql = "INSERT INTO users(id, username, password, email, grade) values (?, ?, ?, ?, ?);";
		String [] parameters = {user.getId()+"", user.getName(), user.getPassword(), user.getEmail(), user.getGrade()+""};
		
		try {
			SqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			b = false;
		}
		
		return b;
	}
	
	
}

