package com.elewei.services;

import java.sql.*;
import java.util.ArrayList;

import com.elewei.domain.Books;
import com.elewei.domain.Users;
import com.elewei.utils.*;

//处理与订单相关的业务逻辑

public class OrderService {
	
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public void submitOrder(MyCart myCart, Users user) {
		String sql = "insert into `shopcart`.`orders` (`userid`,`orderdate`,`totalPrice`) values (?,now(),?)";
		
		try {
			conn=DatabaseUtil.getCon();
			
			//升级级别
			conn.setTransactionIsolation(com.mysql.jdbc.Connection.TRANSACTION_SERIALIZABLE);
			conn.setAutoCommit(false);
			
			ps=conn.prepareStatement(sql);
			ps.setLong(1, Integer.parseInt(user.getUserid()));
			ps.setFloat(2, myCart.getTotalPrice());
			ps.executeUpdate();
			conn.commit();
			
			//得到刚刚自动生成的定单号
			sql = "select max(orderid) as orderid from shopcart.orders";
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int orderid=0;
			if(rs.next()) {
				//取出刚刚创建的orderid
				orderid = rs.getInt(1);
			}
			
			System.out.println(orderid);
			//生成订单细节表【批量提交】
			ArrayList al = MyCart.showMyCart();
			for(int i=0; i<al.size(); i++) {
				Books book = (Books) al.get(i);
				sql = "insert into `shopcart`.`orderItems` "
						+ "( `orderid`,`bookid`, 'booknum') "
						+ "values (?,?,?);";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, orderid);
				ps.setString(2, book.getBookid()+"");
				ps.setInt(3, book.getShoppingNum());
				ps.executeUpdate();
				conn.commit();
			}
			
			//整体提交
			//conn.commit();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DatabaseUtil.close(rs, ps, conn);
		}
		
		
	}
	
}
