/**
 * 这是QQ服务器，它在监听， 等待某个QQ客户端来连接
 */

package com.qq.server.model;

import java.net.*;
import java.io.*;
import java.util.*;

import com.qq.common.Message;
import com.qq.common.User;

public class QQServer {

	
	public QQServer() {
		try {
			System.out.println("服务器在8888端口上监听");
			//在8888端口上监听
			ServerSocket ss = new ServerSocket(8888);
			
			while(true) {
				//等待客户端来连接
				Socket s = ss.accept();
				
				//接收客户端发来的信息
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				try {
					User u = (User)ois.readObject();
					Message m = new Message();
					ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
					
					if(u.getPasswd().equals("123456")) {
						//返回一个成功登录的信息包
						m.setMesType("1");
						oos.writeObject(m);
						
						//这里就单开一个线程，让线程与该客户端保持通讯
						SertoClientThread sct = new SertoClientThread(s);
						manageClientThread.addClientThread(u.getUserId(), sct);
						sct.start();
						
					} else {
						m.setMesType("2");
						oos.writeObject(m);
						//关闭连接
						s.close();
					}
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
