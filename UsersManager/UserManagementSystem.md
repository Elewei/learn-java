
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
2 陈春梅	     weiwei 774026263@qq.com



