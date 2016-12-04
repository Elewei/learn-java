###购物车系统

####需求
* 用户可以登录  
* 用户可以购买商品  
* 用户可以对购物车的商品进行修改和删除  
* 用户可以下订单  
* 系统可以电子邮箱给用户



####第一步：写出项目界面
* WEBROOT/index.jsp
* 登录界面: WEBROOT/WEB-INF/login.jsp
* 购物大厅：WEBROOT/WEB-INF/hall.jsp:  
* 显示我的购物车：WEBROOT/WEB-INF/showcart.jsp
* 预览订单：WEBROOT/WEB-INF/orderform.jsp
* 提交订单：WEBROOT/WEB-INF/submitorder.jsp


####第二步：设计数据库表

CREATE SCHEMA `shopcart` DEFAULT CHARACTER SET utf8 ;

用户表(users)
商品表（goods）
订单表（orderlist）


用户表(users)
<table>
	<tr><td>userid</td><td>username</td><td>password</td><td>email</td><td>telephone</td><td>grade</td></tr>
</table>

	CREATE TABLE `shopcart`.`users` (
	  `userid` VARCHAR(2) NOT NULL COMMENT ‘用户ID号’,
	  `username` VARCHAR(45) NOT NULL COMMENT ‘用户名’,
	  `password` VARCHAR(45) NOT NULL COMMENT ‘用户登录密码’,
	  `email` VARCHAR(45) NOT NULL COMMENT ‘邮箱’,
	  `telephone` VARCHAR(4) NULL,
	  `grade` INT NOT NULL DEFAULT 1 COMMENT ‘用户级别’,
	  PRIMARY KEY (`userid`),
	  UNIQUE INDEX `userid_UNIQUE` (`userid` ASC));
---
	INSERT INTO `shopcart`.`users` (`userid`, `username`, `password`, `email`, `telephone`, `grade`) VALUES (‘001’, ‘启卫’, ‘weiwei’, ‘mzhangqiwei@163.com’, ‘1356666666’, ‘5’);
	
	INSERT INTO `shopcart`.`users` (`userid`, `username`, `password`, `email`, `telephone`, `grade`) VALUES (‘002’, ‘小明’, ‘weiwei’, ‘mzhangqiwei@163.com’, ‘1356666666’, ‘5’);


商品表(books)
<table>
	<tr><td>bookid</td><td>bookname</td><td>author</td><td>publishHouse</td><td>price</td><td>booknum</td></tr>
</table>

	CREATE TABLE `shopcart`.`books` (
	  `bookid` INT NOT NULL,
	  `bookname` VARCHAR(45) NOT NULL,
	  `author` VARCHAR(45) NOT NULL,
	  `publishHouse` VARCHAR(45) NOT NULL,
	  `price` FLOAT NOT NULL,
	  `booknum` INT NOT NULL DEFAULT ‘1000’,
	  PRIMARY KEY (`bookid`),
	  UNIQUE INDEX `bookid_UNIQUE` (`bookid` ASC));
----
	INSERT INTO `shopcart`.`books` (`bookid`, `bookname`, `author`, `publishHouse`, `price`, `booknum`) VALUES (‘001’, ‘java’, ‘java’, ‘java’, ’50’, ‘1000’);
	INSERT INTO `shopcart`.`books` (`bookid`, `bookname`, `author`, `publishHouse`, `price`, `booknum`) VALUES (‘002’, ‘c’, ‘c’, ‘c’, ’40’, ‘1000’);
	INSERT INTO `shopcart`.`books` (`bookid`, `bookname`, `author`, `publishHouse`, `price`) VALUES (‘003’, ‘python’, ‘python’, ‘python’, ’30’);

--------

订单表（orders）
<table>
	<tr><td>订单号</td><td>用户号</td><td>时间</td><td>付款方式</td><td>是否付款</td></tr>
</table>

	CREATE TABLE `shopcart`.`<table_name>` (
		`orderid` int(10) NOT NULL AUTO_INCREMENT COMMENT ‘订单号’,
		`userid` varchar(20) COMMENT ‘用户ID’,
		`orderdate` datetime(20),
		`totalPrice` float(20,0),
		`orderPay` real(5,0) COMMENT ‘是否付款’,
		PRIMARY KEY (`orderid`)
	) COMMENT=‘’;
-----
	insert into `shopcart`.`orders` ( `totalPrice`, `orderPay`, `userid`, `orderdate`) values ( ‘300’, ‘1’, ‘1’, ‘2016-12-03 23:20:13’)

	insert into `shopcart`.`orders` ( `totalPrice`, `orderscol`, `userid`, `orderdate`, `orderid`) values ( ‘222’, ‘3’, ‘3’, ‘2016-12-08 22:25:28’, ‘2’)


订单细节表(orderdetails)

<table>
	<tr><td>id</td><td>订单号</td><td>商品号</td><td>数量</td></tr>
</table>



	CREATE TABLE `shopcart`.`<table_name>` (
		`id` int(1000) UNSIGNED NOT NULL AUTO_INCREMENT,
		`orderid` int(1000),
		`bookid` varchar(255),
		`booknum` integer,
		PRIMARY KEY (`id`),
		CONSTRAINT `orderid` FOREIGN KEY (`orderid`) REFERENCES `shopcart`.`orders` (`orderid`)   ON UPDATE CASCADE ON DELETE CASCADE
	) COMMENT=‘’;




####第三步：程序框架图



###第四步：根据程序框架图，实现


	index.jsp
	<jsp:forward page=“/WEB-INF/login.jsp”></jsp:forward>

-----



	login.jsp
		<h1>欢迎登录</h1>
		<form action=“/ShopcartSystem/ToHallServlet” method=“post”>
			<table border=“1”>
				<tr><td>用户名</td><td><input type=“text” name=“username” /></td></tr>
				<tr><td>密　码</td><td><input type=“text” name=“password” /></td></tr>
				<tr><td><input type=“submit” value=“登录”></td><td><input type=“reset” value=“重置” /></td></tr>
			</table>
		</form>


---
	hall.jsp
		<h1>欢迎访问购物大厅</h1>
		<table border=“1” >
			<tr><td>书名</td><td>价格</td><td>出版社</td><td>点击购买</td></tr>
			<tr><td>天龙八部</td><td>100</td><td>清华出版社</td><td><a href=“”>购买</a></td></tr>
			<tr><td>天龙八部</td><td>100</td><td>清华出版社</td><td><a href=“”>购买</a></td></tr>
			<tr><td>天龙八部</td><td>100</td><td>清华出版社</td><td><a href=“”>购买</a></td></tr>
			<tr><td>天龙八部</td><td>100</td><td>清华出版社</td><td><a href=“”>购买</a></td></tr>
			<tr><td colspan=“4”><input type=“button” value=“购物车”></td></tr>
		</table>

-----

	ToHallServlet.java
		//得到从登录页面传递的用户名与密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Users loginUser = new Users(username,password);
		
		//使用业务逻辑完成验证
		UsersService usersService = new UsersService();
		
		if(usersService.checkUser(loginUser)) {
			//合法用户，跳转到购物大厅
			System.out.println("该用户合法");
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);;
		} else {
			//不合法
			System.out.println("该用户不合法");
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}









