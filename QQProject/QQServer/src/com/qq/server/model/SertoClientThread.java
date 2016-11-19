/**
 * 功能：是服务器和某个客户端的通讯线程
 */
package com.qq.server.model;

import java.io.*;
import java.net.*;

import com.qq.common.Message;

public class SertoClientThread extends Thread {
	
	Socket s;
	
	public SertoClientThread(Socket s) {
		//把服务器和该客户端的连接赋值给s
		this.s = s;
	}
	
	public void run() {
		
		while(true) {
			//这里该线程可以接收客户端的信息
			
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				try {
					Message m = (Message)ois.readObject();
					System.out.println(m.getSender() + "给" + m.getReceiver() +"说：" + m.getCon());
					
					//一会完成转发完成
					SertoClientThread sch = manageClientThread.getClientThread(m.getReceiver());
					ObjectOutputStream oos = new ObjectOutputStream(sch.s.getOutputStream());
					oos.writeObject(m);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
