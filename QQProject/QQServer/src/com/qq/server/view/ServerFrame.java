/**
 * QQ服务器端控制界面， 启动服务器， 关闭服务器，
 * 可以看到，管理，监控在线的用户，强制某个用户下线
 */

package com.qq.server.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.qq.server.model.QQServer;

public class ServerFrame extends JFrame implements ActionListener {
	
	JPanel jp1;
	JButton jb1, jb2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerFrame sf = new ServerFrame();
	}
	
	public ServerFrame() {
		jp1 = new JPanel();
		jb1 = new JButton("启动服务器");
		jb2 = new JButton("关闭服务器");
		jp1.add(jb1);
		jp1.add(jb2);
		
		//增加监听器
		jb1.addActionListener(this);
		
		this.add(jp1);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jb1) {
			QQServer qq = new QQServer();
		}
	}

}
