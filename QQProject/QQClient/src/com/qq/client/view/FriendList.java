/**
 * QQ 好友列表(包括陌生人，黑名单)
 */

package com.qq.client.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import com.qq.common.User;

public class FriendList extends JFrame implements ActionListener,MouseListener {
	
	//处理第一张卡片,3个JPanel, 3个按钮， 1个JScrollPane,显示好友列表
	JPanel jpfriend1, jpfriend2, jpfriend3;
	JButton jpfriend1_jb1, jpfriend1_jb2, jpfriend1_jb3;
	JScrollPane jsp_friend;
	
	//处理第二张卡片（显示陌生人）
	JPanel jpmsr1, jpmsr2, jpmsr3;
	JButton jpmsr2_jb1, jpmsr2_jb2, jpmsr2_jb3;
	JScrollPane jsp_msr;
	
	//把整个JFrame 设置成cardLayout
	CardLayout cl; 
	
	String uid;
	
	public FriendList(String uid) {
		
		this.uid = uid; 
		
		//处理第一张卡片（显示好友列表）
		jpfriend1 = new JPanel(new BorderLayout());
		
		//创建三个按钮
		jpfriend1_jb1 = new JButton("我的好友");
		jpfriend1_jb2 = new JButton("陌生人");
		jpfriend1_jb3 = new JButton("黑名单");
		jpfriend1_jb2.addActionListener(this);
		
		//假定有50个好友
		jpfriend2 = new JPanel(new GridLayout(50, 1, 4 , 4));
		
		//给jpfriend2初始化50个好友
		JLabel [] jbls = new JLabel[50];
		
		for(int i=0; i<jbls.length; i++) {
			jbls[i] = new JLabel(i+1+"",new ImageIcon("image/avator.gif"), JLabel.LEFT);
			jbls[i].addMouseListener(this);
			jpfriend2.add(jbls[i]);
		}
		
		jsp_friend = new JScrollPane(jpfriend2);
		
		jpfriend3 = new JPanel(new GridLayout(2,1));
		
		//把两个按钮加入到第三个Panel中
		jpfriend3.add(jpfriend1_jb2);
		jpfriend3.add(jpfriend1_jb3);

		//对第一个Panel进行初始化
		jpfriend1.add(jpfriend1_jb1, "North");	//将按钮放在最上面
		jpfriend1.add(jsp_friend, "Center");	//将滚动条放在中间
		jpfriend1.add(jpfriend3, "South");		//将两个按钮放在下面
		
		
		//处理第二张卡片（陌生人）
		jpmsr1 = new JPanel(new BorderLayout());

		jpmsr2_jb1 = new JButton("我的好友");
		jpmsr2_jb2 = new JButton("陌生人");
		jpmsr2_jb3 = new JButton("黑名单");
		jpmsr2_jb1.addActionListener(this);
		
		jpmsr3 = new JPanel(new GridLayout(2,1));
		jpmsr3.add(jpmsr2_jb1);
		jpmsr3.add(jpmsr2_jb2);
		
		//假定有20个陌生人
		jpmsr2 = new JPanel(new GridLayout(20, 1, 4 , 4));
		
		//给jpmsr2初始化20个陌生人
		JLabel [] jbls2 = new JLabel[20];
		for(int i=0; i<jbls2.length; i++) {
			jbls2[i] = new JLabel(i+1+"",new ImageIcon("image/avator.gif"), JLabel.LEFT);
			jpmsr2.add(jbls2[i]);
		}
		
		jsp_msr = new JScrollPane(jpmsr2);

		//对第二个Panel进行初始化
		jpmsr1.add(jpmsr3, "North");
		jpmsr1.add(jsp_msr, "Center");
		jpmsr1.add(jpmsr2_jb3, "South");
		
		cl = new CardLayout();
		this.setLayout(cl);
		
		this.add(jpfriend1,"1");
		this.add(jpmsr1, "2");
		
		
		this.setSize(200, 500);
		this.setTitle("好友列表"+uid);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//如果点击陌生人按钮，就显示显示第二张卡片
		if(e.getSource() == jpfriend1_jb2) {
			cl.show(this.getContentPane(), "2");
		} 
		else if(e.getSource() == jpmsr2_jb1) {
			cl.show(this.getContentPane(), "1");
		}
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		//响应用户双击事件，并得到好友的编号
		if(e.getClickCount() == 2) {
			//得到该好友的编号
			String friendNo = ((JLabel)e.getSource()).getText();
			
			//System.out.println(friendNo);
			Chat chat = new Chat(uid, friendNo);
			Thread t = new Thread(chat);
			t.start();
		}
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl = (JLabel)e.getSource();
		jl.setForeground(Color.red);
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl = (JLabel)e.getSource();
		jl.setForeground(Color.BLACK);
	}
	
}
