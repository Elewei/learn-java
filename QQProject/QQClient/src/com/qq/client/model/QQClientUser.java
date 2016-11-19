package com.qq.client.model;

import com.qq.common.User;

public class QQClientUser {
	
	public static boolean checkUser(User u) {
		
		boolean b=false;
		
		b = QQClientToServer.SendLoginInfoToServer(u);
		
		return b;
		
	}
	
	
}
