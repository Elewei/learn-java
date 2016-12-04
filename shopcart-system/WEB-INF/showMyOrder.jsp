<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, com.elewei.domain.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language=javascript type="text/javascript">
		
		function goSubmitOrder() {
			window.location.href="/ShopcartSystem/SubmitOrderServlet";
		}
	
</script>
</head>
<body>
	<h1>我的订单</h1>
	<table border="1">
		<tr>
			<td colspan='2'>用户个人信息</td>
		</tr>
		<tr>
			<td>用户名</td>
			<td><%=((Users) session.getAttribute("loginUser")).getUsername()%>
			</td>
		</tr>
		<tr>
			<td>电子邮件</td>
			<td><%=((Users) session.getAttribute("loginUser")).getEmail()%>
			</td>
		</tr>
		<tr>
			<td>用户级别</td>
			<td><%=((Users) session.getAttribute("loginUser")).getGrade()%>
			</td>
		</tr>
	</table>
	<br />
	<table border='1'>
		<tr>
			<td>BookID</td>
			<td>书名</td>
			<td>价格</td>
			<td>出版社</td>
			<td>数量</td>
		</tr>

		<%
			ArrayList al = (ArrayList) request.getAttribute("orderinfo");
			for (int i = 0; i < al.size(); i++) {
				Books book = (Books) al.get(i);
		%>
		<tr>
			<td><%=book.getBookid()%></td>
			<td><%=book.getBookname()%></td>
			<td><%=book.getPrice()%></td>
			<td><%=book.getPublishHouse()%></td>
			<td><%=book.getShoppingNum()%></td>
		</tr>
		<%
			}
		%>
		<tr><td colspan='5' >总价格为：<%=request.getAttribute("totalPrice") %>元</td></tr>
	</table>
	
	<input type='button' onclick="goSubmitOrder()" value="确认提交"  />
</body>
</html>