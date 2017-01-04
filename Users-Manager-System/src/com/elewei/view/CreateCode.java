package com.elewei.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateCode
 */
@WebServlet("/CreateCode")
public class CreateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//7. 禁止浏览器缓存随机图片
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		//6. 通知客户机以图片方式打开发送过去的数据
		response.setHeader("Content-Type", "image/jpeg");
		
		//1. 在内存中创建一副图片
		BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_BGR);
		
		//2. 向图片上写数字
		Graphics g = image.getGraphics();
		
		//设置背景
		g.setColor(Color.white);
		g.fillRect(0, 0, 80, 30);
		
		//3. 设置写入数据的颜色和字体
		g.setColor(Color.BLACK);
		g.setFont(new Font(null, Font.BOLD, 20));
		
		//4. 向图片上写数据
		String num = makeNum();
		request.getSession().setAttribute("checkcode", num);
		g.drawString(num, 0, 20);
		
		//5.把写好的数据的图片传输给浏览器
		ImageIO.write(image, "jpg", response.getOutputStream());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//该函数随机生成七位数据
	public String makeNum() {
		Random r = new Random();
		String num = r.nextInt(9999999) + "";
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<7-num.length(); i++) {
			sb.append("0");
		}
		
		num = sb.toString() + num;
		return num;
		
	}
	

}
