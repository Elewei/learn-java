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


####第三步：程序框架图





