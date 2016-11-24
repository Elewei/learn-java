#面向对象
目标：理解面向对象编程概念

将问题中的元素以及它们在方案空间的表示物称作“对象”（Object）。根据问题来描述问题。对象有自己的特征与行为。


![](http://www.yq1012.com/ThinkingInJava/Thinking+In+Java/1-1.gif)

Light lt = new Light();
lt.on();

Java采用三个显式（明确）关键字以及一个隐式（暗示）关键字来设置类边界：public，private，protected以及暗示性的friendly。

![](http://www.yq1012.com/ThinkingInJava/Thinking+In+Java/1-2.gif)

	void doStuff(Shape s) {
	  s.erase();
	  // ...
	  s.draw();
	}

	Circle c = new Circle();
	Triangle t = new Triangle();
	Line l = new Line();
	doStuff(c);
	doStuff(t);
	doStuff(l);


数据保存的地方：
(1) 寄存器，由编译器分配
(2) 堆栈
(3) 堆，保存java对象
(4) 静态存储（static）
(5) 常数存储
(6) 非RAM存储


##注释和嵌入文档
第一种：
/*
 * 这是一段注释
 *
 */

第二种：
//这是一条单行注释


##编码样式
类名首字母大写


