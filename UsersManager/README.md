
用户管理系统

在mysql数据库中创建一张表

CREATE SCHEMA `UMS` DEFAULT CHARACTER SET utf8 ;  //创建数据库UMS

CREATE TABLE `UMS`.`users` (
  `id` INT NOT NULL,
  `username` VARCHAR(32) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `email` VARCHAR(64) NOT NULL,
  `grade` INT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
  
初始化数据
1 Zhang Qi Wei weiwei mzhangqiwei@163.com 2
2 HAHA	    weiwei 774026263@qq.com


INSERT INTO users(id, username, password, email, grade) values
(1, "aa", "weiwei", "aa@aa.com", 3);
INSERT INTO users(id, username, password, email, grade) values
(8, "bb", "weiwei", "bb@bb.com", 4);
INSERT INTO users(id, username, password, email, grade) values
(7, "cc", "weiwei", "cc@cc.com", 3);




Servlet 中显示图片
第一步：在webApps目录下新建一个imgs文件夹
第二步：将图片拷贝到该目录下
第三步：在servlet中添加<img src="./imgs/图片名" />


分页技术详解
定义四个分页变量：
pageNow  表示第几页（该变量由用户决定）
pageSize 每页显示几条记录（由程序指定，也可以由用户定制）
pageCount 共有多少页（该变量计算出来）
rowCount  共有多少条记录（该变量是查询数据库得到的）

如何确定pageCount?
写法一：
if(rowCount % pageSize == 0) {
	pageCount = rowCount / pageSize;
} else {
	pageCount = rowCount / pageSize + 1；
}

写法二：
pageCount = rowCount % pageSize == 0? rowCount/pageSize : rowCount/pageSize + 1;

写法三：
pageCount = (rowCount - 1) / pageSize + 1

算出共有多少页：
//查询rowCount
ps = ct.prepareStatement("SELECT COUNT(*) FROM users");
rs = ps.executeQuery();
rs.next() //把游标往下移
rowCount = rs.getInt(1);

数据库分页语句：
SELECT t.*, rownum rn FROM (SELECT * FROM users ORDER BY id) t where rownum <= 6;

每页显示3个， 
1， 1，2，3
2， 4，5，6，
3， 7，8，9，
4， 10

每页显示2个
1， 1，2
2， 3，4，
3， 4，5，
 
SELECT * FROM users order by id limit pageSize * pageNow - pageSize, pageSize
第3页，每页2个， 4，2

pageSize = 2
pageCount = 5





用户登录系统功能改进


网站框架的改进
对当前网站结构的分析：
界面
业务逻辑分开
将常用的代码（比如连接数据库，）封装到类中

具体方法：
1. 每一张表对应一个domain类（表示数据）还要对应service类
比如users 表 对应Users类（domain） UsersService类，该类会封装对users表的各种操作
数据与操作分离的思想

在mysql中建立一个sequence表
    DROP TABLE IF EXISTS sequence;  
    CREATE TABLE sequence (  
             name VARCHAR(50) NOT NULL,  
             current_value INT NOT NULL,  
             increment INT NOT NULL DEFAULT 1,  
             PRIMARY KEY (name)  
    ) ENGINE=InnoDB;  
    
 


