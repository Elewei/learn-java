package tanke2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *  功能：坦克游戏1.0
 *  1. 画出坦克
 *  2. 我的坦克可以上下左右移动
 *  
 */


public class TankGame2 extends JFrame
{
	MyPanel mp = null;
	
	public static void main(String[] args)
	{
		TankGame2 mtg = new TankGame2();
	}
	
	//构造函数
	public TankGame2()
	{
		mp = new MyPanel();
		this.add(mp);
		this.addKeyListener(mp); 	//注册监听
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

//我的面板
class MyPanel extends JPanel implements KeyListener
{
	//定义一个我的坦克
	Hero hero = null;
	
	//定义敌人的坦克
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	
	//敌人坦克有多少辆
	int enSize = 3;
	
	//构造函数
	public MyPanel()
	{
		hero = new Hero(100,100);
		
		//初始化敌人的坦克
		for(int i=0; i<enSize; i++)
		{
			//创建一辆敌人的坦克
			EnemyTank et = new EnemyTank((i+1)*50, 0);
			et.setColor(0);
			et.setDirect(1);
			ets.add(et);
		}
	}
	
	//重新paint
	public void paint(Graphics g)
	{
		super.paint(g);
		
		//定下活动区域
		g.fillRect(0, 0, 400, 300);
		
		/**
		 * 画出坦克
		 * 
		 */
		this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 1);
		
		//画出敌人的坦克
		for(int i=0; i<ets.size(); i++)
		{
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 0);
		}
		
	}
	
	//画出坦克的函数
	public void drawTank(int x, int y, Graphics g, int direct, int type)
	{
		
		//判断是什么类型的坦克
		switch(type)
		{
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
		}
		
		//判断方向
		switch(direct)
		{
		//向上
		case 0:
			//画出我的向上的坦克
			//1.画出左边的矩形
			g.fill3DRect(x, y, 5, 30,false);
			//2. 现出右边的矩形
			g.fill3DRect(x+15, y, 5, 30,false);
			//3. 画出中间矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//4. 画出圆形
			g.fillOval(x+5, y+10, 10, 10);
			//5. 画出线
			g.drawLine(x+10, y+15, x+10, y);
			break;
		case 1:
			//画出我的向下坦克
			//1.画出左边的矩形
			g.fill3DRect(x, y, 5, 30,false);
			//2. 现出右边的矩形
			g.fill3DRect(x+15, y, 5, 30,false);
			//3. 画出中间矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//4. 画出圆形
			g.fillOval(x+5, y+10, 10, 10);
			//5. 画出线
			g.drawLine(x+10, y+15, x+10, y+30);
			break;
		case 2:
			//画出我的向左坦克
			//1.画出上边的矩形
			g.fill3DRect(x, y, 30, 5,false);
			//2. 现出下边的矩形
			g.fill3DRect(x, y+15, 30, 5,false);
			//3. 画出中间矩形
			g.fill3DRect(x+5, y+5, 20, 10,false);
			//4. 画出圆形
			g.fillOval(x+10, y+5, 10, 10);
			//5. 画出线
			g.drawLine(x+15, y+10, x, y+10);
			break;
		case 3:
			//画出我的向右坦克
			//1.画出上边的矩形
			g.fill3DRect(x, y, 30, 5,false);
			//2. 现出下边的矩形
			g.fill3DRect(x, y+15, 30, 5,false);
			//3. 画出中间矩形
			g.fill3DRect(x+5, y+5, 20, 10,false);
			//4. 画出圆形
			g.fillOval(x+10, y+5, 10, 10);
			//5. 画出线
			g.drawLine(x+15, y+10, x+30, y+10);
			break;
		}	
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//按键处理 a表示向左， s表示向下， d 表示向右， w 表示向上
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			//设置我的坦克向上
			this.hero.setDirect(0);
			this.hero.moveUp();
		} 
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
			//设置我的坦克向下
			this.hero.setDirect(1);
			this.hero.moveDown();
		}
		else if(e.getKeyCode() == KeyEvent.VK_A)
		{
			//设置我的坦克向左
			this.hero.setDirect(2);
			this.hero.moveLeft();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			//设置我的坦克向右
			this.hero.setDirect(3);
			this.hero.moveRight();
		}	
		
		//必须要重绘窗口panel
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}








 