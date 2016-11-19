/**
 *  这是客户端连接服务器的8888端口
 */

package com.qq.client.model;

import java.io.*;
import java.util.*;

import com.qq.common.Message;
import com.qq.common.User;

import java.net.*;

public class QQClientToServer {
	
	public static Socket s;
	
	//发送第一次请求
	public static boolean SendLoginInfoToServer(Object o) {
		
		boolean b = false;
		
		try {
			//连接服务器
			s = new Socket("127.0.0.1", 8888);
			
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			
			try {
				Message ms = (Message)ois.readObject();
				
				if(ms.getMesType().equals("1")) {
					b = true;
				} 
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
	
	
	public void SendInfoToServer(Object o) {
		
	}
	
	

}
