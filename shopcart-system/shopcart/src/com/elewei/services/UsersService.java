package com.elewei.services;

import java.util.ArrayList;
import com.elewei.domain.Users;
import com.elewei.utils.*;

//这是专门处理和Users表相关的逻辑类

public class UsersService {
	//验证用户是否合法的方法
	public boolean checkUser(Users user) {
		
		//到数据库验证
		String sql = "SELECT * FROM users where userid=? and password=?";
		String [] paras = {user.getUserid(), user.getPassword()};
		ArrayList al = new SqlHelper().executeQuery(sql, paras);
		
		if(al.size() == 0) {
			//不存在这个人
			return false;
		} else {
			Object [] objects = (Object []) al.get(0); 
			//把对象数组封装到users对象
			user.setUserid((String) objects[0]);
			user.setUsername((String) objects[1]);
			user.setEmail((String) objects[3]);
			user.setTelephone((String) objects[4]);
			user.setGrade(Integer.parseInt(objects[5].toString()));
			return true;
		}
		
		
	}
}
