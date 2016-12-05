#面向对象
目标：  
理解面向对象编程概念  


将问题中的元素以及它们在方案空间的表示物称作“对象”（Object）。根据问题来描述问题。对象有自己的特征(属性)与行为。变化东西与不变的东西分开。


![](http://www.yq1012.com/ThinkingInJava/Thinking+In+Java/1-1.gif)

	Light lt = new Light();
	lt.on();

Java采用三个显式（明确）关键字以及一个隐式（暗示）关键字来设置类边界：`public`，`private`，`protected`以及暗示性的`friendly`。

![](http://www.yq1012.com/ThinkingInJava/Thinking+In+Java/1-2.gif)


<table>
	<tr><td>名称</td><td>说明</td><td>备注</td></tr>
	<tr><td>public</td><td>可以被任何类访问</td><td></td></tr>
	<tr>
		<td>protected</td>
		<td>可以被同一包中的所有类访问  可以被所有子类访问</td>
		<td>子类没有在同一包中也可以访问</td>
	</tr>
	<tr><td>private</td><td></td><td></td></tr>
	<tr><td>friendly(缺省)</td><td></td><td></td></tr>
</table>


类成员访问修饰符与访问能力之间的关系
<table>
	<tr><td>类型</td><td>private</td><td>friendly(缺省)</td><td>protected</td><td>public</td></tr>
	<tr><td>同一类</td><td>可访问</td><td>可访问</td><td>可访问</td><td>可访问</td></tr>
	<tr><td>同一包中的子类</td><td>不可访问</td><td>可访问</td><td>可访问</td><td>可访问</td></tr>
	<tr><td>同一包中的非子类</td><td>不可访问</td><td>可访问</td><td>可访问</td><td>可访问</td></tr>
	<tr><td>不同包中的子类</td><td>不可访问</td><td>不可访问</td><td>可访问</td><td>可访问</td></tr>
	<tr><td>不同包中的非子类</td><td>不可访问</td><td>不可访问</td><td>不可访问</td><td>可访问</td></tr>
</table>


<table>
	<tr><td>类型</td><td>public</td><td>friendly</td><td>private</td><td>protected</td><td>final</td><td>abstract</td><td>static</td></tr>
	<tr><td>类继承</td><td>可继承</td><td>只有同一包中可继承</td><td>不能继承</td><td>不能继承</td><td>不能派生子类</td><td>可继承</td><td>不可继承</td></tr>
	<tr><td>方法重载</td><td>可重载</td><td>可重载</td><td>?</td><td>不能重载</td><td>可重载</td><td>不可重载</td><td>可重载</td></tr>
	<tr><td>成员变量（属性的隐藏）</td><td>父类属性被隐藏（使得super获取父类属性）</td><td>父类属性被隐藏（使得super获取父类属性）</td><td>子类不能直接访问父类的私有属性</td><td>父类属性被隐藏（使得super获取父类属性)</td><td>必须付初值</td><td>不能修饰成员变量</td><td>每个实例共享变量</td></tr>
</table>



public ：能被所有的类(接口、成员)访问， 每个编译单元（文件）都只能有一个public类，public类的名字必须与包含了编译单元的那个文件的名字完全相符，甚至包括它的大小写形式。

protected：只能被本类、同一个包中的类访问；如果在其他包中被访问，则必须是该成员所属类的子类。

private：成员变量和方法都只能在定义它的类中被访问，其他类都访问不到。对成员变量的进行获取和更改，一般用get()，set() ，public 方法。实现了Java面向对象的封装思想。

friendly（缺省）：访问权限与protected相似，但修饰类成员时不同包中的子类不能访问。

static：修饰变量,称为类变量或静态变量。静态变量是和类存在一起的,每个实例共享这个静态变量，在类加载时初始化。

final：被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取不能更改。修饰类是不能派生出子类，修饰方法时，不能被当前子类的方法覆盖。

abstract：不能创建abstract 类的实例。一般被继承，实现抽象方法。类只要有一个abstract方法，类就必须定义为abstract，但abstract类不一定非要保护abstract方法不可。


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


自定义工具库

将system.out.print变成工具库

	package com.elewei.tools;
	
	public class P {
	  public static void rint(Object obj) {
	    System.out.print(obj);
	  }
	  public static void rint(String s) {
	    System.out.print(s);
	  }
	  public static void rint(char[] s) {
	    System.out.print(s);
	  }
	  public static void rint(char c) {
	    System.out.print(c);
	  }
	  public static void rint(int i) {
	    System.out.print(i);
	  }
	  public static void rint(long l) {
	    System.out.print(l);
	  }
	  public static void rint(float f) {
	    System.out.print(f);
	  }
	  public static void rint(double d) {
	    System.out.print(d);
	  }
	  public static void rint(boolean b) {
	    System.out.print(b);
	  }
	  public static void rintln() {
	    System.out.println();
	  }
	  public static void rintln(Object obj) {
	    System.out.println(obj);
	  }
	  public static void rintln(String s) {
	    System.out.println(s);
	  }
	  public static void rintln(char[] s) {
	    System.out.println(s);
	  }
	  public static void rintln(char c) {
	    System.out.println(c);
	  }
	  public static void rintln(int i) {
	    System.out.println(i);
	  }
	  public static void rintln(long l) {
	    System.out.println(l);
	  }
	  public static void rintln(float f) {
	    System.out.println(f);
	  }
	  public static void rintln(double d) {
	    System.out.println(d);
	  }
	  public static void rintln(boolean b) {
	    System.out.println(b);
	  }
	} 


###封装
封装是面向对象编程的核心思想，将对象的属性和行为封装起来，而将对象的属性和行为封装起来的载体就是类，类通常对客户隐藏其实现细节，这就是封装的思想。


###继承
使用继承的目的是增加代码复用，减少冗余。
有两种方法实现这个目的：
一种合成： 在新类里简单地创建原有类的对象
一种继承： 它创建一个新类，将其作为现有类的一个“类型”。可以原样采取现有类的形式，并在其中加入新代码，同时不会对现有的类产生影响。


继承：
从一般到特殊的关系，是一种拓展关系，子类对象是父类的一种，也可称为”is a“的关系

泛化：
把子类里的共性抽取到父类里的来的过程

特化：
子类在父类的基础上上定义了自己特有的行为特征的过程
 
格式：

	修饰符 class SubClass extends SuperClass{
    
	}
 
	SubClass ：导出类、继承类、子类
	SuperClass：父类、基类、超类、源类
	子类SubClass通过extends来继承父类SuperClass

每个类有且只有一个直接父类
一个类没有显示的继承其他的一个类时候，默认的直接父类就是object类
一旦一个类显示的继承了其他的一个类的时候，此时默认的直接父类object就会被取消
Java只支持单继承不支持多继承
在继承操作中，对于子类的对象实例化，子类对象在实例化之前必须首先调用父类中的构造方法之后在调用自身的构造方法
	
	class Super{
	 public Super(){
	  System.out.println("我是父类super");
	 }
	}
	class Sub extends Super{
	 public Sub(){
	  System.out.println("我是子类sub");
	 }
	}
	public class InstanceDemo {
	 public static void main(String[] args) {
	  new Sub();
	  /**
	   * 我是父类super
	   * 我是子类sub
	   *
	   * 先打印的是父类里面的在打印的子类里面
	   * 从这个可以看出是先调用父类的构造方法创建父类对象再来调用子类里面的构造方法
	   *
	   */
	 }
	}

子类对象在初始化之前会默认调用父类无参的构造方法，但是一旦子类显示的调用了父类其他的构造方法，那么默认调用的构造方法将会被取消


方法的重写（Override）：
当父类的某个方法不适合于子类本身的特征行为时就当重写父类中应当改变的方法

方法重写应遵循的原则：
方法签名（方法名+参数列表）必须相同
子类方法的返回值类型比父类方法的返回值类型更小或相等
子类方法声明抛出的异常应比父类方法申明跑出异常更小或相等，即子类方法不能抛出新的异常类型，子类方法可以同时声明抛出多个父类方法声明抛出异常的子类（RuntimeException例外）
子类方法的访问权限应比父类方法更大或相等



将句柄初始化的方法：
(1) 在对象定义的时候。这意味着它们在构建器调用之前肯定能得到初始化。
(2) 在那个类的构建器中。
(3) 紧靠在要求实际使用那个对象之前。这样做可减少不必要的开销——假如对象并不需要创建的话。






###多态
多态性允许以统一的风格编写程序，以处理种类繁多的已存在的类以及相关类。


