实验：使用JSP实现一个计算器


mycalinterface.jsp
result.jsp // 接收用户提交的数据，并显示结果

	calculator.jsp
	<%@ page language=“java” contentType=“text/html; charset=UTF-8”
	    pageEncoding=“UTF-8”%>
	<!DOCTYPE html PUBLIC “-//W3C//DTD HTML 4.01 Transitional//EN” “http://www.w3.org/TR/html4/loose.dtd”>
	<html>
	<head>
	<meta http-equiv=“Content-Type” content=“text/html; charset=UTF-8”>
	<title>Insert title here</title>
	</head>
	<body>
		<form action=‘/ServeletProject/result.jsp’ method=‘post’>
			请输入第一个数：<input type=‘text’ name=‘num1’ /> <br />
			请输入第二个数：<input type=‘text’ name=‘num2’ /> <br />
			请选择运算符：  <select name=‘operator’>
							<option value=“+”>+</option>
							<option value=“-“>-</option>
							<option value=“*”>*</option>
							<option value=“/“>/</option> 
						</select> <br />
			<input type=‘submit’ value=‘计算’ />
		</form>
	</body>
	</html>
	
-------
	

	result.jsp
	<%@ page language=“java” contentType=“text/html; charset=UTF-8”
	    pageEncoding=“UTF-8”%>
	<!DOCTYPE html PUBLIC “-//W3C//DTD HTML 4.01 Transitional//EN” “http://www.w3.org/TR/html4/loose.dtd”>
	<html>
	<head>
	<meta http-equiv=“Content-Type” content=“text/html; charset=UTF-8”>
	<title>Insert title here</title>
	</head>
	<body>
		
		<%
	 		String num1 = request.getParameter(“num1”);
			String num2 = request.getParameter(“num2”);
			String oper = request.getParameter(“operator”); 
			
			double result = 0;
	 		double d_num1 = Double.parseDouble(num1);
			double d_num2 = Double.parseDouble(num2); 
			
			
			switch(oper) {
			case “+”:
				result = d_num1 + d_num2;
				break;
			case “-“:
				result = d_num1 - d_num2;
				break;
			case “*”:
				result = d_num1 * d_num2;
				break;
			case “/“:
				result = d_num1 / d_num2;
				break;
			}
			
			out.println(result); 
		%>
		
	</body>
	</html>
	


