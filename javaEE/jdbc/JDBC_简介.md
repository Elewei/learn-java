JDBC(Java Database Connectivity)简介

SUN公司为统一对数据库的操作，定义一套java操作数据库规范，称为JDBC。  
java.sql包   
javax.sql包

编写一个程序，这个程序从user表中读取数据，并打印在命令行窗口中
实验环境：
mysql数据库

第一步：导入jar包
右击项目，属性
点击java build path, libraries
add external jars
确定

第一步：加载驱动
Class.forName(“”);

第二步：DriverManager.getConnection(“url”,”username”,”password”)

url: 用于标识数据库的位置
jdbc:指协议
mysql: 子协议
主机名：端口
数据库

常用数据库URL地址的写法：
oracle:    jdbc:oracle:thin:@localhost:1521:sid
sqlServer: jdbc:microsoft:sqlserver://localhost:1433; DatabaseName=sid
MySQL:     jdbc:mysql://localhost：3306/数据库的名称?参数=值

创建sql对象：
Statement 	安全性较差
PrepareStatement	 安全性较高
CallableStatement  调用存储过程


