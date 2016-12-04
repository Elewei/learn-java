<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, com.elewei.domain.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/commen.css" />
</head>
<body>
	<h1>我的购物车</h1>
	<a href="/ShopcartSystem/ToHallServlet">返回购物大厅</a>
	<form action="/ShopcartSystem/ShoppingClServlet?type=update" method="post">
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<td>bookid</td>
				<td>书名</td>
				<td>价格</td>
				<td>出版社</td>
				<td>数量</td>
				<td>删除</td>
			</tr>

			<%
				//从request中取出商品信息
				ArrayList al = (ArrayList) request.getAttribute("bookList");
				float totalPrice = (float) request.getAttribute("totalPrice");
				
				for (int i = 0; i < al.size(); i++) {
					Books book = (Books) al.get(i);
			%>
			<tr>
				<td><%=book.getBookid()%><input type='hidden' name="id" value="<%=book.getBookid() %>" /></td>
				<td><%=book.getBookname()%></td>
				<td><%=book.getPrice()%></td>
				<td><%=book.getPublishHouse()%></td>
				<td><input type="text" name="bookNum" value="<%=book.getShoppingNum() %>"/>本</td>
				<td><a href="/ShopcartSystem/ShoppingClServlet?type=del&id=<%=book.getBookid() %>">删除</td>
			</tr>
			<%
				}
			%>


			<tr>
				<td colspan="6"><input type="submit" value="update" /></td>
			</tr>
			<tr>
				<td colspan="6">购物车的总价格： ${totalPrice }元</td>
			</tr>
		</table>
	</form>
	
	<a href="/ShopcartSystem/ToOrderServlet">提交定单</a>
	
</body>
</html>