/**
 * QQ客户端登录界面
 * 
 */

package com.qq.client.view;

import java.net.*;
import java.awt.*;
import javax.swing.*;

import com.qq.client.model.QQClientToServer;
import com.qq.client.model.QQClientUser;
import com.qq.common.User;

import java.awt.event.*;

public class QQClientLogin extends JFrame implements ActionListener {
	
	//定义北部需要的组件
	JLabel jbl1;
	
	
	//定义中部需要的组件
	//中部有三个JPanel, 有一个叫选项卡窗口管理 
	JTabbedPane jtp;
	JPanel jp2, jp3, jp4;
	JLabel jp2_jl1, jp2_jl2, jp2_jl3, jp2_jl4, jp2_jl5;
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jcb1, jp2_jcb2;
	
	//定义南部需要的组件
	JPanel jp1;
	JButton jp1_jb1, jp1_jb2, jp1_jb3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QQClientLogin qq = new QQClientLogin();
	}
	
	public QQClientLogin() {
		
		//处理北部
		jbl1 = new JLabel(new ImageIcon("image/logo.gif"));
		
		//处理中部
		jp2 = new JPanel(new GridLayout(3,3));
		jp2_jl1 = new JLabel("QQ号码", JLabel.CENTER);
		jp2_jl2 = new JLabel("QQ密码", JLabel.CENTER);
		jp2_jl3 = new JLabel("忘记号码", JLabel.CENTER);
		jp2_jl3.setForeground(Color.blue);
		jp2_jl4 = new JLabel("申请密码保护", JLabel.CENTER);
		jp2_jl5 = new JLabel("清除密码", JLabel.CENTER);
		
		jp2_jtf = new JTextField();
		jp2_jpf = new JPasswordField();
		jp2_jcb1 = new JCheckBox("隐身登录");
		jp2_jcb2 = new JCheckBox("记住密码");
		
		//按顺序加入
		jp2.add(jp2_jl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jl3);
		jp2.add(jp2_jl2);
		jp2.add(jp2_jpf);
		jp2.add(jp2_jl5);
		jp2.add(jp2_jcb1);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jl4);
		
		
		jp3 = new JPanel();
		jp4 = new JPanel();
		
		//创建选项卡窗口
		jtp = new JTabbedPane();
		jtp.add("QQ号码", jp2);
		jtp.add("手机号码",jp3);
		jtp.add("电子邮件", jp4);
		
		//处理南部
		jp1 = new JPanel();
		jp1_jb1 = new JButton(new ImageIcon("image/login.gif"));
		jp1_jb2 = new JButton(new ImageIcon("image/register.gif"));
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		
		//响应用户点击登录事件
		jp1_jb1.addActionListener(this);
		
		this.add(jbl1, "North");
		this.add(jtp, "Center");
		this.add(jp1, "South");
		this.setSize(350, 250);
		this.setTitle("QQ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//如果用户点击登录
		if(e.getSource() == jp1_jb1 ) {
			QQClientUser qqClient = new QQClientUser();
			User u = new User();
			u.setUserId(jp2_jtf.getText().trim());
			u.setPasswd(new String(jp2_jpf.getPassword()));
			
			if(QQClientUser.checkUser(u)) {
				new FriendList(u.getUserId());
				//关闭掉登录界面
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "用户名或密码错误");
			}
			
		}
		
	}

}
