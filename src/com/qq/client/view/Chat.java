/**
 * QQ 聊天窗口
 * 因为客户端要处于读取的状态，因此把它做成一个线程
 */

package com.qq.client.view;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import java.util.*;
import com.qq.client.model.*;
import com.qq.common.Message;

public class Chat extends JFrame implements ActionListener, Runnable {
	
	JPanel jp;
	JTextArea jta;
	JTextField jtf;
	JButton jb1;
	
	String uid;
	String friend;
	
	
	public Chat(String uid, String friend) {
		
		this.uid = uid;
		this.friend = friend;
		
		jp = new JPanel();
		jta = new JTextArea();
		jtf = new JTextField(20);
		jb1 = new JButton("发送");
		
		jb1.addActionListener(this);
		
		jp.add(jtf);
		jp.add(jb1);
		
		this.add(jta, "Center");
		this.add(jp,"South");
		
		this.setSize(400, 300);
		this.setTitle(uid + "正在和 " + friend + " 聊天");
		this.setIconImage((new ImageIcon("image/title.gif")).getImage());
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == jb1) {
			//如果用户点击发送按钮
			Message m = new Message();
			m.setSender(this.uid);
			m.setReceiver(this.friend);
			m.setCon(jtf.getText());
			m.setSendTime(new Date().toString());
			//发送给服务器
			try {
				ObjectOutputStream oos = new ObjectOutputStream(QQClientToServer.s.getOutputStream());
				oos.writeObject(m);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				ObjectInputStream ois = new ObjectInputStream(QQClientToServer.s.getInputStream());
				
				try {
					Message m = (Message)ois.readObject();
					
					String info = m.getSender() + "对" + m.getReceiver() + "说" + m.getCon()+ "\r\n";
					this.jta.append(info);
					
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
